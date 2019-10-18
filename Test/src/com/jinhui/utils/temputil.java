package com.jinhui.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.StringUtils;

/**
 * 2017-1-20上午10:52:25
 * temputil.java
 * author:liuyonghua
 */
public class temputil {

	public static final String VIPARA = "0102030405060708";  
	public static final String bm = "utf-8";  
	
	public static String encrypt(String dataPassword, String cleartext)  
    throws Exception {  
		if(dataPassword!=null&&!"".equals(dataPassword)){
			if(dataPassword.length()>16){
				dataPassword=dataPassword.substring(0,16);
			}else{
				dataPassword = StringUtils.leftPad(dataPassword, 16, "0");
			}
		}
		IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes());  
		SecretKeySpec key = new SecretKeySpec(dataPassword.getBytes(), "AES");  
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
		byte[] encryptedData = cipher.doFinal(cleartext.getBytes(bm));  
		
		return byte2hex(encryptedData);  
	}  
	
	public static String decrypt(String dataPassword, String encrypted)  
	    throws Exception {  
		if(dataPassword!=null&&!"".equals(dataPassword)){
			if(dataPassword.length()>16){
				dataPassword=dataPassword.substring(0,16);
			}else{
				dataPassword = StringUtils.leftPad(dataPassword, 16, "0");
			}
		}
		byte[] byteMi = hex2byte(encrypted.getBytes());  
		IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes());  
		SecretKeySpec key = new SecretKeySpec(dataPassword.getBytes(), "AES");  
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  
		cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);  
		byte[] decryptedData = cipher.doFinal(byteMi);  
		
		return new String(decryptedData,bm);  
	}  
	 /**
     * 十六进制字符串转byte
     * @param b
     * @return
     */
     private static String byte2hex(byte[] b) {
         String hs = "";
         String stmp = "";
         for (int n = 0; n < b.length; n++) {
             stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
             if (stmp.length() == 1)
                 hs = hs + "0" + stmp;
             else
                 hs = hs + stmp;
         }
         return hs.toUpperCase();
     }
     
     /**
      * byte转十六进制字符串
      * @param b
      * @return
      */
     private static byte[] hex2byte(byte[] b) {
          if ((b.length % 2) != 0)
              throw new IllegalArgumentException("长度不是偶数");
          byte[] b2 = new byte[b.length / 2];
          for (int n = 0; n < b.length; n += 2) {
              String item = new String(b, n, 2);
              b2[n / 2] = (byte) Integer.parseInt(item, 16);
          }
          return b2;
      }
     public static void main(String[] args) {
    	 String msg="";
 		try {
 			//msg = temputil.encrypt("0102030405060708", "01001001234561484876574");
 			//System.out.println(msg);
 			msg = temputil.decrypt("00123456kfhptptz", "3FCEF371C747D3918BB03C9AC6A12362EB27BE7963544C5AE87DAF7B0D507F322606D3470164B8716AF362DF2D1D9A20306F6F04FCBE4CF54E1A7C8AB1BDF5238D6AA8EA5B34E544E67E4C6C19DC277B74D1B5913EFAD31ED0C51AFF9E1E512899EC748C732518C687E2C860DDA65B7D6908FB1728B938967D1C9E53895EC3372B5C029D2207E710F871DA283F28988DE18209FDD66929CCE8BAFA6BE3E65E7E7D5B9A9EFBF53E67739C28CD222EAA57");
 			//msg = temputil.decrypt("0102030405060708", "79E1D659AB8FCA60D973FF9B2E23CFC0B3C3567D3D6C28F073494C86AC9604C6");
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		System.out.println(msg);
	}
}
