package com.distinct.hotel.service.provider.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.distinct.hotel.service.market.vo.ArrangeRoom;
import com.distinct.hotel.service.market.vo.ArrangeRoomResult;
import com.distinct.hotel.service.provider.service.ProviderService;
import com.distinct.hotel.service.provider.vo.BookingOrder;
import com.distinct.hotel.service.provider.vo.BookingOrderResult;
import com.distinct.hotel.service.provider.vo.CancelOrder;
import com.distinct.hotel.service.provider.vo.CancelOrderResult;

@Controller
@RequestMapping("/provider/order")
public class ProviderController {
	@Resource
	private ProviderService providerService;

	@RequestMapping(value = "/{privoderId}/bookingOrder.do", method = RequestMethod.POST)
	@ResponseBody
	private BookingOrderResult bookingOrder(@RequestBody BookingOrder bookingOrder, @PathVariable Integer privoderId) {
		BookingOrderResult result = new BookingOrderResult();
		try {
			if (privoderId != null && privoderId > 0 && privoderId < 3) {
				if (bookingOrder != null) {
					providerService.bookingOrder(privoderId, bookingOrder, result);
				} else {
					result.setMessage("输入数据错误");
				}

			} else {
				result.setMessage("供应商不存在");
			}
		} catch (Exception e) {
			result.setMessage("服务器错误");
		}
		return result;
	}

	@RequestMapping(value = "/{marketId}/cancelOrder.do",method=RequestMethod.POST)
	@ResponseBody
	private CancelOrderResult cancelOrder(@RequestBody CancelOrder cancelOrder, @PathVariable Integer marketId){
		CancelOrderResult result = new CancelOrderResult();
		try {
			if (marketId != null && marketId > 0 && marketId < 4) {
				if (cancelOrder != null) {
					providerService.cancelOrder(marketId, cancelOrder, result);
				} else {
					result.setMessage("输入数据错误");
				}
			} else {
				result.setMessage("平台不存在");
			}
		} catch (Exception e) {
			result.setMessage("服务器错误");
		}
		return result;
	}

	@RequestMapping(value = "/{marketId}/arrangeRoom.do", method = RequestMethod.POST)
	@ResponseBody
	private ArrangeRoomResult arrangeRoom(@RequestBody ArrangeRoom arrangeRoom, @PathVariable Integer marketId) {
		ArrangeRoomResult result = new ArrangeRoomResult();
		try {
			if (marketId != null && marketId > 0 && marketId < 4) {
				if (arrangeRoom != null) {
					providerService.arrangeRoom(marketId, arrangeRoom, result);
				} else {
					result.setMessage("输入数据错误");
				}

			} else {
				result.setMessage("平台不存在");
			}
		} catch (Exception e) {
			result.setMessage("服务器错误");
		}
		return result;
	}
}
