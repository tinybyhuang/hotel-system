package com.distinct.hotel.product.service;

import java.util.List;


import com.distinct.hotel.product.model.Hotel;

public interface GetAllHotelService {

	List<Hotel> getHotel();

	int getNumber();

	List<Hotel> getHotelByCurrentPage(int currentPage, int dataSize);
}
