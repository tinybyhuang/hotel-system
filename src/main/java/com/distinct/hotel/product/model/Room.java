package com.distinct.hotel.product.model;

import java.util.Date;

public class Room {
    private Integer id;

    private Integer providerId;

    private Integer providerRoomId;

    private Integer hotelId;

    private String roomName;

    private Integer roomBedType;

    private String roomFloor;

    private String roomWindow;

    private String roomWifi;

    private String roomWash;

    private Date created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getProviderRoomId() {
        return providerRoomId;
    }

    public void setProviderRoomId(Integer providerRoomId) {
        this.providerRoomId = providerRoomId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getRoomBedType() {
        return roomBedType;
    }

    public void setRoomBedType(Integer roomBedType) {
        this.roomBedType = roomBedType;
    }

    public String getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(String roomFloor) {
        this.roomFloor = roomFloor;
    }

    public String getRoomWindow() {
        return roomWindow;
    }

    public void setRoomWindow(String roomWindow) {
        this.roomWindow = roomWindow;
    }

    public String getRoomWifi() {
        return roomWifi;
    }

    public void setRoomWifi(String roomWifi) {
        this.roomWifi = roomWifi;
    }

    public String getRoomWash() {
        return roomWash;
    }

    public void setRoomWash(String roomWash) {
        this.roomWash = roomWash;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}