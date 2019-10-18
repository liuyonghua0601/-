package com.jinhui.test.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * 2017-11-28上午11:07:14
 * tcptest.java
 * author:liuyonghua
 */
public class tcptest {

	public static void main(String[] args) {
		try {
            //创建Socket对象
            //Socket socket=new Socket("192.168.127.254",502);
            Socket socket=new Socket("127.0.0.1",6000);
            socket.setSoTimeout(10000);
            //根据输入输出流和服务端连接
            OutputStream outputStream=socket.getOutputStream();//获取一个输出流，向服务端发送信息
            PrintWriter printWriter=new PrintWriter(outputStream);//将输出流包装成打印流
            //printWriter.print("服务端你好，我是Balla_兔子");
            byte[] data = new byte[7];
            data[0]=(byte)0xFF;
            data[1]=(byte)0x01;
            data[2]=(byte)0x00;
            data[3]=(byte)0x09;
            data[4]=(byte)0x00;
            data[5]=(byte)0x01;
            data[6]=(byte)0x0B;
            printWriter.print(data);
            printWriter.flush();
            //socket.shutdownOutput();//关闭输出流
            
            InputStream inputStream=socket.getInputStream();//获取一个输入流，接收服务端的信息
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);//包装成字符流，提高效率
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);//缓冲区
            String info="";
            String temp="";//临时变量
            while((temp=bufferedReader.readLine())!=null){
                info+=temp;
                System.out.println("客户端接收服务端发送信息："+info);
            }
            
            //关闭相对应的资源
            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

		
	}
}
