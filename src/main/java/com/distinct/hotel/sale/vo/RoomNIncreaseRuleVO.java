package com.distinct.hotel.sale.vo;

import com.distinct.hotel.product.model.Room;
import com.distinct.hotel.sale.model.IncreaseRule;

public class RoomNIncreaseRuleVO {

	private Room room;

	private IncreaseRule increaseRule;

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public IncreaseRule getIncreaseRule() {
		return increaseRule;
	}

	public void setIncreaseRule(IncreaseRule increaseRule) {
		this.increaseRule = increaseRule;
	}

}
