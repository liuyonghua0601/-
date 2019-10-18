package com.jinhui.test.xingneng;


/**
 * 2017-3-31下午04:02:51
 * TestUrl.java
 * author:liuyonghua
 */
public class TestUrl {

	public static void main(String[] args) {
		
		Urltask ut = new Urltask();
		for (int i = 0; i < 1000; i++) {
			Thread t = new Thread(ut);
			t.start();
		}
	}
	
	
	
}

