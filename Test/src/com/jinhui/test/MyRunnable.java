package com.jinhui.test;
/**
 * 2017-3-22下午02:28:42
 * MyRunnable.java
 * author:liuyonghua
 */
public class MyRunnable implements Runnable {

	public static volatile int c = 100;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (c>0) {
			//System.out.println("--------"+Thread.currentThread().getName()+"---"+c);
			synchronized (this) {
					c--;
					System.out.println("--------"+Thread.currentThread().getName()+"---"+c);
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
			}
		}
	}

}
