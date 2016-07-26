package com.distinct.hotel.sale.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.distinct.hotel.common.UserUtils;
import com.distinct.hotel.common.page.PageBounds;
import com.distinct.hotel.common.page.PageList;
import com.distinct.hotel.common.page.PageResult;
import com.distinct.hotel.product.dao.CityMapper;
import com.distinct.hotel.product.dao.HotelMapper;
import com.distinct.hotel.product.dao.RoomMapper;
import com.distinct.hotel.product.model.City;
import com.distinct.hotel.product.model.Hotel;
import com.distinct.hotel.product.model.Room;
import com.distinct.hotel.product.vo.HotelDetailVO;
import com.distinct.hotel.product.vo.HotelPurposeVO;
import com.distinct.hotel.sale.dao.IncreaseRuleMapper;
import com.distinct.hotel.sale.dao.SaleRuleMapper;
import com.distinct.hotel.sale.model.IncreaseRule;
import com.distinct.hotel.sale.model.SaleRule;
import com.distinct.hotel.sale.service.HotelNIncreaseService;
import com.distinct.hotel.sale.vo.CityNIncreaseRuleVO;
import com.distinct.hotel.sale.vo.SetIncreaseRuleVO;

@Service
public class HotelNIncreaseServiceImpl implements HotelNIncreaseService {

	private final static String success = "操作成功";

	private final static String failure = "操作失败";

	@Resource
	private HotelMapper hotelMapper;

	@Resource
	private RoomMapper roomMapper;

	@Resource
	private SaleRuleMapper saleRuleMapper;

	@Resource
	private IncreaseRuleMapper increaseRuleMapper;

	@Resource
	private CityMapper cityMapper;

	@Override
	public PageResult<HotelDetailVO> findPurPoseHotelDetailNIncreaseRule(PageBounds pageBounds,
			HotelPurposeVO hotelPurposeVO) {
		// 平台id默认为1
		if (hotelPurposeVO.getCity() == null && hotelPurposeVO.getStar().length() == 0
				&& hotelPurposeVO.getHotelName().length() == 0 && hotelPurposeVO.getProviderId() == 1
				&& hotelPurposeVO.getMarketId() == 1) {
			// 三个值都为空的时候,不需要加任何条件,直接返回一个正常的数据
			PageList<Hotel> hotels = hotelMapper.findAll(pageBounds);
			Integer saleRuleId = saleRuleMapper
					.selectByuserIdNmarketId(UserUtils.getCurrentUser().getId(), hotelPurposeVO.getMarketId()).getId();
			Map<Integer, IncreaseRule> roomIncreaseRuleMap = new HashMap<Integer, IncreaseRule>();
			PageList<HotelDetailVO> hotelDetailVOList = new PageList<HotelDetailVO>();
			// 分页器
			hotelDetailVOList.setPage(hotels.getPaginator());
			for (Hotel hotel : hotels) {
				HotelDetailVO hotelDetailVO = new HotelDetailVO();
				hotelDetailVO.setHotel(hotel); // 设置酒店属性的值
				IncreaseRule hotelIncreaseRule = increaseRuleMapper.selectByScopeTypeNSaleRuleIdNProviderIdNScopeId(
						"酒店", saleRuleId, hotelPurposeVO.getMarketId(), hotel.getProviderHotelId());
				if (hotelIncreaseRule != null) {
					hotelDetailVO.setHotelIncreaseRule(hotelIncreaseRule);
				}
				// 单个房间
				List<Room> rooms = roomMapper.findRoomByHotelId(hotel.getProviderHotelId());// 拿到每一个酒店对应的room列表数据
				hotelDetailVO.setRooms(rooms);
				for (Room room : rooms) {
					IncreaseRule roomIncreaseRule = increaseRuleMapper.selectByScopeTypeNSaleRuleIdNProviderIdNScopeId(
							"房型", saleRuleId, hotelPurposeVO.getMarketId(), room.getProviderRoomId());

					if (roomIncreaseRule != null) {
						roomIncreaseRuleMap.put(room.getProviderRoomId(), roomIncreaseRule);
					}
				}
				hotelDetailVO.setRoomIncreaseRuleMap(roomIncreaseRuleMap);
				hotelDetailVOList.add(hotelDetailVO);
			}
			return new PageResult<HotelDetailVO>(hotelDetailVOList);
		} else {
			// 当5个条件都不全为空，传入一个search查询数据
			PageList<Hotel> hotels = hotelMapper.findPurpose(pageBounds, hotelPurposeVO);
			Integer saleRuleId = saleRuleMapper
					.selectByuserIdNmarketId(UserUtils.getCurrentUser().getId(), hotelPurposeVO.getMarketId()).getId();
			Map<Integer, IncreaseRule> roomIncreaseRuleMap = new HashMap<Integer, IncreaseRule>();
			PageList<HotelDetailVO> hotelDetailVOList = new PageList<HotelDetailVO>();
			// 分页器
			hotelDetailVOList.setPage(hotels.getPaginator());
			for (Hotel hotel : hotels) {
				HotelDetailVO hotelDetailVO = new HotelDetailVO();
				hotelDetailVO.setHotel(hotel); // 设置酒店属性的值
				IncreaseRule hotelIncreaseRule = increaseRuleMapper.selectByScopeTypeNSaleRuleIdNProviderIdNScopeId(
						"酒店", saleRuleId, hotelPurposeVO.getProviderId(), hotel.getProviderHotelId());
				if (hotelIncreaseRule != null) {
					hotelDetailVO.setHotelIncreaseRule(hotelIncreaseRule);
				}
				// 单个房间
				List<Room> rooms = roomMapper.findRoomByHotelId(hotel.getProviderHotelId());// 拿到每一个酒店对应的room列表数据
				hotelDetailVO.setRooms(rooms);
				for (Room room : rooms) {
					IncreaseRule roomIncreaseRule = increaseRuleMapper.selectByScopeTypeNSaleRuleIdNProviderIdNScopeId(
							"房型", saleRuleId, hotelPurposeVO.getProviderId(), room.getProviderRoomId());
					if (roomIncreaseRule != null) {
						roomIncreaseRuleMap.put(room.getProviderRoomId(), roomIncreaseRule);
					}
				}
				hotelDetailVO.setRoomIncreaseRuleMap(roomIncreaseRuleMap);
				hotelDetailVOList.add(hotelDetailVO);

			}
			return new PageResult<HotelDetailVO>(hotelDetailVOList);
		}
	}

	@Override
	public PageResult<HotelDetailVO> findHotelDetailNIncreaseRule(PageBounds pageBounds, int defaultProviderId,
			int saleRuleId) {
		PageList<Hotel> hotels = hotelMapper.findAll(pageBounds);
		/*
		 * Integer saleRuleId =
		 * saleRuleMapper.selectByuserIdNmarketId(UserUtils.getCurrentUser().
		 * getId(), defaultMarketId) .getId();
		 */

		// 一个id和一个加幅规则对应
		Map<Integer, IncreaseRule> roomIncreaseRuleMap = new HashMap<Integer, IncreaseRule>();

		PageList<HotelDetailVO> hotelDetailVOList = new PageList<HotelDetailVO>();
		// 分页器
		hotelDetailVOList.setPage(hotels.getPaginator());
		for (Hotel hotel : hotels) {
			HotelDetailVO hotelDetailVO = new HotelDetailVO();
			hotelDetailVO.setHotel(hotel); // 设置酒店属性的值
			IncreaseRule hotelIncreaseRule = increaseRuleMapper.selectByScopeTypeNSaleRuleIdNProviderIdNScopeId("酒店",
					saleRuleId, defaultProviderId, hotel.getProviderHotelId());

			if (hotelIncreaseRule != null) {
				hotelDetailVO.setHotelIncreaseRule(hotelIncreaseRule);
			}
			// 单个房间
			List<Room> rooms = roomMapper.findRoomByHotelId(hotel.getProviderHotelId());// 拿到每一个酒店对应的room列表数据
			hotelDetailVO.setRooms(rooms);
			for (Room room : rooms) {
				IncreaseRule roomIncreaseRule = increaseRuleMapper.selectByScopeTypeNSaleRuleIdNProviderIdNScopeId("房型",
						saleRuleId, defaultProviderId, room.getProviderRoomId());

				if (roomIncreaseRule != null) {
					roomIncreaseRuleMap.put(room.getProviderRoomId(), roomIncreaseRule);
				}
			}
			hotelDetailVO.setRoomIncreaseRuleMap(roomIncreaseRuleMap);
			hotelDetailVOList.add(hotelDetailVO);
		}
		return new PageResult<HotelDetailVO>(hotelDetailVOList);
	}

	// 返回当前城市加幅的数据
	@Override
	public List<CityNIncreaseRuleVO> findIncreaseCity(int marketId, int providerId) {

		List<CityNIncreaseRuleVO> cityNIncreaseRuleVOList = new ArrayList<CityNIncreaseRuleVO>();

		Integer saleRuleId = saleRuleMapper.selectByuserIdNmarketId(UserUtils.getCurrentUser().getId(), marketId)
				.getId();

		List<Integer> cityIdList = increaseRuleMapper.findScopeIdByScopeTypeNSaleRuleIdNProviderId("城市", saleRuleId,
				providerId);
		// 根据id需找城市
		for (Integer cityId : cityIdList) {
			CityNIncreaseRuleVO cityNIncreaseRuleVO = new CityNIncreaseRuleVO();
			City city = cityMapper.selectByPrimaryKey(cityId);

			IncreaseRule increaseRule = increaseRuleMapper.selectByScopeTypeNSaleRuleIdNProviderIdNScopeId("城市",
					saleRuleId, providerId, cityId);
			cityNIncreaseRuleVO.setCity(city);
			cityNIncreaseRuleVO.setIncreaseRule(increaseRule);
			cityNIncreaseRuleVOList.add(cityNIncreaseRuleVO);
		}
		return cityNIncreaseRuleVOList;
	}

	@Override
	public String setIncreaseRule(SetIncreaseRuleVO SetIncreaseRuleVO) {

		Integer saleRuleId = saleRuleMapper
				.selectByuserIdNmarketId(UserUtils.getCurrentUser().getId(), SetIncreaseRuleVO.getMarketId()).getId();

		if (SetIncreaseRuleVO.getCityId() == null && SetIncreaseRuleVO.getHotelId() == null
				&& SetIncreaseRuleVO.getRoomId() == null) {
			return failure;
		} else if (SetIncreaseRuleVO.getCityId() != null && SetIncreaseRuleVO.getHotelId() != null
				&& SetIncreaseRuleVO.getRoomId() != null) {
			return failure;
		} else if (SetIncreaseRuleVO.getCityId() != null && SetIncreaseRuleVO.getHotelId() == null
				&& SetIncreaseRuleVO.getRoomId() == null) {
			// 查这个城市有没有已经设置了加幅数据

			IncreaseRule increaseRule = increaseRuleMapper.selectByScopeTypeNSaleRuleIdNProviderIdNScopeId("城市",
					saleRuleId, SetIncreaseRuleVO.getProviderId(), SetIncreaseRuleVO.getCityId());

			if (increaseRule == null) {
				IncreaseRule newIncreaseRule = new IncreaseRule();
				newIncreaseRule.setIncreaseAmount(SetIncreaseRuleVO.getIncreaseAmount());
				newIncreaseRule.setIncreaseType(SetIncreaseRuleVO.getIncreaseType());
				newIncreaseRule.setProviderId(SetIncreaseRuleVO.getProviderId());
				newIncreaseRule.setSaleRuleId(saleRuleId);
				newIncreaseRule.setScopeId(SetIncreaseRuleVO.getCityId());
				newIncreaseRule.setScopeType("城市");
				newIncreaseRule.setCreated(new Date());
				newIncreaseRule.setModified(new Date());
				newIncreaseRule.setModUserId(UserUtils.getCurrentUser().getId());
				// 创建对象
				increaseRuleMapper.insert(newIncreaseRule);

			} else if (increaseRule != null) {
				// 更新数据
				increaseRule.setIncreaseAmount(SetIncreaseRuleVO.getIncreaseAmount());
				increaseRule.setIncreaseType(SetIncreaseRuleVO.getIncreaseType());
				increaseRule.setModified(new Date());
				increaseRule.setModUserId(UserUtils.getCurrentUser().getId());
				increaseRuleMapper.updateByPrimaryKey(increaseRule);

			}
			return success;
		} else if (SetIncreaseRuleVO.getCityId() == null && SetIncreaseRuleVO.getHotelId() != null
				&& SetIncreaseRuleVO.getRoomId() == null) {

			IncreaseRule increaseRule = increaseRuleMapper.selectByScopeTypeNSaleRuleIdNProviderIdNScopeId("酒店",
					saleRuleId, SetIncreaseRuleVO.getProviderId(), SetIncreaseRuleVO.getHotelId());

			if (increaseRule == null) {
				IncreaseRule newIncreaseRule = new IncreaseRule();
				newIncreaseRule.setIncreaseAmount(SetIncreaseRuleVO.getIncreaseAmount());
				newIncreaseRule.setIncreaseType(SetIncreaseRuleVO.getIncreaseType());
				newIncreaseRule.setProviderId(SetIncreaseRuleVO.getProviderId());
				newIncreaseRule.setSaleRuleId(saleRuleId);
				newIncreaseRule.setScopeId(SetIncreaseRuleVO.getHotelId());
				newIncreaseRule.setScopeType("酒店");
				newIncreaseRule.setCreated(new Date());
				newIncreaseRule.setModified(new Date());
				newIncreaseRule.setModUserId(UserUtils.getCurrentUser().getId());
				// 创建对象
				increaseRuleMapper.insert(newIncreaseRule);

			} else if (increaseRule != null) {
				// 更新数据
				increaseRule.setIncreaseAmount(SetIncreaseRuleVO.getIncreaseAmount());
				increaseRule.setIncreaseType(SetIncreaseRuleVO.getIncreaseType());
				increaseRule.setModified(new Date());
				increaseRule.setModUserId(UserUtils.getCurrentUser().getId());
				increaseRuleMapper.updateByPrimaryKey(increaseRule);

			}

			return success;
		} else if (SetIncreaseRuleVO.getCityId() == null && SetIncreaseRuleVO.getHotelId() == null
				&& SetIncreaseRuleVO.getRoomId() != null) {

			IncreaseRule increaseRule = increaseRuleMapper.selectByScopeTypeNSaleRuleIdNProviderIdNScopeId("房型",
					saleRuleId, SetIncreaseRuleVO.getProviderId(), SetIncreaseRuleVO.getRoomId());

			if (increaseRule == null) {
				IncreaseRule newIncreaseRule = new IncreaseRule();
				newIncreaseRule.setIncreaseAmount(SetIncreaseRuleVO.getIncreaseAmount());
				newIncreaseRule.setIncreaseType(SetIncreaseRuleVO.getIncreaseType());
				newIncreaseRule.setProviderId(SetIncreaseRuleVO.getProviderId());
				newIncreaseRule.setSaleRuleId(saleRuleId);
				newIncreaseRule.setScopeId(SetIncreaseRuleVO.getRoomId());
				newIncreaseRule.setScopeType("房型");
				newIncreaseRule.setCreated(new Date());
				newIncreaseRule.setModified(new Date());
				newIncreaseRule.setModUserId(UserUtils.getCurrentUser().getId());
				// 创建对象
				increaseRuleMapper.insert(newIncreaseRule);

			} else if (increaseRule != null) {
				// 更新数据
				increaseRule.setIncreaseAmount(SetIncreaseRuleVO.getIncreaseAmount());
				increaseRule.setIncreaseType(SetIncreaseRuleVO.getIncreaseType());
				increaseRule.setModified(new Date());
				increaseRule.setModUserId(UserUtils.getCurrentUser().getId());
				increaseRuleMapper.updateByPrimaryKey(increaseRule);

			}
			return success;
		} else {

			return failure;
		}

	}

	@Override
	public SaleRule findSaleRuleById(int id) {

		return saleRuleMapper.selectByPrimaryKey(id);
	}

	@Override
	public IncreaseRule findIncreaseRuleByproviderIdNmarketIdNscopeTypeNscopeId(String scopeType, int scopeId,
			int marketId, int providerId) {
		Integer saleRuleId = saleRuleMapper.selectByuserIdNmarketId(UserUtils.getCurrentUser().getId(), marketId)
				.getId();
		IncreaseRule increaseRule = increaseRuleMapper.selectByScopeTypeNSaleRuleIdNProviderIdNScopeId(scopeType,
				saleRuleId, providerId, scopeId);
		return increaseRule;
	}

	@Override
	public IncreaseRule findIncreaseRulePurpose(int cityId, int hotelId, int roomId, int providerId, int marketId) {

		Integer saleRuleId = saleRuleMapper.selectByuserIdNmarketId(UserUtils.getCurrentUser().getId(), marketId)
				.getId();

		if (cityId == 0 && hotelId == 0 && roomId == 0) {
			return null;
		} else if (cityId != 0 && hotelId != 0 && roomId != 0) {
			return null;
		} else if (cityId != 0 && hotelId == 0 && roomId == 0) {
			// 城市id不为0
			IncreaseRule increaseRule = increaseRuleMapper.selectByScopeTypeNSaleRuleIdNProviderIdNScopeId("城市",
					saleRuleId, providerId, cityId);
			return increaseRule;
		} else if (cityId == 0 && hotelId != 0 && roomId == 0) {
			// 酒店id不为0
			IncreaseRule increaseRule = increaseRuleMapper.selectByScopeTypeNSaleRuleIdNProviderIdNScopeId("酒店",
					saleRuleId, providerId, hotelId);
			return increaseRule;
		} else if (cityId == 0 && hotelId == 0 && roomId != 0) {
			// 房型id不为0
			IncreaseRule increaseRule = increaseRuleMapper.selectByScopeTypeNSaleRuleIdNProviderIdNScopeId("房型",
					saleRuleId, providerId, roomId);
			return increaseRule;
		} else {

			return null;
		}
	}

	@Override
	public List<Integer> findIncreaseCityIdList(int marketId, int providerId) {
		Integer saleRuleId = saleRuleMapper.selectByuserIdNmarketId(UserUtils.getCurrentUser().getId(), marketId)
				.getId();

		List<Integer> cityIdList = increaseRuleMapper.findScopeIdByScopeTypeNSaleRuleIdNProviderId("城市", saleRuleId,
				providerId);
		return cityIdList;
	}

	@Override
	public List<Integer> findNoIncreaseCityIdList(int marketId, int providerId) {
		Integer saleRuleId = saleRuleMapper.selectByuserIdNmarketId(UserUtils.getCurrentUser().getId(), marketId)
				.getId();

		List<Integer> increaseCityIdList = increaseRuleMapper.findScopeIdByScopeTypeNSaleRuleIdNProviderId("城市",
				saleRuleId, providerId);

		List<Integer> allcityIdList = cityMapper.findAllId();

		allcityIdList.removeAll(increaseCityIdList);

		return allcityIdList;
	}

	@Override
	public List<Integer> findAllCityId() {
		
		return cityMapper.findAllId();
	}

}
