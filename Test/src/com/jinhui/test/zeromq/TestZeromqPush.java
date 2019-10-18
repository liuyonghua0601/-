package com.jinhui.test.zeromq;

import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Context;
import org.zeromq.ZMQ.Socket;

public class TestZeromqPush {

	public static void main(String[] args) {
        Context context = ZMQ.context(1);
        Socket push = context.socket(ZMQ.PUSH);
        push.bind("ipc://fjs");
        for (int i = 0; i < 10000000; i++) {  
            push.send("hello".getBytes(), i);  
        }  
        push.close();  
        context.term();
	}
}
