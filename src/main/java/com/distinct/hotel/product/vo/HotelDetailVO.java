package com.distinct.hotel.product.vo;

import java.util.List;
import java.util.Map;

import com.distinct.hotel.product.model.Hotel;
import com.distinct.hotel.product.model.Room;
import com.distinct.hotel.product.model.RoomPrice;
import com.distinct.hotel.sale.model.IncreaseRule;

public class HotelDetailVO {

	private Hotel hotel;

	// private List<RoomDetailVO> roomDetailVOs;

	// 该酒店的加幅
	private IncreaseRule hotelIncreaseRule;

	private List<Room> rooms;

	// 一个房型id以及一个加幅数据对应
	private Map<Integer, IncreaseRule> roomIncreaseRuleMap;

	private Map<Room, List<RoomPrice>> roomPriceMap;

	
	
	public Map<Room, List<RoomPrice>> getRoomPriceMap() {
		return roomPriceMap;
	}

	public void setRoomPriceMap(Map<Room, List<RoomPrice>> roomPriceMap) {
		this.roomPriceMap = roomPriceMap;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public IncreaseRule getHotelIncreaseRule() {
		return hotelIncreaseRule;
	}

	public void setHotelIncreaseRule(IncreaseRule hotelIncreaseRule) {
		this.hotelIncreaseRule = hotelIncreaseRule;
	}

	public Map<Integer, IncreaseRule> getRoomIncreaseRuleMap() {
		return roomIncreaseRuleMap;
	}

	public void setRoomIncreaseRuleMap(Map<Integer, IncreaseRule> roomIncreaseRuleMap) {
		this.roomIncreaseRuleMap = roomIncreaseRuleMap;
	}	
	
}
