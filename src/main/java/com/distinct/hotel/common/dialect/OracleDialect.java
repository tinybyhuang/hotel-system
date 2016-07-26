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
 * ClassName:OracleDialect <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2014年5月24日 上午8:35:55 <br/>
 * @author   wchuang
 * @version  
 * @since    1.0
 * @see 	 
 */
public class OracleDialect extends Dialect{

	public boolean supportsLimit() {
		return true;
	}

	public boolean supportsLimitOffset() {
		return true;
	}

	public String getLimitString(String sql, int offset,String offsetPlaceholder, int limit, String limitPlaceholder) {
		sql = sql.trim();
		boolean isForUpdate = false;
		if ( sql.toLowerCase().endsWith(" for update") ) {
			sql = sql.substring( 0, sql.length()-11 );
			isForUpdate = true;
		}

		StringBuffer pagingSelect = new StringBuffer( sql.length()+100 );
		if (offset > 0) {
			pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
		}
		else {
			pagingSelect.append("select * from ( ");
		}
		pagingSelect.append(sql);
		if (offset > 0) {
//			int end = offset+limit;
			String endString = offsetPlaceholder+"+"+limitPlaceholder;
			pagingSelect.append(" ) row_ ) where rownum_ <= " + endString + " and rownum_ > " + offsetPlaceholder);
		}
		else {
			pagingSelect.append(" ) where rownum <= " + limitPlaceholder);
		}

		if ( isForUpdate ) {
			pagingSelect.append( " for update" );
		}

		return pagingSelect.toString();
	}

}

