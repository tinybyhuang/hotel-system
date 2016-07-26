package com.distinct.hotel.service.provider.vo;

public class BaseOrderResult {
	
	private String code = "0"; //0 代表失败，1代表成功
	
	private String message = "操作失败";

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
