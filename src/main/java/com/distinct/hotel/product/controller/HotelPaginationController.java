package com.distinct.hotel.product.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.distinct.hotel.product.model.Hotel;
import com.distinct.hotel.product.service.GetAllHotelService;
import com.distinct.hotel.product.service.RoomService;
import com.distinct.hotel.product.vo.RoomPriceVO;
import com.fasterxml.jackson.core.JsonProcessingException;

//酒店数据分页控制器
//rewrite in 2016-3-30
@Controller
public class HotelPaginationController {

	@Resource
	private GetAllHotelService getAllHotelService;
	
	@Resource
	private RoomService roomService;

	private int totalPage;// 总页数
	private static final int dataSize = 15;// 当前显示数据数
	private int totalSize;// 总数据数

	// 在设置页面上把酒店所有的数据拿出来，不分页
	@RequestMapping("/show")
	public String returnTableToJsp(Model model) {
		List<Hotel> list = getAllHotelService.getHotel();
		model.addAttribute("list", list);
		return "product/view/product-setting";
	}

	// 当showPartOfHotel页面get请求访问时，返回页面同时返回第一页的数据
	@RequestMapping("/showPartOfHotel")
	public String defaultPage(Model model) throws JsonProcessingException {

		int page = 1;// 第一页
		totalSize = getAllHotelService.getNumber();
		totalPage = (totalSize % dataSize == 0) ? (totalSize / dataSize) : (totalSize / dataSize + 1);
		model.addAttribute("totalPage", totalPage);
		List<Hotel> list = new ArrayList<Hotel>();
		//ObjectMapper mapper = new ObjectMapper();
		if (page <= 1) {
			list = getAllHotelService.getHotelByCurrentPage((page - 1), dataSize);
		}
		model.addAttribute("currentPage", page);
		model.addAttribute("list", list);
		return "product/view/product-setting";
	}

	// ajax请求变化根据当前page值的每页的数据
	@RequestMapping(value = "/showPartOfHotel", method = { RequestMethod.GET, RequestMethod.POST })
	public String Paginator(@RequestParam(value = "page", defaultValue = "1") int page, Model model)
			throws JsonProcessingException {
		List<Hotel> list = new ArrayList<Hotel>();
		totalSize = getAllHotelService.getNumber();
		totalPage = (totalSize % dataSize == 0) ? (totalSize / dataSize) : (totalSize / dataSize + 1);
		model.addAttribute("totalPage", totalPage);
		if (page <= 1) {
			list = getAllHotelService.getHotelByCurrentPage((page - 1), dataSize);
		} else {
			list = getAllHotelService.getHotelByCurrentPage((dataSize * (page - 1)), dataSize);
		}
		model.addAttribute("list", list);
		model.addAttribute("currentPage", page);
		return "product/view/product-setting";
	}

	@RequestMapping(value = "/roomPriceAndName", method = { RequestMethod.GET, RequestMethod.POST })
	public String roomPriceInWeek(Model model) {

		List<RoomPriceVO> list = roomService.findRoomPriceAndName();

		//System.out.println(list.size());
		
	model.addAttribute("rooms", list);

		return "product/view/priceinaweek";

	}

}
