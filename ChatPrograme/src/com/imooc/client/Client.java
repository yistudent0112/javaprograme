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
    * @Description: TODO(�����ҿͻ���)  
    * @author Darren 
    * @date 2018��5��6��  
    *
 */
public class Client {
	/**
	 * java.net.Socket
	 * ��װ��TCPЭ�飬ʹ�����Ϳ��Ի���TCP����
	 * ����ͨѶ
	 * Socket�������ڿͻ��˵�
	 */
	private Socket socket;
	/**
	 * ���췽����������ʼ���ͻ���
	 * ʵ����Socket��ʱ����Ҫ��������������
	 * 1������˵�ַ��ͨ��IP��ַ�����ҵ��������̨
	 * �����
	 * 2������˶˿ڣ�ͨ���˿ڿ����ҵ�����˼�����ϵ�
	 * �����Ӧ�ó���
	 * ʵ����Socket�Ĺ��̾������ӵĹ��̣���Զ�˼����
	 * û����Ӧ���׳��쳣��
	     * ����һ���µ�ʵ�� Client.  
	     * @throws Exception
	 */
	public Client() throws Exception{
		System.out.println("�������ӷ���ˡ�����");
		socket = new Socket(
				"localhost",8086);
		//localhost�Ǳ��ط���˵�ַ���������Լ�
		System.out.println("�������˽������ӣ�");
	} 
	/**
	 * �����ͻ��˵ķ���
	 */
	public void start() {
		try {
			Scanner scanner = new Scanner(System.in);
			String nickName = null;
			while(true) {
				System.out.println("����������ǳƣ�");
				nickName = scanner.nextLine();
				if(nickName.length()>0) {
					break;
				}
				System.out.println("��������");
			}
			System.out.println("��ӭ����"+nickName+"!��ʼ����ɣ�");
			
			/**
			 * ��Ҫ���û�����һ���ǳ�
			 */
			
			/**
			 * Socket�ṩ�ķ�����
			 * OutputStream getOutputStream
			 * ��ȡһ���ֽ��������ͨ������д��������
			 * �ᱻ������Զ�˼������
			 */
			OutputStream out
			   = socket.getOutputStream();
			
			OutputStreamWriter osw
			   = new OutputStreamWriter(out,"UTF-8");
			
			PrintWriter pw
			  = new PrintWriter(osw,true);//true�Զ���ˢ��
			
			//�ֽ��ǳƷ��͸������
			pw.println(nickName);
			
			
			/**
			 * ������ȡ����˷��͹�����Ϣ��
			 * �̡߳����һ���̣߳��൱�������Ż�
			 * ������ÿ�εȿͻ�������һ�仰���ͻ���
			 * �����յ�����˷����ģ��㲥��һ����Ϣ
			 */
			ServerHander handler
			   = new ServerHander();
			Thread t = new Thread(handler);
			t.start();
			
		    while(true) {
		    	/**
				 * ���ַ��������������
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
			System.out.println("�ͻ�������ʧ�ܣ�");
		}
	}
	
	/**
	 * ���߳�������ȡ����˷��͹�������Ϣ
	 * ��������ͻ��˿���̨��ʾ��
	    * @ClassName: ServerHander  
	    * @Description: TODO(������һ�仰��������������)  
	    * @author Darren 
	    * @date 2018��5��8��  
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







