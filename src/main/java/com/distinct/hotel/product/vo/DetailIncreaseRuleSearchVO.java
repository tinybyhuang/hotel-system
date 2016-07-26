package com.distinct.hotel.product.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DetailIncreaseRuleSearchVO {

	private static final SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
	
	private Integer roomId;

	private Integer providerId;

	private Integer marketId;

	private Date saleDate;

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public Integer getMarketId() {
		return marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
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
	
}
