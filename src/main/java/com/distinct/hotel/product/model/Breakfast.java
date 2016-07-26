package com.distinct.hotel.product.model;

import java.util.Date;

public class Breakfast {
    private Integer id;

    private String breakfastName;

    private String remark;

    private Date created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBreakfastName() {
        return breakfastName;
    }

    public void setBreakfastName(String breakfastName) {
        this.breakfastName = breakfastName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}