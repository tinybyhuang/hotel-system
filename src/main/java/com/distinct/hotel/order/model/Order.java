package com.distinct.hotel.order.model;

import java.util.Date;

public class Order {
    private Integer id;

    private Integer marketId;

    private String marketOrderNo;

    private Integer providerId;

    private String providerOrderNo;

    private String hotelId;

    private String hotelName;

    private String roomId;

    private String roomName;

    private String bookUser;

    private Integer bookAmout;

    private String bookPhone;

    private Date beginDate;

    private Date endDate;

    private Integer days;

    private Float marketAmount;

    private Float providerAmount;

    private String marketStatus;

    private String providerStatus;

    private Date created;

    private String state;
    
    private int userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMarketId() {
        return marketId;
    }

    public void setMarketId(Integer marketId) {
        this.marketId = marketId;
    }

    public String getMarketOrderNo() {
        return marketOrderNo;
    }

    public void setMarketOrderNo(String marketOrderNo) {
        this.marketOrderNo = marketOrderNo;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getProviderOrderNo() {
        return providerOrderNo;
    }

    public void setProviderOrderNo(String providerOrderNo) {
        this.providerOrderNo = providerOrderNo;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getBookUser() {
        return bookUser;
    }

    public void setBookUser(String bookUser) {
        this.bookUser = bookUser;
    }

    public Integer getBookAmout() {
        return bookAmout;
    }

    public void setBookAmout(Integer bookAmout) {
        this.bookAmout = bookAmout;
    }

    public String getBookPhone() {
        return bookPhone;
    }

    public void setBookPhone(String bookPhone) {
        this.bookPhone = bookPhone;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Float getMarketAmount() {
        return marketAmount;
    }

    public void setMarketAmount(Float marketAmount) {
        this.marketAmount = marketAmount;
    }

    public Float getProviderAmount() {
        return providerAmount;
    }

    public void setProviderAmount(Float providerAmount) {
        this.providerAmount = providerAmount;
    }

    public String getMarketStatus() {
        return marketStatus;
    }

    public void setMarketStatus(String marketStatus) {
        this.marketStatus = marketStatus;
    }

    public String getProviderStatus() {
        return providerStatus;
    }

    public void setProviderStatus(String providerStatus) {
        this.providerStatus = providerStatus;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
    
}