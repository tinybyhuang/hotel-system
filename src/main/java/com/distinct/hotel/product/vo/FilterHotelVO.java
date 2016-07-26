package com.distinct.hotel.product.vo;

import com.distinct.hotel.product.model.Hotel;

public class FilterHotelVO {
private Hotel hotel;
private String status;
public Hotel getHotel() {
	return hotel;
}
public void setHotel(Hotel hotel) {
	this.hotel = hotel;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
