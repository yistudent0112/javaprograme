package com.yi.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {

	public static void main(String[] args) {
		try {
			//1.���巢����Ϣ���������ĵ�ַ�Ͷ˿���Ϣ
			InetAddress address=InetAddress.getByName("localhost");
			int port=8008;
			String message="�û��� :admin ,���� ��123";
			byte[] word=message.getBytes();
			//2.����DatagramPacket,������Ҫ���͵���Ϣ
			DatagramPacket packet=new DatagramPacket(word, word.length,address,port);
			//3.����DatagramSocket
			DatagramSocket socket=new DatagramSocket();
			//4.��������
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
