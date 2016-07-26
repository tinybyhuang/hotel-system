package com.distinct.hotel.sale.service;

import java.util.List;

import com.distinct.hotel.sale.model.SaleRule;
import com.distinct.hotel.sale.vo.SaleRuleVO;

public interface SaleRuleService {
	public void insertSaleRuleVO(SaleRuleVO saleRuleVO);

	public int deleteSaleRule(int userId);

	public SaleRule selectSaleRuleByUserId(int userId);

	public int countByUserId(int userId);

	public SaleRule selectById(int id);

	public void updateByIdSelective(SaleRuleVO saleRuleVO);

	public int deleteById(int id);

	public void insertSaleRule(SaleRule saleRule);

	public List<SaleRule> selectListSaleRuleByUserId(Integer userId);

	public List<SaleRuleVO> selectVOListSaleRuleByUserId(Integer userId);
	
	//根据当前的登录用户的id寻找salerule
	public List<SaleRule> selectListSaleRuleByLoginUserId();
}
