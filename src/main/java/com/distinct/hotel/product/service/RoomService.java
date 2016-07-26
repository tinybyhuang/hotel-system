package com.distinct.hotel.product.service;

import java.util.List;

import com.distinct.hotel.product.model.Room;
import com.distinct.hotel.product.vo.RoomPriceVO;

public interface RoomService {

	// 查询房型的价钱
	List<RoomPriceVO> findRoomPriceAndName();

	
	List<Room> findRoomByHotelId(int hotelId);
	
	
}
