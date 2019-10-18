package com.jinhui.test.map;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2018-1-17下午04:28:54
 * testlist.java
 * author:liuyonghua
 */
public class testlist {

	public static void main(String[] args) {
		List<String> sList = new ArrayList<String>();
		sList.add("张三");
		sList.add("李四");
		sList.add("王五");
		sList.add("麻六");
		sList.add("赵七");
		Collections.sort(sList,Collator.getInstance(java.util.Locale.CHINA));
		for (int i = 0; i < sList.size(); i++) {
			System.out.println(sList.get(i));
		}
		
		List<Integer> iList = new ArrayList<Integer>();
		iList.add(8);
		iList.add(3);
		iList.add(34);
		iList.add(6);
		iList.add(9);
		Collections.sort(iList);
		for (int i = 0; i < iList.size(); i++) {
			System.out.println(iList.get(i));
		}
		Collections.reverse(iList);
		for (int i = 0; i < iList.size(); i++) {
			System.out.println(iList.get(i));
		}
	}
}
