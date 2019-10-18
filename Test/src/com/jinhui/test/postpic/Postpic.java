package com.jinhui.test.postpic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import com.jinhui.utils.Base64;
import com.jinhui.utils.DESUtils;
import com.jinhui.utils.FileBase64Util;

/**
 * 2017-5-5下午03:19:00
 * Postpic.java
 * author:liuyonghua
 */
public class Postpic {

	public static void main(String[] args) {
		String pic = "";
		String pic2 = "";
		String urls = "";
		
		//测试时用这个
		Properties m_props = new Properties();
		String urlpath = Thread.currentThread().getContextClassLoader()
		.getResource("").getPath().substring(1);
		
		if (urlpath.contains("%20")) {
			urlpath = urlpath.replaceAll("%20", " ");
		}
		String path = urlpath + "fileconfig.properties";
		//打包时用这个
//		String path = "fileconfig.properties";
		try {
			m_props.load(new FileInputStream(path));
			pic = m_props.getProperty("pic1"); 
			pic2 = m_props.getProperty("pic2"); 
			urls = m_props.getProperty("urls"); 
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
//		String aa=FileBase64Util.GetImageStr(pic);
//		System.out.println(aa);
		String aa= toBase64(pic);
		//System.out.println(aa);
		//aa = aa.replaceAll("\\+", "%2B");
		String params = "file1="+aa;
//		String bb=FileBase64Util.GetImageStr(pic2);
		String bb= toBase64(pic2);//
		//bb = bb.replaceAll("\\+", "%2B");
		params = params+"&file2="+bb;
		long time = System.currentTimeMillis();
		time =time/1000;
		time=time+810;
		String checkcode = "photothan"+time;
		DESUtils desUtils = new DESUtils();
		checkcode = desUtils.strEnc(checkcode, "jinhui_photothan_2017", "","");
		long stime = System.currentTimeMillis();
		params = params+"&time="+time+"&checkcode="+checkcode;
		System.out.println(params);
		String result = post(urls, params);
		long etime = System.currentTimeMillis();
		System.out.println(result);
		result = "开始时间戳："+stime+"\r\n"+"结束时间戳："+etime+"\r\n"+result;
        byte[] bytexml = result.getBytes();  
          
        try {  
            OutputStream os = new FileOutputStream(new File("result.txt"));  
            os.write(bytexml);  
            os.flush();  
            os.close();  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
	}
	
	public static String post(String strURL, String params) {  
        try {  
            URL url = new URL(strURL);// 创建连接  
            HttpURLConnection connection = (HttpURLConnection) url  
                    .openConnection();  
            connection.setDoOutput(true);  
            connection.setDoInput(true);  
            connection.setUseCaches(false);  
            connection.setInstanceFollowRedirects(true);  
            connection.setRequestMethod("POST"); // 设置请求方式  
            connection.setRequestProperty("Accept", "*/*"); // 设置接收数据的格式  
            connection.setRequestProperty("Accept-Encoding", "identity");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            System.out.println(System.currentTimeMillis());
            connection.connect();  
			
            OutputStreamWriter out = new OutputStreamWriter(  
                    connection.getOutputStream(), "UTF-8"); // utf-8编码  
            out.append(params);  
            out.flush();  
            out.close();  
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line;
            String result = "";
            while ((line = in.readLine()) != null) {
                result += line;
            }
            System.out.println(System.currentTimeMillis());
            return result;
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return "error"; // 自定义错误信息  
    }  
	
	public static String toBase64(String imgFilePath){
		String result = "";
		byte[] data = null;   
		  
		// 读取图片字节数组  
		InputStream in = null;
		try {   
			in = new FileInputStream(imgFilePath);  
			System.out.println("======"+in.available()/1024);
			data = new byte[in.available()];   
			in.read(data);   
			//in.close();
			result  = Base64.encode(data);
			result = result.replaceAll("\\+", "%2B");
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
		return result;
	}
}
