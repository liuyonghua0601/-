package com.jinhui.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * 2017-5-17下午03:42:59
 * TestCompare.java
 * author:liuyonghua
 */
public class TestCompare {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("zhans","lisi","wangwu","qumaxi");
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
			
		});
		System.out.println("-----------------------");
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
	}
	
}
