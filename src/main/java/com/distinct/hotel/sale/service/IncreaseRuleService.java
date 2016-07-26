package com.distinct.hotel.sale.service;

import java.util.List;

import com.distinct.hotel.sale.model.IncreaseRule;
import com.distinct.hotel.sale.vo.IncreaseRuleVO;

public interface IncreaseRuleService {
	public void insertIncreaseRule(IncreaseRuleVO increaseVO);

	public int deleteIncreaseRule(int saleRuleId);

	public int deleteIncreaseRuleById(int id);

	public IncreaseRule selectIncreaseRule(int saleRuleId);

	public void updateIncraeseRule(IncreaseRuleVO increaseVO);

	public IncreaseRule selectById(int id);

	public List<IncreaseRule> selectListIncreaseRule(int saleRuleId);

	
}
