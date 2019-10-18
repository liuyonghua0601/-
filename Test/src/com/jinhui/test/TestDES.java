package com.jinhui.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.jinhui.utils.temputil;

/**
 * 2017-3-28下午05:47:42
 * TestDES.java
 * author:liuyonghua
 */
public class TestDES {

	public static void main(String[] args) {
		changeFile("before1.txt");
	}
	
	public static void changeFile(String path){
		FileInputStream is;
		try {
			is = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			FileOutputStream os = new FileOutputStream("after2.txt");
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			String rkey = br.readLine();
			String data = br.readLine();
			String result = temputil.decrypt(rkey, data);
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
