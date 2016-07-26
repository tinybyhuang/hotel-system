package com.distinct.hotel.product.vo;

public class HotelPriceVO {

	private Integer hotelId;

	private Integer providerRoomId;

	private Integer marketId;

	private Integer cityId;

	private Integer providerId;

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getProviderRoomId() {
		return providerRoomId;
	}

	public void setProviderRoomId(Integer providerRoomId) {
		this.providerRoomId = providerRoomId;
	}

	public Integer getMarketId() {
		return marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public static HotelPriceVO saleStatusVOToHotelPriceVO(SetSaleStatusVO saleStatusVO) {
		HotelPriceVO hotelPriceVO = new HotelPriceVO();
		hotelPriceVO.setCityId(saleStatusVO.getCityId());
		hotelPriceVO.setHotelId(saleStatusVO.getHotelId());
		hotelPriceVO.setMarketId(saleStatusVO.getMarketID());
		hotelPriceVO.setProviderId(saleStatusVO.getProviderID());
		hotelPriceVO.setProviderRoomId(saleStatusVO.getRoomID());
		return hotelPriceVO;
	}

	public static HotelPriceVO detailIncreaseRuleVOToHotelPriceVO(SetDetailIncreaseRuleVO detailIncreaseRuleVO) {
		// 填充hotelPriceVO
		HotelPriceVO hotelPriceVO = new HotelPriceVO();
		hotelPriceVO.setCityId(detailIncreaseRuleVO.getCityId());
		hotelPriceVO.setHotelId(detailIncreaseRuleVO.getHotelId());
		hotelPriceVO.setMarketId(detailIncreaseRuleVO.getMarketID());
		hotelPriceVO.setProviderId(detailIncreaseRuleVO.getProviderID());
		hotelPriceVO.setProviderRoomId(detailIncreaseRuleVO.getRoomID());
		return hotelPriceVO;
	}

}
