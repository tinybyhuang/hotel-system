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
 * ClassName:PostgreSQLDialect <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2014年5月24日 上午8:38:52 <br/>
 * @author   wchuang
 * @version  
 * @since    1.0
 * @see 	 
 */
public class PostgreSQLDialect extends Dialect{

	public boolean supportsLimit() {
		return true;
	}

	public boolean supportsLimitOffset(){
		return true;
	}

	public String getLimitString(String sql, int offset,
			String offsetPlaceholder, int limit, String limitPlaceholder) {
		return new StringBuffer( sql.length()+20 )
		.append(sql)
		.append(offset > 0 ? " limit "+limitPlaceholder+" offset "+offsetPlaceholder : " limit "+limitPlaceholder)
		.toString();
	}
}

