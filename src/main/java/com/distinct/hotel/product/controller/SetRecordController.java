package com.distinct.hotel.product.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.distinct.hotel.grap.service.HotelService;
import com.distinct.hotel.product.service.DetailIncreaseRuleService;
import com.distinct.hotel.product.vo.SetDetailIncreaseRuleVO;

@Controller
@RequestMapping("/parameter")
public class SetRecordController {
	@Resource
	private HotelService hotelService;

	@Resource
	private DetailIncreaseRuleService detailIncreaseRuleService;

	@RequestMapping("/setPrices")
	public String setPrices() {
		hotelService.setPrice();
		return null;
	}

	@RequestMapping("/setDetailIncreaseRule")
	public String showSetDetailIncreaseRule() {
		// 参数有日期，roomId,加幅类型，加幅数值，（上下架状态）
		return "product/view/parameter-insert";
	}

	@RequestMapping(value = "/setDetailIncreaseRule", method = RequestMethod.POST)
	public String setDetailIncreaseRule(SetDetailIncreaseRuleVO detailIncreaseRuleVO) {
		// 参数有日期，roomId,加幅类型，加幅数值，（上下架状态）
		detailIncreaseRuleService.updateDetailIncreaseRule(detailIncreaseRuleVO);

		return "product/view/parameter-insert";
	}

}
