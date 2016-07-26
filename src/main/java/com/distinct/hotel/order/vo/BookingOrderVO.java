package com.distinct.hotel.order.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookingOrderVO {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/*
	 * private String username; // 用户名
	 * 
	 * private String password;
	 */

	// 用户密码

	/*
	 * private String action; // 当前操作 bookingOrder
	 */

	// 数据库订单id
	private Integer orderId;

	private Integer providerId; // 订单的供应商id

	private String hotelId; // 供应商酒店Id

	private String roomId; // 供应商房型Id

	private String bookUser; // 预约人，多人用 | 隔开

	private String bookAmount; // 预约人数

	private String bookPhone; // 预约电话

	private String beginDate; // 入店时间

	private String endDate; // 离店时间

	private String days; // 入住天数

	// private String amount; // 供应商订单金额，需要根据当前房价 * 预约房价数 + 下一日 + 下一日

	private String remark; // 客户备注

	// private String state;

	public Integer getProviderId() {
		return providerId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getBookUser() {
		return bookUser;
	}

	public void setBookUser(String bookUser) {
		this.bookUser = bookUser;
	}

	public String getBookAmount() {
		return bookAmount;
	}

	public void setBookAmount(String bookAmount) {
		this.bookAmount = bookAmount;
	}

	public String getBookPhone() {
		return bookPhone;
	}

	public void setBookPhone(String bookPhone) {
		this.bookPhone = bookPhone;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {

		String date = sdf.format(beginDate);

		this.beginDate = date;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {

		String date = sdf.format(endDate);

		this.endDate = date;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String state) {
		this.remark = state;
	}

}
