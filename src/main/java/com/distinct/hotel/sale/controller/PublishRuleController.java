package com.distinct.hotel.sale.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.distinct.hotel.common.UserUtils;
import com.distinct.hotel.product.service.CityService;
import com.distinct.hotel.product.service.FilterHotelService;
import com.distinct.hotel.product.service.GetAllHotelService;
import com.distinct.hotel.product.service.ProductHotelService;
import com.distinct.hotel.product.service.RoomService;
import com.distinct.hotel.sale.dao.PublishRuleMapper;
import com.distinct.hotel.sale.model.PublishRule;
import com.distinct.hotel.sale.service.BaseRuleService;
import com.distinct.hotel.sale.service.FilterRuleService;
import com.distinct.hotel.sale.service.HotelRemarkService;
import com.distinct.hotel.sale.service.IncreaseRuleService;
import com.distinct.hotel.sale.service.PublishRuleService;
import com.distinct.hotel.sale.service.SaleRuleService;
import com.distinct.hotel.sale.service.SaleService;
import com.distinct.hotel.sale.vo.PublishRuleShowVO;
import com.distinct.hotel.sale.vo.PublishRuleVO;

@Controller
@RequestMapping("sale")
public class PublishRuleController {
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
	
	@Resource
	private PublishRuleMapper publishRuleMapper;
	
	/************************************* for publishRule */
	@RequestMapping(value = "updatePublishRule", method = RequestMethod.GET)
	public String insertPublishRule(Model model, @RequestParam("publishRuleId") int id) {
		
		
		PublishRule rule = publishRuleService.selectById(id);
		model.addAttribute("publishRule", rule);
		return "sale/view/publishrule";
	}

	@RequestMapping(value = "insertPublishRule", method = RequestMethod.POST)
	public String insertPublishRule(Model model, PublishRuleVO publishRuleVO,
			@RequestParam("searchId") int saleRuleId) {
		publishRuleVO.setSaleRuleId(saleRuleId);
		publishRuleService.insertPublishRuleData(publishRuleVO);

		List<PublishRule> ruleList = publishRuleService.selectByPublishRuleSaleRuleId(saleRuleId);
		model.addAttribute("publishRuleList", ruleList);
		model.addAttribute("searchId", saleRuleId);

		return "sale/view/publishruledisplay";
	}

	@RequestMapping(value = "showPublishRule", method = RequestMethod.GET)
	public String showPublishRuleInsert(Model model, @RequestParam("searchId") int saleRuleId) {
		/*
		 * PublishRule rule = publishRuleService.selectBySaleRuleId(saleRuleId);
		 * PublishRule test = null; if (rule == test) { PublishRuleVO
		 * publishRuleVO = new PublishRuleVO();
		 * publishRuleVO.setSaleRuleId(saleRuleId);
		 * publishRuleService.insertPublishRule(publishRuleVO); rule =
		 * publishRuleService.selectBySaleRuleId(saleRuleId); }
		 * 
		 * model.addAttribute("publishRule", rule);
		 */
		return "sale/view/publishruledisplay";
	}

	@RequestMapping(value = "updatePublishRule", method = RequestMethod.POST)
	@ResponseBody
	public boolean updatePublishRule(PublishRuleVO publishRuleVO, Model model) {
		List<PublishRule> ruleList = publishRuleService.selectByPublishRuleSaleRuleId(publishRuleVO.getSaleRuleId());
		
		PublishRule rule = publishRuleService.selectById(publishRuleVO.getId());
		Iterator<PublishRule> bush = ruleList.iterator();
		while(bush.hasNext()){
			if(bush.next().getId()== rule.getId()){
				bush.remove();
				
			}
		}
		Date setBegin = publishRuleVO.getBeginDate();
		Date setEnd = publishRuleVO.getEndDate();
		boolean flag = true;
		for (PublishRule testRule : ruleList) {
			Date begin = testRule.getBeginDate();
			Date end = testRule.getEndDate();
			if(begin.after(setEnd) || end.before(setBegin)){
			}else if(setBegin.getTime() == begin.getTime() && setEnd.getTime() == end.getTime()){
				
				
			}else{
				flag = false;
			}
		}
		if(flag){
			publishRuleService.updatePublishRule(publishRuleVO);
		}
		return flag;
		
		
	}

	@RequestMapping(value = "deletePublishRule", method = RequestMethod.POST)
	public String deletePublishRule(Model model, @RequestParam("deleteId") int deleteId,
			@RequestParam("searchId") int saleRuleId) {
		publishRuleService.deletePublishRuleById(deleteId);
		List<PublishRule> ruleList = publishRuleService.selectByPublishRuleSaleRuleId(saleRuleId);
		model.addAttribute("publishRuleList", ruleList);
		model.addAttribute("searchId", saleRuleId);
		return "sale/view/publishruledisplay";
	}

	@RequestMapping(value = "showListPublishRule", method = RequestMethod.GET)
	public String showPublishRuleByList(Model model, @RequestParam("searchId") int saleRuleId) {
		List<PublishRule> ruleList = publishRuleService.selectByPublishRuleSaleRuleId(saleRuleId);
		List<PublishRuleShowVO> showList = publishRuleService.selectPublishRuleListBySaleRuleId(saleRuleId);
		model.addAttribute("publishRuleList", ruleList);
		model.addAttribute("searchId", saleRuleId);
		model.addAttribute("showList", showList);
		return "sale/view/publishruledisplay";
	}

	@RequestMapping(value = "matchListPublishRule", method = RequestMethod.POST)
	@ResponseBody
	public boolean matchListPublishRule(@RequestParam("beginDate") String beginDate, @RequestParam("status")String status,
			@RequestParam("endDate") String endDate, @RequestParam("saleRuleId") int saleRuleId) throws ParseException {
		List<PublishRule> ruleList = publishRuleService.selectByPublishRuleSaleRuleId(saleRuleId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date bDate = sdf.parse(beginDate);
		Date eDate = sdf.parse(endDate);
		boolean flag = true;
		for (PublishRule testRule : ruleList) {
			Date begin = testRule.getBeginDate();
			Date end = testRule.getEndDate();
			if(begin.after(eDate) || end.before(bDate)){
				
			}else{
				flag = false;
			}
		}
		if(flag){
			PublishRuleVO publishRuleVO = new PublishRuleVO();
			publishRuleVO.setBeginDate(beginDate);
			publishRuleVO.setEndDate(endDate);
			publishRuleVO.setSaleRuleId(saleRuleId);
			publishRuleVO.setStatus(status);
			publishRuleService.insertPublishRuleData(publishRuleVO);
		}
		return flag;

	}
}
