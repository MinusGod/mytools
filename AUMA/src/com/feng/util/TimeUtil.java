package com.feng.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	public static Long parsTime(String time){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date=null;
		try {
			date=sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date.getTime();
	}
	
	public static String LongToTime(String time){
		Long timeL=Long.valueOf(time);
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date=new Date(timeL);		
		return sdf.format(date);
	}

}
