package com.distinct.hotel.sale.vo;

import com.distinct.hotel.sale.model.PublishRule;

public class PublishRuleShowVO {
private PublishRule publishRule;
private String beginDate;
private String endDate;
public PublishRule getPublishRule() {
	return publishRule;
}
public void setPublishRule(PublishRule publishRule) {
	this.publishRule = publishRule;
}
public String getBeginDate() {
	return beginDate;
}
public void setBeginDate(String beginDate) {
	this.beginDate = beginDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
}
