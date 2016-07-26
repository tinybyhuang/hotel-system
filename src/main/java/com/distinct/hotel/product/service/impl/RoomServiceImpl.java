package com.distinct.hotel.product.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.distinct.hotel.product.dao.RoomMapper;
import com.distinct.hotel.product.dao.RoomPriceMapper;
import com.distinct.hotel.product.model.Room;
import com.distinct.hotel.product.vo.RoomPriceVO;

@Service
public class RoomServiceImpl implements com.distinct.hotel.product.service.RoomService {

	@Resource
	private RoomMapper roomMapper;

	@Resource
	private RoomPriceMapper roomPriceMapper;

	@Override
	public List<RoomPriceVO> findRoomPriceAndName() {

		List<RoomPriceVO> roomPriceVOList = new ArrayList<RoomPriceVO>();

		//List<RoomPrice> roomPriceList = roomPriceMapper.findRoomPriceByDate(); // 一周内的数据

		//List<Room> roomList = roomMapper.findRoom();// 房型表
		return roomPriceVOList;
	}

	@Override
	public List<Room> findRoomByHotelId(int hotelId) {
		return roomMapper.findRoomByHotelId(hotelId);
	}

}
