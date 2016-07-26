package com.distinct.hotel.sale.model;

import java.util.Date;

public class SaleRule {
    private Integer id;

    private Integer userId;

    private Integer marketId;

    private String status;
    
   

    private Date created;

    private Date modified;

    private Integer modUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMarketId() {
        return marketId;
    }

    public void setMarketId(Integer marketId) {
        this.marketId = marketId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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