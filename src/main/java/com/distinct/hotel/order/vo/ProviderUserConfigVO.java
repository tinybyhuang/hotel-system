package com.distinct.hotel.order.vo;

public class ProviderUserConfigVO {

	// 配置编码 供应商为1
	private Integer configType = 1;

	private Integer providerId;

	private String userNo;

	private String userPwd;


	public Integer getConfigType() {
		return configType;
	}

	public void setConfigType(Integer configType) {
		this.configType = configType;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
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

}
