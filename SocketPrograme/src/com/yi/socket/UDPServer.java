package com.yi.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * UDP协议socket通讯中的服务端
 */
public class UDPServer {

	public static void main(String[] args) {
		try {
			//1.创建DatagramSocket，指定端口号
			DatagramSocket server=new DatagramSocket(8008);
			//2.创建DatagramPacket
			byte[]data=new byte[8096];
			DatagramPacket packet=new DatagramPacket(data, data.length);
			//3.接收客户端发送时的数据信息
			server.receive(packet);//此方法在接收到数据报之前会一直阻塞
			//4.读取数据
			String word=new String(packet.getData());
			System.out.println("这里是服务端 , 客户端说 ："+word);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
