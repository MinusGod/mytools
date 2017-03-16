package com.feng.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Http 请求
 * @author Administrator
 */
public class HttpUtil {
	/**
	 * http Get请求
	 * @param url
	 * @param params
	 * @return
	 */
	public static Map<String,String> httpGet(String url,Map<String,String> params){
		  String httpURL=httpURL(url,params);
		  CloseableHttpClient httpclient = HttpClients.createDefault();		  
	      HttpGet httpget = new HttpGet(httpURL);

	      CloseableHttpResponse response=null;
	      String returnData="";
	      	      	      
	     try {
	    	response=httpclient.execute(httpget);
	    	if(HttpStatus.SC_OK == response.getStatusLine().getStatusCode()){
	    		HttpEntity entity=response.getEntity();	     		
	    		returnData=EntityUtils.toString(entity,"UTF-8");
	    	}
	    	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			httpget.abort();
			try {
				response.close();
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	    return jsonToMap(returnData);
	}
	/**
	 * http Post请求
	 * @param url
	 * @param paramsMap
	 * @return
	 */
	public static Map<String,String> httpPost(String url,Map<String,String> paramsMap){
		  CloseableHttpClient httpclient = HttpClients.createDefault();		 		  
	      HttpPost httpPost=new HttpPost(url);
	      CloseableHttpResponse response=null;
	      String returnData="";      	      	      
	     try {
	    	 if(paramsMap!=null){
	    		 List<NameValuePair> params = new ArrayList<NameValuePair>();	
	    		 for (Iterator<Entry<String, String>> iterator = paramsMap.entrySet()
	    				 .iterator(); iterator.hasNext();) {
	    			 Entry<String, String> entry = iterator.next();
	    			 params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
	    		 }
	    		 
	    		 UrlEncodedFormEntity urlEntity=new UrlEncodedFormEntity(params, "UTF-8");
	    		 httpPost.setEntity(urlEntity);
	    		 
	    	 }
	    	response=httpclient.execute(httpPost);
	    	if(HttpStatus.SC_OK == response.getStatusLine().getStatusCode()){
	    		HttpEntity entity=response.getEntity();	     		
	    		returnData=EntityUtils.toString(entity,"UTF-8");
	    	}
	    	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			httpPost.abort();
			try {
				response.close();
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	     System.out.println("data"+returnData);
	    return jsonToMap(returnData);
	}
	
	/**
	 * 短信发送请求
	 * @param url
	 * @param params
	 * @return
	 */
	public static String HttpSMS(String url,Map<String,String> params){
		  String httpURL=httpURL(url,params);
		  CloseableHttpClient httpclient = HttpClients.createDefault();		  
	      HttpGet httpget = new HttpGet(httpURL);
	      CloseableHttpResponse response=null;
	      String returnData="";
	      	      	      
	     try {
	    	response=httpclient.execute(httpget);
	    	if(HttpStatus.SC_OK == response.getStatusLine().getStatusCode()){
	    		HttpEntity entity=response.getEntity();	     		
	    		returnData=EntityUtils.toString(entity);
	    	}
	    	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			httpget.abort();
			try {
				response.close();
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	    return returnData;
		
	}
	
	
	/**
	 * 组装 GET请求URL
	 * @param url
	 * @param params
	 * @return
	 */
	public static String httpURL(String url,Map<String,String> params){
		StringBuilder httpURL=new StringBuilder("");
		if(params==null){
			httpURL.append(url);
		}else{
			httpURL.append(url+"?");
			for(String key:params.keySet()){
				httpURL.append(key+"="+params.get(key)+"&");			
			}
			System.out.println(httpURL.substring(0,httpURL.length()-1));
			httpURL=new StringBuilder(httpURL.substring(0,httpURL.length()-1));
		}
		return httpURL.toString();
	}
	
	/**
	 * json To map
	 * @param json
	 * @return
	 */
	public static Map<String,String> jsonToMap(String jsonStr){
		JSONObject jsonObj=null;
		try {
			jsonObj= new JSONObject(jsonStr);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		@SuppressWarnings("unchecked")
		Iterator<String> nameItr = jsonObj.keys();
		String name;
		Map<String, String> outMap = new HashMap<String, String>();
		while (nameItr.hasNext()) {
			name = nameItr.next();
			try {
				outMap.put(name, jsonObj.getString(name));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return outMap;		
	}
	

}
