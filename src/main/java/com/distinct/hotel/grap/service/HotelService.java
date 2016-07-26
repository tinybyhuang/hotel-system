package com.distinct.hotel.grap.service;

import java.util.List;

import com.distinct.hotel.product.model.Hotel;
import com.distinct.hotel.product.model.Room;

public interface HotelService {
	
	public void insertHotel(List<Hotel> hotels);
	
	public void insertRoom(List<Room> rooms);
	
	public void addHotel(Hotel hotel);
	
	public void deleteHotel();
	
	public void deleteRoom();
	
	public void setPrice();

}
