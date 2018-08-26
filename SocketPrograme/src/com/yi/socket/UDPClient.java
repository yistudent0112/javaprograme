package com.yi.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {

	public static void main(String[] args) {
		try {
			//1.定义发送信息，服务器的地址和端口信息
			InetAddress address=InetAddress.getByName("localhost");
			int port=8008;
			String message="用户名 :admin ,密码 ：123";
			byte[] word=message.getBytes();
			//2.创建DatagramPacket,包含将要发送的信息
			DatagramPacket packet=new DatagramPacket(word, word.length,address,port);
			//3.创建DatagramSocket
			DatagramSocket socket=new DatagramSocket();
			//4.发送数据
			socket.send(packet);
			socket.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
