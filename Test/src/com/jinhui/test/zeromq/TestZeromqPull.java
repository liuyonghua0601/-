package com.jinhui.test.zeromq;

import java.util.concurrent.atomic.AtomicInteger;

import org.zeromq.ZMQ;

public class TestZeromqPull {

	public static void main(String[] args) {
		final AtomicInteger number = new AtomicInteger(0);  
	    for (int i = 0; i < 5; i++) {  
	        new Thread(new Runnable(){  
	            private int here = 0;  
	            public void run() {  
	                // TODO Auto-generated method stub  
	                ZMQ.Context context = ZMQ.context(1);  
	                ZMQ.Socket pull = context.socket(ZMQ.PULL);  
	                pull.connect("ipc://fjs");  
	                //pull.connect("ipc://fjs");  
	                while (true) {  
	                    String message = new String(pull.recv());  
	                    int now = number.incrementAndGet();  
	                    here++;  
	                    if (now % 1000000 == 0) {  
	                        System.out.println(now + "  here is : " + here);  
	                    }  
	                }  
	            }                
	        }).start();               
	    }  
	}
}
