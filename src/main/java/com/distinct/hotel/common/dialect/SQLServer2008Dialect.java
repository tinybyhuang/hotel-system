package com.distinct.hotel.common.dialect;

/**
 * ClassName:SQLServer2008Dialect <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2014年5月24日 上午8:37:03 <br/>
 * @author   lyh
 * @version  
 * @since    1.0
 * @see 	 
 */
/**
 * 
 * @author wchuang
 * 
 */
public class SQLServer2008Dialect extends Dialect {

	@Override
	public boolean supportsLimit() {
		return true;
	}

	@Override
	public boolean supportsLimitOffset() {
		return true;
	}

	/**
	 * Add a LIMIT clause to the given SQL SELECT
	 * 
	 * SELECT t.* FROM ( SELECT a.* , row_number() over(ORDER BY
	 * CURRENT_TIMESTAMP) r FROM (select * from t_resource ) a ) t where t.r <=
	 * (10 * 1) and t.r > (10*(1-1))
	 */
	@Override
	public String getLimitString(String querySqlString, int offset, String offsetPlaceholder, int limit,
			String limitPlaceholder) {

		String sqlPartString = getSqlByPart(querySqlString);
		String orderby = getOrderByPart(querySqlString);

		// if no ORDER BY is specified use fake ORDER BY field to avoid errors
		if (orderby == null || orderby.length() == 0) {
			orderby = "ORDER BY CURRENT_TIMESTAMP";
		}

		StringBuffer sqlBuilder = new StringBuffer();
		sqlBuilder.append("SELECT t.* FROM ( SELECT __row_table__.* , row_number() over(");
		sqlBuilder.append(orderby);
		sqlBuilder.append(") r FROM (");
		sqlBuilder.append(sqlPartString);
		sqlBuilder.append(") __row_table__ ) t where t.r <= " + (offset + limit));
		sqlBuilder.append("and t.r > " + offset);

		return sqlBuilder.toString();
	}

	static String getSqlByPart(String sql) {
		sql = sql.toLowerCase();
		if (sql.indexOf("temp_order") > -1) {
			sql = sql.substring(15);
			int index = sql.indexOf(") temp_order");
			sql = sql.substring(0, index);
		} else {
			int index = sql.indexOf("order by");
			if (index >  -1) {
				sql = sql.substring(0, index);
			}
			
		}
		return sql;
	}
	static String getOrderByPart(String sql) {
		String loweredString = sql.toLowerCase();
		int orderByIndex = loweredString.indexOf("order by");
		if (orderByIndex != -1) {
			// if we find a new "order by" then we need to ignore
			// the previous one since it was probably used for a subquery
			return sql.substring(orderByIndex);
		} else {
			return "";
		}
	}
}
