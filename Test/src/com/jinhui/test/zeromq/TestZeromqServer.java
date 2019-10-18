package com.jinhui.test.zeromq;

import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Context;
import org.zeromq.ZMQ.Socket;

public class TestZeromqServer {

	public static void main(String[] args) throws InterruptedException {
	       Context context = ZMQ.context(1);
	       Socket publisher = context.socket(ZMQ.PUB);
	       publisher.bind("tcp://*:5555");
	       Thread.sleep(3000);
	       for(int i=0;i<100;i++){
	           publisher.send(("admin " + i).getBytes(), ZMQ.NOBLOCK);
	           System.out.println("pub msg " + i);  
	           Thread.sleep(1000);  
	       }
	       context.close();
	       publisher.close();
	   }
}
