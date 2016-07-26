package com.distinct.hotel.service.provider.vo;

public class BookingOrder extends BaseOrder {
	
	private String hotelId; //供应商酒店Id
	
	private String roomId; //供应商房型Id
	
	private String bookUser; //预约人，多人用 |  隔开
	
	private String bookAmount; //预约人数
	
	private String bookPhone; //预约电话
	
	private String beginDate; //入店时间
	 
	private String endDate; //离店时间
	
	private String days; //入住天数
	
	private String amount; //供应商订单金额，需要根据当前房价 * 预约房价数 + 下一日 + 下一日
	
	private String remark; //客户备注

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

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	

}
