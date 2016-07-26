package com.distinct.hotel.grap.vo;

public class RoomJson {
	
	private boolean anony = true;
	
	private String contentType = "json";
	
	private int contrl = 8;
	
	private String fc = "M=jED0MDkk4NDEI=";
	
	private int flag = 512;
	
	private Head head;
	
	private int id;
	
	private String inDay;
	
	private String outDay;
	
	private String membertype = "";
	
	private int num = 1;
	
	private int pay = 0;
	
	private int sf = 2;
	
	private int ver = 0;
	
	public RoomJson(Head head, int id, String inDay, String outDay) {
		super();
		this.head = head;
		this.id = id;
		this.inDay = inDay;
		this.outDay = outDay;
	}

	public RoomJson() {
		super();
	}

	public boolean isAnony() {
		return anony;
	}

	public void setAnony(boolean anony) {
		this.anony = anony;
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

	public String getFc() {
		return fc;
	}

	public void setFc(String fc) {
		this.fc = fc;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getSf() {
		return sf;
	}

	public void setSf(int sf) {
		this.sf = sf;
	}

	public int getVer() {
		return ver;
	}

	public void setVer(int ver) {
		this.ver = ver;
	}
	
	

}
