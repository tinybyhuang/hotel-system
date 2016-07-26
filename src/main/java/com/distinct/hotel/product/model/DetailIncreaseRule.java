package com.distinct.hotel.product.model;

import java.util.Date;

public class DetailIncreaseRule {
    private Integer id;

    private Integer saleRuleId;

    private Integer providerId;

    private Integer roomId;

    private Date increaseDate;

    private String increaseType;

    private Double increaseAmount;

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

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Date getIncreaseDate() {
        return increaseDate;
    }

    public void setIncreaseDate(Date increaseDate) {
        this.increaseDate = increaseDate;
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