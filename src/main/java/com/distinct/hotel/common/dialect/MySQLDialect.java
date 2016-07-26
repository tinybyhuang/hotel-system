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
 * ClassName:MySQLDialect <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2014年5月24日 上午8:34:50 <br/>
 * @author   wchuang
 * @version  
 * @since    1.0
 * @see 	 
 */
public class MySQLDialect extends Dialect{

	public boolean supportsLimitOffset(){
		return true;
	}

    public boolean supportsLimit() {   
        return true;   
    }  
    
	public String getLimitString(String sql, int offset,String offsetPlaceholder, int limit, String limitPlaceholder) {
        if (offset > 0) {   
        	return sql + " limit "+offsetPlaceholder+","+limitPlaceholder; 
        } else {   
            return sql + " limit "+limitPlaceholder;
        }  
	}   
  
}
