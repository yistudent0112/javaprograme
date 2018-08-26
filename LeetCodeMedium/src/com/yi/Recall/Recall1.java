package com.yi.Recall;

import java.util.ArrayList;
import java.util.List;
/*
 * �������Ҫ�����˻����㷨��������⣬
 * �����㷨���Ƕ�һ����������(��ÿһ�㶼�ж���״�����ж�������)�Ķ����������һ�δε�������أ�
 * ��������˲�����𰸵���������˻���һ�ε�������������¿�ʼ����
 * �е������ͼ����ȱ������ҵ�һ���ڵ�����û���ӽڵ��ˣ��������ˣ�һֱ�˵����ҵ��ڶ���·�����
 * ��Ҳ�Ǹոտ�ʼѧϰ�������㷨��˼��Ҳ�����ر��˽�
 * 2018/8/19
 */
public class Recall1 {
	//�绰���ֶ�Ӧ����ĸ�ֵ䣬��0~9��Ӧ���ֵ�
	 static String []numbers= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	 public List<String> letterCombinations(String digits) {
		 //�������������Ͻ����list
	        List<String>result=new ArrayList<String>();
	        if(digits==null||digits.length()==0) {
	        	return result;
	        }
	        backTracking(digits, result, 0, "");
	        return result;
	    }
	 //�ݹ���ú�����Ҳ�ǻ����㷨��ʵ��
	 public static void backTracking(String digits,List<String> result,int flag,String s) {
		//�������˳�����������ҵ��Ľ�������Ѿ�����Ҫ���ˣ��Ͱѽ����ӽ�list��
		 //����ҵ��Ľ�����Ȼ������Ļ����ͼ����ݹ�ȥѰ�ҽ��
		 if(flag>=digits.length()) {
			 result.add(s);
			 return ;
		 }
		 //���ֵ����ó���ǰ��������Ӧ����ĸ������������Ϊ��Ѱ�ҵ�Ŀ��
		 //�����ҵ���һ����ܵĸ��ַ����·��
		 String chars=numbers[digits.charAt(flag)-'0'];
		 //ͨ��forѭ���Ѹ��ַ����·��������һ��
		 for(int i=0;i<chars.length();i++) {
			 //һ�����İѴ�Ѱ�ҵ�Ŀ��ĸ��ֿ��ܸ�Ѱ��һ��
			 //�ҵ�һ��·��������һ�ֿ��ܣ��������µ�һ�ֵݹ�
			 backTracking(digits, result, flag+1, s+chars.charAt(i));
		 }
	 }
	public static void main(String[] args) {
		Recall1 test=new Recall1();
		test.letterCombinations("2345");

	}

}
