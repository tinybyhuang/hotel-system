package com.distinct.hotel.service.market.listener;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.distinct.hotel.service.market.service.OrderSyncService;
@Component
public class MarketOrderListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Resource
	private OrderSyncService orderSyncService;
	
	private static int count = 0;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		count++;
		if(count > 1){
			System.out.println("------------测试------------");
			new Thread(new Runnable() {
				public void run() {
//					orderSyncService.syncOrder();
//					orderSyncService.matchHotel();
				}
			}).start();
		}
		
	}

}
