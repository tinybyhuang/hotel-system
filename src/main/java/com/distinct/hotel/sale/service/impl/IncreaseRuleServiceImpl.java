package com.distinct.hotel.sale.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.distinct.hotel.common.UserUtils;
import com.distinct.hotel.sale.dao.IncreaseRuleMapper;
import com.distinct.hotel.sale.model.IncreaseRule;
import com.distinct.hotel.sale.service.IncreaseRuleService;

import com.distinct.hotel.sale.vo.IncreaseRuleVO;

@Service
public class IncreaseRuleServiceImpl implements IncreaseRuleService {
	
	@Resource
	private IncreaseRuleMapper increaseRuleMapper;

	@Override
	public void insertIncreaseRule(IncreaseRuleVO increaseRuleVO) {
		IncreaseRule rule = new IncreaseRule();
		String nothing = new String();
		Date now = new Date();
		rule.setCreated(now);
		rule.setModified(null);
		rule.setModUserId(UserUtils.getCurrentUser().getId());
		rule.setIncreaseAmount(0.0);
		rule.setIncreaseType(nothing);
		rule.setProviderId(0);
		rule.setSaleRuleId(increaseRuleVO.getSaleRuleId());
		rule.setScopeId(0);
		rule.setScopeType(nothing);
		increaseRuleMapper.insertSelective(rule);

	}

	@Override
	public int deleteIncreaseRule(int saleRuleId) {
		return increaseRuleMapper.deleteBySaleRuleId(saleRuleId);

	}

	@Override
	public IncreaseRule selectIncreaseRule(int saleRuleId) {

		return increaseRuleMapper.selectBySaleRuleId(saleRuleId);
	}

	@Override
	public void updateIncraeseRule(IncreaseRuleVO increaseRuleVO) {

		IncreaseRule rule = increaseRuleMapper.selectByPrimaryKey(increaseRuleVO.getIncreaseId());
		Date now = new Date();
		rule.setModified(now);

		rule.setModUserId(UserUtils.getCurrentUser().getId());

		rule.setIncreaseAmount(increaseRuleVO.getIncreaseAmount());
		rule.setIncreaseType(increaseRuleVO.getIncreaseType());
		rule.setProviderId(increaseRuleVO.getProviderId());

		rule.setScopeId(increaseRuleVO.getScopeId());
		rule.setScopeType(increaseRuleVO.getScopeType());
		increaseRuleMapper.updateByPrimaryKeySelective(rule);

	}

	@Override
	public IncreaseRule selectById(int id) {
		return increaseRuleMapper.selectByPrimaryKey(id);

	}

	@Override
	public int deleteIncreaseRuleById(int id) {

		return increaseRuleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<IncreaseRule> selectListIncreaseRule(int saleRuleId) {

		return increaseRuleMapper.selectListBySaleRuleId(saleRuleId);
	}

	

}
