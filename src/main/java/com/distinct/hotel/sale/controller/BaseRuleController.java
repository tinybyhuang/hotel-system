package com.distinct.hotel.sale.controller;
import java.text.ParseException;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.distinct.hotel.common.UserUtils;
import com.distinct.hotel.product.service.CityService;
import com.distinct.hotel.product.service.FilterHotelService;
import com.distinct.hotel.product.service.GetAllHotelService;
import com.distinct.hotel.product.service.ProductHotelService;
import com.distinct.hotel.product.service.RoomService;
import com.distinct.hotel.sale.model.BaseRule;
import com.distinct.hotel.sale.service.BaseRuleService;
import com.distinct.hotel.sale.service.FilterRuleService;
import com.distinct.hotel.sale.service.HotelRemarkService;
import com.distinct.hotel.sale.service.IncreaseRuleService;
import com.distinct.hotel.sale.service.PublishRuleService;
import com.distinct.hotel.sale.service.SaleRuleService;
import com.distinct.hotel.sale.service.SaleService;
import com.distinct.hotel.sale.vo.BaseRuleVO;

@Controller
@RequestMapping("sale")
public class BaseRuleController {
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
	
	@RequestMapping(value = "/deleteBaseRule", method = RequestMethod.POST)
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
	}
	
}
