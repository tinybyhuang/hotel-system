package com.distinct.hotel.product.vo;

import java.math.BigDecimal;
import java.util.Date;

public class PriceNDateVO {

	private int recordNO;

	private Date saleDate; // 出售日期，加幅日期

	private Double originalPrice; // 初始价格

	private String increaseType; // 加幅类型 差价 百分比

	private double increaseAmount; // 加幅数值

	private String increaseStatus; // 是否加幅

	private String saleStatus; // 上下架状态

	private Double salePrice; // 出售价格

	private String showPrice;// 展示价格，格式为 originalPrice + ( + increaseAmount + )

	/**
	 * not use
	 */
	private String scopeType; // 城市加幅 房型加幅 酒店加幅

	private int scopeId; // 特定的城市id 房型id 酒店id

	public int getRecordNO() {
		return recordNO;
	}

	public void setRecordNO(int recordNO) {
		this.recordNO = recordNO;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
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

	public void setIncreaseAmount(double increaseAmount) {
		this.increaseAmount = increaseAmount;
	}

	public String getIncreaseStatus() {
		return increaseStatus;
	}

	public void setIncreaseStatus(String increaseStatus) {
		this.increaseStatus = increaseStatus;
	}

	public String getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(String saleStatus) {
		this.saleStatus = saleStatus;
	}

	public Double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getScopeType() {
		return scopeType;
	}

	public void setScopeType(String scopeType) {
		this.scopeType = scopeType;
	}

	public int getScopeId() {
		return scopeId;
	}

	public void setScopeId(int scopeId) {
		this.scopeId = scopeId;
	}

	/* 2016-04-27 */
	public String getShowPrice() {
		return showPrice;
	}

	public void setShowPrice(String showPrice) {
		this.showPrice = showPrice;
	}

	public void setStringPriceFromDoubleDifferent(Double price, Double amount) {
		StringBuilder sb = new StringBuilder();
		sb.append(price).append("+(").append(amount).append(")");
		this.showPrice = sb.toString();
	};

	public void setStringPriceFromDoublePercent(Double price, Double amount) {
		StringBuilder sb = new StringBuilder();
		double percent = price * 0.01 * amount; // 百分比计算
		BigDecimal decimal = new BigDecimal(percent);
		//保留一位小数
		sb.append(price).append("+(").append( decimal.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue()).append(")");
		this.showPrice = sb.toString();
	};
	
	
}
