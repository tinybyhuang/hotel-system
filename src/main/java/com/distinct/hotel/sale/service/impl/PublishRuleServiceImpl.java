package com.distinct.hotel.sale.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.distinct.hotel.common.UserUtils;
import com.distinct.hotel.product.vo.DateApplication;
import com.distinct.hotel.sale.dao.PublishRuleMapper;
import com.distinct.hotel.sale.model.PublishRule;
import com.distinct.hotel.sale.service.PublishRuleService;
import com.distinct.hotel.sale.vo.PublishRuleShowVO;
import com.distinct.hotel.sale.vo.PublishRuleVO;

@Service
public class PublishRuleServiceImpl implements PublishRuleService {
   
	@Resource
	private    PublishRuleMapper publishRuleMapper;
	

	@Override
	public void insertPublishRule(PublishRuleVO publishRuleVO) {
		  Date now = new Date();
		  String nothing = new String();
		PublishRule rule = new PublishRule();
		rule.setBeginDate(now);
		rule.setCreated(now);
		rule.setEndDate(now);
		rule.setModified(null);
		rule.setModUserId(UserUtils.getCurrentUser().getId());
		rule.setSaleRuleId(publishRuleVO.getSaleRuleId());
		rule.setStatus(nothing);
		publishRuleMapper.insertSelective(rule);
		
	}

	@Override
	public PublishRule selectBySaleRuleId(int saleRuleId) {
		
		return publishRuleMapper.selectBySaleRuleId(saleRuleId);
	}

	@Override
	public void updatePublishRule(PublishRuleVO publishRuleVO) {
		  Date now = new Date();
			PublishRule rule = publishRuleMapper.selectByPrimaryKey(publishRuleVO.getId());
			rule.setBeginDate(publishRuleVO.getBeginDate());
			
			rule.setEndDate(publishRuleVO.getEndDate());
			rule.setModified(now);
			rule.setModUserId(UserUtils.getCurrentUser().getId());
		
			rule.setStatus(publishRuleVO.getStatus());
			publishRuleMapper.updateByPrimaryKeySelective(rule);
		
	}

	@Override
	public void deletePublisRuleBySaleRuleId(int saleRuleId)  {
		publishRuleMapper.deleteBySaleRuleId(saleRuleId);
		
	}

	@Override
	public PublishRule selectById(int id) {
		
		return publishRuleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deletePublishRuleById(int id) {
	publishRuleMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public List<PublishRule> selectByPublishRuleSaleRuleId(int saleRuleId) {
		
		return publishRuleMapper.selectListBySaleRuleId(saleRuleId);
	}

	@Override
	public void insertPublishRuleData(PublishRuleVO publishRuleVO) {
		Date now = new Date();
		PublishRule rule = new PublishRule();
		rule.setBeginDate(publishRuleVO.getBeginDate());
		rule.setCreated(now);
		rule.setEndDate(publishRuleVO.getEndDate());
		rule.setModified(now);
		rule.setModUserId(UserUtils.getCurrentUser().getId());
		rule.setSaleRuleId(publishRuleVO.getSaleRuleId());
		rule.setStatus(publishRuleVO.getStatus());
		publishRuleMapper.insertSelective(rule);
			
	}
	@Override
	public List<PublishRule> selectByIdList(Integer id) {
		
		return publishRuleMapper.selectByIdList(id);
	}

	@Override
	public List<PublishRuleShowVO> selectPublishRuleListBySaleRuleId(Integer saleRuleId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		List<PublishRule> ruleList =publishRuleMapper.selectListBySaleRuleId(saleRuleId);
		List<PublishRuleShowVO> showList= new ArrayList<PublishRuleShowVO>();
		for (PublishRule bush : ruleList){
			PublishRuleShowVO show = new PublishRuleShowVO();
			show.setPublishRule(bush);
			
			show.setEndDate(sdf.format(bush.getEndDate()));
		    show.setBeginDate(sdf.format(bush.getBeginDate()));
		    showList.add(show);
		}
		
		
		return showList;
	}

}
