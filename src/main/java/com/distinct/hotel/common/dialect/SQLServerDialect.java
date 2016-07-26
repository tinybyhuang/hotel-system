/*
 * Copyright (c) 2014，the original authors or Shenzhen Stock Exchange 
 *
 *      http://www.distinct.com/
 *
 * Statement: This document's code after sufficiently has not permitted does not have 
 * any way dissemination and the change, once discovered violates the stipulation, will
 * receive the criminal sanction.
 * Email: lyhnclg@163.com　
 */

package com.distinct.hotel.common.dialect;

/**
 * ClassName:SQLServerDialect <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2014年5月24日 上午8:38:07 <br/>
 * @author   wchuang
 * @version  
 * @since    1.0
 * @see 	 
 */
public class SQLServerDialect extends Dialect{

	public boolean supportsLimitOffset(){
		return false;
	}

	public boolean supportsLimit() {
		return true;
	}

	static int getAfterSelectInsertPoint(String sql) {
		int selectIndex = sql.toLowerCase().indexOf( "select" );
		final int selectDistinctIndex = sql.toLowerCase().indexOf( "select distinct" );
		return selectIndex + ( selectDistinctIndex == selectIndex ? 15 : 6 );
	}

	public String getLimitString(String sql, int offset, int limit) {
		return getLimitString(sql,offset,null,limit,null);
	}

	public String getLimitString(String querySelect, int offset, String offsetPlaceholder, int limit, String limitPlaceholder) {
		/*if ( offset > 0 ) {
			throw new UnsupportedOperationException( "sql server has no offset" );
		}*/
		/*return new StringBuffer( querySelect.length() + 8 )
				.append( querySelect )
				.insert( getAfterSelectInsertPoint( querySelect ), " top " + limit )
				.toString();*/
		return new StringBuffer().append(querySelect)
				.append(" offset ").append(offset)
				.append(" rows fetch next ")
				.append(limit).append(" rows only").toString();
	}


}

