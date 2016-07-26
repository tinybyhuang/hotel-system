package com.distinct.hotel.grap.vo;

public class HotelListJson {
	
	private Head head;
	
	private SetInfo setInfo;
	
	private Sort sort;
	
	private int biz = 1;
	
	private String contentType = "json";
	
	private int contrl = 3;
	
	private int facility = 0;
	
	private String key = "";
	
	private int keytp = 0;
	
	private int pay = 0;
	
	private int qbitmap = 0;
	

	public HotelListJson(Head head, SetInfo setInfo, Sort sort) {
		super();
		this.head = head;
		this.setInfo = setInfo;
		this.sort = sort;
	}

	public HotelListJson() {
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

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public int getBiz() {
		return biz;
	}

	public void setBiz(int biz) {
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

	public int getFacility() {
		return facility;
	}

	public void setFacility(int facility) {
		this.facility = facility;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getKeytp() {
		return keytp;
	}

	public void setKeytp(int keytp) {
		this.keytp = keytp;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getQbitmap() {
		return qbitmap;
	}

	public void setQbitmap(int qbitmap) {
		this.qbitmap = qbitmap;
	}
	
	
}
