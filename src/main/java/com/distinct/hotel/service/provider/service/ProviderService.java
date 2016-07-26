package com.distinct.hotel.service.provider.service;

import java.util.List;

import com.distinct.hotel.product.model.RoomPrice;
import com.distinct.hotel.service.market.vo.ArrangeRoom;
import com.distinct.hotel.service.market.vo.ArrangeRoomResult;
import com.distinct.hotel.service.provider.vo.BookingOrder;
import com.distinct.hotel.service.provider.vo.BookingOrderResult;
import com.distinct.hotel.service.provider.vo.CancelOrder;
import com.distinct.hotel.service.provider.vo.CancelOrderResult;

public interface ProviderService {

	boolean authUser(String username, String password, Integer privoderId);

	boolean authMarketUser(String username, String password, Integer marketId);
	
	boolean authHotel(Integer privoderId, Integer hotelId);

	boolean authRoom(Integer privoderId, Integer hotelId, Integer roomId);

	void bookingOrder(Integer privoderId, BookingOrder bookingOrder, BookingOrderResult result);

	void updateRoomPrice(List<RoomPrice> recrods);

	void cancelOrder(Integer marketId, CancelOrder cancelOrder, CancelOrderResult result);

	boolean authOrder(Integer marketId, String marketOrderNo);

	void arrangeRoom(Integer marketId, ArrangeRoom arrangeRoom, ArrangeRoomResult result);

}
