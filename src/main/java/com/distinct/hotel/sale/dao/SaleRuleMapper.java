package com.distinct.hotel.sale.dao;

import com.distinct.hotel.sale.model.SaleRule;
import com.distinct.hotel.sale.model.SaleRuleExample;
import com.distinct.hotel.sale.vo.SaleRuleVO;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleRuleMapper {
	int countByExample(SaleRuleExample example);

	int deleteByUserId(Integer userId);

	int deleteByExample(SaleRuleExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(SaleRule record);

	int insertSelective(SaleRule record);

	List<SaleRule> selectByExample(SaleRuleExample example);

	int updateByExampleSelective(@Param("record") SaleRule record, @Param("example") SaleRuleExample example);


	int updateByPrimaryKey(SaleRule record);

	int updateByExample(@Param("record") SaleRule record, @Param("example") SaleRuleExample example);



	SaleRule selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(SaleRule record);



	int countByUserId(Integer userId);
    List<SaleRuleVO> selectVOListSaleRuleByUserId(Integer userId);
    SaleRule selectByUserIdAndMarketId(@Param ("userId")Integer userId,@Param ("marketId")Integer marketId);

	int updateByUserIdSelective(SaleRule record);



	SaleRule selectByUserId(Integer userId);
	//根据用户id以及平台id查找唯一一条记录
	SaleRule selectByuserIdNmarketId(@Param("userId")Integer userId, @Param("marketId")Integer marketId);



	List<SaleRule> selectListSaleRuleByUserId(Integer userId);

	
	

}