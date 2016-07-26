package com.distinct.hotel.service.provider.vo;

public class CancelOrderResult extends BaseOrderResult{
	
	private String orderNo;
	private String status;
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
