package com.jinhui.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.jinhui.utils.temputil;


/**
 * 2017-3-27上午11:41:31
 * TestAES.java
 * author:liuyonghua
 */
public class TestAES {

	public static String urlpath;
	
	public static void main(String[] args) {
		//urlpath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//		if (urlpath.contains("%20")) {
//			urlpath = urlpath.replaceAll("%20", " ");
//		}
		//System.out.println(urlpath);
		changeFile("before.txt");
	}
	
	public static void changeFile(String path){
		FileInputStream is;
		try {
			is = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			FileOutputStream os = new FileOutputStream("after.txt");
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			String rkey = br.readLine();
			String data = br.readLine();
			String line = "";
			while ((line=br.readLine())!=null) {
				data = data+"\n"+line;
			}
			
			String result = temputil.encrypt(rkey, data);
			bw.write(result);
			is.close();
			bw.flush();
			os.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
