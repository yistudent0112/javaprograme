package com.yi.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAdressTest {

	public static void main(String[] args) throws UnknownHostException {
		// ��ȡ������InetAddressʵ��
		InetAddress inetAddress = InetAddress.getLocalHost();
		System.out.println("�������� " + inetAddress.getHostName());
		System.out.println("ip��ַ��" + inetAddress.getHostAddress());
		// ��byte�������ʽ��ȡ������IP��ַ
		byte[] address = inetAddress.getAddress();
		System.out.println(Arrays.toString(address));
		//ֱ�Ӵ�ӡInetAddress���󣬵õ�������������ip��ַ
		System.out.println(inetAddress);
		
		//������������ȡInetAddress����
	InetAddress inetAddress2=InetAddress.getByName("XJIE");
	System.out.println("�������� " + inetAddress2.getHostName());
	System.out.println("ip��ַ��" + inetAddress2.getHostAddress());
	
	//����������ַ��ȡInetAddress����
	byte[]address1= {10,25,25,30};
	InetAddress inetAddress3=InetAddress.getByAddress(address1);
	System.out.println("�������� " + inetAddress3.getHostName());
	System.out.println("ip��ַ��" + inetAddress3.getHostAddress());
	}
}
