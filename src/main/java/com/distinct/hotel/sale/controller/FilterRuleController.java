package com.distinct.hotel.sale.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.distinct.hotel.common.page.PageList;
import com.distinct.hotel.common.page.PageResult;
import com.distinct.hotel.common.page.Pageable;
import com.distinct.hotel.log.service.UserLogService;
import com.distinct.hotel.product.model.City;
import com.distinct.hotel.product.model.Hotel;
import com.distinct.hotel.product.service.CityService;
import com.distinct.hotel.product.service.FilterHotelService;
import com.distinct.hotel.product.service.GetAllHotelService;
import com.distinct.hotel.product.service.ProductHotelService;
import com.distinct.hotel.product.service.RoomService;
import com.distinct.hotel.product.vo.FilterHotelVO;
import com.distinct.hotel.sale.model.FilterRule;
import com.distinct.hotel.sale.service.BaseRuleService;
import com.distinct.hotel.sale.service.FilterRuleService;
import com.distinct.hotel.sale.service.HotelRemarkService;
import com.distinct.hotel.sale.service.IncreaseRuleService;
import com.distinct.hotel.sale.service.PublishRuleService;
import com.distinct.hotel.sale.service.SaleRuleService;
import com.distinct.hotel.sale.service.SaleService;
import com.distinct.hotel.sale.vo.FilterRuleVO;

@Controller
@RequestMapping("sale")
public class FilterRuleController {
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
	private UserLogService userLogService;

	/************************** 8*from testfilterController */
	@RequestMapping(value = "filterData", method = RequestMethod.GET)
	public String filterData(Model model, Pageable pageable, @RequestParam("searchId") Integer saleRuleId,
			FilterRuleVO filterRuleVO) {

		pageable.setPageSize(10);
		List<FilterRule> test = filterRuleService.selectListAllWithSaleRuleId(saleRuleId);
		List<Integer> cityIdList = new ArrayList<Integer>();
		List<Integer> filterCityHotelIdList = new ArrayList<Integer>();
		List<Integer> hotelIdList = new ArrayList<Integer>();
		PageResult<Hotel> filterHotel = null;
		PageResult<FilterHotelVO> filterHotelVO =null;
		List<City> cities = null;
		List<Hotel> filterHotels = null;
		List<City> filterCities = null;
		List<Integer> showHotelIdList = new ArrayList<Integer>();
		String filterCity = null;
		Integer cityId = filterRuleVO.getCityId();
		if (test.size() == 0) {
			filterHotelVO =filterHotelService.filterFindAll(pageable.toPageBounds(),hotelIdList);
			cities = cityService.findAll();
			if(cityId != null){
				filterHotelVO = filterHotelService.filterFindByCityId(pageable.toPageBounds(),hotelIdList, cityId);
				City city = cityService.selectById(cityId);
				model.addAttribute("city", city);
		}  
			model.addAttribute("searchId", saleRuleId);
			model.addAttribute("page", filterHotelVO);
			model.addAttribute("cities", cities);
		}else if(test.size() != 0){
			cities = cityService.findAll();
			for (FilterRule rule : test) {
				if (rule.getFilterType().equals("酒店过滤")) {
					hotelIdList.add(rule.getFilterId());
				} else if (rule.getFilterType().equals("城市过滤")) {
					cityIdList.add(rule.getFilterId());
				}
			}
			if(hotelIdList.size() == 0){
				List<Hotel> cityFilter = filterHotelService.selectedByCityId(cityIdList);
				for (Hotel city : cityFilter){
					filterCityHotelIdList.add(city.getProviderHotelId());
				}
				model.addAttribute("filterCityHotelIdList",filterCityHotelIdList);
				filterHotelVO =filterHotelService.filterFindAll(pageable.toPageBounds(),hotelIdList);
				if(cityId != null){
					filterHotelVO = filterHotelService.filterFindByCityId(pageable.toPageBounds(),hotelIdList, cityId);
					City city = cityService.selectById(cityId);
					model.addAttribute("city", city);
				}
			}
			// 酒店，城市过滤均不为空
			if (hotelIdList.size() != 0) {
				if (cityIdList.size() == 0) {
				filterHotelVO =filterHotelService.filterFindAll(pageable.toPageBounds(),hotelIdList);
				if(cityId != null){
					filterHotelVO = filterHotelService.filterFindByCityId(pageable.toPageBounds(),hotelIdList, cityId);
					City city = cityService.selectById(cityId);
					model.addAttribute("city", city);
				}
				}
				if (cityIdList.size() != 0) {
					List<Hotel> cityFilter = filterHotelService.selectedByCityId(cityIdList);
				for (Hotel city : cityFilter){
					if(!hotelIdList.contains(city.getProviderHotelId())){
						filterCityHotelIdList.add(city.getProviderHotelId());
					}
				}
				model.addAttribute("filterCityHotelIdList",filterCityHotelIdList);
				filterHotelVO =filterHotelService.filterFindAll(pageable.toPageBounds(),hotelIdList);
				if(cityId != null){
					filterHotelVO = filterHotelService.filterFindByCityId(pageable.toPageBounds(),hotelIdList, cityId);
					City city = cityService.selectById(cityId);
					model.addAttribute("city", city);
				}
			}
				Collection<FilterHotelVO> result = filterHotelVO.getResults();
				for (FilterHotelVO show : result) {
					Hotel hotel =show.getHotel();
					showHotelIdList.add(hotel.getProviderHotelId());
		}	
				if (cityIdList.contains(cityId)) {
					filterCity = "filter";
				}
				model.addAttribute("hotelIdList",hotelIdList);
				model.addAttribute("filterCity", filterCity);
				model.addAttribute("showHotelIdList",showHotelIdList);
				model.addAttribute("searchId", saleRuleId);
				model.addAttribute("page", filterHotelVO);
				model.addAttribute("cities", cities);
			}
		}
		return "sale/view/testfilterrule";
	}

	@RequestMapping(value = "insertFilterHotel", method = RequestMethod.POST)
	@ResponseBody
	public Boolean insertFilterHotel(Hotel hotel, @RequestParam("searchId") int saleRuleId) {
		FilterRuleVO filterRuleVO = new FilterRuleVO();
		filterRuleVO.setProviderId(hotel.getProviderId());
		filterRuleVO.setFilterId(hotel.getProviderHotelId());
		filterRuleVO.setSaleRuleId(saleRuleId);
		filterRuleVO.setFilterType("酒店过滤");
		
		Boolean flag = filterRuleService.insertFilterRule(filterRuleVO);

		userLogService.insertFillterRuleInsertUserLog(saleRuleId,filterRuleVO.getFilterId() ,filterRuleVO.getFilterType(),filterRuleVO.getProviderId());
		return flag;

	}

	@RequestMapping(value = "insertFilterCity", method = RequestMethod.POST)
	@ResponseBody
	public boolean insertFilterCity(@RequestParam("cityId") String cityId, @RequestParam("searchId") int saleRuleId) {
		FilterRuleVO filterRuleVO = new FilterRuleVO();
		int filterId = 0;
		String[] strArray = null;
		if (cityId != null && cityId.matches("^[0-9]+$")) {
			try {
				filterId = Integer.valueOf(cityId).intValue();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			filterRuleVO.setFilterId(filterId);
			filterRuleVO.setProviderId(0);
			filterRuleVO.setSaleRuleId(saleRuleId);
			filterRuleVO.setFilterType("城市过滤");
			filterRuleService.insertFilterRule(filterRuleVO);
		} else if (cityId != null) {
			strArray = cityId.split(",");
			for (int i = 0; i < strArray.length; i++) {
				try {
					filterId = Integer.parseInt(strArray[i]);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				filterRuleVO.setFilterId(filterId);
				filterRuleVO.setProviderId(0);
				filterRuleVO.setFilterType("城市过滤");
				filterRuleVO.setSaleRuleId(saleRuleId);
				filterRuleService.insertFilterRule(filterRuleVO);

			}

		}

		return true;
	}

	@RequestMapping(value = "deleteCityFilterRule", method = RequestMethod.POST)
	@ResponseBody
	public Boolean deleteCityFilterRule(@RequestParam("cityId") int filterId,
			@RequestParam("searchId") int saleRuleId) {
		filterRuleService.deleteCityFilterRuleWithSaleRuleId(filterId, saleRuleId);
		boolean flag = true;
		return flag;
	}

	@RequestMapping(value = "deleteHotelFilterRule", method = RequestMethod.POST)
	@ResponseBody
	public Boolean deleteHotelFilterRule(@RequestParam("hotelId") int filterId,
			@RequestParam("searchId") int saleRuleId) {
		filterRuleService.deleteHotelFilterRuleWithSaleRuleId(filterId, saleRuleId);
		boolean flag = true;
		return flag;

	}

}
