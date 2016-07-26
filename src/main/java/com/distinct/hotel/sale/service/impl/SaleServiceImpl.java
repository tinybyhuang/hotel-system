package com.distinct.hotel.sale.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.distinct.hotel.product.dao.HotelMapper;
import com.distinct.hotel.sale.service.SaleService;
@Service
public class SaleServiceImpl implements SaleService {
	@Resource
private HotelMapper hotelMapper;

	@Override
	public List<String> getInformation() {
	List<String> hotel=hotelMapper.selectByHotelName();

		return hotel;
	}

}
