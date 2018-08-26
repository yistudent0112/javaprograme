package com.yi.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAdressTest {

	public static void main(String[] args) throws UnknownHostException {
		// 获取本机的InetAddress实例
		InetAddress inetAddress = InetAddress.getLocalHost();
		System.out.println("主机名： " + inetAddress.getHostName());
		System.out.println("ip地址：" + inetAddress.getHostAddress());
		// 已byte数组的形式获取本机的IP地址
		byte[] address = inetAddress.getAddress();
		System.out.println(Arrays.toString(address));
		//直接打印InetAddress对象，得到的是主机名和ip地址
		System.out.println(inetAddress);
		
		//根据主机名获取InetAddress对象
	InetAddress inetAddress2=InetAddress.getByName("XJIE");
	System.out.println("主机名： " + inetAddress2.getHostName());
	System.out.println("ip地址：" + inetAddress2.getHostAddress());
	
	//根据主机地址获取InetAddress对象
	byte[]address1= {10,25,25,30};
	InetAddress inetAddress3=InetAddress.getByAddress(address1);
	System.out.println("主机名： " + inetAddress3.getHostName());
	System.out.println("ip地址：" + inetAddress3.getHostAddress());
	}
}
