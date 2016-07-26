package com.distinct.hotel.sale.service;

import java.util.List;

import com.distinct.hotel.sale.model.BaseRule;
import com.distinct.hotel.sale.vo.BaseRuleVO;

public interface BaseRuleService {
	int addRecord(BaseRule record);

	public BaseRule selectBySaleRuleId(int saleRuleId) ;
    public List<String> getAllBaseRule();
	/*int updateBySaleRuleIdSelective(BaseRule record);*/

	int deleteBySaleRuleId(int saleRuleId);
	
	public int deleteById(int id);
		
	public void updateBaseRule(BaseRuleVO baseRuleVO);

	public void insertBaseRule(BaseRuleVO baseRuleVO);

	public BaseRule selectById(Integer id);
	
	
}
