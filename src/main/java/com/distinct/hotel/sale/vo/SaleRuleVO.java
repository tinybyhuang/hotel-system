package com.distinct.hotel.sale.vo;

import java.util.Date;

import com.distinct.hotel.common.UserUtils;

public class SaleRuleVO {
	
private Integer Id;
	    private Integer userId;

	    private Integer marketId;

	    private String status;

	    private Date created;

	    private Date modified;
       
	    private Integer modUserId;
	    Date now =new Date();
	    private String marketName;
		

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
			this.modUserId = UserUtils.getCurrentUser().getId();
		}

		public Integer getId() {
			return Id;
		}

		public void setId(Integer id) {
			Id = id;
		}

		

		public String getMarketName() {
			return marketName;
		}

		public void setMarketName(String marketName) {
			this.marketName = marketName;
		}
	
}
