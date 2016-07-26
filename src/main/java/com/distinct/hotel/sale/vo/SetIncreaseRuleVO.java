package com.distinct.hotel.sale.vo;

public class SetIncreaseRuleVO {

	// 以下三个id作为scopeId
	private Integer cityId;

	private Integer hotelId;

	private Integer roomId;

	private Integer marketId;

	private String scopeType;

	private Integer providerId;

	private String increaseType;

	private Double increaseAmount;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getMarketId() {
		return marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

	public String getScopeType() {
		return scopeType;
	}

	public void setScopeType(String scopeType) {
		this.scopeType = scopeType;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public String getIncreaseType() {
		return increaseType;
	}

	public void setIncreaseType(String increaseType) {
		this.increaseType = increaseType;
	}

	public double getIncreaseAmount() {
		return increaseAmount;
	}

	// 页面输入空白increaseAmount的时候，可以把这个值置为0.0
	public void setIncreaseAmount(String increaseAmount) {
		Double amount = 0.0;
		if (increaseAmount == null | increaseAmount == "")
			this.increaseAmount = amount;
		else
			this.increaseAmount = Double.parseDouble(increaseAmount);
	}
}
