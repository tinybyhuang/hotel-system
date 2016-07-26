package com.distinct.hotel.sale.dao;

import com.distinct.hotel.sale.model.BaseRule;
import com.distinct.hotel.sale.model.BaseRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseRuleMapper {
	int countByExample(BaseRuleExample example);

	int deleteByExample(BaseRuleExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(BaseRule record);

	int insertSelective(BaseRule record);

	List<BaseRule> selectByExample(BaseRuleExample example);

	BaseRule selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") BaseRule record, @Param("example") BaseRuleExample example);

	int updateByExample(@Param("record") BaseRule record, @Param("example") BaseRuleExample example);

	int updateByPrimaryKeySelective(BaseRule record);
	int updateBysaleRuleId(BaseRule record);
	int updateByPrimaryKey(BaseRule record);

	BaseRule selectBySaleRuleId(Integer saleRuleId);

	int deleteBySaleRuleId(Integer saleRuleId);
	List<String> selectAllUserRule();
  
}