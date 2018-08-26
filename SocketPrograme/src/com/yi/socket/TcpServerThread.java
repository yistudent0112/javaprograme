package com.yi.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpServerThread extends Thread {
private Socket connect=null;
public TcpServerThread(Socket socket) {
	this.connect=socket;
}
	@Override
public void run() {
		try {
			InputStream is = connect.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			
			//System.out.println(br.read());
			String clientSay=null;
			br.read();
			System.out.println("test");
			clientSay=br.readLine();//readLine函数是通过/n/r来作为结束符的，如果没有出现结束标志
			//会一直处于阻塞的状态，所以写入的时候一定要换行
//			while((clientSay=br.readLine())!=null) {
//				System.out.println(clientSay);
//			}
			//System.out.println("test");
			if(clientSay==null) {
				System.out.println("发送丢失");
			}
			if(clientSay!=null) {
			System.out.println("这里是服务端  ，客户端说 : "+clientSay);
			}
		//	connect.shutdownInput();//关闭服务器的输出流
			//4.通过输出流向客户端发送响应数据
			OutputStream os=connect.getOutputStream();
			PrintWriter pw=new PrintWriter(os);
			pw.write("服务器成功接收到消息，正在准备回复");
			pw.flush();
			pw.write("服务器完成回复");
			pw.flush();
			connect.shutdownOutput();//关闭服务器的输入流
			connect.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
