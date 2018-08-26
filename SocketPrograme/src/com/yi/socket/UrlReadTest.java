package com.yi.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * 使用Url来读取网页内容
 */
public class UrlReadTest {

	public static void main(String[] args) {
		try {
			//新建一个百度官网的url连接
			URL baidu=new URL("https://www.baidu.com/");
			//通过openStream方法获取url对象所表示的资源的字节输入流
			InputStream is=baidu.openStream();
			//将字节输入流转化成字符输入流
			InputStreamReader isr=new InputStreamReader(is,"utf-8");
			//将字符输入流转添加缓冲
			BufferedReader br=new BufferedReader(isr);
			String word=br.readLine();//读取缓冲过去的一句话
			//当缓冲区存在内容时，不断的循环读取
			while(null!=word) {
				//打印结果
				System.out.println(word);
				word=br.readLine();
			}
			br.close();//关闭缓冲
			isr.close();//关闭字符流
			is.close();//关闭字节流
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
