package com.distinct.hotel.product.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Administrator
 *
 *         按时间段上下架获取数据VO
 */
public class SetSaleStatusVO {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private String status;

	private Date startTime; // 开始时间

	private Date endTime; // 下架时间

	private Integer roomID; // 房型id

	private Integer marketID; // 平台id

	private Integer providerID; // 供应商id

	private Integer cityId;

	private Integer hotelId;

	private Date saleDate; // 销售日期，精细到时分秒

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {

		Date date = null;

		if (StringUtils.isNotBlank(startTime)) {

			try {
				date = sdf.parse(startTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

		this.startTime = date;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		Date date = null;
		if (StringUtils.isNotBlank(endTime)) {

			try {
				date = sdf.parse(endTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		this.endTime = date;
	}

	public Integer getRoomID() {
		return roomID;
	}

	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}

	public Integer getMarketID() {
		return marketID;
	}

	public void setMarketID(Integer marketID) {
		this.marketID = marketID;
	}

	public Integer getProviderID() {
		return providerID;
	}

	public void setProviderID(Integer providerID) {
		this.providerID = providerID;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	
	
	
}
