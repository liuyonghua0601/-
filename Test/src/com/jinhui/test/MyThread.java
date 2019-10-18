package com.jinhui.test;
/**
 * 2017-3-22下午02:24:59
 * MyThread.java
 * author:liuyonghua
 */
public class MyThread extends Thread {

	public int c = 10;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (c>0) {
			synchronized (this) {
				c--;
				System.out.println("--------"+currentThread().getName()+"---"+c);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		}
		
	}
}
