package com.distinct.hotel.product.model;

import java.util.Date;

public class Hotel {
    private Integer id;

    private Integer providerId;

    private Integer providerHotelId;

    private Integer cityId;

    private String hotelName;

    private String hotelPhone;

    private String hotelAddress;

    private String hotelWebsite;

    private String hotelLongitude;

    private String hotelLatitude;

    private String hotelStar;

    private Date created;

    private String hotelIntroduction;

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

    public Integer getProviderHotelId() {
        return providerHotelId;
    }

    public void setProviderHotelId(Integer providerHotelId) {
        this.providerHotelId = providerHotelId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelWebsite() {
        return hotelWebsite;
    }

    public void setHotelWebsite(String hotelWebsite) {
        this.hotelWebsite = hotelWebsite;
    }

    public String getHotelLongitude() {
        return hotelLongitude;
    }

    public void setHotelLongitude(String hotelLongitude) {
        this.hotelLongitude = hotelLongitude;
    }

    public String getHotelLatitude() {
        return hotelLatitude;
    }

    public void setHotelLatitude(String hotelLatitude) {
        this.hotelLatitude = hotelLatitude;
    }

    public String getHotelStar() {
        return hotelStar;
    }

    public void setHotelStar(String hotelStar) {
        this.hotelStar = hotelStar;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getHotelIntroduction() {
        return hotelIntroduction;
    }

    public void setHotelIntroduction(String hotelIntroduction) {
        this.hotelIntroduction = hotelIntroduction;
    }
}