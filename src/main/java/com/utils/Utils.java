package com.utils;

import java.security.MessageDigest;

public class Utils {

	public static long getCurrentTimeStamp(){
		return 	System.currentTimeMillis();
	};
	
	public static String convertIntoMd5(String password) throws Exception{
		 MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(password.getBytes());
	        
	        byte byteData[] = md.digest();
	 
	        //convert the byte to hex format method 1
	        StringBuffer sbPassword = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sbPassword.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	     
	        System.out.println("Digest(in hex format):: " + sbPassword.toString());
	        
			return sbPassword.toString();
	}
}
