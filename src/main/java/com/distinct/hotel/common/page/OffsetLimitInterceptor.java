

package com.distinct.hotel.common.page;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.distinct.hotel.common.dialect.Dialect;
import com.distinct.hotel.common.page.PageBounds;
import com.distinct.hotel.common.page.PageList;
import com.distinct.hotel.common.page.Paginator;
import com.distinct.hotel.common.support.SQLHelper;

/**
 * 为MyBatis提供基于方言(Dialect)的分页查询的插件
 * 
 * 将拦截Executor.query()方法实现分页方言的插入.
 * 
 * @author wchuang
 * 
 */

@Intercepts({ @Signature(type = Executor.class, method = "query", args = {
		MappedStatement.class, Object.class, RowBounds.class,
		ResultHandler.class }) })
public class OffsetLimitInterceptor implements Interceptor {

	private static Logger logger = LoggerFactory
			.getLogger(OffsetLimitInterceptor.class);

	private final static int MAPPED_STATEMENT_INDEX = 0;// sql语句的索引

	private final static int PARAMETER_INDEX = 1; // 参数对象的索引

	private final static int ROWBOUNDS_INDEX = 2; // 分页对象的索引

	// private final static int RESULT_HANDLER_INDEX = 3;

	private Dialect dialect; // 数据库方言

	private static ExecutorService pool;

	private boolean asyncTotalCount = false;

	private int poolMaxSize;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object intercept(final Invocation invocation) throws Throwable {

		final Executor executor = (Executor) invocation.getTarget();
		final Object[] queryArgs = invocation.getArgs();
		final MappedStatement ms = (MappedStatement) queryArgs[MAPPED_STATEMENT_INDEX];
		final Object parameter = queryArgs[PARAMETER_INDEX];
		final RowBounds rowBounds = (RowBounds) queryArgs[ROWBOUNDS_INDEX];
		final PageBounds pageBounds = new PageBounds(rowBounds);

		final int offset = pageBounds.getOffset();
		final int limit = pageBounds.getLimit();
		final int page = pageBounds.getPage();

		final BoundSql boundSql = ms.getBoundSql(parameter);
		final StringBuffer bufferSql = new StringBuffer(boundSql.getSql()
				.trim());
		if (bufferSql.lastIndexOf(";") == bufferSql.length() - 1) {
			bufferSql.deleteCharAt(bufferSql.length() - 1);
		}
		String sql = bufferSql.toString();

		if (pageBounds.getOrders() != null && !pageBounds.getOrders().isEmpty()) {
			sql = dialect.getSortString(sql, pageBounds.getOrders());
		}

		Callable<Paginator> countTask = null;

		if (dialect.supportsLimit()
				&& (offset != RowBounds.NO_ROW_OFFSET || limit != RowBounds.NO_ROW_LIMIT)) {
			if (pageBounds.isContainsTotalCount()) {
				countTask = new Callable() {

					public Object call() throws Exception {
						Integer count = null;
						Cache cache = ms.getCache();
						if (cache != null && ms.isUseCache()) {
							CacheKey cacheKey = executor.createCacheKey(
									ms,
									parameter,
									new PageBounds(),
									copyFromBoundSql(ms, boundSql,
											bufferSql.toString()));
							count = (Integer) cache.getObject(cacheKey);
							if (count == null) {
								count = SQLHelper.getCount(
										bufferSql.toString(), ms, parameter,
										boundSql, dialect);
								cache.putObject(cacheKey, count);
							}
						}
						else {
							count = SQLHelper.getCount(bufferSql.toString(),
									ms, parameter, boundSql, dialect);
						}
						return new Paginator(page, limit, count);
					}
				};
			}

			if (dialect.supportsLimitOffset()) {
				sql = dialect.getLimitString(sql, offset, limit);
			}
			else {
				sql = dialect.getLimitString(sql, offset, limit);
			}
			queryArgs[ROWBOUNDS_INDEX] = new RowBounds(RowBounds.NO_ROW_OFFSET,
					RowBounds.NO_ROW_LIMIT);
		}

		queryArgs[MAPPED_STATEMENT_INDEX] = copyFromNewSql(ms, boundSql, sql);

		Boolean async = pageBounds.getAsyncTotalCount() == null ? asyncTotalCount
				: pageBounds.getAsyncTotalCount();
		Future<List> listFuture = call(new Callable<List>() {

			public List call() throws Exception {
				return (List) invocation.proceed();
			}
		}, async);

		if (countTask != null) {
			Future<Paginator> countFutrue = call(countTask, async);
			return new PageList(listFuture.get(), countFutrue.get());
		}

		return listFuture.get();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private <T> Future<T> call(Callable callable, boolean async) {
		if (async) {
			return getThreadPool().submit(callable);
		}
		else {
			FutureTask<T> future = new FutureTask(callable);
			future.run();
			return future;
		}
	}

	private MappedStatement copyFromNewSql(MappedStatement ms,
			BoundSql boundSql, String sql) {
		BoundSql newBoundSql = copyFromBoundSql(ms, boundSql, sql);
		return copyFromMappedStatement(ms, new BoundSqlSqlSource(newBoundSql));
	}

	private BoundSql copyFromBoundSql(MappedStatement ms, BoundSql boundSql,
			String sql) {
		BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), sql,
				boundSql.getParameterMappings(), boundSql.getParameterObject());
		for (ParameterMapping mapping : boundSql.getParameterMappings()) {
			String prop = mapping.getProperty();
			if (boundSql.hasAdditionalParameter(prop)) {
				newBoundSql.setAdditionalParameter(prop,
						boundSql.getAdditionalParameter(prop));
			}
		}
		return newBoundSql;
	}

	// see: MapperBuilderAssistant
	private MappedStatement copyFromMappedStatement(MappedStatement ms,
			SqlSource newSqlSource) {
		Builder builder = new Builder(ms.getConfiguration(), ms.getId(),
				newSqlSource, ms.getSqlCommandType());

		builder.resource(ms.getResource());
		builder.fetchSize(ms.getFetchSize());
		builder.statementType(ms.getStatementType());
		builder.keyGenerator(ms.getKeyGenerator());
		if (ms.getKeyProperties() != null && ms.getKeyProperties().length != 0) {
			StringBuffer keyProperties = new StringBuffer();
			for (String keyProperty : ms.getKeyProperties()) {
				keyProperties.append(keyProperty).append(",");
			}
			keyProperties.delete(keyProperties.length() - 1,
					keyProperties.length());
			builder.keyProperty(keyProperties.toString());
		}

		// setStatementTimeout()
		builder.timeout(ms.getTimeout());

		// setStatementResultMap()
		builder.parameterMap(ms.getParameterMap());

		// setStatementResultMap()
		builder.resultMaps(ms.getResultMaps());
		builder.resultSetType(ms.getResultSetType());

		// setStatementCache()
		builder.cache(ms.getCache());
		builder.flushCacheRequired(ms.isFlushCacheRequired());
		builder.useCache(ms.isUseCache());

		return builder.build();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {

		if (null != properties) {
			setDialect(properties.getProperty("dialect", "mysql"));
			setPoolMaxSize(Integer.parseInt(properties.getProperty(
					"poolMaxSize", "0")));

		}
	}

	public static class BoundSqlSqlSource implements SqlSource {

		BoundSql boundSql;

		public BoundSqlSqlSource(BoundSql boundSql) {
			this.boundSql = boundSql;
		}

		public BoundSql getBoundSql(Object parameterObject) {
			return boundSql;
		}
	}

	public void setDialect(String dialectName) {
		this.dialect = Dialect.getDialect(dialectName);
		logger.debug("dialectClass: {} ", dialect.getClass().getName());
	}

	public void setAsyncTotalCount(boolean asyncTotalCount) {
		logger.debug("asyncTotalCount: {} ", asyncTotalCount);
		this.asyncTotalCount = asyncTotalCount;
	}

	public void setPoolMaxSize(int poolMaxSize) {

		if (poolMaxSize > 0) {
			logger.debug("poolMaxSize: {} ", poolMaxSize);
			pool = Executors.newFixedThreadPool(poolMaxSize);
		}
		else {
			pool = Executors.newCachedThreadPool();
		}

	}

	public void destroy() {

		if (null != pool) {
			pool.shutdown();
		}
	}

	/**
	 * 
	 * getThreadPool. <br/>
	 * 
	 * @author lyh
	 * @return
	 * @since 1.0
	 */
	private ExecutorService getThreadPool() {

		if (null == pool) {
			if (poolMaxSize > 0) {
				logger.debug("poolMaxSize: {} ", poolMaxSize);
				pool = Executors.newFixedThreadPool(poolMaxSize);
			}
			else {
				pool = Executors.newCachedThreadPool();
			}
		}

		return pool;

	}
}
