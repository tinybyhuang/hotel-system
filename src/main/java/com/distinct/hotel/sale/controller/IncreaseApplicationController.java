package com.distinct.hotel.sale.controller;

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
import com.distinct.hotel.product.service.CityService;
import com.distinct.hotel.product.service.ProductHotelService;
import com.distinct.hotel.product.vo.HotelDetailVO;
import com.distinct.hotel.product.vo.HotelPurposeVO;
import com.distinct.hotel.sale.model.IncreaseRule;
import com.distinct.hotel.sale.service.HotelNIncreaseService;
import com.distinct.hotel.sale.vo.SetIncreaseRuleVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/sale")
public class IncreaseApplicationController {

	@Resource
	private CityService cityService;

	@Resource
	private ProductHotelService productHotelService;

	@Resource
	private HotelNIncreaseService hotelNIncreaseService;

	// 初始化saleRuleID，可以根据传进来的saleRuleId定值
	private static Integer saleRuleID = 0;

	@RequestMapping("/hotelRecords")
	public String hotelRecords(Model model, Pageable pageable, @RequestParam("searchId") int saleRuleId) {

		saleRuleID = saleRuleId;

		// 返回当前的登录用户
		model.addAttribute("user", UserUtils.getCurrentUser());

		// 返回所有的城市
		List<City> citys = cityService.findAll();
		model.addAttribute("citys", citys);

		Integer defaultMarketId = 0; // 默认平台携程 id为1
		Integer providerId = 1; // 默认供应商为 1 捷旅
		List<Integer> marketIdList = productHotelService.findSaleRuleByUserIdNMarketId();

		defaultMarketId = hotelNIncreaseService.findSaleRuleById(saleRuleID).getMarketId();

		/*
		 * if (marketIdList.contains(1)) { defaultMarketId = 1; } else if
		 * (!(marketIdList.contains(1)) && marketIdList.contains(2)) {
		 * defaultMarketId = 2; } else if (!(marketIdList.contains(1)) &&
		 * !(marketIdList.contains(2)) && marketIdList.contains(3)) {
		 * defaultMarketId = 3; }
		 */

		model.addAttribute("marketId", marketIdList);
		model.addAttribute("defaultMarket", defaultMarketId);// 默认携程平台
		pageable.setPageSize(10); // 设置每页十条数据
		PageResult<HotelDetailVO> hotelPage = hotelNIncreaseService
				.findHotelDetailNIncreaseRule(pageable.toPageBounds(), defaultMarketId, providerId);
		model.addAttribute("page", hotelPage);

		// 返回有城市加幅的城市集合
		List<Integer> increaseCityList = hotelNIncreaseService.findIncreaseCityIdList(defaultMarketId, providerId);
		model.addAttribute("increaseCityList", increaseCityList);
		
		List<Integer>  allCityIdList  =  hotelNIncreaseService.findAllCityId();
		model.addAttribute("allCityList", allCityIdList);
		
        System.out.println(increaseCityList);
        System.out.println(allCityIdList);
		model.addAttribute("searchId", saleRuleID);
		return "sale/view/hotel-increase-page";
	}

	// 条件查找
	@RequestMapping(value = "/hotelRecords", method = RequestMethod.POST)
	public String hotelPRecords(Model model, Pageable pageable, HotelPurposeVO hotelPurposeVO) {
		// 返回当前的登录用户
		model.addAttribute("user", UserUtils.getCurrentUser());
		// 选择数据回填
		model.addAttribute("searchDetail", hotelPurposeVO);

		List<City> citys = cityService.findAll();
		model.addAttribute("citys", citys);

		List<Integer> marketIdList = productHotelService.findSaleRuleByUserIdNMarketId();
		model.addAttribute("marketId", marketIdList);

		pageable.setPageSize(10); // 设置每页十条数据
		PageResult<HotelDetailVO> hotelPage = hotelNIncreaseService
				.findPurPoseHotelDetailNIncreaseRule(pageable.toPageBounds(), hotelPurposeVO);
		model.addAttribute("page", hotelPage);

		List<Integer> increaseCityList = hotelNIncreaseService.findIncreaseCityIdList(hotelPurposeVO.getMarketId(),
				hotelPurposeVO.getProviderId());
		model.addAttribute("increaseCityList", increaseCityList);
		
		
		
		List<Integer>  allCityIdList  =  hotelNIncreaseService.findAllCityId();
		model.addAttribute("allCityList", allCityIdList);
		
        System.out.println(increaseCityList);
        System.out.println(allCityIdList);
        
		// 返回一个saleRuleID
		model.addAttribute("searchId", saleRuleID);
		return "sale/view/hotel-increase-page";
	}

	@RequestMapping(value = "/setIncreaseRule", method = RequestMethod.POST)
	@ResponseBody
	public String setIncreaseRule(SetIncreaseRuleVO setIncreaseRuleVO) {
		return hotelNIncreaseService.setIncreaseRule(setIncreaseRuleVO);
	}

	@RequestMapping(value = "/findIncreaseRule", method = RequestMethod.POST)
	@ResponseBody
	public String findIncreaseRule(@RequestParam("cityId") int cityId, @RequestParam("hotelId") int hotelId,
			@RequestParam("roomId") int roomId, @RequestParam("providerId") int providerId,
			@RequestParam("marketId") int marketId) {

		IncreaseRule increaseRule = hotelNIncreaseService.findIncreaseRulePurpose(cityId, hotelId, roomId, providerId,
				marketId);
		if (increaseRule == null) {
			return "数据为空";
		} else {
			// 以下为json数据设置
			String increaseRuleJsonData = null;
			ObjectMapper objectMapper = new ObjectMapper();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			objectMapper.setDateFormat(sdf);
			// 转化为json数据
			try {
				increaseRuleJsonData = objectMapper.writeValueAsString(increaseRule);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return increaseRuleJsonData;
		}
	}

}
