package com.jinhui.testexecutor;

import java.util.concurrent.Callable;

/**
 * 2017-11-3下午04:34:28
 * Thread1.java
 * author:liuyonghua
 */
public class Thread1 implements Callable<Boolean> {
	int i=0;

	@Override
	public Boolean call() throws Exception {
		// TODO Auto-generated method stub
		
		i++;
		System.out.println("thread"+i);
		Thread.sleep(3000);
		return true;
	}

	

}
