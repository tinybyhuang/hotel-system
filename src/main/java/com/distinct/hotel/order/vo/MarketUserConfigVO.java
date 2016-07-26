package com.distinct.hotel.order.vo;

public class MarketUserConfigVO {

	// 配置编码 平台为2
	private Integer configType = 2;

	private Integer marketId;

	private String userNo;

	private String userPwd;

	public Integer getConfigType() {
		return configType;
	}

	public void setConfigType(Integer configType) {
		this.configType = configType;
	}

	public Integer getMarketId() {
		return marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
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
