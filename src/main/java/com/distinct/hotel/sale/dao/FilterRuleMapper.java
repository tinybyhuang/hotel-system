package com.distinct.hotel.sale.dao;

import com.distinct.hotel.sale.model.FilterRule;
import com.distinct.hotel.sale.model.FilterRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FilterRuleMapper {
    int countByExample(FilterRuleExample example);

    int deleteByExample(FilterRuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FilterRule record);

    int insertSelective(FilterRule record);

    List<FilterRule> selectByExample(FilterRuleExample example);
    

    FilterRule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FilterRule record, @Param("example") FilterRuleExample example);

    int updateByExample(@Param("record") FilterRule record, @Param("example") FilterRuleExample example);

    int updateByPrimaryKeySelective(FilterRule record);

    int updateByPrimaryKey(FilterRule record);
    FilterRule selectBySaleRuleId (Integer saleRuleId);
    List<FilterRule> selectListBySaleRuleId(Integer saleRuleId);
    List<FilterRule> selectListByFilterType();
    List<FilterRule> selectListByFilterTypeofHotel();
    int deleteCityFilterRule(Integer cityId);
    int deleteHotelFilterRule(Integer hotelId);

	List<FilterRule> selectListFilterRuleByFilterCityTypeAndSaleRuleId(@Param("saleRuleId") Integer saleRuleId);
	List<FilterRule> selectListFilterRuleTypeByhotelAndSaleRuleId(@Param("saleRuleId") Integer saleRuleId);
	 int deleteCityFilterRuleWithSaleRuleId(@Param("filterId") Integer filterId,@Param("saleRuleId") Integer saleRuleId);
	 int deleteHotelFilterRuleWithSaleRuleId(@Param("filterId") Integer filterId,@Param("saleRuleId") Integer saleRuleId);

	
	List<FilterRule> selectListAllWithSaleRuleId(@Param("saleRuleId") Integer saleRuleId);

}