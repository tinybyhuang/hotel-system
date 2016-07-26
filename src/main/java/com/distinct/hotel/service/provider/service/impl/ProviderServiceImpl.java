package com.distinct.hotel.service.provider.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import com.distinct.hotel.common.Utils;
import com.distinct.hotel.order.dao.OrderMapper;
import com.distinct.hotel.order.dao.UserConfigMapper;
import com.distinct.hotel.order.model.Order;
import com.distinct.hotel.order.model.OrderExample;
import com.distinct.hotel.order.model.UserConfig;
import com.distinct.hotel.order.model.UserConfigExample;
import com.distinct.hotel.product.dao.HotelMapper;
import com.distinct.hotel.product.dao.RoomMapper;
import com.distinct.hotel.product.dao.RoomPriceMapper;
import com.distinct.hotel.product.model.Hotel;
import com.distinct.hotel.product.model.HotelExample;
import com.distinct.hotel.product.model.Room;
import com.distinct.hotel.product.model.RoomExample;
import com.distinct.hotel.product.model.RoomPrice;
import com.distinct.hotel.product.model.RoomPriceExample;
import com.distinct.hotel.service.market.vo.ArrangeRoom;
import com.distinct.hotel.service.market.vo.ArrangeRoomResult;
import com.distinct.hotel.service.provider.service.ProviderService;
import com.distinct.hotel.service.provider.vo.BookingOrder;
import com.distinct.hotel.service.provider.vo.BookingOrderResult;
import com.distinct.hotel.service.provider.vo.CancelOrder;
import com.distinct.hotel.service.provider.vo.CancelOrderResult;

@Service
public class ProviderServiceImpl implements ProviderService {
	@Resource
	private UserConfigMapper userConfigMapper;
	@Resource
	private HotelMapper hotelMapper;
	@Resource
	private RoomMapper roomMapper;
	@Resource
	private RoomPriceMapper roomPriceMapper;
	@Resource
	private OrderMapper orderMapper;

	@Override
	public boolean authUser(String username, String password, Integer privoderId) {
		boolean flag = false;
		UserConfigExample example = new UserConfigExample();
		example.createCriteria().andConfigIdEqualTo(privoderId).andConfigTypeEqualTo(1).andUserNoEqualTo(username)
				.andUserPwdEqualTo(password);
		List<UserConfig> records = userConfigMapper.selectByExample(example);
		if (records != null && records.size() > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean authMarketUser(String username, String password, Integer marketId) {
		boolean flag = false;
		UserConfigExample example = new UserConfigExample();
		example.createCriteria().andConfigIdEqualTo(marketId).andConfigTypeEqualTo(2).andUserNoEqualTo(username)
				.andUserPwdEqualTo(password);
		List<UserConfig> records = userConfigMapper.selectByExample(example);
		if (records != null && records.size() > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean authHotel(Integer privoderId, Integer hotelId) {
		boolean flag = false;
		HotelExample example = new HotelExample();
		example.createCriteria().andProviderIdEqualTo(privoderId).andProviderHotelIdEqualTo(hotelId);
		List<Hotel> records = hotelMapper.selectByExample(example);
		if (records != null && records.size() > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean authRoom(Integer privoderId, Integer hotelId, Integer roomId) {
		boolean flag = false;
		RoomExample example = new RoomExample();
		example.createCriteria().andProviderIdEqualTo(privoderId).andHotelIdEqualTo(hotelId)
				.andProviderRoomIdEqualTo(roomId);
		List<Room> records = roomMapper.selectByExample(example);
		if (records != null && records.size() > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public void bookingOrder(Integer privoderId, BookingOrder bookingOrder, BookingOrderResult result) {

		int persons = Integer.valueOf(bookingOrder.getBookAmount()); // 判断预约人数
		if (persons > 0) {
			boolean flag = authUser(bookingOrder.getUsername(), bookingOrder.getPassword(), privoderId); // 判断授权用户
			if (flag) {
				boolean hotelFlag = authHotel(privoderId, Integer.valueOf(bookingOrder.getHotelId())); // 判断酒店
				if (hotelFlag) {
					boolean roomFlag = authRoom(privoderId, Integer.valueOf(bookingOrder.getHotelId()), // 判断房型
							Integer.valueOf(bookingOrder.getRoomId()));
					if (roomFlag) {

						Date beginDate = Utils.parseDate(bookingOrder.getBeginDate(), "yyyy-MM-ddd");

						Date endDate = Utils.parseDate(bookingOrder.getEndDate(), "yyyy-MM-ddd");

						boolean dateFlag = checkDate(beginDate, endDate, Integer.valueOf(bookingOrder.getDays())); // 判断住离店时间
						if (dateFlag) {

							RoomPriceExample example = new RoomPriceExample();
							example.createCriteria().andProviderIdEqualTo(privoderId)
									.andRoomIdEqualTo(Integer.valueOf(bookingOrder.getRoomId()))
									.andSaleDateBetween(beginDate, endDate).andSaleDateNotEqualTo(endDate);
							List<RoomPrice> records = roomPriceMapper.selectByExample(example);
							double amount = 0;
							boolean amountFlag = true;
							if (records.size() == Integer.valueOf(bookingOrder.getDays())) { // 判断是否有房
								for (RoomPrice price : records) {
									int roomAmount = price.getRoomAmount();
									if (persons > roomAmount) { // 判断房量
										String str = Utils.formatDate(price.getSaleDate(), "yyyy-MM-dd");
										result.setMessage(str + "房间数量不够");
										amountFlag = false;
										break;
									}
									amount = amount + price.getSalePrice() * persons;

									price.setRoomAmount(price.getRoomAmount() - persons);

								}

								if (amountFlag) {
									if (amount == Double.valueOf(bookingOrder.getAmount())) { // 判断预定金额

										updateRoomPrice(records);

										result.setCode("1");
										result.setHotelId(bookingOrder.getHotelId());
										result.setRoomId(bookingOrder.getRoomId());
										result.setMessage("下单成功");
										result.setStatus("成功");

									} else {
										result.setMessage("预定金额错误");
									}
								}

							} else {
								result.setMessage("存在没房的日期");
							}

						} else {
							result.setMessage("入离店时间错误");
						}

					} else {
						result.setMessage("找不到房型");
					}
				} else {
					result.setMessage("找不到酒店");
				}

			} else {
				result.setMessage("用户授权失败");
			}
		} else {
			result.setMessage("入住人数错误");
		}

	}

	private boolean checkDate(Date beginDate, Date endDate, int days) {
		boolean flag = false;

		beginDate = DateUtils.truncate(beginDate, Calendar.DATE);

		endDate = DateUtils.truncate(endDate, Calendar.DATE);

		Date date = DateUtils.addDays(beginDate, days);

		if (date.getTime() == endDate.getTime()) {
			flag = true;
		}

		return flag;
	}

	@Override
	public void updateRoomPrice(List<RoomPrice> records) {
		for (RoomPrice price : records) {
			roomPriceMapper.updateByPrimaryKeySelective(price);
		}

	}

	@Override
	public void cancelOrder(Integer marketId, CancelOrder cancelOrder, CancelOrderResult result) {
		boolean flag = authMarketUser(cancelOrder.getUsername(), cancelOrder.getPassword(), marketId); // 判断授权用户
		if (flag) {
			boolean orderFlag = authOrder(marketId, cancelOrder.getOrderNo());
			if (orderFlag) {
				result.setCode("1");
				result.setOrderNo(cancelOrder.getOrderNo());
				result.setMessage("取消订单成功");
			} else {
				result.setMessage("该订单数据不存在");
			}
		} else {
			result.setMessage("用户授权失败");
		}
	}

	@Override
	public boolean authOrder(Integer marketId, String marketOrderNo) {
		boolean flag = false;
		OrderExample example = new OrderExample();
		example.createCriteria().andMarketIdEqualTo(marketId).andMarketOrderNoEqualTo(marketOrderNo);
		List<Order> records = orderMapper.selectByExample(example);
		if (records != null && records.size() > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public void arrangeRoom(Integer marketId, ArrangeRoom arrangeRoom, ArrangeRoomResult result) {
		boolean flag = authMarketUser(arrangeRoom.getUsername(), arrangeRoom.getPassword(), marketId); // 判断授权用户
		// 如果有这个平台用户配置
		if (flag) {

			// 判断是否已经安排房间
			result.setCode("1");// 返回状态码
			result.setMessage("已确认订单");// 返回来的信息
			result.setOrderNo(arrangeRoom.getOrderNo());// 返回来的订单号
			result.setStatus("确认");// 返回来的状态
		} else {
			result.setMessage("用户授权失败");
		}
	}

}
