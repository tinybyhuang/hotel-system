package com.distinct.hotel.service.provider.vo;

public class BookingOrderResult extends BaseOrderResult{
	
	private String orderNo; //供应商订单号
	
	private String status; //供应商订单状态
	
	private String hotelId; //酒店Id
	
	private String roomId; //房型Id

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	
	

}
