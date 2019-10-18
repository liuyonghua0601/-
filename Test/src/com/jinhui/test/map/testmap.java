package com.jinhui.test.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 2017-9-26下午02:36:13
 * testmap.java
 * author:liuyonghua
 */
public class testmap {

	public static void main(String[] args) {
		/*ConcurrentHashMap<String, String> cmap = new ConcurrentHashMap<String, String>();
		cmap.put("abc", "bcd");
		System.out.println(cmap.toString());*/
		int cap =33;
		int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n);
	}
}
