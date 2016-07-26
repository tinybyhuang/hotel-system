package com.distinct.hotel.order.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.distinct.hotel.common.UserUtils;
import com.distinct.hotel.common.page.PageResult;
import com.distinct.hotel.common.page.Pageable;
import com.distinct.hotel.order.model.Order;
import com.distinct.hotel.order.service.HttpClientRequestService;
import com.distinct.hotel.order.service.OrderManageService;
import com.distinct.hotel.order.service.UserConfigManagerService;
import com.distinct.hotel.order.vo.ArrangeRoomVO;
import com.distinct.hotel.order.vo.BookingOrderVO;
import com.distinct.hotel.order.vo.SearchOrderVO;
import com.distinct.hotel.order.vo.SearchRoomPriceVO;
import com.distinct.hotel.product.model.RoomPrice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/order")
public class OrderManageController {

	@Resource
	private OrderManageService orderManageService;

	@Resource
	private HttpClientRequestService httpClientRequestService;

	@Resource
	private UserConfigManagerService userConfigManagerService;
	// 对接平台的订单接口，同步订单数据到本地数据库进行订单管理，包括安排房间以及发送短信

	// 管理订单数据
	// 根据makertId即是平台区分数据

	@RequestMapping("/manageOrder")
	public String manageOrder(Model model, Pageable pageable) {
		SearchOrderVO searchOrderVO = new SearchOrderVO();
		searchOrderVO.setMarketStatus("待安排房间");
		model.addAttribute("user", UserUtils.getCurrentUser());
		pageable.setPageSize(10);
		List<Integer> marketIdList = orderManageService.returnAllMarketId();
		model.addAttribute("marketIdList", marketIdList);
		// PageResult<Order> orderList =
		// orderManageService.findAllOrder(pageable.toPageBounds());
		PageResult<Order> orderList = orderManageService.findAllOrderPurpose(pageable.toPageBounds(), searchOrderVO);
		model.addAttribute("orderList", orderList);
		model.addAttribute("search", searchOrderVO);
		return "order/view/show-order-page";
	}

	@RequestMapping(value = "/manageOrder", method = RequestMethod.POST)
	public String findOrderPurpose(Model model, Pageable pageable, SearchOrderVO searchOrderVO) {
		model.addAttribute("user", UserUtils.getCurrentUser());
		pageable.setPageSize(10);
		List<Integer> marketIdList = orderManageService.returnAllMarketId();
		PageResult<Order> orderList = orderManageService.findAllOrderPurpose(pageable.toPageBounds(), searchOrderVO);
		model.addAttribute("orderList", orderList);
		model.addAttribute("search", searchOrderVO);
		model.addAttribute("marketIdList", marketIdList);
		return "order/view/show-order-page";
	}

	// 检查room-amount持房量
	@RequestMapping(value = "/findRoomPrice", method = RequestMethod.POST)
	@ResponseBody
	public String findRoomPrice(SearchRoomPriceVO searchRoomPriceVO) {
		List<RoomPrice> roomPriceList = orderManageService.findLiveDayRoomPriceDetail(searchRoomPriceVO);
		String roomPriceListJson = null;
		if (roomPriceList != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setDateFormat(sdf);
			try {
				roomPriceListJson = objectMapper.writeValueAsString(roomPriceList);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return roomPriceListJson;
		} else {
			return roomPriceListJson;
		}
	}

	// 下单操作,与供应商对接，configType为1
	@RequestMapping(value = "/bookingOrder", method = RequestMethod.POST)
	@ResponseBody
	public String bookingOrder(BookingOrderVO bookingOrderVO) {
		// 当这边下单成功了，需要进行待安排房间操作，通知这个订单成功了即可
		// 当这边下单失败了，，可以进行取消订单申请返回到平台
		String status = null;
		status = orderManageService.bookingOrderHandler(bookingOrderVO);
		return status;
	}

	// 安排房间
	@RequestMapping(value = "/arrangeRoom", method = RequestMethod.POST)
	@ResponseBody
	public String arrangeRoom(ArrangeRoomVO arrangeRoomVO) {
		String status = null;
		status = orderManageService.arrangeRoomHandler(arrangeRoomVO);
		return status;
	}

	// 取消单操作
	@RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
	public String cancleOrder() {
		return null;
	}

	@RequestMapping("/testHttpGet")
	@ResponseBody
	public String testHttpGet() {
		String result = httpClientRequestService.get("http://www.baidu.com/");
		return result;
	}

}
