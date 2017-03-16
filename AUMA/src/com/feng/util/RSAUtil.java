package com.feng.util;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import sun.misc.BASE64Encoder
import javax.crypto.Cipher;


public class RSAUtil {
	
	/**
	 * 生成Base64密钥对
	 * @return
	 */
	public static Map<String, String> geneKeyPairs() {
		KeyPairGenerator keyPairGen = null;
		try {
			keyPairGen = KeyPairGenerator.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		keyPairGen.initialize(512);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPublicKey pubKey = (RSAPublicKey)keyPair.getPublic();
		RSAPrivateKey priKey = (RSAPrivateKey)keyPair.getPrivate();
		Map<String, String> map = new HashMap<String, String>();
		BASE64Encoder encode = new BASE64Encoder();
		byte[] pub = pubKey.getEncoded();
		byte[] pri = priKey.getEncoded();
		String pubstr = encode.encode(pub);
		String pristr = encode.encode(pri);
		System.out.println(pubstr);
		System.out.println(pristr);
		map.put("pubKey", pubstr);
		map.put("priKey", pristr);
		return map;
	}
	
	/**
	 * 根据base64字符串初始化公钥
	 * @param pubKeyStr
	 * @return
	 * @throws Exception
	 */
	public static PublicKey strToPubKey(String pubKeyStr) 
			throws Exception {	
		byte[] pubKeyArr = new BASE64Decoder().decodeBuffer(pubKeyStr);
	    // 构造PKCS8EncodedKeySpec对象  
	    X509EncodedKeySpec pkcs8KeySpec = new X509EncodedKeySpec(pubKeyArr);  
        // KEY_ALGORITHM 指定的加密算法  
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");    
        // 取私钥匙对象  
        PublicKey pubKey = keyFactory.generatePublic(pkcs8KeySpec);
        return pubKey;		
	}
	
	/**
	 * 根据base64字符串初始化私钥
	 * @param priKeyStr
	 * @return
	 * @throws Exception
	 */
	public static PrivateKey strToPriKey(String priKeyStr) 
			throws Exception {	
        byte[] priKeyArr = new BASE64Decoder().decodeBuffer(priKeyStr);  
        // 取得私钥  
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(priKeyArr);  
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);  
        return priKey;
	}
	
	/**
	 *  公钥加密数据
	 * @param data
	 * @param pubKeyStr
	 * @return
	 */
	public static String pubKeyEncrypt(String data ,String pubKeyStr) {
		byte[] dataArr = data.getBytes();
		PublicKey pubKey = null;
		try {
			pubKey = strToPubKey(pubKeyStr);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		// 用公钥对数据加密  
		byte[] dataEnc = null;
		try {
			Cipher cipher = Cipher.getInstance(KeyFactory.
					getInstance("RSA").getAlgorithm());  
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);  
		    dataEnc = cipher.doFinal(dataArr); 			
		} catch (Exception e) {
			e.printStackTrace();
		}
        return  new BASE64Encoder().encode(dataEnc);
	}
	
	/**
	 * 私钥解密数据
	 * @param dataEnc
	 * @param priKeyStr
	 * @return
	 */
	public static String priKeyDeco(String dataEnc, String priKeyStr) {
		byte[] dataArr = null;
		PrivateKey priKey = null;
		try {
			dataArr = new BASE64Decoder().decodeBuffer(dataEnc);
			priKey = strToPriKey(priKeyStr);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		// 用私钥解密数据 
		byte[] dataEnced = null;
		try {
			Cipher cipher = Cipher.getInstance(KeyFactory.
					getInstance("RSA").getAlgorithm());  
			cipher.init(Cipher.DECRYPT_MODE, priKey);  
			dataEnced = cipher.doFinal(dataArr); 			
		} catch (Exception e) {
			e.printStackTrace();
		}	
        return  new String(dataEnced);
	}
	
	/**
	 * 私钥生成签名
	 * @param data
	 * @param priKeyStr
	 * @return
	 */
	public static String priKeyGenSign(String data, String priKeyStr) {
		byte[] dataByte = data.getBytes();
		PrivateKey priKey = null;
		try {
			priKey = strToPriKey(priKeyStr);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		// 用私钥生成签名 
		byte[] dataSign = null;
		try {
			Signature signature = Signature.getInstance("MD5withRSA");  
	        signature.initSign(priKey);  
	        signature.update(dataByte);  	
	        dataSign = signature.sign();
		} catch (Exception e) {
			e.printStackTrace();
		}	
        return  new BASE64Encoder().encode(dataSign);
	}
	
	/**
	 * 公钥验证签名
	 * @param data
	 * @param sign
	 * @param pubKeyStr
	 * @return
	 */
	public static boolean pubKeyVerSign(String data, String sign ,String pubKeyStr) {
		byte[] signArr = null;
		PublicKey pubKey = null;
		byte[] dataByte = data.getBytes();
		try {
			pubKey = strToPubKey(pubKeyStr);
			signArr = new BASE64Decoder().decodeBuffer(sign);		
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Signature signature = null; 
		boolean flag = false;
		try {
		    signature = Signature.getInstance("MD5withRSA");  
			signature.initVerify(pubKey);  
     		signature.update(dataByte); 
     		flag = signature.verify(signArr);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	    // 验证签名是否正常  
	    return flag;
	}

}
