package com.yi.socket;

import java.net.MalformedURLException;
import java.net.URL;
/**
 * 
 * Url��Ļ�������
 *
 */
public class UrlTest {

	public static void main(String[] args) {
		try {
			//����һ��urlʵ������
			URL imooc=new URL("https://www.imooc.com");
			//?�����ʾ���ǲ�����#�����ʾ����ê��
			URL url=new URL(imooc, "/index.html?username=tom#test");
			System.out.println("Э�飺"+url.getProtocol());
			System.out.println("������"+url.getHost());
			//���Ϊָ���˿ںţ���ʹ��Э��Ĭ�ϵĶ˿ںţ���ʱgetPort()����ֵΪ-1
			System.out.println("�˿ںţ�"+url.getPort());
			System.out.println("�ļ�·����"+url.getPath());
			System.out.println("�ļ�����"+url.getFile());
			System.out.println("���·����"+url.getRef());
			System.out.println("��ѯ�ؼ��֣�"+url.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
