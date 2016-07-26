package com.distinct.hotel.sale.dao;

import com.distinct.hotel.sale.model.PublishRule;
import com.distinct.hotel.sale.model.PublishRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PublishRuleMapper {
    int countByExample(PublishRuleExample example);

    int deleteByExample(PublishRuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PublishRule record);

    int insertSelective(PublishRule record);

    List<PublishRule> selectByExample(PublishRuleExample example);

    PublishRule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PublishRule record, @Param("example") PublishRuleExample example);

    int updateByExample(@Param("record") PublishRule record, @Param("example") PublishRuleExample example);

    int updateByPrimaryKeySelective(PublishRule record);

    int updateByPrimaryKey(PublishRule record);

	PublishRule selectBySaleRuleId(Integer SaleRuleId);
	
	 int updateByRuleUserIdSelective(PublishRule record);
	 
	 List<PublishRule> selectListBySaleRuleId(Integer SaleRuleId);

	void deleteBySaleRuleId(Integer saleRuleId);
	
	Integer returnMaxId();

	List<PublishRule> selectByIdList(Integer id);
	
	
}