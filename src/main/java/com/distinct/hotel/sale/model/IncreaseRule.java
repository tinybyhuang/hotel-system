package com.distinct.hotel.sale.model;

import java.util.Date;

public class IncreaseRule {
	private Integer id;

	private Integer saleRuleId;

	private String scopeType;

	private Integer scopeId;

	private Integer providerId;

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

	public String getScopeType() {
		return scopeType;
	}

	public void setScopeType(String scopeType) {
		this.scopeType = scopeType;
	}

	public Integer getScopeId() {
		return scopeId;
	}

	public void setScopeId(Integer scopeId) {
		this.scopeId = scopeId;
	}

	public Integer getProviderId() {
		return providerId;

	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;

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