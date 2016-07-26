package com.distinct.hotel.service.market.service;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;
import com.distinct.hotel.common.Constants.Market;
import com.distinct.hotel.common.Utils;
import com.distinct.hotel.order.dao.OrderMapper;
import com.distinct.hotel.order.model.Order;
import com.distinct.hotel.order.model.OrderExample;
import com.distinct.hotel.product.dao.HotelMapper;
import com.distinct.hotel.product.dao.RoomMapper;
import com.distinct.hotel.product.model.Hotel;
import com.distinct.hotel.product.model.HotelExample;
import com.distinct.hotel.product.model.Room;
import com.distinct.hotel.product.model.RoomExample;

@Component
public class OrderSyncService {
	
	private static final int marketId = Market.Ctrip.getId();
	private static final int personAmount = 1;
	private static final float roomPrice = 250;
	private static final Date day = new Date();
	
	private static final String note = "赶紧定房间啊";
	@Resource
	private RoomMapper roomMapper;
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private HotelMapper hotelMapper;
	
	public void syncOrder(){
		
		RoomExample example = new RoomExample();
		example.createCriteria().andIdGreaterThan(0);
		List<Room> rooms = roomMapper.selectByExample(example);
		for(Room room : rooms){
			Order order = new Order();
			order.setMarketId(marketId);
			order.setMarketOrderNo(new Date().getTime() + "");
			order.setProviderId(room.getProviderId());
			order.setHotelId(room.getHotelId() + "");
			order.setRoomId(room.getProviderRoomId() + "");
			order.setBookUser(Utils.getNames());
			order.setBookAmout(personAmount);
			order.setBookPhone(Utils.getPhone());
			int begin = Utils.getDays();//开始时间
			int length = Utils.getDays(); //结束时间
			Date beginDate = DateUtils.addDays(day, begin);
			Date endDate = DateUtils.addDays(beginDate, length);
			order.setBeginDate(beginDate);
			order.setEndDate(endDate);
			order.setDays(length);
			order.setMarketAmount(roomPrice * length);
			order.setState(note);
			order.setMarketStatus(Utils.getStatus());
			order.setCreated(day);
			orderMapper.insertSelective(order);
		}
	}
	
	public void matchHotel(){
		OrderExample orderExample = new OrderExample();
		orderExample.createCriteria().andIdGreaterThan(0);
		List<Order> orders = orderMapper.selectByExample(orderExample);
		for(Order order : orders){
			//获取房型名称
			boolean flag = false;
			RoomExample roomExample = new RoomExample();
			roomExample.createCriteria().andProviderIdEqualTo(order.getProviderId())
			.andProviderRoomIdEqualTo(Integer.valueOf(order.getRoomId()));
			List<Room> rooms = roomMapper.selectByExample(roomExample);
			if(rooms != null && rooms.size() > 0){
				order.setRoomName(rooms.get(0).getRoomName());
				flag = true;
			}
			
			//获取酒店名称
			HotelExample hotelExample = new HotelExample();
			hotelExample.createCriteria().andProviderIdEqualTo(order.getProviderId())
			.andProviderHotelIdEqualTo(Integer.valueOf(order.getHotelId()));
			List<Hotel> hotels = hotelMapper.selectByExample(hotelExample);
			if(hotels != null && hotels.size() > 0){
				order.setHotelName(hotels.get(0).getHotelName());
				flag = true;
			}
			
			if (flag) {
				orderMapper.updateByPrimaryKeySelective(order);
			}
		}
	}
}
