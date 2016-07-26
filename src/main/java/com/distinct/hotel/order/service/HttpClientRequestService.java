package com.distinct.hotel.order.service;

public interface HttpClientRequestService {

	//20160522
	//下单post
	//public String post(String url,BookingOrder bookingOrder);
	
	//使用这个方法先把数据转换成String传进来这个方法
	public String post(String url,String data);
	
	//get请求网站,如百度
	public String get(String url);
	
}
