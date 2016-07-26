package com.distinct.hotel.grap.vo;

public class Head {
	
	private String cid;
	
	private String auth;
	
	private String ctok = "";
	
	private String cver = "1.0";
	
	private String lang = "01";
			
	private String sid = "8888";
	
	private String syscode = "09";
	
	public Head() {
		super();
	}

	public Head(String cid) {
		super();
		this.cid = cid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getCtok() {
		return ctok;
	}

	public void setCtok(String ctok) {
		this.ctok = ctok;
	}

	public String getCver() {
		return cver;
	}

	public void setCver(String cver) {
		this.cver = cver;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSyscode() {
		return syscode;
	}

	public void setSyscode(String syscode) {
		this.syscode = syscode;
	}
	
	

}
