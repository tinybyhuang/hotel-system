package com.distinct.hotel.grap.vo;

public class SetInfo {
	
	private int cityId = 0;
	
	private int dstId = 0;
	
	private String inDay;
	
	private String outDay;
	
	private String membertype = "";

	public SetInfo() {
		super();
	}
	public SetInfo(int cityId, String inDay, String outDay) {
		super();
		this.cityId = cityId;
		this.inDay = inDay;
		this.outDay = outDay;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getDstId() {
		return dstId;
	}

	public void setDstId(int dstId) {
		this.dstId = dstId;
	}

	public String getInDay() {
		return inDay;
	}

	public void setInDay(String inDay) {
		this.inDay = inDay;
	}

	public String getOutDay() {
		return outDay;
	}

	public void setOutDay(String outDay) {
		this.outDay = outDay;
	}
	public String getMembertype() {
		return membertype;
	}
	public void setMembertype(String membertype) {
		this.membertype = membertype;
	}
	
	
}
