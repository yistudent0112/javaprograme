package com.yi.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * UDPЭ��socketͨѶ�еķ����
 */
public class UDPServer {

	public static void main(String[] args) {
		try {
			//1.����DatagramSocket��ָ���˿ں�
			DatagramSocket server=new DatagramSocket(8008);
			//2.����DatagramPacket
			byte[]data=new byte[8096];
			DatagramPacket packet=new DatagramPacket(data, data.length);
			//3.���տͻ��˷���ʱ��������Ϣ
			server.receive(packet);//�˷����ڽ��յ����ݱ�֮ǰ��һֱ����
			//4.��ȡ����
			String word=new String(packet.getData());
			System.out.println("�����Ƿ���� , �ͻ���˵ ��"+word);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
