package com.distinct.hotel.order.model;

import java.util.Date;

public class UserConfig {
    private Integer id;

    private Integer configType;

    private Integer configId;

    private String userNo;

    private String userPwd;

    private Date created;

    private Date modified;

    private Integer modUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConfigType() {
        return configType;
    }

    public void setConfigType(Integer configType) {
        this.configType = configType;
    }

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
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