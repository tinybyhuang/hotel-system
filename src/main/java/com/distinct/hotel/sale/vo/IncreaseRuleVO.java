package com.distinct.hotel.sale.vo;


public class IncreaseRuleVO {
	 private Integer id;

	 private Integer increaseId;
	    public Integer getIncreaseId() {
		return increaseId;
	}

	public void setIncreaseId(Integer increaseId) {
		this.increaseId = increaseId;
	}

		private Integer saleRuleId;

	    private String scopeType;

	    private Integer scopeId;

	    private Integer providerId;

	    private String increaseType;

	    private Double increaseAmount;

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

	
}
