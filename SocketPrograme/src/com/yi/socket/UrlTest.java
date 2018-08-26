package com.yi.socket;

import java.net.MalformedURLException;
import java.net.URL;
/**
 * 
 * Url类的基本操作
 *
 */
public class UrlTest {

	public static void main(String[] args) {
		try {
			//创建一个url实例对象
			URL imooc=new URL("https://www.imooc.com");
			//?后面表示的是参数，#后面表示的是锚点
			URL url=new URL(imooc, "/index.html?username=tom#test");
			System.out.println("协议："+url.getProtocol());
			System.out.println("主机："+url.getHost());
			//如果为指定端口号，则使用协议默认的端口号，此时getPort()返回值为-1
			System.out.println("端口号："+url.getPort());
			System.out.println("文件路径："+url.getPath());
			System.out.println("文件名："+url.getFile());
			System.out.println("相对路径："+url.getRef());
			System.out.println("查询关键字："+url.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
