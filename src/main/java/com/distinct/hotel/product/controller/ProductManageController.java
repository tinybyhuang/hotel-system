package com.distinct.hotel.product.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.distinct.hotel.common.UserUtils;
import com.distinct.hotel.common.page.PageResult;
import com.distinct.hotel.common.page.Pageable;
import com.distinct.hotel.product.model.City;
import com.distinct.hotel.product.model.DetailIncreaseRule;
import com.distinct.hotel.product.model.SaleStatus;
import com.distinct.hotel.product.service.CityService;
import com.distinct.hotel.product.service.DetailIncreaseRuleService;
import com.distinct.hotel.product.service.ProductHotelService;
import com.distinct.hotel.product.service.SaleStatusService;
import com.distinct.hotel.product.vo.DetailIncreaseRuleSearchVO;
import com.distinct.hotel.product.vo.HotelDetailVO;
import com.distinct.hotel.product.vo.HotelPriceVO;
import com.distinct.hotel.product.vo.HotelPurposeVO;
import com.distinct.hotel.product.vo.PriceNDateVO;
import com.distinct.hotel.product.vo.SetDetailIncreaseRuleVO;
import com.distinct.hotel.product.vo.SetSaleStatusVO;
import com.distinct.hotel.sale.service.SaleRuleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/product")
public class ProductManageController {
	@Resource
	private ProductHotelService productHotelService;
	@Resource
	private CityService cityService;
	@Resource
	private SaleStatusService saleStatusService;
	@Resource
	private DetailIncreaseRuleService detailIncreaseRuleService;
	@Resource
	private SaleRuleService saleRuleService;

	@RequestMapping("/returnUser")
	public String returnUser(Model model){
		model.addAttribute("user", UserUtils.getCurrentUser());
		return "../index";
	}
	
	// 返回酒店所有数据
	@RequestMapping("/hotels")
	public String hotelList(Pageable pageable, Model model) {

		Integer defaultMarketId = 0;
		// 返回当前的用户
		model.addAttribute("user", UserUtils.getCurrentUser());
		List<City> citys = cityService.findAll();
		pageable.setPageSize(10); // 设置每页十条数据
		PageResult<HotelDetailVO> hotelPage = productHotelService.findDetail(pageable.toPageBounds());
		List<Integer> marketIdList = productHotelService.findSaleRuleByUserIdNMarketId();
		if (marketIdList.contains(1)) {
			defaultMarketId = 1;
		} else if (!(marketIdList.contains(1)) && marketIdList.contains(2)) {
			defaultMarketId = 2;
		} else if (!(marketIdList.contains(1)) && !(marketIdList.contains(2)) && marketIdList.contains(3)) {
			defaultMarketId = 3;
		}
		model.addAttribute("defaultMarket", defaultMarketId);// 默认携程平台
		model.addAttribute("marketId", marketIdList);
		model.addAttribute("page", hotelPage);
		model.addAttribute("citys", citys);
		return "product/view/product-hotel-page";
	}

	// 返回酒店所有数据，条件查询
	@RequestMapping(value = "/hotels", method = RequestMethod.POST)
	public String purposeHotelList(Pageable pageable, Model model, HotelPurposeVO search) {
		// 城市的返回值不变，但是在显示方面因为选择了城市，应该在当前返回的页面中显示当前城市和星级的选择
		pageable.setPageSize(10);// 设置每页十条数据
		List<City> citys = cityService.findAll();
		List<Integer> marketIdList = productHotelService.findSaleRuleByUserIdNMarketId();
		// 传入userid 以及 marketid
		model.addAttribute("user", UserUtils.getCurrentUser());
		model.addAttribute("marketId", marketIdList);// 返回平台
		PageResult<HotelDetailVO> hotelPage = productHotelService.findPurposeDetail(pageable.toPageBounds(), search);
		model.addAttribute("page", hotelPage);
		model.addAttribute("citys", citys);
		model.addAttribute("searchDetail", search);
		return "product/view/product-hotel-page";
	}

	// 查询每个酒店下所有房型所有房价(旧，页面没请求)
	@RequestMapping(value = "/allRoomDetail", method = RequestMethod.POST)
	@ResponseBody
	public String allRoomDetail(Model model, @RequestParam("providerHotelId") int providerHotelId) {
		String roomJsonData = null;
		HotelDetailVO hotelDetailVO = productHotelService.findPrice(providerHotelId);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			roomJsonData = objectMapper.writeValueAsString(hotelDetailVO);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return roomJsonData;
	}

	// 单独房型查询房价，并且需要通过检测该房型有没有经过详细加幅的设置(旧)
	@ResponseBody
	public String roomDetail(Model model, @RequestParam("providerRoomId") int providerRoomId) {

		// 以下为json数据设置
		String roomJsonData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		objectMapper.setDateFormat(sdf);

		// 获取价格以及上下架状态数据
		List<PriceNDateVO> priceNDateVOList = productHotelService.findPriceAndSaleDate(providerRoomId);

		// 转化为json数据
		try {
			roomJsonData = objectMapper.writeValueAsString(priceNDateVOList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return roomJsonData;
	}

	// 详细加幅 增删查改
	// 增
	@RequestMapping(value = "/setDetailIncreaseRules", method = RequestMethod.POST)
	@ResponseBody
	public String updateDetailIncreaseRule(Model model, SetDetailIncreaseRuleVO detailIncreaseRuleVO) {

		productHotelService.setDetailIncreaseRule(detailIncreaseRuleVO);
		// saleStatusService.addSaleStatus(detailIncreaseRuleVO); //上下架设置
		// productHotelService.setNewPrice(detailIncreaseRuleVO);
		String roomPriceJsonData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		objectMapper.setDateFormat(sdf);
		List<PriceNDateVO> priceNDateVOList = productHotelService
				.requirePriceDetailAndSaleStatus(HotelPriceVO.detailIncreaseRuleVOToHotelPriceVO(detailIncreaseRuleVO));
		try {
			roomPriceJsonData = objectMapper.writeValueAsString(priceNDateVOList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return roomPriceJsonData;
	}

	// 根据房型id上下架
	@RequestMapping(value = "/setSaleStatus", method = RequestMethod.POST)
	@ResponseBody
	public String setAllSaleStatus(SetSaleStatusVO saleStatusVO) {
		saleStatusService.setSaleStatus(saleStatusVO);
		String roomPriceJsonData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		objectMapper.setDateFormat(sdf);
		List<PriceNDateVO> priceNDateVOList = productHotelService
				.requirePriceDetailAndSaleStatus(HotelPriceVO.saleStatusVOToHotelPriceVO(saleStatusVO));
		try {
			roomPriceJsonData = objectMapper.writeValueAsString(priceNDateVOList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return roomPriceJsonData;
	}

	// 最后修改:2016-05-06
	// 返回房价数据和详细加幅和上下架
	// 返回的数值通过新建的innerHTML展示出来
	@RequestMapping(value = "/roomDetail", method = RequestMethod.POST)
	@ResponseBody
	public String findPriceDetailNSaleStatus(Model model, HotelPriceVO HotelPriceVO) {
		// 因为详细加幅三种，以平台和供应商区分，所以需要传回来一个平台id，需找是哪一种详细加幅

		// 以下为json数据设置
		String roomPriceJsonData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		/*JSON数据日期格式化*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		objectMapper.setDateFormat(sdf);

		// 获取价格以及上下架状态数据
		List<PriceNDateVO> priceNDateVOList = productHotelService.requirePriceDetailAndSaleStatus(HotelPriceVO);

		// 转化为json数据
		try {
			roomPriceJsonData = objectMapper.writeValueAsString(priceNDateVOList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return roomPriceJsonData;
	}

	// 两个按键
	// 一个详细加幅按键,回填当前房型当天的详细加幅

	@RequestMapping(value = "/findDetailIncreaseRule", method = RequestMethod.POST)
	@ResponseBody
	public String returnDetailIncreaseRule(DetailIncreaseRuleSearchVO detailIncreaseRuleSearchVO) {

		DetailIncreaseRule detailIncreaseRule = detailIncreaseRuleService
				.findDetailIncreaseRuleByMarketIdNroomIdNsaleDateNproviderId(detailIncreaseRuleSearchVO.getRoomId(),
						detailIncreaseRuleSearchVO.getSaleDate(), detailIncreaseRuleSearchVO.getMarketId(),
						detailIncreaseRuleSearchVO.getProviderId());
		if (detailIncreaseRule == null) {
			return "数据为空";
		} else {
		// 以下为json数据设置
		String detailIncreaseRuleJsonData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		objectMapper.setDateFormat(sdf);
		// 转化为json数据
		try {
			detailIncreaseRuleJsonData = objectMapper.writeValueAsString(detailIncreaseRule);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return detailIncreaseRuleJsonData;
		}
	}

	// 一个上下架按键，回填当前房型详细上下架
	@RequestMapping(value = "/findSaleStatus", method = RequestMethod.POST)
	@ResponseBody
	public String returnSaleStatus(@RequestParam("roomId") int roomId, @RequestParam("marketId") Integer marketId,
			@RequestParam("providerId") int providerId) {
		List<SaleStatus> saleStatusList = saleStatusService.findSaleStatusByMarketIdNroomIdNproviderIdNToday(roomId,
				marketId, providerId);

		if (saleStatusList.size() == 0) {
			return "数据为空";
		} else if (saleStatusList.size() != 0) {

			// 以下为json数据设置
			String saleStatusListJsonData = null;
			ObjectMapper objectMapper = new ObjectMapper();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			objectMapper.setDateFormat(sdf);
			// 转化为json数据
			try {
				saleStatusListJsonData = objectMapper.writeValueAsString(saleStatusList);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return saleStatusListJsonData;
		} else
			return "数据为空";//返回一个String值给前台判断
		
	}
	
	

}
