package com.imooc.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 
    * @ClassName: Server  
    * @Description: TODO(聊天室服务端)  
    * @author Darren 
    * @date 2018年5月6日  
    *
 */
public class Server {
	/**
	 * 运行在服务端的ServerSocket主要负责：
	 * 1：向系统申请服务器端口
	 *    客户端就是通过这个端口与之连接的
	 * 2：监听申请的服务端口，当一个客户端通过该
	 *    端口尝试建立连接时，ServerSocket
	 *    会在服务端创建一个Socket与客户端建立连接。
	 */
	private ServerSocket server;
	
	/**
	 * 保存所有客户端输出流的集合，用来遍历，
	 * 达到广播的效果
	 */
	private List<PrintWriter> allOut;
	
	
	/**
	 * 用来初始化服务端的
	     * 创建一个新的实例 Server.  
	     *
	 */
	public Server()throws Exception {
		/**
		 * 初始化的同时申请服务端口
		 */
		server = new ServerSocket(8086);
		
		
		allOut = new ArrayList<PrintWriter>();
	}
	/**
	 * 将给定的输出流(out对应pw)存入共享集合
	    * @Title: addOut  
	    * @Description: TODO(这里用一句话描述这个方法的作用)  
	    * @param @param out    参数  
	    * @return void    返回类型  
	    * @throws
	 */
	private synchronized void  addOut(PrintWriter out) {
		allOut.add(out);
	}
	/**
	 * 将给定的输出流从共享集合中删除
	    * @Title: removeOut  
	    * @Description: TODO(这里用一句话描述这个方法的作用)  
	    * @param @param out    参数  
	    * @return void    返回类型  
	    * @throws
	 */
	private synchronized void removeOut(PrintWriter out) {
		allOut.remove(out);
	}
	/**
	 * 将给定的消息发送给所有客户端（遍历）
	 * 但是对象不包括消息发送方，因为synchronized（本）队列
	 * 进行增删改查时，不允许遍历
	 * 
	    * @Title: sendMessage  
	    * @Description: TODO(这里用一句话描述这个方法的作用)  
	    * @param @param message    参数  
	    * @return void    返回类型  
	    * @throws
	 */
	private synchronized  void sendMessage(String message) {
		for(PrintWriter out : allOut) {//这里的out相当于pw
			out.println(message);
		}
	}
	
	
	/**
	 * 服务端开始工作的方法
	 */
	public void start() {
		try {
			/**
			 * ServerSocket的accept方法是一个阻塞
			 * 方法，作用是监听服务端口，直到一个客户端连接
			 * 并创建一个Socket，使用该Socket
			 * 即可与刚连接的客户端进行交互
			 */
			while(true) {
			System.out.println("等待客户端连接。。。");
			Socket socket = server.accept();
			System.out.println("一个客户端连接了！");
			/**
			 * 启动一个线程，来完成与该客户端的交互
			 * （另立门户）
			 */
			ClientHandler handler
			    = new ClientHandler(socket);
			Thread t = new Thread(handler);
			t.start();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("服务端启动失败！");
		}
	}
	/**
	 * 该线程负责处理一个客户端的交互
	    * @ClassName: ClientHandler  
	    * @Description: TODO(这里用一句话描述这个类的作用)  
	    * @author Darren 
	    * @date 2018年5月8日  
	    *
	 */
	class ClientHandler implements Runnable{
		/**
		 * 该线程处理的客户端的Socket
		 */
		private Socket socket;
		
		//客户端的地址信息
		private String host;
		
		private String nickName;
		
		public ClientHandler(Socket socket) {
			this.socket=socket;
		    /**
		     * 通过Socket可以获取远端计算机的
		     * 地址信息
		     */
			InetAddress address
			   = socket.getInetAddress();
			//获取ip地址
			host = address.getHostAddress();
		}
		public void run() {
			PrintWriter pw = null;
			try {
				/**
				 * Socket提供的方法
				 * InputStream getInputStream()
				 * 该方法可以获取一个输入流，从该流读取的
				 * 数据就是从远端计算机发送过来的
				 */
				InputStream in = socket.getInputStream();
				
				InputStreamReader isr
				   = new InputStreamReader(in,"UTF-8");
				//由于BufferedReader不能处理字节流，所以借助
				//InputStreamReader转换一下
				
				BufferedReader br
				    = new BufferedReader(isr);
				
				nickName = br.readLine();
				//首先读取一行字符串为昵称
				 System.out.println(nickName+"上线了！");
				sendMessage(nickName+"上线了！");
				
				/**
				 * 通过Socket创建输出流用于将消息
				 * 发送给客户端
				 */
				OutputStream out
				   = socket.getOutputStream();
				
				OutputStreamWriter osw
				   = new OutputStreamWriter(out,"UTF-8");
				
			
			    pw = new PrintWriter(osw,true);//true自动行刷新
				/**
				 * 将该客户端的输出流存入到共享集合中
				 */
				addOut(pw);
				
				String message = null;
				/**
				 * br.readLine在读取客户端发送过来的
				 * 消息是，由于客户端断线，而其操作系统
				 * 的不同，这里读取后的结果不同：
				 * 当windows的客户端断开时：br.readLine
				 * 会抛出异常
				 * 当linux的客户端断开时：br.readLine会
				 * 返回null
				 * 
				 * 所以用finally统一处理
				 */
				while((message = br.readLine())!=null) {
				     System.out.println(nickName+"说："+message);
				     //pw.println(nickName+"说："+message);
				     //广播消息
				     sendMessage(nickName+"说："+message);
				}
			}catch(Exception e) {
				
			}finally {
				/**
				 * 处理当前客户端断开后的逻辑
				 */
				
				/**
				 * 将该客户端的输出流从共享集合中删除
				 */
				removeOut(pw);
				
				
				 System.out.println(nickName+"下线了！");
				 sendMessage(nickName+"下线了！");
				try {
					socket.close();
					//关这个，两个流也就关了
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
