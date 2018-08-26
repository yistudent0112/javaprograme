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
 * socket������������Ĺر���һЩѧ�ʣ����ڻ�ûŪ������¼һ��
 */
public class TCPServer {

	public static void main(String[] args) {
		try {
			//1.����һ��ServerSocket���󣬰󶨼����˿�
			ServerSocket serverSocket=new ServerSocket(8811);
			//2.ͨ��accept()���������ͻ�������
			System.out.println("�����׼������,�ȴ��ͻ��˵�����  ");
			Socket connect=null;
//			//3.���ӽ�����ͨ����������ȡ�ͻ��˷��͵�������Ϣ
//			InputStream is=connect.getInputStream();
//			InputStreamReader isr=new InputStreamReader(is);
//			BufferedReader br=new BufferedReader(isr);
//			
//			//System.out.println(br.read());
//			String clientSay=null;
//			br.read();
//			System.out.println("test");
//			clientSay=br.readLine();//readLine������ͨ��/n/r����Ϊ�������ģ����û�г��ֽ�����־
//			//��һֱ����������״̬������д���ʱ��һ��Ҫ����
////			while((clientSay=br.readLine())!=null) {
////				System.out.println(clientSay);
////			}
//			//System.out.println("test");
//			if(clientSay==null) {
//				System.out.println("���Ͷ�ʧ");
//			}
//			if(clientSay!=null) {
//			System.out.println("�����Ƿ����  ���ͻ���˵ : "+clientSay);
//			}
//		//	connect.shutdownInput();//�رշ������������
//			//4.ͨ���������ͻ��˷�����Ӧ����
//			OutputStream os=connect.getOutputStream();
//			PrintWriter pw=new PrintWriter(os);
//			pw.write("�������ɹ����յ���Ϣ������׼���ظ�");
//			pw.flush();
//			pw.write("��������ɻظ�");
//			pw.flush();
//			connect.shutdownOutput();//�رշ�������������
//			connect.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("io exception");
//			e.printStackTrace();
//		}finally {
//			//5.�ر���Դ
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



