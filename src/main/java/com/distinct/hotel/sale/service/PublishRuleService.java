package com.distinct.hotel.sale.service;

import java.util.List;

import com.distinct.hotel.sale.model.PublishRule;
import com.distinct.hotel.sale.vo.PublishRuleShowVO;
import com.distinct.hotel.sale.vo.PublishRuleVO;

public interface PublishRuleService {
	public void insertPublishRule(PublishRuleVO publishRuleVO);

	public void insertPublishRuleData(PublishRuleVO publishRuleVO);

	public PublishRule selectBySaleRuleId(int saleRuleId);

	public void updatePublishRule(PublishRuleVO publishRuleVO);

	public void deletePublisRuleBySaleRuleId(int saleRuleId);

	public PublishRule selectById(int id);

	public void deletePublishRuleById(int id);

	public List<PublishRule> selectByPublishRuleSaleRuleId(int saleRuleId);
 
	public List<PublishRule> selectByIdList(Integer id);

	public List<PublishRuleShowVO> selectPublishRuleListBySaleRuleId(Integer saleRuleId);
    
}
