package com.jinhui.utils;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * AES/CBC/NoPadding算法
 * 2017-5-26上午09:56:21
 * AESencrp.java
 * author:liuyonghua
 */
public class AESencrp {

	// 加密算法
	private String ALGO = "AES";
    private String ALGO_MODE = "AES/CBC/NoPadding";
    private String akey = "jinhui_photothan";
    private String aiv = "0102030405060708";


    /**
     * 用来进行加密的操作
     * 
     * @param Data
     * @return
     * @throws Exception
     */public String encrypt(String Data) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance(ALGO_MODE);
        int blockSize = cipher.getBlockSize();
        byte[] dataBytes = Data.getBytes();
        int plaintextLength = dataBytes.length;
        if (plaintextLength % blockSize != 0) {
            plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
        }
        byte[] plaintext = new byte[plaintextLength];
        System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
    
        SecretKeySpec keyspec = new SecretKeySpec(akey.getBytes("utf-8"), ALGO);
        IvParameterSpec ivspec = new IvParameterSpec(aiv.getBytes("utf-8"));
        cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
        byte[] encrypted = cipher.doFinal(plaintext);
        //String EncStr = new sun.misc.BASE64Encoder().encode(encrypted);
        String EncStr = byte2hex(encrypted);
        return EncStr ;
      } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    }

    /**
     * 用来进行解密的操作
     * 
     * @param encryptedData
     * @return
     * @throws Exception
     */public String decrypt(String encryptedData) throws Exception {
	        try {
	            //byte[] encrypted1 = new sun.misc.BASE64Decoder().decodeBuffer(encryptedData);
	            byte[] encrypted1 = hex2byte(encryptedData.getBytes());
		        Cipher cipher = Cipher.getInstance(ALGO_MODE);
		        SecretKeySpec keyspec = new SecretKeySpec(akey.getBytes("utf-8"), ALGO);
		        IvParameterSpec ivspec = new IvParameterSpec(aiv.getBytes("utf-8"));
		    
		        cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
		        byte[] original = cipher.doFinal(encrypted1);
		        String originalString = new String(original);
		        return originalString;
	      } catch (Exception e) {
		      e.printStackTrace();
		      return null;
		    }
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
    	// 创建加解密
         AESencrp aes = new AESencrp();
         // 要进行加密的密码
         String password = "12311dsfsd  ";
         // 进行加密后的字符串
         String passwordEnc="";
		try {
			passwordEnc = aes.encrypt(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         String passwordDec="";
		try {
			passwordDec = aes.decrypt(passwordEnc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         System.out.println("原来的密码 : " + password);
         System.out.println("加密后的密码 : " + passwordEnc);
         System.out.println("解密后的原密码 : " + passwordDec.trim());
         
         try {
			passwordDec = aes.decrypt("0E39C22999503FFA23DD82035FAA7F45");
			System.out.println(passwordDec);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
