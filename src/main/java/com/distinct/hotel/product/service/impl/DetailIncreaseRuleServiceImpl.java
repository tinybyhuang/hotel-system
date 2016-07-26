package com.distinct.hotel.product.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.distinct.hotel.common.UserUtils;
import com.distinct.hotel.common.page.PageBounds;
import com.distinct.hotel.common.page.PageList;
import com.distinct.hotel.common.page.PageResult;
import com.distinct.hotel.product.dao.DetailIncreaseRuleMapper;
import com.distinct.hotel.product.model.DetailIncreaseRule;
import com.distinct.hotel.product.service.DetailIncreaseRuleService;
import com.distinct.hotel.product.vo.SetDetailIncreaseRuleVO;
import com.distinct.hotel.sale.dao.SaleRuleMapper;
import com.distinct.hotel.sale.model.SaleRule;

@Service
public class DetailIncreaseRuleServiceImpl implements DetailIncreaseRuleService {

	@Resource
	private DetailIncreaseRuleMapper detailIncreaseRuleMapper;

	@Resource
	private SaleRuleMapper saleRuleMapper;

	@Override
	public void updateDetailIncreaseRule(SetDetailIncreaseRuleVO detailIncreaseRuleVO) {

		Integer saleRuleId = saleRuleMapper
				.selectByUserIdAndMarketId(UserUtils.getCurrentUser().getId(), detailIncreaseRuleVO.getMarketID())
				.getId();

		DetailIncreaseRule detailIncreaseRule = new DetailIncreaseRule();
		// 查id
		/*
		 * Integer id =
		 * detailIncreaseRuleMapper.returnMaxId(detailIncreaseRuleVO.getRoomID()
		 * , detailIncreaseRuleVO.getSaleDate());
		 */

		Integer id = detailIncreaseRuleMapper
				.findDetailIncreaseRuleBySaleRuleIdNroomIdNsaleDateNproviderId(detailIncreaseRuleVO.getRoomID(),
						detailIncreaseRuleVO.getSaleDate(), saleRuleId, detailIncreaseRuleVO.getProviderID())
				.getId();

		detailIncreaseRule = detailIncreaseRuleMapper.findDetailIncreaseRuleByid(id);
		// 修改内容
		detailIncreaseRule.setIncreaseType(detailIncreaseRuleVO.getIncreaseType());
		detailIncreaseRule.setIncreaseAmount(detailIncreaseRuleVO.getIncreaseAmount());
		detailIncreaseRule.setModUserId(UserUtils.getCurrentUser().getId()); // 用户2修改
		detailIncreaseRule.setModified(new Date()); // 修改日期 年月日时分秒
		detailIncreaseRuleMapper.updateByPrimaryKey(detailIncreaseRule);
	}

	// 增数据
	// 当有选择加幅类型
	@Override
	public void addDetailIncreaseRule(SetDetailIncreaseRuleVO detailIncreaseRuleVO) {

		if (detailIncreaseRuleVO.getIncreaseType() != null && detailIncreaseRuleVO.getIncreaseAmount() != 0.0) {
			SaleRule saleRule = saleRuleMapper.selectByUserIdAndMarketId(UserUtils.getCurrentUser().getId(),
					detailIncreaseRuleVO.getMarketID());
			DetailIncreaseRule detailIncreaseRule = new DetailIncreaseRule();
			detailIncreaseRule.setSaleRuleId(saleRule.getId()); // 销售规则的id代表某个平台的开关店，此处把它的值固定为1
			detailIncreaseRule.setProviderId(detailIncreaseRuleVO.getProviderID());// 供应商的id固定值为1
			detailIncreaseRule.setCreated(new Date());
			detailIncreaseRule.setIncreaseAmount(detailIncreaseRuleVO.getIncreaseAmount());
			detailIncreaseRule.setIncreaseDate(detailIncreaseRuleVO.getSaleDate());
			detailIncreaseRule.setIncreaseType(detailIncreaseRuleVO.getIncreaseType());
			detailIncreaseRule.setRoomId(detailIncreaseRuleVO.getRoomID());
			detailIncreaseRuleMapper.insert(detailIncreaseRule);
		}
	}

	// 返回酒店数据，提供分页功能
	@Override
	public PageResult<DetailIncreaseRule> selectDetailIncreaseRule(PageBounds pageBounds) {

		PageList<DetailIncreaseRule> detailIncreaseRules = detailIncreaseRuleMapper.findAll(pageBounds);
		System.out.println(detailIncreaseRules);
		return new PageResult<DetailIncreaseRule>(detailIncreaseRules);
	}

	@Override
	public void deleteDetailIncreaseRule() {

	}

	@Override
	public void detailIncreaseRuleApplication(int theRuleId) {

	}

	@Override
	public DetailIncreaseRule findDetailIncreaseRuleByMarketIdNroomIdNsaleDateNproviderId(int roomId, Date saleDate, int marketId, int providerId) {
		Integer saleRuleId = saleRuleMapper.selectByUserIdAndMarketId(UserUtils.getCurrentUser().getId(), marketId)
				.getId();

		return detailIncreaseRuleMapper.findDetailIncreaseRuleBySaleRuleIdNroomIdNsaleDateNproviderId(roomId, saleDate,
				saleRuleId, providerId);
	}

}
