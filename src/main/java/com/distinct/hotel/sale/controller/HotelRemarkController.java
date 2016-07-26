package com.distinct.hotel.sale.controller;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.distinct.hotel.common.page.Pageable;
import com.distinct.hotel.product.service.CityService;
import com.distinct.hotel.product.service.FilterHotelService;
import com.distinct.hotel.product.service.GetAllHotelService;
import com.distinct.hotel.product.service.ProductHotelService;
import com.distinct.hotel.product.service.RoomService;
import com.distinct.hotel.sale.model.HotelRemark;
import com.distinct.hotel.sale.service.BaseRuleService;
import com.distinct.hotel.sale.service.FilterRuleService;
import com.distinct.hotel.sale.service.HotelRemarkService;
import com.distinct.hotel.sale.service.IncreaseRuleService;
import com.distinct.hotel.sale.service.PublishRuleService;
import com.distinct.hotel.sale.service.SaleRuleService;
import com.distinct.hotel.sale.service.SaleService;
import com.distinct.hotel.sale.vo.HotelRemarkVO;

@Controller
@RequestMapping("sale")
public class HotelRemarkController {
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
	private CityService cityService;
	@Resource
	private FilterHotelService filterHotelService;
	@Resource
	private RoomService roomService;
	@Resource
	private GetAllHotelService getAllHotelService;
	@Resource
	private ProductHotelService productHotelService;
	
	
	@RequestMapping(value = "insertHotelRemark", method = RequestMethod.POST)
	public String insertHotelRemark(HotelRemarkVO hotelRemarkVO, Model model, Pageable pageable) {

		hotelRemarkService.insertHotelRemark(hotelRemarkVO);
		
		return "/sale/view/testfilterrule";

	}

	@RequestMapping(value = "showHotelRemark", method = RequestMethod.POST)
	@ResponseBody
	public String showHotelRemark(Model model,HotelRemarkVO hotelRemarkVO) {
		HotelRemark remark = hotelRemarkService.selectedByHotelIdAndSaleRuleId(hotelRemarkVO.getHotelId(), hotelRemarkVO.getSaleRuleId());
		String hotelRemark = null;
		if (remark == null) {
			hotelRemarkService.insertHotelRemarkInit(hotelRemarkVO.getHotelId(),hotelRemarkVO.getProviderId(),hotelRemarkVO.getSaleRuleId());
			HotelRemark mark = hotelRemarkService.selectedByHotelIdAndSaleRuleId(hotelRemarkVO.getHotelId(),hotelRemarkVO.getSaleRuleId());
			hotelRemark = mark.getRemark();

		} else {
			hotelRemark = remark.getRemark();

		}
		return hotelRemark;
	}

	@RequestMapping(value = "updateHotelRemark", method = RequestMethod.POST)
	@ResponseBody
	public String updateHotelRemark(HotelRemarkVO hotelRemarkVO) {
		hotelRemarkService.updateHotelRemark(hotelRemarkVO);
		return hotelRemarkService.selectedByHotelIdAndSaleRuleId(hotelRemarkVO.getHotelId(),hotelRemarkVO.getSaleRuleId()).getRemark();
	}

	@RequestMapping(value = "deleteHotelRemark", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteHotelRemark(HotelRemarkVO hotelRemarkVO) {
		hotelRemarkService.deleteHotelRemarkByHotelIdAndSaleRuleIdAP(hotelRemarkVO.getHotelId(),hotelRemarkVO.getSaleRuleId(),hotelRemarkVO.getProviderId());

		return true;

	}
}
