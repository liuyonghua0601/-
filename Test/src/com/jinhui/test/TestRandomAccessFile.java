package com.jinhui.test;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * 2017-10-13下午06:12:45
 * TestRandomAccessFile.java
 * author:liuyonghua
 */
public class TestRandomAccessFile {

	public static void main(String[] args) {
		try {
			RandomAccessFile rfile = new RandomAccessFile("D:\\ftp\\abc.txt", "rw");
			rfile.seek(1024);
			rfile.writeBytes("aaa");
			rfile.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
