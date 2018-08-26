package com.yi.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * socket的输入输出流的关闭有一些学问，现在还没弄懂，记录一下
 */
public class TCPServer {

	public static void main(String[] args) {
		try {
			//1.创建一个ServerSocket对象，绑定监听端口
			ServerSocket serverSocket=new ServerSocket(8811);
			//2.通过accept()方法监听客户端请求
			System.out.println("服务端准备就绪,等待客户端的连接  ");
			Socket connect=null;
//			//3.连接建立后，通过输入流读取客户端发送的请求信息
//			InputStream is=connect.getInputStream();
//			InputStreamReader isr=new InputStreamReader(is);
//			BufferedReader br=new BufferedReader(isr);
//			
//			//System.out.println(br.read());
//			String clientSay=null;
//			br.read();
//			System.out.println("test");
//			clientSay=br.readLine();//readLine函数是通过/n/r来作为结束符的，如果没有出现结束标志
//			//会一直处于阻塞的状态，所以写入的时候一定要换行
////			while((clientSay=br.readLine())!=null) {
////				System.out.println(clientSay);
////			}
//			//System.out.println("test");
//			if(clientSay==null) {
//				System.out.println("发送丢失");
//			}
//			if(clientSay!=null) {
//			System.out.println("这里是服务端  ，客户端说 : "+clientSay);
//			}
//		//	connect.shutdownInput();//关闭服务器的输出流
//			//4.通过输出流向客户端发送响应数据
//			OutputStream os=connect.getOutputStream();
//			PrintWriter pw=new PrintWriter(os);
//			pw.write("服务器成功接收到消息，正在准备回复");
//			pw.flush();
//			pw.write("服务器完成回复");
//			pw.flush();
//			connect.shutdownOutput();//关闭服务器的输入流
//			connect.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("io exception");
//			e.printStackTrace();
//		}finally {
//			//5.关闭资源
//			//connect.close();
//		}
//	
			while(true) {
				connect=serverSocket.accept();
				TcpServerThread serverthread=new TcpServerThread(connect);
				serverthread.run();
				InetAddress address=connect.getInetAddress();
				System.out.println(address);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
	}



