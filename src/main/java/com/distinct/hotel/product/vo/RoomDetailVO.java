package com.distinct.hotel.product.vo;

import java.util.List;

import com.distinct.hotel.product.model.Bed;
import com.distinct.hotel.product.model.Room;
import com.distinct.hotel.product.model.RoomPrice;

public class RoomDetailVO {

	private Room room; // 每个酒店找到的集合

	private List<RoomPrice> roomPrices;

	private Bed bed;

	public List<RoomPrice> getRoomPrices() {
		return roomPrices;
	}

	public void setRoomPrices(List<RoomPrice> roomPrices) {
		this.roomPrices = roomPrices;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Bed getBed() {
		return bed;
	}

	public void setBed(Bed bed) {
		this.bed = bed;
	}

}
