package com.distinct.hotel.grap.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.distinct.hotel.common.Utils;
import com.distinct.hotel.grap.service.HotelService;
import com.distinct.hotel.product.dao.HotelMapper;
import com.distinct.hotel.product.dao.RoomMapper;
import com.distinct.hotel.product.dao.RoomPriceMapper;
import com.distinct.hotel.product.model.Hotel;
import com.distinct.hotel.product.model.Room;
import com.distinct.hotel.product.model.RoomExample;
import com.distinct.hotel.product.model.RoomPrice;
@Service
public class HotelServiceImpl implements HotelService {
	@Resource
	private HotelMapper hotelMapper;
	@Resource
	private RoomMapper roomMapper;
	@Resource
	private RoomPriceMapper roomPriceMapper;

	@Override
	public void insertHotel(List<Hotel> hotels) {
		if(null != hotels && hotels.size() > 0){
			for(Hotel hotel : hotels){
				hotelMapper.insert(hotel);
			}
		}

	}

	@Override
	public void insertRoom(List<Room> rooms) {
		if(null != rooms && rooms.size() > 0){
			for(Room room : rooms){
				roomMapper.insert(room);
			}
		}
	}

	@Override
	public void addHotel(Hotel hotel) {
		
		hotelMapper.insert(hotel);
	}

	@Override
	public void deleteHotel() {
		
		List<Integer> hotelIds = hotelMapper.getHotelIds();
		hotelMapper.deleteHotels(hotelIds);
		
	}

	@Override
	public void deleteRoom() {
		List<Integer> roomIds = roomMapper.getRoomIds();
		roomMapper.deleteRooms(roomIds);
		
	}

	@Override
	public void setPrice() {
		RoomExample example = new RoomExample();
		example.createCriteria().andIdGreaterThan(0);
		List<Room> rooms = roomMapper.selectByExample(example);
		List<Date> dates = Utils.getDays(30);
		for(Room room : rooms){
			for(Date date : dates){
				RoomPrice price = new RoomPrice();
				price.setProviderId(1);
				price.setRoomId(room.getProviderRoomId());
				price.setBreakfastType(Utils.getBreakfast());
				price.setRoomAmount(Utils.getBedType());
				price.setSaleDate(date);
				price.setSalePrice(Utils.getPrice());
				price.setCreated(new Date());
				roomPriceMapper.insert(price);
			}
		}
	}

}
