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
			clientSay=br.readLine();//readLine������ͨ��/n/r����Ϊ�������ģ����û�г��ֽ�����־
			//��һֱ����������״̬������д���ʱ��һ��Ҫ����
//			while((clientSay=br.readLine())!=null) {
//				System.out.println(clientSay);
//			}
			//System.out.println("test");
			if(clientSay==null) {
				System.out.println("���Ͷ�ʧ");
			}
			if(clientSay!=null) {
			System.out.println("�����Ƿ����  ���ͻ���˵ : "+clientSay);
			}
		//	connect.shutdownInput();//�رշ������������
			//4.ͨ���������ͻ��˷�����Ӧ����
			OutputStream os=connect.getOutputStream();
			PrintWriter pw=new PrintWriter(os);
			pw.write("�������ɹ����յ���Ϣ������׼���ظ�");
			pw.flush();
			pw.write("��������ɻظ�");
			pw.flush();
			connect.shutdownOutput();//�رշ�������������
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
