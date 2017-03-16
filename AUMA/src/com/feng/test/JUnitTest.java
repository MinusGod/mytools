package com.feng.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.feng.util.FTPUtil;
import com.feng.util.RSAUtil;

public class JUnitTest {

	//@Test
	public void test() {
		File file=new File("./feng.txt");
		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			FileInputStream fis=new FileInputStream("./feng.txt");
			FTPUtil.uploadFile("192.168.0.80", 21, "feng", "123123", "", "feng.txt", fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("junit");
	}
	
	//@Test
	public void test1(){
		FTPUtil.downFile("192.168.0.33", 21, "LCD", "333333", "", "ERP.txt", "F:");
		List list = new ArrayList();
		list.add("");
		
	}
	
	//@Test
	public void testRSA(){
			String info = "冯立业feng123456";
			System.out.println("加密前："+info);
			String pubKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAI4FZPiLCo+PX+IpWC5dLnAUvq7fbnlRCOyneoAB4ozW"+
		    "Hm0KYoWTpPrS3PC3G5evHlYhjh60yhVY5e+9Nkc49uMCAwEAAQ==";
			String priKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAjgVk+IsKj49f4ilYLl0ucBS+rt9u"+
			"eVEI7Kd6gAHijNYebQpihZOk+tLc8Lcbl68eViGOHrTKFVjl7702Rzj24wIDAQABAkBO6RRnPOpL"+
			"RgCiqxJCAKhSwlQI2kCJy8rHo27fPSzhzyorrfhRpAdHLx9Wf3Tejv3OF47pPNtaQv5eUCkf9lTh"+
			"AiEA0KqYNO3Z61tOJwaaBayniqhalKg37WsZ5a8Q/+bHjKkCIQCuPKi7ooWDC7KAh4P/wjLlEU1Y"+
			"B0GtVFV3HHL2Pu0yqwIgGM5e/9PS1z7ogI0xXEFVPY+cDRYeZ/QWhQ6V18YorNkCIQCShAPHtQTc"+
			"i8uQ9WP0gBNYONJ3QbLi1FYCEXRCyeugfQIhAJJheiyn0kAuRLMRME1dOoyHPGG339frfQmn/+K9"+
			"Xf93";
			String infoEnc = RSAUtil.pubKeyEncrypt(info, pubKey);
			System.out.println("加密后："+infoEnc);
			String infoDec = RSAUtil.priKeyDeco(infoEnc, priKey);
	        System.out.println("加密后："+infoDec);
	        String sign = RSAUtil.priKeyGenSign(info, priKey);
	        System.out.println("签名：" +sign);
	        System.out.println("验签："+RSAUtil.pubKeyVerSign(info, sign, pubKey));
	}
	
	@Test
	public void testEnum() {
		EnumTest en = EnumTest.Feng;
		System.out.println(EnumTest.initInstance(2));
	}
	
	
	
}
