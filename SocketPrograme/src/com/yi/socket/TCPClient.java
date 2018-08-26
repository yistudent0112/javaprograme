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
			//1.����socket����ָ����Ҫ���ӵķ������ĵ�ַ�Ͷ˿ں�
			Socket clientSocket=new Socket("localhost", 8811);
			//2.���ӽ�����ͨ���������������˷���������Ϣ
			OutputStream os=clientSocket.getOutputStream();
			PrintWriter pw=new PrintWriter(os);
			//pw.write("�û��� �� admin ���� ��123");
			//printwriter ��write������print������������ϻ��з�����println���������һ�����з�
			//����bufferedreader�ڶ�ȡ��ʱ��Ͳ��ᷢ��������������
			pw.println("�û��� �� yi ���� ��123456");
			pw.flush();
			System.out.println("���ͳɹ�");
			//clientSocket.shutdownOutput();
			//3.ͨ����������ȡ����������Ӧ��Ϣ
			InputStream is=clientSocket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			String serverSay=br.readLine();
			System.out.println("�����ǿͻ���  �������˵ : "+serverSay);	
			//4.�ر���Դ
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
