package com.distinct.hotel.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.distinct.hotel.product.dao.HotelMapper;
import com.distinct.hotel.product.model.Hotel;
import com.distinct.hotel.product.service.GetAllHotelService;

@Service
public class GetAllHotelServiceImpl implements GetAllHotelService {

	@Resource
	private HotelMapper hotelMapper;

	@Override
	public List<Hotel> getHotel() {
		return hotelMapper.getAllHotel();
	}

	@Override
	public int getNumber() {
		return hotelMapper.getDataNumber();
	}

	@Override
	public List<Hotel> getHotelByCurrentPage(int currentPage, int dataSize) {
		
		return hotelMapper.getHotelByCurrentPage(currentPage, dataSize);
	}

}
