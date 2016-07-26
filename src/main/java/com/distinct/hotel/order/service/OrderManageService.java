package com.distinct.hotel.order.service;

import java.util.List;

import com.distinct.hotel.common.page.PageBounds;
import com.distinct.hotel.common.page.PageResult;
import com.distinct.hotel.order.model.Order;
import com.distinct.hotel.order.vo.ArrangeRoomVO;
import com.distinct.hotel.order.vo.BookingOrderVO;
import com.distinct.hotel.order.vo.SearchOrderVO;
import com.distinct.hotel.order.vo.SearchRoomPriceVO;
import com.distinct.hotel.product.model.RoomPrice;

public interface OrderManageService {

	// create in 20160507
	List<Integer> returnAllMarketId();

	PageResult<Order> findAllOrder(PageBounds pageBounds);

	PageResult<Order> findAllOrderPurpose(PageBounds pageBounds, SearchOrderVO searchOrderVO);

	List<RoomPrice> findLiveDayRoomPriceDetail(SearchRoomPriceVO searchRoomPriceVO);

	String bookingOrderHandler(BookingOrderVO bookingOrderVO);

	Integer updataOrderData(Order order);

	Order findOrderById(Integer id);

	String arrangeRoomHandler(ArrangeRoomVO arrangeRoomVO);
	
	
}
