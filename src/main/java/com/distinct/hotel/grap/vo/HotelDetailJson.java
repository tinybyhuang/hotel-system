package com.distinct.hotel.grap.vo;

public class HotelDetailJson {
	
	private Head head;
	
	private SetInfo setInfo;
	
	private String biz = "1";
	
	private String contentType = "json";
	
	private int contrl = 2;
	
	private int icldrid = 0;
	
	private int id;
	
	private boolean needRoom = false;
	
	private int num = 1;
	
	private int pay = 0;
	
	private int priceBiz = 0;
	
	private int sourBiz = 0;
	
	public HotelDetailJson(Head head, SetInfo setInfo, int id) {
		super();
		this.head = head;
		this.setInfo = setInfo;
		this.id = id;
	}

	public HotelDetailJson() {
		super();
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public SetInfo getSetInfo() {
		return setInfo;
	}

	public void setSetInfo(SetInfo setInfo) {
		this.setInfo = setInfo;
	}

	public String getBiz() {
		return biz;
	}

	public void setBiz(String biz) {
		this.biz = biz;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public int getContrl() {
		return contrl;
	}

	public void setContrl(int contrl) {
		this.contrl = contrl;
	}

	public int getIcldrid() {
		return icldrid;
	}

	public void setIcldrid(int icldrid) {
		this.icldrid = icldrid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isNeedRoom() {
		return needRoom;
	}

	public void setNeedRoom(boolean needRoom) {
		this.needRoom = needRoom;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getPriceBiz() {
		return priceBiz;
	}

	public void setPriceBiz(int priceBiz) {
		this.priceBiz = priceBiz;
	}

	public int getSourBiz() {
		return sourBiz;
	}

	public void setSourBiz(int sourBiz) {
		this.sourBiz = sourBiz;
	}
	
	

}
