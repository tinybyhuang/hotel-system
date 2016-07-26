package com.distinct.hotel.sale.controller;

import java.util.ArrayList;
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
import com.distinct.hotel.product.model.Hotel;
import com.distinct.hotel.product.service.CityService;
import com.distinct.hotel.product.service.FilterHotelService;
import com.distinct.hotel.product.service.GetAllHotelService;
import com.distinct.hotel.product.service.ProductHotelService;
import com.distinct.hotel.product.service.RoomService;
import com.distinct.hotel.sale.model.BaseRule;
import com.distinct.hotel.sale.model.IncreaseRule;
import com.distinct.hotel.sale.model.SaleRule;
import com.distinct.hotel.sale.service.BaseRuleService;
import com.distinct.hotel.sale.service.FilterRuleService;
import com.distinct.hotel.sale.service.HotelRemarkService;
import com.distinct.hotel.sale.service.IncreaseRuleService;
import com.distinct.hotel.sale.service.PublishRuleService;
import com.distinct.hotel.sale.service.SaleRuleService;
import com.distinct.hotel.sale.service.SaleService;
import com.distinct.hotel.sale.vo.IncreaseRuleVO;
import com.distinct.hotel.sale.vo.SaleRuleVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("sale")
public class SaleController {
	@Resource
	private SaleService saleService;
	@Resource
	private BaseRuleService baseRuleService;
	@Resource
	private IncreaseRuleService increaseRuleService;
	@Resource
	private SaleRuleService saleRuleService;
	@Resource
	private PublishRuleService publishRuleService;
	@Resource
	private FilterRuleService filterRuleService;
	@Resource
	private HotelRemarkService hotelRemarkService;
	@Resource
	CityService cityService;
	@Resource
	FilterHotelService filterHotelService;
	@Resource
	RoomService roomService;
	@Resource
	GetAllHotelService getAllHotelService;
	@Resource
	ProductHotelService productHotelService;
	/****************************** for baserule */

	/*@RequestMapping(value = "/deleteBaseRule", method = RequestMethod.POST)
	public String baseRuleDelete(Model model, @RequestParam("deleteId") int id) {

		baseRuleService.deleteById(id);
		BaseRule rule = baseRuleService.selectById(id);
		model.addAttribute("baseRule", rule);
		return "sale/view/baseruledisplay";

	}

	@RequestMapping(value = "/updateBaseRule", method = RequestMethod.POST)

	public String baseRuleUpdate(Model model,BaseRuleVO baseRuleVO) {

		baseRuleService.updateBaseRule(baseRuleVO);
		BaseRule rule = baseRuleService.selectById(baseRuleVO.getBaseId());
		model.addAttribute("baseRule", rule);
		return "sale/view/baseruledisplay";
	}

	@RequestMapping(value = "/showBaseRule", method = RequestMethod.GET)
	public String showBaseRule(Model model, @RequestParam("searchId") int saleRuleId) throws ParseException {
		BaseRule rule = baseRuleService.selectBySaleRuleId(saleRuleId);
		BaseRule test = null;
		if (rule == test) {
			BaseRuleVO baseRuleVO = new BaseRuleVO();
			baseRuleVO.setSaleRuleId(saleRuleId);
			baseRuleService.insertBaseRule(baseRuleVO);
			rule = baseRuleService.selectBySaleRuleId(saleRuleId);

		}

		model.addAttribute("baseRule", rule);
		return "sale/view/baseruledisplay";
	}*/

	/******************************* for saleRule */
	@RequestMapping(value = "/insertSaleRule", method = RequestMethod.GET)
	public String insertSaleRule() {

		return "sale/view/salerule";
	}

	@RequestMapping(value = "/insertSaleRule", method = RequestMethod.POST)
	public String insertSaleRule(Model model, SaleRule saleRule) {
		saleRuleService.insertSaleRule(saleRule);
		return "sale/view/salerule";
	}

	@RequestMapping(value = "/showSaleRule", method = RequestMethod.GET)
	public String showSaleRuleInsert(Model model) {
		SaleRule rule = saleRuleService.selectSaleRuleByUserId(UserUtils.getCurrentUser().getId());
		SaleRule test = null;
		if (rule == test) {
			SaleRuleVO saleRuleVO = new SaleRuleVO();
			saleRuleService.insertSaleRuleVO(saleRuleVO);
			rule = saleRuleService.selectSaleRuleByUserId(UserUtils.getCurrentUser().getId());
		}
		int num = rule.getMarketId();
		SaleRuleVO BackVO = new SaleRuleVO();
		if (num == 1) {

			BackVO.setMarketName("携程");

		} else if (num == 2) {
			BackVO.setMarketName("去哪儿");
		} else {

			BackVO.setMarketName("淘宝");
		}
		BackVO.setCreated(rule.getCreated());
		BackVO.setMarketId(rule.getMarketId());
		BackVO.setModified(rule.getModified());
		BackVO.setModUserId(rule.getModUserId());
		BackVO.setStatus(rule.getStatus());
		BackVO.setId(rule.getId());

		model.addAttribute("saleRule", BackVO);

		return "sale/view/salemanager";
	}

	@RequestMapping(value = "deleteSaleRule", method = RequestMethod.POST)
	public String deleteSaleRule(Model model, @RequestParam("deleteId") int id) {
		saleRuleService.deleteById(id);
		SaleRule rule = saleRuleService.selectById(id);
		model.addAttribute("saleRule", rule);
		return "sale/view/salemanager";
	}

	@RequestMapping(value = "updateSaleRule", method = RequestMethod.POST)
	public String updateSaleRule(SaleRuleVO saleRuleVO, Model model) {

		saleRuleService.updateByIdSelective(saleRuleVO);
		List<SaleRule> ruleList = saleRuleService.selectListSaleRuleByUserId(UserUtils.getCurrentUser().getId());

		List<SaleRuleVO> VOList = new ArrayList<SaleRuleVO>();

		for (SaleRule rule : ruleList) {
			SaleRuleVO backVO = new SaleRuleVO();
			backVO.setCreated(rule.getCreated());
			backVO.setId(rule.getId());
			backVO.setMarketId(rule.getMarketId());
			backVO.setModified(rule.getModified());
			backVO.setModUserId(rule.getModUserId());
			backVO.setStatus(rule.getStatus());
			backVO.setUserId(rule.getUserId());
			if (backVO.getMarketId() == 1) {
				backVO.setMarketName("携程");

			} else if (backVO.getMarketId() == 2) {
				backVO.setMarketName("去哪儿");

			} else if (backVO.getMarketId() == 3) {
				backVO.setMarketName("淘宝");

			}
			VOList.add(backVO);
		}
		model.addAttribute("saleRule", VOList);
		return "sale/view/testshowsalerule";
	}

	@RequestMapping(value = "/showListSaleRule", method = RequestMethod.GET)
	public String showListSaleRule(Model model) {
		List<SaleRule> ruleList = saleRuleService.selectListSaleRuleByUserId(UserUtils.getCurrentUser().getId());

		List<SaleRuleVO> VOList = new ArrayList<SaleRuleVO>();

		for (SaleRule rule : ruleList) {
			SaleRuleVO saleRuleVO = new SaleRuleVO();
			saleRuleVO.setCreated(rule.getCreated());
			saleRuleVO.setId(rule.getId());
			saleRuleVO.setMarketId(rule.getMarketId());
			saleRuleVO.setModified(rule.getModified());
			saleRuleVO.setModUserId(rule.getModUserId());
			saleRuleVO.setStatus(rule.getStatus());
			saleRuleVO.setUserId(rule.getUserId());
			if (saleRuleVO.getMarketId() == 1) {
				saleRuleVO.setMarketName("携程");

			} else if (saleRuleVO.getMarketId() == 2) {
				saleRuleVO.setMarketName("去哪儿");

			} else if (saleRuleVO.getMarketId() == 3) {
				saleRuleVO.setMarketName("淘宝");

			}
			VOList.add(saleRuleVO);
		}

		model.addAttribute("user", UserUtils.getCurrentUser());
		model.addAttribute("saleRule", VOList);
		return "sale/view/testshowsalerule";
	}


	/**************************************
	 * for increaseRule
	 ***************************/
	@RequestMapping(value = "/showIncreaseRule", method = RequestMethod.GET)
	public String showIncreaseRuleSetting(Model model, @RequestParam("searchId") int saleRuleId, Pageable pageable) {
		List<IncreaseRule> rule = increaseRuleService.selectListIncreaseRule(saleRuleId);

		pageable.setPageSize(10);

		PageResult<Hotel> hotelList = filterHotelService.forIncreaseRuleHotel(pageable.toPageBounds());
		model.addAttribute("increaseRule", rule);
		model.addAttribute("hotelList", hotelList);
		model.addAttribute("searchId", saleRuleId);
		return "sale/view/increaseruledisplay";
	}

	@RequestMapping(value = "/updateIncreaseRule", method = RequestMethod.POST)
	public String updateIncreaseRule(IncreaseRuleVO increaseRuleVO, Model model) {
		increaseRuleService.updateIncraeseRule(increaseRuleVO);
		IncreaseRule rule = increaseRuleService.selectById(increaseRuleVO.getIncreaseId());
		model.addAttribute("increaseRule", rule);
		return "sale/view/increaseruledisplay";

	}

	@RequestMapping(value = "/deleteIncreaseRule", method = RequestMethod.POST)
	public String deleteIncreaseRule(Model model, @RequestParam("deleteIncreaseRuleId") int id) {
		increaseRuleService.deleteIncreaseRuleById(id);
		IncreaseRule rule = increaseRuleService.selectIncreaseRule(UserUtils.getCurrentUser().getId());
		model.addAttribute("increaseRule", rule);
		return "sale/view/increaseruledisplay";
	}

	@RequestMapping(value = "/getAllCities", method = RequestMethod.POST)
	@ResponseBody
	public String getAllCities() {
		String CityData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		List<City> cityList = cityService.getAllCities();
		try {
			CityData = objectMapper.writeValueAsString(cityList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return CityData;
	}


	/**************************************** for increaseDate */
	@RequestMapping(value = "increaseData", method = RequestMethod.POST)
	public String increaseData(IncreaseRuleVO increaseRuleVO) {
		String type = increaseRuleVO.getIncreaseType();
		double increase = increaseRuleVO.getIncreaseAmount();
		double price = 20;
		double increasePrice = 0;
		if (type == "差价") {
			increasePrice = price + increase;
		} else if (type == "百分比") {
			increasePrice = price * increase;
		} else {
			System.out.println("数据类型不正确");
		}
		System.out.println(increasePrice);

		return null;
	}


	/********************* 8加幅数据处理 */
	@RequestMapping(value = "filterSaleRule", method = RequestMethod.POST)
	public String filterSaleRule() {
		BaseRule filter = baseRuleService.selectBySaleRuleId(UserUtils.getCurrentUser().getId());

		/*
		 * 未完善 Double filterRoomPrice = null ; Double price =
		 * roomPrice.getSalePrice(); Double amount = filter.getIncreaseAmount();
		 * if(filter.getIncreaseType() == "差价"){ filterRoomPrice = price +
		 * amount;} else if(filter.getIncreaseType() == "百分比"){
		 * 
		 * filterRoomPrice = price * amount; } int lowerPrice =
		 * filter.getLowerPrice(); if (lowerPrice < filterRoomPrice){
		 * 
		 * 
		 * 
		 * }
		 */
		return null;

	}

}
