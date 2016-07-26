package com.distinct.hotel.sale.vo;

import java.util.Date;

public class HotelRemarkVO {
	 private Integer id;

	    private Integer saleRuleId;

	    private Integer providerId;

	    private Integer hotelId;

	    private String remark;

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

		public Integer getHotelId() {
			return hotelId;
		}

		public void setHotelId(Integer hotelId) {
			this.hotelId = hotelId;
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
}
