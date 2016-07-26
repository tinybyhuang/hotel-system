package com.distinct.hotel.sale.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.distinct.hotel.common.UserUtils;
import com.distinct.hotel.product.vo.HotelPurposeVO;
import com.distinct.hotel.sale.dao.SaleRuleMapper;
import com.distinct.hotel.sale.model.BaseRule;
import com.distinct.hotel.sale.model.SaleRule;
import com.distinct.hotel.sale.service.SaleRuleService;
import com.distinct.hotel.sale.vo.SaleRuleVO;

@Service

public class SaleRuleServiceImpl implements SaleRuleService {
	@Resource
	private SaleRuleMapper saleRuleMapper;

	@Override
	public void insertSaleRuleVO(SaleRuleVO saleRuleVO) {
		SaleRule rule = new SaleRule();
		Date now = new Date();
		String none = new String();
		rule.setMarketId(0);
		rule.setCreated(now);
		rule.setModified(null);
		rule.setStatus(none);
		rule.setModUserId(UserUtils.getCurrentUser().getId());
		rule.setUserId(UserUtils.getCurrentUser().getId());
		saleRuleMapper.insertSelective(rule);
	}

	@Override
	public int deleteSaleRule(int userId) {
		return saleRuleMapper.deleteByUserId(UserUtils.getCurrentUser().getId());

	}

	@Override
	public SaleRule selectSaleRuleByUserId(int userId) {
		return saleRuleMapper.selectByUserId(userId);

	}

	@Override
	public void updateByIdSelective(SaleRuleVO saleRuleVO) {
		Integer userId = UserUtils.getCurrentUser().getId();
		Integer MarketId = saleRuleVO.getMarketId();
		SaleRule rule = saleRuleMapper.selectByUserIdAndMarketId(userId, MarketId);
		Date now = new Date();
		rule.setModified(now);
		rule.setStatus(saleRuleVO.getStatus());
		rule.setModUserId(UserUtils.getCurrentUser().getId());

		saleRuleMapper.updateByPrimaryKeySelective(rule);

	}

	@Override
	public int countByUserId(int userId) {

		return saleRuleMapper.countByUserId(userId);
	}

	@Override
	public SaleRule selectById(int id) {

		return saleRuleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(int id) {

		return saleRuleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void insertSaleRule(SaleRule saleRule) {
		SaleRule rule = new SaleRule();
		Date now = new Date();

		rule.setMarketId(saleRule.getMarketId());
		rule.setCreated(now);
		rule.setModified(null);
		rule.setStatus(saleRule.getStatus());
		rule.setModUserId(UserUtils.getCurrentUser().getId());
		rule.setUserId(UserUtils.getCurrentUser().getId());
		saleRuleMapper.insertSelective(rule);

	}

	@Override
	public List<SaleRule> selectListSaleRuleByUserId(Integer userId) {

		return saleRuleMapper.selectListSaleRuleByUserId(userId);
	}

	@Override
	public List<SaleRuleVO> selectVOListSaleRuleByUserId(Integer userId) {
		return saleRuleMapper.selectVOListSaleRuleByUserId(userId);
	}

	@Override
	public List<SaleRule> selectListSaleRuleByLoginUserId() {
		return saleRuleMapper.selectListSaleRuleByUserId(UserUtils.getCurrentUser().getId());
	}

}
