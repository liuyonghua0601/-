package com.jinhui.test;

import java.util.Random;

/**
 * 2017-3-22下午01:59:02
 * TestLock.java
 * author:liuyonghua
 */
public class TestLock {

	public static void main(String[] args) {
		//MyThread m = new MyThread();
		MyRunnable m = new MyRunnable(); 
		Thread t1 = new Thread(m, "线程1");
		Thread t2 = new Thread(m, "线程2");
		Thread t3 = new Thread(m, "线程3");
		Thread t4 = new Thread(m, "线程4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			Thread.sleep(12000);
			System.out.println(MyRunnable.c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
//		
//		MyRunnable r = new MyRunnable();
//		Thread t2 = new Thread(r,"runnable1");
//		Thread t3 = new Thread(r,"runnable2");
//		t2.start();
//		t3.start();
//		Random r = new Random();
//		while (m.c>0) {
//			int a = r.nextInt(6);
//			if(a==1){
//				Thread t1 = new Thread(m, "线程1");
//				t1.start();
//			}else if(a==2){
//				Thread t2 = new Thread(m, "线程2");
//				t2.start();
//			}else if(a==3){
//				Thread t3 = new Thread(m, "线程3");
//				t3.start();
//			}else if(a==4){
//				Thread t4 = new Thread(m, "线程4");
//				t4.start();
//			}else if(a==5){
//				Thread t5 = new Thread(m, "线程5");
//				t5.start();
//			}
//		}
	}
}
