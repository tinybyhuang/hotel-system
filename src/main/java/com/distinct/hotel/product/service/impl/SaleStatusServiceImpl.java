package com.distinct.hotel.product.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.distinct.hotel.common.UserUtils;
import com.distinct.hotel.product.dao.RoomMapper;
import com.distinct.hotel.product.dao.RoomPriceMapper;
import com.distinct.hotel.product.dao.SaleStatusMapper;
import com.distinct.hotel.product.model.RoomPrice;
import com.distinct.hotel.product.model.SaleStatus;
import com.distinct.hotel.product.service.SaleStatusService;
import com.distinct.hotel.product.vo.DateApplication;
import com.distinct.hotel.product.vo.SetSaleStatusVO;
import com.distinct.hotel.sale.dao.PublishRuleMapper;
import com.distinct.hotel.sale.dao.SaleRuleMapper;

@Service
public class SaleStatusServiceImpl implements SaleStatusService {

	@Resource
	private SaleStatusMapper saleStatusMapper;

	@Resource
	private RoomPriceMapper roomPriceMapper;

	@Resource
	private SaleRuleMapper saleRuleMapper;

	@Resource
	private RoomMapper roomMapper;

	@Resource
	private PublishRuleMapper publishRuleMapper;

	// 返回一个销售状态的集合
	@Override
	public List<SaleStatus> findSaleStatusList(int providerRoomId) {
		return saleStatusMapper.findSaleStatusListByRoomId(providerRoomId);
	}

	// 增加一个记录
	@Override
	public int addSaleStatus(SetSaleStatusVO setSaleStatusVO) {
		Integer saleRuleId = saleRuleMapper
				.selectByuserIdNmarketId(UserUtils.getCurrentUser().getId(), setSaleStatusVO.getMarketID()).getId();
		SaleStatus saleStatus = new SaleStatus();
		saleStatus.setCreated(new Date());
		saleStatus.setProviderId(setSaleStatusVO.getProviderID());
		saleStatus.setRoomId(setSaleStatusVO.getRoomID());
		saleStatus.setSaleDate(setSaleStatusVO.getSaleDate());
		saleStatus.setSaleStatus(setSaleStatusVO.getStatus());
		saleStatus.setSaleRuleId(saleRuleId);
		return saleStatusMapper.insert(saleStatus);
	}

	@Override
	public void setBatchSaleStatusByRoomId(int providerRoomId, String status) {
		List<RoomPrice> roomPriceList = roomPriceMapper.findRoomPriceByRoomId(providerRoomId);
		if (status.equals("全部上架")) {
			for (RoomPrice roomPrice : roomPriceList) {
				SaleStatus saleStatus = new SaleStatus();
				saleStatus.setSaleRuleId(1);
				saleStatus.setCreated(new Date());
				saleStatus.setProviderId(1);
				saleStatus.setRoomId(roomPrice.getRoomId());
				saleStatus.setSaleDate(roomPrice.getSaleDate());
				saleStatus.setSaleStatus("上架");
				saleStatusMapper.insert(saleStatus);
			}
		} else if (status.equals("全部下架")) {
			for (RoomPrice roomPrice : roomPriceList) {
				SaleStatus saleStatus = new SaleStatus();
				saleStatus.setCreated(new Date());
				saleStatus.setProviderId(1);
				saleStatus.setRoomId(roomPrice.getRoomId());
				saleStatus.setSaleDate(roomPrice.getSaleDate());
				saleStatus.setSaleStatus("下架");
				saleStatus.setSaleRuleId(1);
				saleStatusMapper.insert(saleStatus);
			}
		} else {

			System.out.println(0);
		}

	}

	@Override
	public void setSaleStatusConsiderPublishRule(SetSaleStatusVO saleStatusVO) {
		// 应用的saleRule的id为3 平台2关店
		// 应用的publishRule的id为2 该rule应用的 SaleRule的Id为3 2016-05-10到2016-05-15
		// 所有房型都下架

	}

	@Override
	public void setSaleStatus(SetSaleStatusVO saleStatusVO) {
		// 日期处理器
		// 判断输入的这个日期是否已经有数据了，然后修改
		Integer saleRuleId = saleRuleMapper
				.selectByuserIdNmarketId(UserUtils.getCurrentUser().getId(), saleStatusVO.getMarketID()).getId();

		// 利用上下架返回两个日期间的日期集合
		List<Date> dateList = DateApplication.returnDateList(saleStatusVO.getStartTime(), saleStatusVO.getEndTime());

		System.out.println(dateList);

		for (Date date : dateList) {
			// 判断是否有了上下架
			// 唯一一个上下架状态
			SaleStatus saleStatus = saleStatusMapper.findSaleStatusByroomIdNproviderIdNsaleDateNsaleRuleId(
					saleStatusVO.getRoomID(), saleRuleId, saleStatusVO.getProviderID(), date);
			if (null == saleStatus) {
				// 把这一天的日期压进去
				// saleStatusVO.setSaleDate(date);
				// 增加上下架记录
				SaleStatus newStatus = new SaleStatus();
				newStatus.setCreated(new Date());
				newStatus.setProviderId(saleStatusVO.getProviderID());
				newStatus.setRoomId(saleStatusVO.getRoomID());
				newStatus.setSaleDate(date);
				newStatus.setSaleStatus(saleStatusVO.getStatus());
				newStatus.setSaleRuleId(saleRuleId);
				saleStatusMapper.insert(newStatus);
			} else {
				Integer id = saleStatusMapper.findSaleStatusByroomIdNproviderIdNsaleDateNsaleRuleId(
						saleStatusVO.getRoomID(), saleRuleId, saleStatusVO.getProviderID(), date).getId();
				SaleStatus newStatus = saleStatusMapper.selectByPrimaryKey(id);
				newStatus.setModified(new Date());
				newStatus.setModUserId(UserUtils.getCurrentUser().getId());
				newStatus.setSaleStatus(saleStatusVO.getStatus());
				saleStatusMapper.updateByPrimaryKey(newStatus);
			}

		}

	}

	@Override
	public void updateSaleStatusRecord(SetSaleStatusVO saleStatusVO) {

		// 返回一条销售规则的id
		Integer saleRuleId = saleRuleMapper
				.selectByUserIdAndMarketId(UserUtils.getCurrentUser().getId(), saleStatusVO.getMarketID()).getId();
		Integer id = saleStatusMapper.findSaleStatusByroomIdNproviderIdNsaleDateNsaleRuleId(saleStatusVO.getRoomID(),
				saleRuleId, saleStatusVO.getProviderID(), saleStatusVO.getSaleDate()).getId();
		SaleStatus saleStatus = saleStatusMapper.selectByPrimaryKey(id);
		saleStatus.setModified(new Date());
		saleStatus.setModUserId(UserUtils.getCurrentUser().getId());
		saleStatus.setSaleStatus(saleStatusVO.getStatus());
		saleStatusMapper.updateByPrimaryKey(saleStatus);
	}

	@Override
	public List<SaleStatus> findSaleStatusByMarketIdNroomIdNproviderId(int roomId, int marketId, int providerId) {

		Integer saleRuleId = saleRuleMapper.selectByUserIdAndMarketId(UserUtils.getCurrentUser().getId(), marketId)
				.getId();

		List<SaleStatus> saleStatusList = saleStatusMapper.findSaleStatusListByroomIdNproviderIdNsaleRuleId(roomId,
				saleRuleId, providerId);

		return saleStatusList;
	}

	@Override
	public List<SaleStatus> findSaleStatusByMarketIdNroomIdNproviderIdNToday(int roomId, int marketId, int providerId) {
		Integer saleRuleId = saleRuleMapper.selectByUserIdAndMarketId(UserUtils.getCurrentUser().getId(), marketId)
				.getId();
		return saleStatusMapper.findSaleStatusByroomIdNproviderIdNsaleDateNsaleRuleIdNAfterToday(roomId, saleRuleId,
				providerId, new Date());
	}

}
