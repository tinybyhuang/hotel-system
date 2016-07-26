package com.distinct.hotel.product.service.impl;

import java.math.BigDecimal;
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
import com.distinct.hotel.product.dao.DetailIncreaseRuleMapper;
import com.distinct.hotel.product.dao.HotelMapper;
import com.distinct.hotel.product.dao.RoomMapper;
import com.distinct.hotel.product.dao.RoomPriceMapper;
import com.distinct.hotel.product.dao.SaleStatusMapper;
import com.distinct.hotel.product.model.DetailIncreaseRule;
import com.distinct.hotel.product.model.Hotel;
import com.distinct.hotel.product.model.Room;
import com.distinct.hotel.product.model.RoomPrice;
import com.distinct.hotel.product.model.SaleStatus;
import com.distinct.hotel.product.service.DetailIncreaseRuleService;
import com.distinct.hotel.product.service.ProductHotelService;
import com.distinct.hotel.product.vo.DateApplication;
import com.distinct.hotel.product.vo.HotelDetailVO;
import com.distinct.hotel.product.vo.HotelPriceVO;
import com.distinct.hotel.product.vo.HotelPurposeVO;
import com.distinct.hotel.product.vo.PriceNDateVO;
import com.distinct.hotel.product.vo.SetDetailIncreaseRuleVO;
import com.distinct.hotel.sale.dao.BaseRuleMapper;
import com.distinct.hotel.sale.dao.IncreaseRuleMapper;
import com.distinct.hotel.sale.dao.PublishRuleMapper;
import com.distinct.hotel.sale.dao.SaleRuleMapper;
import com.distinct.hotel.sale.model.BaseRule;
import com.distinct.hotel.sale.model.IncreaseRule;
import com.distinct.hotel.sale.model.PublishRule;
import com.distinct.hotel.sale.model.SaleRule;

@Service
public class ProductHotelServiceImpl implements ProductHotelService {
	@Resource
	private HotelMapper hotelMapper;

	@Resource
	private RoomMapper roomMapper;

	@Resource
	private RoomPriceMapper roomPriceMapper;

	@Resource
	private DetailIncreaseRuleService detailIncreaseRuleService;

	@Resource
	private DetailIncreaseRuleMapper detailIncreaseRuleMapper;

	@Resource
	private SaleStatusMapper saleStatusMapper;

	@Resource
	private PublishRuleMapper publishRuleMapper;

	@Resource
	private SaleRuleMapper saleRuleMapper;

	@Resource
	private IncreaseRuleMapper increaseRuleMapper;

	@Resource
	private BaseRuleMapper baseRuleMapper;

	// 返回酒店所有数据
	@Override
	public PageResult<Hotel> findAll(PageBounds pageBounds) {
		PageList<Hotel> hotels = hotelMapper.findAll(pageBounds);
		return new PageResult<Hotel>(hotels);
	}

	// 返回酒店全部数据与其对应房型
	@Override
	public PageResult<HotelDetailVO> findDetail(PageBounds pageBounds) {
		PageList<Hotel> hotels = hotelMapper.findAll(pageBounds);

		PageList<HotelDetailVO> hotelDetailVOList = new PageList<HotelDetailVO>();
		// 分页器
		System.out.println(hotels.size());
		hotelDetailVOList.setPage(hotels.getPaginator());
		for (Hotel hotel : hotels) {
			HotelDetailVO hotelDetailVO = new HotelDetailVO();
			hotelDetailVO.setHotel(hotel); // 设置酒店属性的值
			// 单个房间
			List<Room> rooms = roomMapper.findRoomByHotelId(hotel.getProviderHotelId());// 拿到每一个酒店对应的room列表数据
			hotelDetailVO.setRooms(rooms);
			hotelDetailVOList.add(hotelDetailVO);
		}
		return new PageResult<HotelDetailVO>(hotelDetailVOList);
	}

	// 根据酒店id返回去对应的房型数据
	@Override
	public HotelDetailVO findPrice(int providerHotelId) {
		// 一个酒店 一个roomlist 一个map
		HotelDetailVO hotelDetailVO = new HotelDetailVO();
		List<Room> rooms = roomMapper.findRoomByHotelId(providerHotelId);
		Map<Room, List<RoomPrice>> roomPriceMap = new HashMap<Room, List<RoomPrice>>();
		for (Room room : rooms) { // 遍历每个房间，得到房间的床型和房间两周内的价格
			List<RoomPrice> roomPrices = roomPriceMapper.findRoomPriceByRoomId(room.getProviderRoomId());
			roomPriceMap.put(room, roomPrices);
		}
		hotelDetailVO.setRooms(rooms);
		hotelDetailVO.setRoomPriceMap(roomPriceMap);
		return hotelDetailVO;
	}

	// 按条件查询
	@Override
	public PageResult<HotelDetailVO> findPurposeDetail(PageBounds pageBounds, HotelPurposeVO search) {

		// 平台id默认为1(如果该用户有这个平台)
		// 供应商默认为1
		if (search.getCity() == null && search.getStar().length() == 0 && search.getHotelName().length() == 0
				&& search.getProviderId() == 1) {
			// 三个值都为空的时候,不需要加任何条件,直接返回一个正常的数据
			PageList<Hotel> hotels = hotelMapper.findAll(pageBounds);
			PageList<HotelDetailVO> hotelDetailVOList = new PageList<HotelDetailVO>();
			// 分页器

			// 返回酒店数据
			hotelDetailVOList.setPage(hotels.getPaginator());
			for (Hotel hotel : hotels) {
				HotelDetailVO hotelDetailVO = new HotelDetailVO();
				hotelDetailVO.setHotel(hotel); // 设置酒店属性的值
				// 单个房间
				List<Room> rooms = roomMapper.findRoomByHotelId(hotel.getProviderHotelId());// 拿到每一个酒店对应的room列表数据
				hotelDetailVO.setRooms(rooms);
				hotelDetailVOList.add(hotelDetailVO);
			}
			return new PageResult<HotelDetailVO>(hotelDetailVOList);
		} else {
			// 当6个条件都不全为空，传入一个search查询数据
			PageList<Hotel> hotels = hotelMapper.findPurpose(pageBounds, search);
			PageList<HotelDetailVO> hotelDetailVOList = new PageList<HotelDetailVO>();
			// 分页器
			hotelDetailVOList.setPage(hotels.getPaginator());
			for (Hotel hotel : hotels) {
				HotelDetailVO hotelDetailVO = new HotelDetailVO();
				hotelDetailVO.setHotel(hotel); // 设置酒店属性的值
				// 单个房间
				List<Room> rooms = roomMapper.findRoomByHotelId(hotel.getProviderHotelId());// 拿到每一个酒店对应的room列表数据
				hotelDetailVO.setRooms(rooms);
				hotelDetailVOList.add(hotelDetailVO);
			}
			return new PageResult<HotelDetailVO>(hotelDetailVOList);
		}
	}

	// 显示一个房型的全部房价表
	@Override
	public List<PriceNDateVO> findPriceAndSaleDate(int providerRoomId) {
		// 插入数据的条数

		// 把该房型的价钱表拿到手
		List<RoomPrice> roomPriceList = roomPriceMapper.findRoomPriceByAnyDate(
				DateApplication.stringToDate(DateApplication.returnStringDate()),
				DateApplication.changeCalendarFromString(DateApplication.returnStringDate(), 14), providerRoomId);
		List<PriceNDateVO> priceNDateVOList = new ArrayList<PriceNDateVO>();
		for (RoomPrice roomPrice : roomPriceList) {
			PriceNDateVO priceNDateVO = new PriceNDateVO();
			priceNDateVO.setSaleDate(roomPrice.getSaleDate());
			// 根据当前的这个房价数据查出相应的加幅id
			Integer maxIncreaseId = detailIncreaseRuleMapper.returnMaxId(roomPrice.getRoomId(),
					roomPrice.getSaleDate());
			Integer maxStatusId = saleStatusMapper.returnMaxId(roomPrice.getRoomId(), roomPrice.getSaleDate());

			Integer maxPublishRuleId = publishRuleMapper.returnMaxId();

			if (maxStatusId != null) {
				SaleStatus saleStatus = saleStatusMapper.findSaleStatusByid(maxStatusId);
				priceNDateVO.setSaleStatus(saleStatus.getSaleStatus());
			} else {

				if (maxPublishRuleId != null) {

					PublishRule publishRule = publishRuleMapper.selectByPrimaryKey(maxPublishRuleId);
					// 返回一个时间集合
					List<Date> dateList = DateApplication.returnDateList(publishRule.getBeginDate(),
							publishRule.getEndDate());
					// 判断是不是在日期内，执行一次上下架设置，优先级比详细上下架低
					if (dateList.contains(roomPrice.getSaleDate())) {
						priceNDateVO.setSaleStatus(publishRule.getStatus());
					} else
						priceNDateVO.setSaleStatus("下架");

				}
				/*
				 * else{ priceNDateVO.setSaleStatus("下架"); }
				 */
			}

			if (maxIncreaseId != null) { // 有没有加幅要求
				// 读出一个加幅，说明这一条有要加幅的要求
				DetailIncreaseRule detailIncreaseRule = detailIncreaseRuleMapper
						.findDetailIncreaseRuleByid(maxIncreaseId);
				double price = 0;
				if (detailIncreaseRule.getIncreaseType().equals("差价")) {
					price = roomPrice.getSalePrice() + detailIncreaseRule.getIncreaseAmount();
					priceNDateVO.setSalePrice(price);
					priceNDateVO.setStringPriceFromDoubleDifferent(roomPrice.getSalePrice(),
							detailIncreaseRule.getIncreaseAmount());
					System.out.println(priceNDateVO.getShowPrice());
					priceNDateVO.setIncreaseAmount(detailIncreaseRule.getIncreaseAmount());
					priceNDateVO.setIncreaseStatus("加幅");
					priceNDateVO.setIncreaseType("差价加幅");
				} else if (detailIncreaseRule.getIncreaseType().equals("百分比")) {
					// 价钱要变咯
					price = roomPrice.getSalePrice() * (1 + 0.01 * detailIncreaseRule.getIncreaseAmount());
					priceNDateVO.setIncreaseAmount(detailIncreaseRule.getIncreaseAmount());
					priceNDateVO.setIncreaseStatus("加幅");
					priceNDateVO.setIncreaseType("百分比");
					priceNDateVO.setStringPriceFromDoublePercent(roomPrice.getSalePrice(),
							detailIncreaseRule.getIncreaseAmount());
					priceNDateVO.setSalePrice(price);
				} else {
					priceNDateVO.setIncreaseAmount(0);
					priceNDateVO.setIncreaseStatus("无加幅");
					priceNDateVO.setIncreaseType("无");
					priceNDateVO.setStringPriceFromDoubleDifferent(roomPrice.getSalePrice(), 0.0);
					priceNDateVO.setSalePrice(roomPrice.getSalePrice());

				}

			} else {
				priceNDateVO.setIncreaseAmount(0);
				priceNDateVO.setIncreaseStatus("无加幅");
				priceNDateVO.setIncreaseType("无");
				priceNDateVO.setStringPriceFromDoubleDifferent(roomPrice.getSalePrice(), 0.0);
				priceNDateVO.setSalePrice(roomPrice.getSalePrice());
				// priceNDateVO.setRecordNO(i);
			}
			priceNDateVOList.add(priceNDateVO);
		}
		return priceNDateVOList;
	}

	// 传一个参数改价进来返回一个新的列表,改变价钱
	// 通过roomid找到房型，再通过销售日期找到需要改的数据，然后根绝差价或者百分比改变价格数据，再返回页面给变为innerHTML
	@Override
	public List<PriceNDateVO> setNewPrice(SetDetailIncreaseRuleVO setDetailIncreaseRuleVO) {
		List<RoomPrice> roomPriceList = roomPriceMapper.findRoomPriceByRoomId(setDetailIncreaseRuleVO.getRoomID());
		if (setDetailIncreaseRuleVO.getIncreaseType().equals("差价")) {
			for (RoomPrice roomPrice : roomPriceList) {
				if (roomPrice.getSaleDate().toString().equals(setDetailIncreaseRuleVO.getSaleDate().toString())) {
					// 根据日期找到一个价钱然后加价，差价
					double price = roomPrice.getSalePrice() + setDetailIncreaseRuleVO.getIncreaseAmount();
					System.out.println(price);
				}
			}
		} else if (setDetailIncreaseRuleVO.getIncreaseType().equals("百分比")) {
			for (RoomPrice roomPrice : roomPriceList) {
				if (roomPrice.getSaleDate().toString().equals(setDetailIncreaseRuleVO.getSaleDate().toString())) {
					// 根据日期找到一个价钱然后加价,百分比价格,转为string之后用equals比较内容
					double price = roomPrice.getSalePrice()
							* (1 + 0.01 * (setDetailIncreaseRuleVO.getIncreaseAmount()));
					System.out.println(price);
				}
			}
		}
		return null;
	}

	@Override
	public List<Integer> findSaleRuleByUserIdNMarketId() {

		List<SaleRule> saleRuleList = saleRuleMapper.selectListSaleRuleByUserId(UserUtils.getCurrentUser().getId());

		// 查看该id下的saleruleid的平台是多少
		List<Integer> marketIdList = new ArrayList<Integer>();

		for (SaleRule saleRule : saleRuleList) {
			marketIdList.add(saleRule.getMarketId());
		}
		return marketIdList;

	}

	@Override
	public void setDetailIncreaseRule(SetDetailIncreaseRuleVO detailIncreaseRuleVO) {
		/*
		 * 1、先查询有没有详细加幅了 寻找详细加幅 roomid saledate 先查询salerule
		 */

		Integer saleRuleId = saleRuleMapper
				.selectByUserIdAndMarketId(UserUtils.getCurrentUser().getId(), detailIncreaseRuleVO.getMarketID())
				.getId();

		// 如果为空，即是没有详细加幅
		if (null == detailIncreaseRuleMapper.findDetailIncreaseRuleBySaleRuleIdNroomIdNsaleDateNproviderId(
				detailIncreaseRuleVO.getRoomID(), detailIncreaseRuleVO.getSaleDate(), saleRuleId,
				detailIncreaseRuleVO.getProviderID())) {
			// 加入详细加幅
			detailIncreaseRuleService.addDetailIncreaseRule(detailIncreaseRuleVO);
		} else {
			// 2、根据传来的数据创建或者修改详细加幅
			detailIncreaseRuleService.updateDetailIncreaseRule(detailIncreaseRuleVO);
		}

	}

	// created 2016-05-06
	@Override
	public List<PriceNDateVO> findPriceDetailAndSaleStatus(Integer providerRoomId, Integer marketId,
			Integer providerId) {

		// 销售规则Id(saleRule即是平台)
		Integer saleRuleId = saleRuleMapper.selectByuserIdNmarketId(UserUtils.getCurrentUser().getId(), marketId)
				.getId();

		// 返回一个日期集合(两周)
		List<Date> saleDateList = DateApplication.returnDateList(
				DateApplication.stringToDate(DateApplication.returnStringDate()),
				DateApplication.changeCalendarFromString(DateApplication.returnStringDate(), 14));
		List<RoomPrice> RroomPriceBaseDataList = new ArrayList<RoomPrice>();
		for (Date date : saleDateList) {

			RoomPrice roomPrice = roomPriceMapper.findRoomPriceBysaleDateNRoomIdNProviderId(date, providerRoomId,
					providerId);

			// 如果这一天的数据为空，加入一个默认的数据
			// 价格为0
			if (roomPrice == null) {
				RoomPrice newRoomPrice = new RoomPrice();
				newRoomPrice.setBreakfastType(0);
				newRoomPrice.setCreated(new Date());
				newRoomPrice.setProviderId(providerId);
				newRoomPrice.setRoomAmount(0);
				newRoomPrice.setRoomId(providerRoomId);
				newRoomPrice.setSaleDate(date);
				newRoomPrice.setSalePrice(0.0);
				RroomPriceBaseDataList.add(newRoomPrice);
			} else

				RroomPriceBaseDataList.add(roomPrice);
		}

		// 需要返回的数据集合创建（旧）
		List<PriceNDateVO> priceNDateVOList = new ArrayList<PriceNDateVO>();

		for (RoomPrice roomPrice : RroomPriceBaseDataList) {
			PriceNDateVO priceNDateVO = new PriceNDateVO();

			priceNDateVO.setSaleDate(roomPrice.getSaleDate());

			// 查询这一天的详细加幅，如果为null，则按默认操作处理(无详细加幅)
			DetailIncreaseRule detailIncreaseRule = detailIncreaseRuleMapper
					.findDetailIncreaseRuleBySaleRuleIdNroomIdNsaleDateNproviderId(providerRoomId,
							roomPrice.getSaleDate(), saleRuleId, providerId);
			// 查询这一天的详细上下架设置，如果为空，查看发布设置，如果发布设置不在范围内，按默认下架处理
			SaleStatus saleStatus = saleStatusMapper.findSaleStatusByroomIdNproviderIdNsaleDateNsaleRuleId(
					providerRoomId, saleRuleId, providerId, roomPrice.getSaleDate());

			// 发布规则集合
			// 根据不同的时间段发布上下架状态
			List<PublishRule> publishRuleList = publishRuleMapper.selectListBySaleRuleId(saleRuleId);

			// 上下架设置以及显示
			if (saleStatus != null) {
				priceNDateVO.setSaleStatus(saleStatus.getSaleStatus());
			} else {
				if (publishRuleList != null) {

					for (PublishRule publishRule : publishRuleList) {
						// 返回一个时间集合
						List<Date> dateList = DateApplication.returnDateList(publishRule.getBeginDate(),
								publishRule.getEndDate());
						// 判断是不是在日期内，执行一次上下架设置，优先级比详细上下架低
						if (dateList.contains(roomPrice.getSaleDate())) {
							priceNDateVO.setSaleStatus(publishRule.getStatus());
						} else
							priceNDateVO.setSaleStatus("下架");
					}
				}
			}

			// 详细加幅优先级最高，然后到加幅设置，然后再到基本设置
			// 根据销售规则id选出基本设置,一对一
			// BaseRule baseRule =
			// baseRuleMapper.selectBySaleRuleId(saleRuleId);
			// 根据销售规则id选出加幅规则，一对多，一个平台对应多条加幅规则
			// List<IncreaseRule> increaseRuleList =
			// increaseRuleMapper.selectListBySaleRuleId(saleRuleId);

			// 详细加幅设置以及显示
			if (detailIncreaseRule != null) {
				// 有没有加幅要求
				// 读出一个加幅，说明这一条有要加幅的要求
				double price = 0;
				if (detailIncreaseRule.getIncreaseType().equals("差价")) {
					price = roomPrice.getSalePrice() + detailIncreaseRule.getIncreaseAmount();
					priceNDateVO.setSalePrice(price);
					priceNDateVO.setStringPriceFromDoubleDifferent(roomPrice.getSalePrice(),
							detailIncreaseRule.getIncreaseAmount());
					priceNDateVO.setIncreaseAmount(detailIncreaseRule.getIncreaseAmount());
					priceNDateVO.setIncreaseStatus("详细加幅");
					priceNDateVO.setIncreaseType("差价加幅");
				} else if (detailIncreaseRule.getIncreaseType().equals("百分比")) {
					// 最后价格
					price = roomPrice.getSalePrice() * (1 + 0.01 * detailIncreaseRule.getIncreaseAmount());
					priceNDateVO.setIncreaseAmount(detailIncreaseRule.getIncreaseAmount());
					priceNDateVO.setIncreaseStatus("详细加幅");
					priceNDateVO.setIncreaseType("百分比");
					priceNDateVO.setStringPriceFromDoublePercent(roomPrice.getSalePrice(),
							detailIncreaseRule.getIncreaseAmount());
					priceNDateVO.setSalePrice(price);
				}
				/*
				 * else { priceNDateVO.setIncreaseAmount(0);
				 * priceNDateVO.setIncreaseStatus("无详细加幅");
				 * priceNDateVO.setIncreaseType("无");
				 * priceNDateVO.setStringPriceFromDoubleDifferent(roomPrice.
				 * getSalePrice(), 0.0);
				 * priceNDateVO.setSalePrice(roomPrice.getSalePrice()); }
				 */
			} else {
				/*
				 * IncreaseRule roomIncreaseRule = increaseRuleMapper.
				 * selectByScopeTypeNSaleRuleIdNProviderIdNScopeId("房型",
				 * saleRuleId, providerId, roomPrice.getRoomId()); if
				 * (roomIncreaseRule != null) { double price = 0.0; if
				 * (roomIncreaseRule.getIncreaseType().equals("差价")) { price =
				 * roomPrice.getSalePrice() +
				 * roomIncreaseRule.getIncreaseAmount();
				 * priceNDateVO.setSalePrice(price);
				 * priceNDateVO.setStringPriceFromDoubleDifferent(roomPrice.
				 * getSalePrice(), roomIncreaseRule.getIncreaseAmount());
				 * priceNDateVO.setIncreaseAmount(roomIncreaseRule.
				 * getIncreaseAmount()); priceNDateVO.setIncreaseStatus("房型加幅");
				 * priceNDateVO.setIncreaseType("差价加幅"); } else if
				 * (roomIncreaseRule.getIncreaseType().equals("百分比")) { // 最后价格
				 * price = roomPrice.getSalePrice() * (1 + 0.01 *
				 * roomIncreaseRule.getIncreaseAmount());
				 * priceNDateVO.setIncreaseAmount(roomIncreaseRule.
				 * getIncreaseAmount()); priceNDateVO.setIncreaseStatus("房型加幅");
				 * priceNDateVO.setIncreaseType("百分比");
				 * priceNDateVO.setStringPriceFromDoublePercent(roomPrice.
				 * getSalePrice(), roomIncreaseRule.getIncreaseAmount());
				 * priceNDateVO.setSalePrice(price); } }
				 */
				priceNDateVO.setIncreaseAmount(0);
				priceNDateVO.setIncreaseStatus("无详细加幅");
				priceNDateVO.setIncreaseType("无");
				priceNDateVO.setStringPriceFromDoubleDifferent(roomPrice.getSalePrice(), 0.0);
				priceNDateVO.setSalePrice(roomPrice.getSalePrice());
			}
			priceNDateVOList.add(priceNDateVO);
		}
		return priceNDateVOList;

	}

	// 20160509
	// marketId、providerId、roomId、hotelId、cityId in hotelPriceVO
	// baseRule 所有城市所有酒店所有房型都涨价
	// cityIncreaseRule 该城市所有酒店所有房型都涨价
	// hotelIncreaseRule 该酒店所有房型都涨价
	// roomIncreaseRule 这个房型都涨价
	// detailIncreaseRule 这个房型的某一天都涨价
	@Override
	public List<PriceNDateVO> requirePriceDetailAndSaleStatus(HotelPriceVO hotelPriceVO) {

		// 销售规则Id(saleRule即是平台)
		Integer saleRuleId = saleRuleMapper
				.selectByuserIdNmarketId(UserUtils.getCurrentUser().getId(), hotelPriceVO.getMarketId()).getId();

		// 返回一个日期集合(两周)
		List<Date> saleDateList = DateApplication.returnDateList(
				DateApplication.stringToDate(DateApplication.returnStringDate()),
				DateApplication.changeCalendarFromString(DateApplication.returnStringDate(), 14));

		// 价钱集合
		List<RoomPrice> RroomPriceBaseDataList = new ArrayList<RoomPrice>();

		// 根据每一天查询房价对象
		for (Date date : saleDateList) {

			RoomPrice roomPrice = roomPriceMapper.findRoomPriceBysaleDateNRoomIdNProviderId(date,
					hotelPriceVO.getProviderRoomId(), hotelPriceVO.getProviderId());

			// 如果这一天的数据为空，加入一个默认的数据
			// 在页面上面应该怎样显示
			// 价格为0
			if (roomPrice == null) {
				RoomPrice newRoomPrice = new RoomPrice();
				newRoomPrice.setBreakfastType(0);
				newRoomPrice.setCreated(new Date());
				newRoomPrice.setProviderId(hotelPriceVO.getProviderId());
				newRoomPrice.setRoomAmount(0);
				newRoomPrice.setRoomId(hotelPriceVO.getProviderRoomId());
				newRoomPrice.setSaleDate(date);
				newRoomPrice.setSalePrice(0.0);
				RroomPriceBaseDataList.add(newRoomPrice);
			} else

				RroomPriceBaseDataList.add(roomPrice);
		}

		// 需要返回的数据集合创建
		List<PriceNDateVO> priceNDateVOList = new ArrayList<PriceNDateVO>();

		// 遍历价格数据
		for (RoomPrice roomPrice : RroomPriceBaseDataList) {
			PriceNDateVO priceNDateVO = new PriceNDateVO();

			priceNDateVO.setSaleDate(roomPrice.getSaleDate());

			// 查询这一天的详细上下架设置，如果为空，查看发布设置，如果发布设置不在范围内，按默认下架处理
			SaleStatus saleStatus = saleStatusMapper.findSaleStatusByroomIdNproviderIdNsaleDateNsaleRuleId(
					hotelPriceVO.getProviderRoomId(), saleRuleId, hotelPriceVO.getProviderId(),
					roomPrice.getSaleDate());

			// 发布规则集合
			// 根据不同的时间段发布上下架状态
			List<PublishRule> publishRuleList = publishRuleMapper.selectListBySaleRuleId(saleRuleId);

			// 上下架设置以及显示
			if (saleStatus != null) {
				priceNDateVO.setSaleStatus(saleStatus.getSaleStatus());
			} else {
				if (publishRuleList != null) {
					for (PublishRule publishRule : publishRuleList) {
						// 返回一个时间集合
						List<Date> dateList = DateApplication.returnDateList(publishRule.getBeginDate(),
								publishRule.getEndDate());
						// 判断是不是在日期内，执行一次上下架设置，优先级比详细上下架低
						if (dateList.contains(roomPrice.getSaleDate())) {
							priceNDateVO.setSaleStatus(publishRule.getStatus());
						} else
							priceNDateVO.setSaleStatus("下架");
					}
				}
			}

			/** 详细加幅优先级最高，然后到加幅设置，然后再到基本设置 */

			// 查询这一天的详细加幅，如果为null，则按默认操作处理(无详细加幅)
			DetailIncreaseRule detailIncreaseRule = detailIncreaseRuleMapper
					.findDetailIncreaseRuleBySaleRuleIdNroomIdNsaleDateNproviderId(hotelPriceVO.getProviderRoomId(),
							roomPrice.getSaleDate(), saleRuleId, hotelPriceVO.getProviderId());

			// 最大判断，判断价格是否为0
			if (roomPrice.getSalePrice() != 0.0) {
				// 详细加幅设置以及显示
				if (detailIncreaseRule != null) {
					// 有没有加幅要求
					// 读出一个加幅，说明这一条有要加幅的要求
					double price = 0;
					if (detailIncreaseRule.getIncreaseType().equals("差价")) {
						price = roomPrice.getSalePrice() + detailIncreaseRule.getIncreaseAmount();
						priceNDateVO.setSalePrice(price);
						priceNDateVO.setStringPriceFromDoubleDifferent(roomPrice.getSalePrice(),
								detailIncreaseRule.getIncreaseAmount());
						priceNDateVO.setIncreaseAmount(detailIncreaseRule.getIncreaseAmount());
						priceNDateVO.setIncreaseStatus("详细加幅");
						priceNDateVO.setIncreaseType("差价加幅");
					} else if (detailIncreaseRule.getIncreaseType().equals("百分比")) {
						// 最后价格
						// 百分比加幅时，保留一位小数
						price = new BigDecimal(
								roomPrice.getSalePrice() * (1 + 0.01 * detailIncreaseRule.getIncreaseAmount()))
										.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
						priceNDateVO.setIncreaseAmount(detailIncreaseRule.getIncreaseAmount());
						priceNDateVO.setIncreaseStatus("详细加幅");
						priceNDateVO.setIncreaseType("百分比");
						priceNDateVO.setStringPriceFromDoublePercent(roomPrice.getSalePrice(),
								detailIncreaseRule.getIncreaseAmount());
						priceNDateVO.setSalePrice(price);
					}
				}

				/** 当这一天的详细加幅为空，先判断加幅规则 */

				else {

					// 查这天有无有加幅
					IncreaseRule roomIncreaseRule = increaseRuleMapper.selectByScopeTypeNSaleRuleIdNProviderIdNScopeId(
							"房型", saleRuleId, hotelPriceVO.getProviderId(), hotelPriceVO.getProviderRoomId());
					IncreaseRule hotelIncreaseRule = increaseRuleMapper.selectByScopeTypeNSaleRuleIdNProviderIdNScopeId(
							"酒店", saleRuleId, hotelPriceVO.getProviderId(), hotelPriceVO.getHotelId());
					IncreaseRule cityIncreaseRule = increaseRuleMapper.selectByScopeTypeNSaleRuleIdNProviderIdNScopeId(
							"城市", saleRuleId, hotelPriceVO.getProviderId(), hotelPriceVO.getCityId());
					// 根据销售规则id选出基本设置,一对一
					BaseRule baseRule = baseRuleMapper.selectBySaleRuleId(saleRuleId);
					if (roomIncreaseRule != null) {
						double price = 0;
						if (roomIncreaseRule.getIncreaseType().equals("差价")) {
							price = roomPrice.getSalePrice() + roomIncreaseRule.getIncreaseAmount();
							priceNDateVO.setSalePrice(price);
							priceNDateVO.setStringPriceFromDoubleDifferent(roomPrice.getSalePrice(),
									roomIncreaseRule.getIncreaseAmount());
							priceNDateVO.setIncreaseAmount(roomIncreaseRule.getIncreaseAmount());
							priceNDateVO.setIncreaseStatus("房型加幅");
							priceNDateVO.setIncreaseType("差价加幅");
						} else if (roomIncreaseRule.getIncreaseType().equals("百分比")) {
							// 最后价格
							price = new BigDecimal(
									roomPrice.getSalePrice() * (1 + 0.01 * roomIncreaseRule.getIncreaseAmount()))
											.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							priceNDateVO.setIncreaseAmount(roomIncreaseRule.getIncreaseAmount());
							priceNDateVO.setIncreaseStatus("房型加幅");
							priceNDateVO.setIncreaseType("百分比");
							priceNDateVO.setStringPriceFromDoublePercent(roomPrice.getSalePrice(),
									roomIncreaseRule.getIncreaseAmount());
							priceNDateVO.setSalePrice(price);
						}
					} else if (roomIncreaseRule == null && hotelIncreaseRule != null) {
						double price = 0;
						if (hotelIncreaseRule.getIncreaseType().equals("差价")) {
							price = roomPrice.getSalePrice() + hotelIncreaseRule.getIncreaseAmount();
							priceNDateVO.setSalePrice(price);
							priceNDateVO.setStringPriceFromDoubleDifferent(roomPrice.getSalePrice(),
									hotelIncreaseRule.getIncreaseAmount());
							priceNDateVO.setIncreaseAmount(hotelIncreaseRule.getIncreaseAmount());
							priceNDateVO.setIncreaseStatus("酒店加幅");
							priceNDateVO.setIncreaseType("差价加幅");
						} else if (hotelIncreaseRule.getIncreaseType().equals("百分比")) {
							// 最后价格
							price = new BigDecimal(
									roomPrice.getSalePrice() * (1 + 0.01 * hotelIncreaseRule.getIncreaseAmount()))
											.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

							priceNDateVO.setIncreaseAmount(hotelIncreaseRule.getIncreaseAmount());
							priceNDateVO.setIncreaseStatus("酒店加幅");
							priceNDateVO.setIncreaseType("百分比");
							priceNDateVO.setStringPriceFromDoublePercent(roomPrice.getSalePrice(),
									hotelIncreaseRule.getIncreaseAmount());
							priceNDateVO.setSalePrice(price);
						}

					} else if (roomIncreaseRule == null && hotelIncreaseRule == null && cityIncreaseRule != null) {

						double price = 0;
						if (cityIncreaseRule.getIncreaseType().equals("差价")) {
							price = roomPrice.getSalePrice() + cityIncreaseRule.getIncreaseAmount();

							priceNDateVO.setSalePrice(price);
							priceNDateVO.setStringPriceFromDoubleDifferent(roomPrice.getSalePrice(),
									cityIncreaseRule.getIncreaseAmount());
							priceNDateVO.setIncreaseAmount(cityIncreaseRule.getIncreaseAmount());
							priceNDateVO.setIncreaseStatus("城市加幅");
							priceNDateVO.setIncreaseType("差价加幅");
						} else if (cityIncreaseRule.getIncreaseType().equals("百分比")) {
							// 最后价格
							price = new BigDecimal(
									roomPrice.getSalePrice() * (1 + 0.01 * cityIncreaseRule.getIncreaseAmount()))
											.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
							priceNDateVO.setIncreaseAmount(cityIncreaseRule.getIncreaseAmount());
							priceNDateVO.setIncreaseStatus("城市加幅");
							priceNDateVO.setIncreaseType("百分比");
							priceNDateVO.setStringPriceFromDoublePercent(roomPrice.getSalePrice(),
									cityIncreaseRule.getIncreaseAmount());
							priceNDateVO.setSalePrice(price);
						}
					} else if (roomIncreaseRule == null && hotelIncreaseRule == null && cityIncreaseRule == null
							&& baseRule != null) {

						double price = 0;
						if (baseRule.getIncreaseType().equals("差价")) {
							price = roomPrice.getSalePrice() + baseRule.getIncreaseAmount();
							priceNDateVO.setSalePrice(price);
							priceNDateVO.setStringPriceFromDoubleDifferent(roomPrice.getSalePrice(),
									baseRule.getIncreaseAmount());
							priceNDateVO.setIncreaseAmount(baseRule.getIncreaseAmount());
							priceNDateVO.setIncreaseStatus("基本加幅");
							priceNDateVO.setIncreaseType("差价加幅");
						} else if (baseRule.getIncreaseType().equals("百分比")) {
							// 最后价格
							price = new BigDecimal(roomPrice.getSalePrice() * (1 + 0.01 * baseRule.getIncreaseAmount()))
									.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
							priceNDateVO.setIncreaseAmount(baseRule.getIncreaseAmount());
							priceNDateVO.setIncreaseStatus("基本加幅");
							priceNDateVO.setIncreaseType("百分比");
							priceNDateVO.setStringPriceFromDoublePercent(roomPrice.getSalePrice(),
									baseRule.getIncreaseAmount());
							priceNDateVO.setSalePrice(price);
						}

					} else {

						priceNDateVO.setIncreaseAmount(0);
						priceNDateVO.setIncreaseStatus("无加幅");
						priceNDateVO.setIncreaseType("无");
						priceNDateVO.setStringPriceFromDoubleDifferent(roomPrice.getSalePrice(), 0.0);
						priceNDateVO.setSalePrice(roomPrice.getSalePrice());
					}
				}
			} else {
				priceNDateVO.setIncreaseAmount(0);
				priceNDateVO.setIncreaseStatus("无加幅");
				priceNDateVO.setIncreaseType("无");
				priceNDateVO.setStringPriceFromDoubleDifferent(roomPrice.getSalePrice(), 0.0);
				priceNDateVO.setSalePrice(roomPrice.getSalePrice());
			}
			priceNDateVOList.add(priceNDateVO);
		}
		return priceNDateVOList;
	}

}
