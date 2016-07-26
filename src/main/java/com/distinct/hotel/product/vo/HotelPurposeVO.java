package com.distinct.hotel.product.vo;

//条件查询的VO对象
public class HotelPurposeVO {

	private Integer city; // 防止输入的数据为null，而出现判断错误

	private String hotelName;

	private String star; // 1到5星级

	private Integer marketId; // 平台的值 1、2、3

	private Integer providerId; // 供应商的值 1、2

	//private Integer userId; // 当前使用者id

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public Integer getMarketId() {
		return marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	/*public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}*/

}
