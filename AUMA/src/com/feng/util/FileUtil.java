package com.feng.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class FileUtil {
	
/*	public static boolean writeUser(String userName){
		 String filePath = Play.getFile("/tmp/").getAbsolutePath();
		 File file=new File(filePath+"/user.txt");
		 if(!file.exists()){
			 try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }
		 
		 
		 BufferedWriter bw=null;		 
		 try {			
			 FileOutputStream fos = new FileOutputStream(filePath+"/user.txt",true);
			 OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			 bw=new BufferedWriter(osw);
			 bw.write(userName+" ");
			 bw.flush();
			 
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}finally{		
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		Logger.info("写入"+userName+"成功");
		return true;
	}
	
	public static List<String> readerUser(){
		String filePath = Play.getFile("/tmp/").getAbsolutePath();
		List<String> list=null;
		try {
			FileInputStream fis=new FileInputStream(filePath+"/user.txt");
			InputStreamReader isr=new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(isr);
			String content="";
			try {
				String info=null;
				while((info=br.readLine())!=null){
					content+=info;
				}				
			} catch (Exception e) {
			}
			String[] arr=content.split(" ");
			list=new ArrayList();
			for(String unit:arr){				
				list.add(unit.trim());
			}
			Logger.info(list.toString());	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}*/

}
