package com.distinct.hotel.sale.dao;

import com.distinct.hotel.sale.model.IncreaseRule;
import com.distinct.hotel.sale.model.IncreaseRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IncreaseRuleMapper {
	int countByExample(IncreaseRuleExample example);

	int deleteByExample(IncreaseRuleExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(IncreaseRule record);

	int insertSelective(IncreaseRule record);

	List<IncreaseRule> selectByExample(IncreaseRuleExample example);

	IncreaseRule selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") IncreaseRule record, @Param("example") IncreaseRuleExample example);

	int updateByExample(@Param("record") IncreaseRule record, @Param("example") IncreaseRuleExample example);

	int updateByPrimaryKeySelective(IncreaseRule record);

	int updateBySaleRuleIdSelective(IncreaseRule record);

	int updateByPrimaryKey(IncreaseRule record);

	int deleteBySaleRuleId(Integer saleRuleId);

	IncreaseRule selectBySaleRuleId(int saleRuleId);

	List<IncreaseRule> selectListBySaleRuleId(int saleRuleId);

	List<IncreaseRule> selectByScopeTypeNSaleRuleIdNProviderId(@Param("scopeType") String scopeType,
			@Param("saleRuleId") int saleRuleId, @Param("providerId") int providerId);

	List<Integer> selectScopeIdByScopeTypeNSaleRuleIdNProviderId(@Param("scopeType") String scopeType,
			@Param("saleRuleId") int saleRuleId, @Param("providerId") int providerId);

	IncreaseRule selectByScopeTypeNSaleRuleIdNProviderIdNScopeId(@Param("scopeType") String scopeType,
			@Param("saleRuleId") int saleRuleId, @Param("providerId") int providerId, @Param("scopeId") int scopeId);

	// 返回有加幅的城市id(或者酒店id、或者房型id)，以平台区分
	List<Integer> findScopeIdByScopeTypeNSaleRuleIdNProviderId(@Param("scopeType") String scopeType,
			@Param("saleRuleId") int saleRuleId, @Param("providerId") int providerId);

}