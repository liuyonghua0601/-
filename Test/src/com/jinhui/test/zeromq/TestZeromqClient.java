package com.jinhui.test.zeromq;

import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Context;
import org.zeromq.ZMQ.Socket;

public class TestZeromqClient {

	public static void main(String[] args) {
		Context context = ZMQ.context(1);
        Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.connect("tcp://localhost:5555");
         subscriber.subscribe("".getBytes());  
         for (int i=0;i<100;i++) {  
             //Receive a message.       
             String string = new String(subscriber.recv(0));           
             System.out.println("recv 1" + string);  
         }       
         //关闭套接字和上下文  
         subscriber.close();  
         context.term();  
	}
}
