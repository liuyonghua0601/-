package com.jinhui.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.jinhui.utils.Base64;
import com.jinhui.utils.DESUtils;
import com.jinhui.utils.temputil;

/**
 * 2017-5-26下午02:07:53
 * TestDesUtils.java
 * author:liuyonghua
 */
public class TestDesUtilsEnc {

	public static void main(String[] args) {
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
			
			DESUtils desUtils = new DESUtils();
	      	String result = desUtils.strEnc(data, rkey, "", "");
	      	result = Base64.encode(result.getBytes());
	      	result=result.replace("\n", "");
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
