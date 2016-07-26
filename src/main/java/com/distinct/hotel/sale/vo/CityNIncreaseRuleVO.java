package com.distinct.hotel.sale.vo;

import com.distinct.hotel.product.model.City;
import com.distinct.hotel.sale.model.IncreaseRule;

public class CityNIncreaseRuleVO {

	private City city;

	private IncreaseRule increaseRule;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public IncreaseRule getIncreaseRule() {
		return increaseRule;
	}

	public void setIncreaseRule(IncreaseRule increaseRule) {
		this.increaseRule = increaseRule;
	}

}
