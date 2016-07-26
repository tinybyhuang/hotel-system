package com.distinct.hotel.product.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class RoomPriceVO {

	private static final SimpleDateFormat sd = new SimpleDateFormat("HH:mm");

	private Integer roomId; // 房间 id

	private Integer providerRoomId;// 供应商提供房间 id

	private Double salePrice;

	private String saleDate;

	private String roomName;

	private Integer hotelId;

	private Integer roomAmount;

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getProviderRoomId() {
		return providerRoomId;
	}

	public void setProviderRoomId(Integer providerRoomId) {
		this.providerRoomId = providerRoomId;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Date getSaleDate() {

		Date saleDay = null;
		if (StringUtils.isNoneBlank(saleDate)) {
			try {
				saleDay = sd.parse(saleDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return saleDay;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getRoomAmount() {
		return roomAmount;
	}

	public void setRoomAmount(Integer roomAmount) {
		this.roomAmount = roomAmount;
	}

}
