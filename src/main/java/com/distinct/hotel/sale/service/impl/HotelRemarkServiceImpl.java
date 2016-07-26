package com.distinct.hotel.sale.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.distinct.hotel.common.UserUtils;
import com.distinct.hotel.sale.dao.HotelRemarkMapper;
import com.distinct.hotel.sale.model.HotelRemark;
import com.distinct.hotel.sale.service.HotelRemarkService;
import com.distinct.hotel.sale.vo.HotelRemarkVO;
@Service
public class HotelRemarkServiceImpl implements HotelRemarkService {
@Resource HotelRemarkMapper hotelRemarkMapper;
	@Override
	public void insertHotelRemark(HotelRemarkVO hotelRemarkVO){
		HotelRemark remark = new HotelRemark();
		Date now = new Date();
		remark.setCreated(now);
		remark.setHotelId(hotelRemarkVO.getHotelId());
		remark.setModified(null);
		remark.setRemark(hotelRemarkVO.getRemark());
		remark.setProviderId(hotelRemarkVO.getProviderId());
		remark.setModUserId(null);
		remark.setSaleRuleId(UserUtils.getCurrentUser().getId());
		hotelRemarkMapper.insertSelective(remark);
	}

	@Override
	public void deleteHotelRemarkById(Integer id) {
		hotelRemarkMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public List<HotelRemark> selectedListBySaleRuleId(Integer saleRuleId) {
		
		return hotelRemarkMapper.selectedListBySaleRuleId(saleRuleId);
	}

	@Override
	public void updateHotelRemark(HotelRemarkVO hotelRemarkVO) {
		Date now = new Date();
		HotelRemark remark = hotelRemarkMapper.selectedByHotelIdAndSaleRuleId(hotelRemarkVO.getHotelId(),hotelRemarkVO.getSaleRuleId());
		
		remark.setHotelId(hotelRemarkVO.getHotelId());
		remark.setModified(now);
		remark.setModUserId(UserUtils.getCurrentUser().getId());
		remark.setProviderId(hotelRemarkVO.getProviderId());
		remark.setRemark(hotelRemarkVO.getRemark());
		remark.setSaleRuleId(hotelRemarkVO.getSaleRuleId());
		
		hotelRemarkMapper.updateByPrimaryKeySelective(remark);
		
		
	}

	@Override
	public HotelRemark selectedByHotelIdAndSaleRuleId(Integer hotelId,Integer saleRuleId) {
		
		return hotelRemarkMapper.selectedByHotelIdAndSaleRuleId(hotelId,saleRuleId);
	}

	@Override
	public void insertHotelRemarkInit(Integer hotelId,Integer providerId,Integer saleRuleId) {
		HotelRemark remark = new HotelRemark();
		Date now = new Date();
		remark.setCreated(now);
		remark.setHotelId(hotelId);
		remark.setModified(null);
		remark.setRemark("请描述该酒店");
		remark.setProviderId(providerId);
		remark.setModUserId(null);
		remark.setSaleRuleId(saleRuleId);
		hotelRemarkMapper.insertSelective(remark);
		
	}

	@Override
	public void deleteHotelRemarkByHotelIdAndSaleRuleIdAP(Integer hotelId, Integer saleRuleId,Integer providerId) {
		hotelRemarkMapper.deleteHotelRemarkByHotelIdAndSaleRuleIdAP( hotelId,  saleRuleId,providerId);
	}

	

}
