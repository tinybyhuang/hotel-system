package com.distinct.hotel.sale.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;


public class PublishRuleVO {
	  private Integer id;
  private Integer publishId;
	    private Integer saleRuleId;

	    private String beginDate;

	    private String endDate;

	    private String status;

	    private Date created;

	    private Date modified;

	    private Integer modUserId;
	    private static final SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getSaleRuleId() {
	return saleRuleId;
}
public void setSaleRuleId(Integer saleRuleId) {
	this.saleRuleId = saleRuleId;
}
public Date getBeginDate() {
	
	Date start = null;
	if(StringUtils.isNoneBlank(beginDate)){
		try{
			start = sd.parse(beginDate);
		} catch(ParseException e) {
			e.printStackTrace();
			
		}
		
	}
	return start;	
}
public void setBeginDate(String beginDate) {
	this.beginDate = beginDate;
}
public Date getEndDate() {
	Date end = null;
	if(StringUtils.isNoneBlank(endDate)){
		try{
			  end =sd.parse(endDate);
					  
		}catch(ParseException e){
			e.printStackTrace();
		}
	}
	
	
	return end ;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Date getCreated() {
	return created;
}
public void setCreated(Date created) {
	this.created = created;
}
public Date getModified() {
	return modified;
}
public void setModified(Date modified) {
	this.modified = modified;
}
public Integer getModUserId() {
	return modUserId;
}
public void setModUserId(Integer modUserId) {
	this.modUserId = modUserId;
}
public Integer getPublishId() {
	return publishId;
}
public void setPublishId(Integer publishId) {
	this.publishId = publishId;
}

}
