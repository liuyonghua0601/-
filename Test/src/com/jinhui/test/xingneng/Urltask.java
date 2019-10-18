package com.jinhui.test.xingneng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 2017-3-31下午04:43:35
 * Urltask.java
 * author:liuyonghua
 */
public class Urltask implements Runnable{
	String urlStr = "http://192.168.97.202:8088/MyWebProject/hello";
	String params = "name=liuyi";
	@Override
	public void run() {
		// TODO Auto-generated method stub
			for (int i = 0; i < 2; i++) {
				String result="";
				try {
					result = getURLByPost(urlStr, params);
					Thread.sleep(10000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(Thread.currentThread().getName()+"---"+result);
			}
	}

	public static String getURLByPost(String urlStr,String params)throws Exception{  
	       URL url=new URL(urlStr);  
	       HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
	       conn.setRequestMethod("POST");  
	       conn.setDoOutput(true);  
	       conn.setDoInput(true);  
	       PrintWriter printWriter = new PrintWriter(conn.getOutputStream());  
	       printWriter.write(params);  
	       printWriter.flush();          
	       BufferedReader in = null;   
	       StringBuilder sb = new StringBuilder();   
	       try{     
	           in = new BufferedReader( new InputStreamReader(conn.getInputStream(),"UTF-8") );   
	           String str = null;    
	           while((str = in.readLine()) != null) {    
	               sb.append( str );     
	           }     
	        } catch (Exception ex) {   
	           throw ex;   
	        } finally{    
	         try{   
	             conn.disconnect();  
	             if(in!=null){  
	                 in.close();  
	             }  
	             if(printWriter!=null){  
	                 printWriter.close();  
	             }  
	         }catch(IOException ex) {     
	             throw ex;   
	         }     
	        }     
	        return sb.toString();   
	   }  
}
