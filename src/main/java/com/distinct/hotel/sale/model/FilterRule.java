package com.distinct.hotel.sale.model;

import java.util.Date;

public class FilterRule {
    private Integer id;

    private Integer saleRuleId;

    private Integer providerId;

    private String filterType;

    private Integer filterId;

    private Date created;

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

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public Integer getFilterId() {
        return filterId;
    }

    public void setFilterId(Integer filterId) {
        this.filterId = filterId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}