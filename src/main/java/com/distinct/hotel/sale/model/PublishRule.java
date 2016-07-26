package com.distinct.hotel.sale.model;

import java.util.Date;

public class PublishRule {
    private Integer id;

    private Integer saleRuleId;

    private Date beginDate;

    private Date endDate;

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

    public Integer getSaleRuleId() {
        return saleRuleId;
    }

    public void setSaleRuleId(Integer saleRuleId) {
        this.saleRuleId = saleRuleId;
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