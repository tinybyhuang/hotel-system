 package com.distinct.hotel.grap.vo;

public class Sort {
	
	private int dir = 1;
	
	private int idx;
	
	private int ordby;
	
	private int size = 15;
	

	public Sort() {
		super();
	}
	
	public Sort(int idx) {
		super();
		this.idx = idx;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getOrdby() {
		return ordby;
	}

	public void setOrdby(int ordby) {
		this.ordby = ordby;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
