package com.distinct.hotel.product.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateApplication {

	// 返回当日n天后的日期
	public static  Date setCalendar(int num) {
		Date today = new Date(); // 当前的日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 日期格式
		String now = sdf.format(today);
		System.out.println(now);
		Date dt = null;
		try {
			dt = sdf.parse(now); // 转为日期
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar nextTime = Calendar.getInstance();
		nextTime.setTime(dt);
		// rightNow.add(Calendar.YEAR,-1);//日期减1年
		// rightNow.add(Calendar.MONTH,3);//日期加3个月
		nextTime.add(Calendar.DAY_OF_YEAR, num);// 日期加10天
		Date date = nextTime.getTime();
		// this.date = date;
		return date;
	}

	// 输入一个日期日期设置
	public static Date changeCalendar(Date date, int num) {
		Calendar nextTime = Calendar.getInstance();
		nextTime.setTime(date);
		nextTime.add(Calendar.DAY_OF_YEAR, num);// 日期加10天
		Date finaldate = nextTime.getTime();
		return finaldate;
	}

	// 输入一个日期日期设置，含当日比如今天是0511，num等于14时，输出的日期是0524   ，相差13天，含当日就会有14天
	public static Date changeCalendarFromString(String date, int num) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 要符合这个格式的String对象才能运行
		Date dt = null;
		try {
			dt = sdf.parse(date); // 转为日期
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar nextTime = Calendar.getInstance();
		nextTime.setTime(dt);
		// rightNow.add(Calendar.YEAR,-1);//日期减1年
		// rightNow.add(Calendar.MONTH,3);//日期加3个月
		nextTime.add(Calendar.DAY_OF_YEAR, num-1);// 日期加10天
		Date finaldate = nextTime.getTime();
		return finaldate;
	}

	public static Date stringToDate(String date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date dt = null;
		try {
			dt = sdf.parse(date); // 转为日期
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// String now = sdf.format(date);
		return dt;
	}

	public static String returnStringDate() {
		Date today = new Date(); // 当前的日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 日期格式
		String now = sdf.format(today);
		return now;

	}

	// 返回当日n天后的日期
	public static Date setCalendarByOtherMethod(int num) {
		Date today = new Date(); // 当前的日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 日期格式
		String now = sdf.format(today);
		System.out.println(now);
		return changeCalendarFromString(now, num);
	}

	// 返回一个日期list
	/**
	 * 
	 * 暂时不用
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	/*public static List<Date> returnDateListOrigin(Date startDate, Date endDate) {
		Calendar startTime = Calendar.getInstance();
		startTime.setTime(startDate); //
		Calendar endTime = Calendar.getInstance();
		endTime.setTime(endDate);
		return null;
	}*/

	// 返回一个日期list,包含当日,包含结束日期
	public static List<Date> returnDateList(Date startDate, Date endDate) {
		List<Date> dateList = new ArrayList<Date>();
		dateList.add(startDate);
		long day;
		day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
		for (long i = 1; i <= day; i++) {
			Calendar nextTime = Calendar.getInstance();
			nextTime.setTime(startDate);
			// rightNow.add(Calendar.YEAR,-1);//日期减1年
			// rightNow.add(Calendar.MONTH,3);//日期加3个月
			nextTime.add(Calendar.DAY_OF_YEAR, (int)i);// 日期加10天
			Date finaldate = nextTime.getTime();
			dateList.add(finaldate);
		}
		return dateList;
	}
	// 返回一个日期list,包含当日,包含结束日期
	public static List<Date> returnDateListNotEndDate(Date startDate, Date endDate) {
		List<Date> dateList = new ArrayList<Date>();
		dateList.add(startDate);
		long day;
		day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
		for (long i = 1; i < day; i++) {
			Calendar nextTime = Calendar.getInstance();
			nextTime.setTime(startDate);
			// rightNow.add(Calendar.YEAR,-1);//日期减1年
			// rightNow.add(Calendar.MONTH,3);//日期加3个月
			nextTime.add(Calendar.DAY_OF_YEAR, (int)i);// 日期加10天
			Date finaldate = nextTime.getTime();
			dateList.add(finaldate);
		}
		return dateList;
	}

	
}
