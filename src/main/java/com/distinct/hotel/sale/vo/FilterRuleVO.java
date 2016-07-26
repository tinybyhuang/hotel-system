package com.distinct.hotel.sale.vo;

import java.util.Date;

public class FilterRuleVO {
	  private Integer id;
private Integer filterRuleId;
	    private Integer saleRuleId;

	    private Integer cityId;
	    
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

		public Integer getFilterRuleId() {
			return filterRuleId;
		}

		public void setFilterRuleId(Integer filterRuleId) {
			this.filterRuleId = filterRuleId;
		}

		public Integer getCityId() {
			return cityId;
		}

		public void setCityId(Integer cityId) {
			this.cityId = cityId;
		}

}
