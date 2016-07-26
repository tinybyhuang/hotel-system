package com.distinct.hotel.sale.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.distinct.hotel.user.model.User;
import com.distinct.hotel.user.service.UserService;
import com.distinct.hotel.common.UserUtils;
import com.distinct.hotel.sale.dao.BaseRuleMapper;
import com.distinct.hotel.sale.model.BaseRule;
import com.distinct.hotel.sale.service.BaseRuleService;

import com.distinct.hotel.sale.vo.BaseRuleVO;


@Service
public class BaseRuleServiceImpl implements BaseRuleService {
	@Resource
	private BaseRuleMapper baseRuleMapper;

	private BaseRuleVO baseRuleVO;

	@Override
	public int addRecord(BaseRule record) {

		return baseRuleMapper.insert(record);

	}

	@Override
	public BaseRule selectBySaleRuleId(int saleRuleId) {
		return baseRuleMapper.selectBySaleRuleId(saleRuleId);
	}

	/*@Override
	public int updateBySaleRuleIdSelective(BaseRule record) {
		return baseRuleMapper.updateByPrimaryKey(record);
	}*/

	@Override
	public int deleteBySaleRuleId(int saleRuleId) {
		return baseRuleMapper.deleteBySaleRuleId(saleRuleId);
	}

	@Override

	public void insertBaseRule(BaseRuleVO baseRuleVO) {


		BaseRule rule = new BaseRule();
		Date now = new Date();
		rule.setCreated(now);
		rule.setHotelInstruction(null);
		rule.setIncreaseAmount(null);
		rule.setIncreaseType(null);
		rule.setLowerPrice(0);
		rule.setModified(null);
		rule.setModUserId(UserUtils.getCurrentUser().getId());
		rule.setPresentSale(now);
		rule.setRoomDetain(0);
		rule.setRoomInstruction(null);

		rule.setSafePrice(0);
	
		rule.setSaleRuleId(baseRuleVO.getSaleRuleId());


		baseRuleMapper.insertSelective(rule);
	}

	@Override
	public void updateBaseRule(BaseRuleVO baseRuleVO) {
		

		BaseRule rule = baseRuleMapper.selectByPrimaryKey(baseRuleVO.getBaseId());
		Date now = new Date();
		rule.setHotelInstruction(baseRuleVO.getHotelInstruction());
		rule.setIncreaseAmount(baseRuleVO.getIncreaseAmount());
		rule.setIncreaseType(baseRuleVO.getIncreaseType());
		rule.setLowerPrice(baseRuleVO.getLowerPrice());
		rule.setModified(now);
		rule.setModUserId(UserUtils.getCurrentUser().getId());
		rule.setPresentSale(baseRuleVO.getPresentSale());
		rule.setRoomDetain(baseRuleVO.getRoomDetain());
		rule.setRoomInstruction(baseRuleVO.getRoomInstruction());

		rule.setSafePrice(baseRuleVO.getSafePrice());
		

		baseRuleMapper.updateByPrimaryKeySelective(rule);

	}

	@Override
	public List<String> getAllBaseRule() {
		return baseRuleMapper.selectAllUserRule();
	}

	@Override
	public BaseRule selectById(Integer id) {
		
		return baseRuleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(int id) {
		
		return baseRuleMapper.deleteByPrimaryKey(id);
	}

	


	
	}


