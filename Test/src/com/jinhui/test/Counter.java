package com.jinhui.test;
/**
 * 2017-3-16下午04:00:54
 * Counter.java
 * author:liuyonghua
 */
public class Counter {

	public static int count = 0;
	
	public synchronized static void inc(){
		//这里延时1毫秒，使得结果明显
		try {
			Thread.sleep(1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		count++;
	}
	
	public static void main(String args[]){
		
		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Counter.inc();
				}
			}).start();
		}
		System.out.println("运行结果:Counter.count="+Counter.count);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("运行结果:Counter.count="+Counter.count);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("运行结果:Counter.count="+Counter.count);
	}
}
