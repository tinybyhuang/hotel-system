package com.distinct.hotel.product.model;

import java.util.Date;

public class RoomPrice {
	private Integer id;

	private Integer providerId;

	private Integer roomId;

	private Integer roomAmount;

	private Date saleDate;

	private Double salePrice;

	private Integer breakfastType;

	private Date created;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getRoomAmount() {
		return roomAmount;
	}

	public void setRoomAmount(Integer roomAmount) {
		this.roomAmount = roomAmount;
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

	public Integer getBreakfastType() {
		return breakfastType;
	}

	public void setBreakfastType(Integer breakfastType) {
		this.breakfastType = breakfastType;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}