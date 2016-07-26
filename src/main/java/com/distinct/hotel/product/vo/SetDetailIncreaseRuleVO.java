package com.distinct.hotel.product.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class SetDetailIncreaseRuleVO {

	private static final SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

	private Date saleDate; // 加幅日期

	// private Integer recordNO;

	private Integer roomID; // 房间id

	/*
	 * private double differentPrice;
	 * 
	 * private double percentPrice;
	 */
	private Integer marketID; // 平台id

	private Integer providerID; // 供应商id

	// private Integer saleRuleId;

	private String increaseType;// 增幅类型

	private double increaseAmount;// 增幅数值

	// private String status;

	private Integer hotelId;

	private Integer cityId;

	public Integer getRoomID() {
		return roomID;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		Date date = new Date();
		if (StringUtils.isNotBlank(saleDate)) {
			try {
				date = sd.parse(saleDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		this.saleDate = date;
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

	public void setIncreaseAmount(String increaseAmount) {
		Double amount = 0.0;
		if (increaseAmount == null | increaseAmount == "")
			this.increaseAmount = amount;
		else
			this.increaseAmount = Double.parseDouble(increaseAmount);
	}

	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}

	public Integer getMarketID() {
		return marketID;
	}

	public void setMarketID(Integer marketID) {
		this.marketID = marketID;
	}

	public Integer getProviderID() {
		return providerID;
	}

	public void setProviderID(Integer providerID) {
		this.providerID = providerID;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

}
