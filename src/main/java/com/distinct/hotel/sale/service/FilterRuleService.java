package com.distinct.hotel.sale.service;

import java.util.List;

import com.distinct.hotel.sale.model.FilterRule;
import com.distinct.hotel.sale.vo.FilterRuleVO;

public interface FilterRuleService {
	public Boolean insertFilterRule(FilterRuleVO filterRuleVO);
	public void insertByFilterRule();
  public void deleteByFilterRuleId(Integer id);
  public void updateByFilterRuleId(FilterRuleVO filterRuleVO);
  public FilterRule selectFilterRuleBySaleRuleId(Integer saleRuleId);
  public FilterRule selectFilterRuleById(Integer id);
  public List<FilterRule> selectListFilterRuleBySaleRuleId(Integer saleRuleId);
  public List<FilterRule> selectListFilterRuleByFilterType();
  public List<FilterRule> selectListByFilterTypeofHotel();
  public void deleteHotelFilterRule(Integer hotelId);
  public void deleteCityFilterRule(Integer cityId);
  public List<FilterRule> selectListFilterRuleByFilterCityTypeAndSaleRuleId(Integer saleRuleId);
  public List<FilterRule> selectListFilterRuleTypeByhotelAndSaleRuleId(Integer saleRuleId);
  public void deleteCityFilterRuleWithSaleRuleId(Integer cityId,Integer saleRuleId);
  public void deleteHotelFilterRuleWithSaleRuleId(Integer hotelId,Integer saleRuleId);
  public  List<FilterRule> selectListAllWithSaleRuleId(Integer saleRuleId);
}
