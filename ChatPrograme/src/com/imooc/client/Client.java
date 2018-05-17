package com.imooc.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 
    * @ClassName: Client  
    * @Description: TODO(聊天室客户端)  
    * @author Darren 
    * @date 2018年5月6日  
    *
 */
public class Client {
	/**
	 * java.net.Socket
	 * 封装了TCP协议，使用它就可以基于TCP进行
	 * 网络通讯
	 * Socket是运行在客户端的
	 */
	private Socket socket;
	/**
	 * 构造方法，用来初始化客户端
	 * 实例化Socket的时候需要传入两个参数：
	 * 1：服务端地址：通过IP地址可以找到服务的那台
	 * 计算机
	 * 2：服务端端口：通过端口可以找到服务端计算机上的
	 * 服务端应用程序
	 * 实例化Socket的过程就是连接的过程，若远端计算机
	 * 没有响应会抛出异常。
	     * 创建一个新的实例 Client.  
	     * @throws Exception
	 */
	public Client() throws Exception{
		System.out.println("正在连接服务端。。。");
		socket = new Socket(
				"localhost",8086);
		//localhost是本地服务端地址，这里连自己
		System.out.println("已与服务端建立连接！");
	} 
	/**
	 * 启动客户端的方法
	 */
	public void start() {
		try {
			Scanner scanner = new Scanner(System.in);
			String nickName = null;
			while(true) {
				System.out.println("请输入你的昵称：");
				nickName = scanner.nextLine();
				if(nickName.length()>0) {
					break;
				}
				System.out.println("输入有误！");
			}
			System.out.println("欢迎您，"+nickName+"!开始聊天吧！");
			
			/**
			 * 先要求用户输入一个昵称
			 */
			
			/**
			 * Socket提供的方法：
			 * OutputStream getOutputStream
			 * 获取一个字节输出流，通过该流写出的数据
			 * 会被发送至远端计算机。
			 */
			OutputStream out
			   = socket.getOutputStream();
			
			OutputStreamWriter osw
			   = new OutputStreamWriter(out,"UTF-8");
			
			PrintWriter pw
			  = new PrintWriter(osw,true);//true自动行刷新
			
			//现将昵称发送给服务端
			pw.println(nickName);
			
			
			/**
			 * 启动读取服务端发送过来消息的
			 * 线程。另加一个线程，相当于另立门户
			 * ，不必每次等客户端输入一句话，客户端
			 * 才能收到服务端发来的（广播）一条消息
			 */
			ServerHander handler
			   = new ServerHander();
			Thread t = new Thread(handler);
			t.start();
			
		    while(true) {
		    	/**
				 * 将字符串发送至服务端
				 */
			
			pw.println(scanner.nextLine());
		    }
						
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Client client = new Client();
			client.start();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("客户端启动失败！");
		}
	}
	
	/**
	 * 该线程用来读取服务端发送过来的消息
	 * 并输出到客户端控制台显示。
	    * @ClassName: ServerHander  
	    * @Description: TODO(这里用一句话描述这个类的作用)  
	    * @author Darren 
	    * @date 2018年5月8日  
	    *
	 */
	class ServerHander implements Runnable{
		public void run() {
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader isr
				   = new InputStreamReader(in,"UTF-8");
				BufferedReader br
				   = new BufferedReader(isr);
				String message = null;
				while((message = br.readLine())!=null) {
					System.out.println(message);
				}
			}catch(Exception e) {
				
			}
		}
	}
}







