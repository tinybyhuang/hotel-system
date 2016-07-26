package com.distinct.hotel.sale.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.distinct.hotel.common.UserUtils;
import com.distinct.hotel.sale.dao.FilterRuleMapper;
import com.distinct.hotel.sale.model.FilterRule;
import com.distinct.hotel.sale.service.FilterRuleService;
import com.distinct.hotel.sale.vo.FilterRuleVO;
@Service
public class FilterRuleServiceImpl implements FilterRuleService {
@Resource FilterRuleMapper filterRuleMapper;
	@Override
	public void insertByFilterRule() {
		FilterRule rule = new FilterRule();
		String nothing = "0";
		Date now = new Date();
		rule.setFilterId(0);
		rule.setCreated(now);
		rule.setFilterType(nothing);
		rule.setProviderId(0);
		rule.setSaleRuleId(UserUtils.getCurrentUser().getId());
		filterRuleMapper.insertSelective(rule);
	}

	@Override
	public void deleteByFilterRuleId(Integer id) {
		filterRuleMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void updateByFilterRuleId(FilterRuleVO filterRuleVO) {
		Date now = new Date();
		  FilterRule rule =  filterRuleMapper.selectByPrimaryKey(filterRuleVO.getFilterRuleId());
		rule.setCreated(now);
		rule.setFilterId(filterRuleVO.getFilterId());
		rule.setFilterType(filterRuleVO.getFilterType());
		rule.setProviderId(filterRuleVO.getProviderId());
		rule.setSaleRuleId(UserUtils.getCurrentUser().getId());
		filterRuleMapper.updateByPrimaryKeySelective(rule);
		
		
		
	}

	@Override
	public FilterRule selectFilterRuleBySaleRuleId(Integer saleRuleId) {
		
		return filterRuleMapper.selectBySaleRuleId(saleRuleId);
				
	}

	@Override
	public FilterRule selectFilterRuleById(Integer id) {
		
		return filterRuleMapper.selectByPrimaryKey(id);
	}

	@Override
	public Boolean insertFilterRule(FilterRuleVO filterRuleVO) {
		FilterRule rule = new FilterRule();
		
		Date now = new Date();
		rule.setFilterId(filterRuleVO.getFilterId());
		rule.setCreated(now);
		rule.setFilterType(filterRuleVO.getFilterType());
		rule.setProviderId(filterRuleVO.getProviderId());
		rule.setSaleRuleId(filterRuleVO.getSaleRuleId());
		filterRuleMapper.insertSelective(rule);
		return true;
	}

	@Override
	public List<FilterRule> selectListFilterRuleBySaleRuleId(Integer saleRuleId) {
		
		return filterRuleMapper.selectListBySaleRuleId(saleRuleId);
	}

	@Override
	public List<FilterRule> selectListFilterRuleByFilterType() {
		
		return filterRuleMapper.selectListByFilterType();
	}

	@Override
	public List<FilterRule> selectListByFilterTypeofHotel() {
		return filterRuleMapper.selectListByFilterTypeofHotel();
	
	}

	@Override
	public void deleteHotelFilterRule(Integer hotelId) {
    filterRuleMapper.deleteHotelFilterRule(hotelId);		
	}
	@Override
	public void deleteCityFilterRule(Integer cityId) {
		filterRuleMapper.deleteCityFilterRule(cityId);
	}

	@Override
	public List<FilterRule> selectListFilterRuleByFilterCityTypeAndSaleRuleId(Integer saleRuleId) {
		
		return filterRuleMapper.selectListFilterRuleByFilterCityTypeAndSaleRuleId(saleRuleId);
	}

	@Override
	public List<FilterRule> selectListFilterRuleTypeByhotelAndSaleRuleId(Integer saleRuleId) {
		
		return filterRuleMapper.selectListFilterRuleTypeByhotelAndSaleRuleId(saleRuleId);
	}

	@Override
	public void deleteCityFilterRuleWithSaleRuleId(Integer cityId, Integer saleRuleId) {
		filterRuleMapper.deleteCityFilterRuleWithSaleRuleId(cityId, saleRuleId);
		
	}

	@Override
	public void deleteHotelFilterRuleWithSaleRuleId(Integer filterId, Integer saleRuleId) {
		filterRuleMapper.deleteHotelFilterRuleWithSaleRuleId(filterId, saleRuleId);
		
	}

	@Override
	public List<FilterRule> selectListAllWithSaleRuleId(Integer saleRuleId) {
		
		return filterRuleMapper.selectListAllWithSaleRuleId(saleRuleId);
	}

	

}
