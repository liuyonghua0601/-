package com.jinhui.testexecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 2017-11-3下午04:33:57
 * Test.java
 * author:liuyonghua
 */
public class Test {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
 		List<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();
   		for(int i=0;i<100;i++){
   			
   			tasks.add(new Thread1());
   		}
   		/**等待执行完成**/
   		try {
   			@SuppressWarnings("unused")
			List<Future<Boolean>>  results = executorService.invokeAll(tasks);
   			System.out.println(results.size());
   			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			executorService.shutdown();
		}

	}
}
