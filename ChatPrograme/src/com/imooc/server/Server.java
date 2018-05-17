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
    * @Description: TODO(�����ҷ����)  
    * @author Darren 
    * @date 2018��5��6��  
    *
 */
public class Server {
	/**
	 * �����ڷ���˵�ServerSocket��Ҫ����
	 * 1����ϵͳ����������˿�
	 *    �ͻ��˾���ͨ������˿���֮���ӵ�
	 * 2����������ķ���˿ڣ���һ���ͻ���ͨ����
	 *    �˿ڳ��Խ�������ʱ��ServerSocket
	 *    ���ڷ���˴���һ��Socket��ͻ��˽������ӡ�
	 */
	private ServerSocket server;
	
	/**
	 * �������пͻ���������ļ��ϣ�����������
	 * �ﵽ�㲥��Ч��
	 */
	private List<PrintWriter> allOut;
	
	
	/**
	 * ������ʼ������˵�
	     * ����һ���µ�ʵ�� Server.  
	     *
	 */
	public Server()throws Exception {
		/**
		 * ��ʼ����ͬʱ�������˿�
		 */
		server = new ServerSocket(8086);
		
		
		allOut = new ArrayList<PrintWriter>();
	}
	/**
	 * �������������(out��Ӧpw)���빲����
	    * @Title: addOut  
	    * @Description: TODO(������һ�仰�����������������)  
	    * @param @param out    ����  
	    * @return void    ��������  
	    * @throws
	 */
	private synchronized void  addOut(PrintWriter out) {
		allOut.add(out);
	}
	/**
	 * ��������������ӹ�������ɾ��
	    * @Title: removeOut  
	    * @Description: TODO(������һ�仰�����������������)  
	    * @param @param out    ����  
	    * @return void    ��������  
	    * @throws
	 */
	private synchronized void removeOut(PrintWriter out) {
		allOut.remove(out);
	}
	/**
	 * ����������Ϣ���͸����пͻ��ˣ�������
	 * ���Ƕ��󲻰�����Ϣ���ͷ�����Ϊsynchronized����������
	 * ������ɾ�Ĳ�ʱ�����������
	 * 
	    * @Title: sendMessage  
	    * @Description: TODO(������һ�仰�����������������)  
	    * @param @param message    ����  
	    * @return void    ��������  
	    * @throws
	 */
	private synchronized  void sendMessage(String message) {
		for(PrintWriter out : allOut) {//�����out�൱��pw
			out.println(message);
		}
	}
	
	
	/**
	 * ����˿�ʼ�����ķ���
	 */
	public void start() {
		try {
			/**
			 * ServerSocket��accept������һ������
			 * �����������Ǽ�������˿ڣ�ֱ��һ���ͻ�������
			 * ������һ��Socket��ʹ�ø�Socket
			 * ����������ӵĿͻ��˽��н���
			 */
			while(true) {
			System.out.println("�ȴ��ͻ������ӡ�����");
			Socket socket = server.accept();
			System.out.println("һ���ͻ��������ˣ�");
			/**
			 * ����һ���̣߳��������ÿͻ��˵Ľ���
			 * �������Ż���
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
			System.out.println("���������ʧ�ܣ�");
		}
	}
	/**
	 * ���̸߳�����һ���ͻ��˵Ľ���
	    * @ClassName: ClientHandler  
	    * @Description: TODO(������һ�仰��������������)  
	    * @author Darren 
	    * @date 2018��5��8��  
	    *
	 */
	class ClientHandler implements Runnable{
		/**
		 * ���̴߳���Ŀͻ��˵�Socket
		 */
		private Socket socket;
		
		//�ͻ��˵ĵ�ַ��Ϣ
		private String host;
		
		private String nickName;
		
		public ClientHandler(Socket socket) {
			this.socket=socket;
		    /**
		     * ͨ��Socket���Ի�ȡԶ�˼������
		     * ��ַ��Ϣ
		     */
			InetAddress address
			   = socket.getInetAddress();
			//��ȡip��ַ
			host = address.getHostAddress();
		}
		public void run() {
			PrintWriter pw = null;
			try {
				/**
				 * Socket�ṩ�ķ���
				 * InputStream getInputStream()
				 * �÷������Ի�ȡһ�����������Ӹ�����ȡ��
				 * ���ݾ��Ǵ�Զ�˼�������͹�����
				 */
				InputStream in = socket.getInputStream();
				
				InputStreamReader isr
				   = new InputStreamReader(in,"UTF-8");
				//����BufferedReader���ܴ����ֽ��������Խ���
				//InputStreamReaderת��һ��
				
				BufferedReader br
				    = new BufferedReader(isr);
				
				nickName = br.readLine();
				//���ȶ�ȡһ���ַ���Ϊ�ǳ�
				 System.out.println(nickName+"�����ˣ�");
				sendMessage(nickName+"�����ˣ�");
				
				/**
				 * ͨ��Socket������������ڽ���Ϣ
				 * ���͸��ͻ���
				 */
				OutputStream out
				   = socket.getOutputStream();
				
				OutputStreamWriter osw
				   = new OutputStreamWriter(out,"UTF-8");
				
			
			    pw = new PrintWriter(osw,true);//true�Զ���ˢ��
				/**
				 * ���ÿͻ��˵���������뵽��������
				 */
				addOut(pw);
				
				String message = null;
				/**
				 * br.readLine�ڶ�ȡ�ͻ��˷��͹�����
				 * ��Ϣ�ǣ����ڿͻ��˶��ߣ��������ϵͳ
				 * �Ĳ�ͬ�������ȡ��Ľ����ͬ��
				 * ��windows�Ŀͻ��˶Ͽ�ʱ��br.readLine
				 * ���׳��쳣
				 * ��linux�Ŀͻ��˶Ͽ�ʱ��br.readLine��
				 * ����null
				 * 
				 * ������finallyͳһ����
				 */
				while((message = br.readLine())!=null) {
				     System.out.println(nickName+"˵��"+message);
				     //pw.println(nickName+"˵��"+message);
				     //�㲥��Ϣ
				     sendMessage(nickName+"˵��"+message);
				}
			}catch(Exception e) {
				
			}finally {
				/**
				 * ����ǰ�ͻ��˶Ͽ�����߼�
				 */
				
				/**
				 * ���ÿͻ��˵�������ӹ�������ɾ��
				 */
				removeOut(pw);
				
				
				 System.out.println(nickName+"�����ˣ�");
				 sendMessage(nickName+"�����ˣ�");
				try {
					socket.close();
					//�������������Ҳ�͹���
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
