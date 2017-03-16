package com.feng.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelUtil {
	
	
	/*public static void exportExcel(List<?> list, String name, String [] arr1, String [] arr2){
			JsonConfig jsonConfig = new JsonConfig();
	    	jsonConfig.registerJsonValueProcessor(Date.class, new JsonValueProcessor("yyyy-MM-dd"));
	    	jsonConfig.registerJsonValueProcessor(Double.class, new JsonValueProcessor("##,##0.00"));
	    	JSONArray arrList = JSONArray.fromObject(list, jsonConfig);
	    	System.out.println(arrList.toString());
		    export(name, arrList, arr1, arr2);

	} 
		
	

	public static <T> File export(String sheetName, List<T> list, String[] titles, String[] fieldNames) {
		HSSFWorkbook wb = new HSSFWorkbook();
		
		HSSFSheet sheet = null;
		
		// 对每个表生成一个新的sheet,并以表名命名
		if(sheetName == null){
			sheetName = "sheet1";
		}
		
		sheet = wb.createSheet(sheetName);
		
		// 设置表头的说明
		HSSFRow topRow = sheet.createRow(0);

		for(int i = 0; i < titles.length; i++){
			setCellGBKValue(topRow.createCell((short) i), titles[i]);
		}
		
		for (int i = 0; i < list.size(); i++) {
			HSSFRow row = sheet.createRow(i+1);
			JSONObject obj = JSONObject.fromObject(list.get(i));
			
			for(int j = 0; j < fieldNames.length; j++){
				setCellGBKValue(row.createCell((short) j), obj.get(fieldNames[j])+"");
			}
		}
		
		String path = Play.getFile("/file/").getAbsolutePath();
    	//String filename = UUID.randomUUID().toString() + ".xls";
		Date date=new Date();
		String filename=DateUtil.dateToString1(date)+".xls";
    	File file = new File(path + "/" + filename);

    	try {
    		OutputStream os = new FileOutputStream(file);
    		wb.write(os);
    		os.flush();
    		os.close();
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
		
		return file;
	}

	@SuppressWarnings("deprecation")
	private static void setCellGBKValue(HSSFCell cell, String value) {
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		// 设置CELL的编码信息
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue(value);
	}*/
	

}
