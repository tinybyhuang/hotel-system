package com.distinct.hotel.sale.model;

import java.util.Date;

public class BaseRule {
    private Integer id;

    private Integer saleRuleId;

    private String increaseType;

    private Double increaseAmount;

    private Integer lowerPrice;

    private Integer safePrice;

    private Integer roomDetain;

    private Date presentSale;

    private String hotelInstruction;

    private String roomInstruction;

    private Date created;

    private Date modified;

    private Integer modUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaleRuleId() {
        return saleRuleId;
    }

    public void setSaleRuleId(Integer saleRuleId) {
        this.saleRuleId = saleRuleId;
    }

    public String getIncreaseType() {
        return increaseType;
    }

    public void setIncreaseType(String increaseType) {
        this.increaseType = increaseType;
    }

    public Double getIncreaseAmount() {
        return increaseAmount;
    }

    public void setIncreaseAmount(Double increaseAmount) {
        this.increaseAmount = increaseAmount;
    }

    public Integer getLowerPrice() {
        return lowerPrice;
    }

    public void setLowerPrice(Integer lowerPrice) {
        this.lowerPrice = lowerPrice;
    }

    public Integer getSafePrice() {
        return safePrice;
    }

    public void setSafePrice(Integer safePrice) {
        this.safePrice = safePrice;
    }

    public Integer getRoomDetain() {
        return roomDetain;
    }

    public void setRoomDetain(Integer roomDetain) {
        this.roomDetain = roomDetain;
    }

    public Date getPresentSale() {
        return presentSale;
    }

    public void setPresentSale(Date presentSale) {
        this.presentSale = presentSale;
    }

    public String getHotelInstruction() {
        return hotelInstruction;
    }

    public void setHotelInstruction(String hotelInstruction) {
        this.hotelInstruction = hotelInstruction;
    }

    public String getRoomInstruction() {
        return roomInstruction;
    }

    public void setRoomInstruction(String roomInstruction) {
        this.roomInstruction = roomInstruction;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Integer getModUserId() {
        return modUserId;
    }

    public void setModUserId(Integer modUserId) {
        this.modUserId = modUserId;
    }
}