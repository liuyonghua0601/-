package com.jinhui.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class FileBase64Util {
	
	
	public static void main(String[] args) {
		String pic = "D:\\out\\IMG_3901.JPG";
		String aa=GetImageStr(pic);
		System.out.println(aa);
		System.out.println(getBase64Size(aa));
		System.out.println(GenerateImage(aa,"D:\\out\\aa.jpg"));
		
	}
	
	public static String GetImageStr(String imgFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理   
		byte[] data = null;   
		  
		// 读取图片字节数组  
		InputStream in = null;
		try {   
			in = new FileInputStream(imgFilePath);  
			System.out.println("======"+in.available()/1024);
			data = new byte[in.available()];   
			in.read(data);   
			//in.close();   
		} catch (IOException e) {   
			e.printStackTrace();   
		}finally{
			try {
				if(in!=null)
					in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
		  
		// 对字节数组Base64编码   
		BASE64Encoder encoder = new BASE64Encoder();   
		
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串   
	}   
	/**
	 * 根据base64编码解析成文件	  
	 * @param imgStr--base64编码
	 * @param imgFilePath--带文件名的路径
	 * @return
	 */
	public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片   
		boolean flag = false;
		if (imgStr == null) // 图像数据为空   
			return flag;
		if(imgStr.startsWith("data:image")){
			imgStr= imgStr.substring(imgStr.indexOf(",")+1, imgStr.length());
		}
		BASE64Decoder decoder = new BASE64Decoder();   
		OutputStream out = null;
		try { 
			// Base64解码   
			byte[] bytes = decoder.decodeBuffer(imgStr);   
			for (int i = 0; i < bytes.length; ++i) {   
				if (bytes[i] < 0) {// 调整异常数据   
					bytes[i] += 256;   
				}   
			}
			// 生成jpeg图片   
			out = new FileOutputStream(imgFilePath);   
			out.write(bytes);  
			out.flush();   
			flag= true;   
		} catch (Exception e) {   
			flag= false;   
		}finally{
			try {
				if(out !=null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	/**
	 * 根据base64编码获取文件大小
	 * @param imgStr---base64编码
	 * @return   KB
	 */
	
	public static int getBase64Size(String imgStr) {   
		int size = 0;
		if (imgStr == null) 
			return size;   
		BASE64Decoder decoder = new BASE64Decoder();   
		try { 
			// Base64解码   
			byte[] bytes = decoder.decodeBuffer(imgStr);   
			size = bytes.length/1024;
			
		} catch (Exception e) {   
			size= 0;   
		}
		return size;
	}
		 


}
