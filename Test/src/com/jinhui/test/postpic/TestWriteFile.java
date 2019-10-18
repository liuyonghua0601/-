package com.jinhui.test.postpic;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * 2017-5-9下午05:02:44
 * TestWriteFile.java
 * author:liuyonghua
 */
public class TestWriteFile {

	public static void main(String[] args) {
		/*try {
			OutputStream os = new FileOutputStream(new File("result.txt"));
			for (int j = 0; j < 10; j++) {
				os.write(("a"+j).getBytes());
				os.write("\r\n".getBytes());
			}
			os.flush();  
            os.close();  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		
		InputStreamReader is = new InputStreamReader(new ByteArrayInputStream("abc".getBytes()));
		try {
			int a=0;
			while ((a = is.read())!=-1) {
				System.out.println(a);
			}
			//is.close();
			
			BufferedReader bf = new BufferedReader(is);
			String str = bf.readLine();
			while (str!=null) {
				System.out.println(str);
				str= bf.readLine();
			}
			is.close();
			bf.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
