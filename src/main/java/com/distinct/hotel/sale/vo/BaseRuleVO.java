package com.distinct.hotel.sale.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class BaseRuleVO {
	
	private static final SimpleDateFormat sd = new SimpleDateFormat("HH:mm");
	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    private Integer baseId;
	private Integer saleRuleId;
	
	private Integer safePrice;
	
	private Integer lowerPrice;
	
	private Integer roomDetain;
	
	private String presentSale;
	
	private double increaseAmount;
	
	private String increaseType;
	
	private String hotelInstruction;
	
	private String roomInstruction;

	

	public int getSafePrice() {
		return safePrice;
	}

	public int getSaleRuleId() {
		return saleRuleId;
	}

	public void setSaleRuleId(Integer saleRuleId) {
		this.saleRuleId = saleRuleId;
	}

	public void setSafePrice(Integer safePrice) {
		this.safePrice = safePrice;
	}

	public int getLowerPrice() {
		return lowerPrice;
	}

	public void setLowerPrice(Integer lowerPrice) {
		this.lowerPrice = lowerPrice;
	}

	public int getRoomDetain() {
		return roomDetain;
	}

	public void setRoomDetain(Integer roomDetain) {
		this.roomDetain = roomDetain;
	}

	public Date getPresentSale() {
		
		Date saleDay = null;
		if(StringUtils.isNoneBlank(presentSale)){
			try {
				saleDay = sd.parse(presentSale);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return saleDay;
	}

	public void setPresentSale(String presentSale) {
		this.presentSale = presentSale;
	}

	public double getIncreaseAmount() {
		return increaseAmount;
	}

	public void setIncreaseAmount(double increaseAmount) {
		this.increaseAmount = increaseAmount;
	}

	public String getIncreaseType() {
		return increaseType;
	}

	public void setIncreaseType(String increaseType) {
		this.increaseType = increaseType;
	}

	public String getHotelInstruction() {
		return hotelInstruction;
	}

	public void setHotelInstruction(String hotelInstruction) {
		this.hotelInstruction = hotelInstruction;
	}

	public String getRoomInstruction() {
		return roomInstruction;
	}

	public void setRoomInstruction(String roomInstruction) {
		this.roomInstruction = roomInstruction;
	}

	public Integer getBaseId() {
		return baseId;
	}

	public void setBaseId(Integer baseId) {
		this.baseId = baseId;
	}
	
	
	

}
