package com.yi.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) {
		
		try {
			//1.创建socket对象，指明需要连接的服务器的地址和端口号
			Socket clientSocket=new Socket("localhost", 8811);
			//2.连接建立后，通过输出流向服务器端发送请求消息
			OutputStream os=clientSocket.getOutputStream();
			PrintWriter pw=new PrintWriter(os);
			//pw.write("用户名 ： admin 密码 ：123");
			//printwriter 的write函数和print函数都不会加上换行符，而println函数会加上一个换行符
			//这样bufferedreader在读取的时候就不会发生阻塞的现象了
			pw.println("用户名 ： yi 密码 ：123456");
			pw.flush();
			System.out.println("发送成功");
			//clientSocket.shutdownOutput();
			//3.通过输入流获取服务器的响应信息
			InputStream is=clientSocket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			String serverSay=br.readLine();
			System.out.println("这里是客户端  ，服务端说 : "+serverSay);	
			//4.关闭资源
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
