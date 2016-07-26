package com.distinct.hotel.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.time.DateUtils;

import com.google.gson.Gson;

public class Utils {
	
	private static final Random random = new Random();
	
	private static Gson gson = new Gson();
	
	public static String getHotelStar(){
		
		String[] stars = new String[]{"1星级","2星级","3星级","4星级","5星级"};
		return stars[random.nextInt(stars.length)];
	}
	
	public static int getBedType(){
		
		int[] bedType = new int[]{1,2,3,4,5,6};
		return bedType[random.nextInt(bedType.length)];
	}
	
	public static int getBreakfast(){
		
		int[] bedType = new int[]{1,2,3,4,5};
		return bedType[random.nextInt(bedType.length)];
	}
	
	public static double getPrice(){
		double price = 0.0;
		int[] firstPrices = new int[]{3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int[] secondPrices = new int[]{0,1,2,3,4,5,6,7,8,9};
		String priceStr = "" + firstPrices[random.nextInt(firstPrices.length)] 
				+ secondPrices[random.nextInt(secondPrices.length)] + "0";
		price = Double.valueOf(priceStr);
		return price;
	}
	
	public static List<Date> getDays(int dayCount){
		List<Date> dates = new ArrayList<Date>();
		if(dayCount > 0){
			Date date = new Date();
			for(int i = 1; i <= dayCount; i++){
				
				Date d = DateUtils.addDays(date, i);
				dates.add(d);
			}
		}
		return dates;
	}
	
	public static String getNames(){
		
		String[] names = new String[]{"张三","李四","王五","赵六","小明","小红"};
		return names[random.nextInt(names.length)];
	}
	
	public static String getPhone(){
		String phone= "";
		int[] number = new int[]{1,2,3,4,5,6,7,8,9};
		for(int i = 0; i < 11; i++){
			phone = phone + number[random.nextInt(number.length)];
 		}
		return phone;
	}
	
	public static int getDays(){
		int[] number = new int[]{1,2,3,4,5};
		return number[random.nextInt(number.length)];
	}
	
	public static String getStatus(){
		String[] status = new String[]{"新单","待付款","待安排房间","确认","取消"};
		return status[random.nextInt(status.length)];
	}
	
	public static Date parseDate(String date, String pattern){
		Date d = null;
		SimpleDateFormat sd = new SimpleDateFormat(pattern);
		try {
			d = sd.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public static String formatDate(Date date, String pattern){
		SimpleDateFormat sd = new SimpleDateFormat(pattern);
		return sd.format(date);
	}

	public static String dataConvertJsonString(Object object){
		return gson.toJson(object);
	}
	
	
	
	
}
