package com.feng.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class SMSUtil {
	public static String sendSMS(String phone,String content){
		Map<String,String> map=new HashMap<String,String>();
		String message="";
		try {
			message = URLEncoder.encode(content, "gb2312");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String url="http://q.hl95.com:8061/";
		map.put("username", "ryjr");
		map.put("password", "ryjr123");
		map.put("phone", phone);
		map.put("message", message);
		map.put("epid", "120652");
		String result=HttpUtil.HttpSMS(url, map);
		return result;
	}

}
