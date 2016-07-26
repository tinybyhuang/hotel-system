package com.distinct.hotel.grap.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.distinct.hotel.grap.service.HotelGrapService;
import com.distinct.hotel.grap.service.HotelService;
import com.distinct.hotel.grap.vo.Head;
import com.distinct.hotel.product.dao.CityMapper;
import com.distinct.hotel.product.model.City;
import com.distinct.hotel.product.model.CityExample;
import com.distinct.hotel.product.model.Hotel;
import com.distinct.hotel.product.model.Room;

@Component
public class HotelGrapListener implements ApplicationListener<ContextRefreshedEvent> {
	
	private static final Logger logger = LoggerFactory.getLogger(HotelGrapListener.class);
	
	@Resource
	private CityMapper cityMapper;
	@Resource
	private HotelService hotelService;
	@Resource
	private HotelGrapService hService;
	
	private BlockingQueue<Hotel> hotelQueue = new LinkedBlockingQueue<Hotel>();
	
	private BlockingQueue<Room> roomQueue = new LinkedBlockingQueue<Room>();
	
	private List<Hotel> hotels = new ArrayList<Hotel>();
	
	private List<Room> rooms = new ArrayList<Room>();
	
	private String inDay = "2016-03-25";
	
	private String outDay = "2016-03-26";
	
	private final int hotelMaxSize = 20;
	
	private final int roomMaxSize = 50;
	
	private final int destroySize = 100;
	
	private int currentSize = 0;
	
	private static int count = 0;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		count++;
		if(count > 1){
			
			new Thread(new Runnable() {
				public void run() {
//					hotelService.setPrice();
				}
			}).start();
			
//			new Thread(new Runnable() {
//				public void run() {
//					CityExample cityExample = new CityExample();
//					cityExample.createCriteria().andIdGreaterThan(0);
//					List<City> citys = cityMapper.selectByExample(cityExample);
//					
////					HotelGrapService hService = new HotelGrapService(hotelQueue, roomQueue);
//					
//					String clientId = hService.getClientId();
//					Head head = new Head(clientId);
//					hService.getHotelIds(617, inDay, outDay, head);
////					for(City city : citys){
////						
////						hService.getHotelIds(city.getId(), inDay, outDay, head);
////					}
//				}
//			}).start();
			
//			hotelService.setPrice();
		}
		
		
//		new Thread(new Runnable() {
//			public void run() {
//				CityExample cityExample = new CityExample();
//				cityExample.createCriteria().andIdGreaterThan(0);
//				List<City> citys = cityMapper.selectByExample(cityExample);
//				
////				HotelGrapService hService = new HotelGrapService(hotelQueue, roomQueue);
//				
//				String clientId = hService.getClientId();
//				Head head = new Head(clientId);
//				hService.getHotelIds(43, inDay, outDay, head);
////				for(City city : citys){
////					
////					hService.getHotelIds(city.getId(), inDay, outDay, head);
////				}
//			}
//		}).start();
		
//		new Thread(new Runnable() {
//			
//			public void run() {
//				
//				while(true){
//					try {
//						Thread.sleep(3000);
//					} catch (Exception e) {
//						
//					}
//					boolean flag = true;
//					int hotelSize = hotelQueue.size();
//					
//					logger.info("当前酒店总数为：" + hotelSize);
//					if(hotelSize > hotelMaxSize){
//						hotels.clear();
//						hotelQueue.drainTo(hotels, hotelMaxSize);
//						flag = false;
//					}
//					
//					int roomSize = roomQueue.size();
//					logger.info("当前房型总数为：" + roomSize);
//					if(roomSize > roomMaxSize){
//						rooms.clear();
//						roomQueue.drainTo(rooms,roomMaxSize);
//						flag = false;
//					}
//					
//					if(flag){
//						currentSize++;
//					}
//					hotelService.insertHotel(hotels);
//					hotelService.insertRoom(rooms);
//					if(currentSize > destroySize ){
//						
//						logger.info("超过当前，关闭轮询");
//						
//						break;
//					}
//					
//				}
//			}
//		}).start();
		
	}

}
