package com.distinct.hotel.user.model;

import java.beans.Transient;
import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private String pwd;

    private String phone;

    private String company;

    private String remark;

    private Date created;

    private Date modified;

    private Integer modUserId;

    private Date lastLoginDate;

    private String lastLoginIp;

    private String code;
    @Transient  
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }
}