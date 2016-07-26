package com.distinct.hotel.order.vo;

public class UserConfigVO {

	//这为配置类型 分为供应商 和平台两种
	private Integer configType;

	//供应商的id   (平台id或者供应商id)
	private Integer configId;

	//用户名
	private String userNo;

	//用户密码
	private String userPwd;

	//修改信息的用户  可以作为userId去查找用户配置
	private Integer modUserId;

	public Integer getConfigType() {
		return configType;
	}

	public void setConfigType(Integer configType) {
		this.configType = configType;
	}

	public Integer getConfigId() {
		return configId;
	}

	public void setConfigId(Integer configId) {
		this.configId = configId;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Integer getModUserId() {
		return modUserId;
	}

	public void setModUserId(Integer modUserId) {
		this.modUserId = modUserId;
	}

}
