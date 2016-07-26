package com.distinct.hotel.order.vo;

import java.util.Date;

public class SearchOrderVO {

	// 根据平台找
	private Integer marketId;
	// 根据酒店名找
	private String hotelName;

	// 根据房型字段找
	private String roomName;

	// private Integer hotelId;

	private Integer providerId;

	// 平台订单状态
	private String marketStatus;

	// 按照大于小于天数寻找
	private Integer days;

	// 大于小于预定数量寻找
	private Integer bookAmount;

	// 可以按照大于小于平台支付金额寻找
	private Float marketAmount;

	// 可以寻找这两个日期之间的订单
	private Date beginDate;

	private Date endDate;

	public Integer getMarketId() {
		return marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public String getMarketStatus() {
		return marketStatus;
	}

	public void setMarketStatus(String marketStatus) {
		this.marketStatus = marketStatus;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Integer getBookAmount() {
		return bookAmount;
	}

	public void setBookAmount(Integer bookAmount) {
		this.bookAmount = bookAmount;
	}

	public Float getMarketAmount() {
		return marketAmount;
	}

	public void setMarketAmount(Float marketAmount) {
		this.marketAmount = marketAmount;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/*
	 * public Integer getRoomId() { return roomId; }
	 * 
	 * public void setRoomId(Integer roomId) { this.roomId = roomId; }
	 * 
	 * public Integer getHotelId() { return hotelId; }
	 * 
	 * public void setHotelId(Integer hotelId) { this.hotelId = hotelId; }
	 */

}
