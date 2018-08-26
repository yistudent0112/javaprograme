package com.yi.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * ʹ��Url����ȡ��ҳ����
 */
public class UrlReadTest {

	public static void main(String[] args) {
		try {
			//�½�һ���ٶȹ�����url����
			URL baidu=new URL("https://www.baidu.com/");
			//ͨ��openStream������ȡurl��������ʾ����Դ���ֽ�������
			InputStream is=baidu.openStream();
			//���ֽ�������ת�����ַ�������
			InputStreamReader isr=new InputStreamReader(is,"utf-8");
			//���ַ�������ת��ӻ���
			BufferedReader br=new BufferedReader(isr);
			String word=br.readLine();//��ȡ�����ȥ��һ�仰
			//����������������ʱ�����ϵ�ѭ����ȡ
			while(null!=word) {
				//��ӡ���
				System.out.println(word);
				word=br.readLine();
			}
			br.close();//�رջ���
			isr.close();//�ر��ַ���
			is.close();//�ر��ֽ���
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
