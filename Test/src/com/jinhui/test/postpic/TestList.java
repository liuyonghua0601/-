package com.jinhui.test.postpic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 2017-5-10上午11:41:32
 * TestList.java
 * author:liuyonghua
 */
public class TestList {

	public static void main(String[] args) {
//		List<String> alist = new ArrayList<String>();
//		System.out.println(alist);
//		System.out.println(alist.get(0));
		System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        System.out.println(TestList.class.getClassLoader().getResource(""));
        System.out.println(ClassLoader.getSystemResource(""));
        System.out.println(TestList.class.getResource(""));
        System.out.println(TestList.class.getResource("/")); // Class文件所在路径
        System.out.println(new File("/").getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
	}
}
