package com.distinct.hotel.order.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.distinct.hotel.common.UserUtils;
import com.distinct.hotel.common.Utils;
import com.distinct.hotel.common.page.PageBounds;
import com.distinct.hotel.common.page.PageList;
import com.distinct.hotel.common.page.PageResult;
import com.distinct.hotel.order.dao.OrderMapper;
import com.distinct.hotel.order.dao.UserConfigMapper;
import com.distinct.hotel.order.model.Order;
import com.distinct.hotel.order.model.OrderExample;
import com.distinct.hotel.order.model.UserConfig;
import com.distinct.hotel.order.service.HttpClientRequestService;
import com.distinct.hotel.order.service.OrderManageService;
import com.distinct.hotel.order.vo.ArrangeRoomVO;
import com.distinct.hotel.order.vo.BookingOrderVO;
import com.distinct.hotel.order.vo.SearchOrderVO;
import com.distinct.hotel.order.vo.SearchRoomPriceVO;
import com.distinct.hotel.product.dao.RoomPriceMapper;
import com.distinct.hotel.product.model.RoomPrice;
import com.distinct.hotel.product.vo.DateApplication;
import com.distinct.hotel.service.market.vo.ArrangeRoom;
import com.distinct.hotel.service.provider.vo.BookingOrder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class OrderManageServiceImpl implements OrderManageService {

	@Resource
	private OrderMapper orderMapper;

	@Resource
	private RoomPriceMapper roomPriceMapper;

	@Resource
	private UserConfigMapper userConfigMapper;

	@Resource
	private HttpClientRequestService httpClientRequestService;

	// 解析response回来的数据
	private JsonParser jsonParser = new JsonParser();

	@Override
	public List<Integer> returnAllMarketId() {
		return orderMapper.findAllMarketId();
	}

	@Override
	public PageResult<Order> findAllOrder(PageBounds pageBounds) {
		PageList<Order> orderList = orderMapper.findAllOrder(pageBounds);
		return new PageResult<Order>(orderList);
	}

	@Override
	public PageResult<Order> findAllOrderPurpose(PageBounds pageBounds, SearchOrderVO searchOrderVO) {
		PageList<Order> orderList = orderMapper.findOrderPurpose(pageBounds, searchOrderVO);
		return new PageResult<Order>(orderList);
	}

	@Override
	public List<RoomPrice> findLiveDayRoomPriceDetail(SearchRoomPriceVO searchRoomPriceVO) {

		List<RoomPrice> roomPriceList = new ArrayList<RoomPrice>();

		List<Date> dateList = DateApplication.returnDateList(searchRoomPriceVO.getBeginDate(),
				searchRoomPriceVO.getEndDate());
		for (Date date : dateList) {
			RoomPrice roomPrice = roomPriceMapper.findRoomPriceBysaleDateNRoomId(date, searchRoomPriceVO.getRoomId());
			roomPriceList.add(roomPrice);
		}
		return roomPriceList;
	}

	@Override
	public String bookingOrderHandler(BookingOrderVO bookingOrderVO) {

		String message = "下单失败或者已经下单";
		// 总价格
		Double totalAmount = 0.0;
		if (orderMapper.selectByPrimaryKey(bookingOrderVO.getOrderId()).getProviderStatus() == null) {

			String bookingOrderResult = null;
			// 返回状态 下单成功，或者下单失败
			// 寻找当前订单的配置信息
			UserConfig userConfig = userConfigMapper.selectUserConfigByUserIdNConfigTypeNConfigId(
					UserUtils.getCurrentUser().getId(), 1, bookingOrderVO.getProviderId());
			// 离店日期不计算
			List<Date> dateList = DateApplication.returnDateListNotEndDate(
					DateApplication.stringToDate(bookingOrderVO.getBeginDate()),
					DateApplication.stringToDate(bookingOrderVO.getEndDate()));
			for (Date date : dateList) {
				RoomPrice roomPrice = roomPriceMapper.findRoomPriceBysaleDateNRoomId(date,
						Integer.parseInt(bookingOrderVO.getRoomId()));
				totalAmount = totalAmount + roomPrice.getSalePrice() * Integer.parseInt(bookingOrderVO.getBookAmount());
			}
			// 配置下单
			BookingOrder bookingOrder = new BookingOrder();
			bookingOrder.setBeginDate(bookingOrderVO.getBeginDate());
			bookingOrder.setBookAmount(bookingOrderVO.getBookAmount());
			bookingOrder.setBookPhone(bookingOrderVO.getBookPhone());
			bookingOrder.setBookUser(bookingOrderVO.getBookUser());
			bookingOrder.setDays(bookingOrderVO.getDays());
			bookingOrder.setEndDate(bookingOrderVO.getEndDate());
			bookingOrder.setHotelId(bookingOrderVO.getHotelId());
			bookingOrder.setPassword(userConfig.getUserPwd());
			bookingOrder.setRemark(bookingOrderVO.getRemark());
			bookingOrder.setRoomId(bookingOrderVO.getRoomId());
			bookingOrder.setUsername(userConfig.getUserNo());
			// action为 下单
			bookingOrder.setAction("http://localhost:8080/hotel-system/bookingOrder");
			bookingOrder.setAmount(String.valueOf(totalAmount));
			String bookingOrderJsonString = Utils.dataConvertJsonString(bookingOrder);
			String url = "http://localhost:8080/hotel-system/provider/order/" + bookingOrderVO.getProviderId()
					+ "/bookingOrder.do";
			bookingOrderResult = httpClientRequestService.post(url, bookingOrderJsonString);
			JsonObject bookingOrderResultJsonObject = jsonParser.parse(bookingOrderResult).getAsJsonObject();
			message = bookingOrderResultJsonObject.get("message").getAsString();
		}

		if (message.equals("下单成功")) {
			Order order = orderMapper.selectByPrimaryKey(bookingOrderVO.getOrderId());
			order.setProviderStatus("确认");
			order.setProviderOrderNo(String.valueOf(Calendar.getInstance().getTimeInMillis()));
			order.setUserId(UserUtils.getCurrentUser().getId());
			order.setProviderAmount(totalAmount.floatValue());
			updataOrderData(order);
		}
		return message;
	}

	@Override
	public Integer updataOrderData(Order order) {
		return orderMapper.updateByPrimaryKey(order);
	}

	@Override
	public Order findOrderById(Integer id) {
		return orderMapper.selectByPrimaryKey(id);
	}

	@Override
	public String arrangeRoomHandler(ArrangeRoomVO arrangeRoomVO) {

		String arrangeRoomResult = null;

		String message = "还没进行下单操作或者下单不成功";
		// 判断是否这个订单已经确认了
		OrderExample orderExample = new OrderExample();
		orderExample.createCriteria().andMarketOrderNoEqualTo(arrangeRoomVO.getOrderNo())
				.andProviderStatusEqualTo("确认");
		List<Order> orderList = orderMapper.selectByExample(orderExample);

		System.out.println(orderList.isEmpty());

		// 如果!null
		if (!orderList.isEmpty()) {
			UserConfig userConfig = userConfigMapper.selectUserConfigByUserIdNConfigTypeNConfigId(
					UserUtils.getCurrentUser().getId(), 2, arrangeRoomVO.getMarketId());
			ArrangeRoom arrangeRoom = new ArrangeRoom();
			arrangeRoom.setAction("http://localhost:8080/hotel-system/arrangeRoom");
			arrangeRoom.setOrderNo(arrangeRoomVO.getOrderNo());
			arrangeRoom.setPassword(userConfig.getUserPwd());
			arrangeRoom.setUsername(userConfig.getUserNo());
			String arrangeRoomJsonString = Utils.dataConvertJsonString(arrangeRoom);
			String url = "http://localhost:8080/hotel-system/provider/order/" + arrangeRoomVO.getMarketId()
					+ "/arrangeRoom.do";
			arrangeRoomResult = httpClientRequestService.post(url, arrangeRoomJsonString);
			JsonObject arrangeRoomResultJsonObject = jsonParser.parse(arrangeRoomResult).getAsJsonObject();
			message = arrangeRoomResultJsonObject.get("message").getAsString();

		}
		return message;
	}

}
