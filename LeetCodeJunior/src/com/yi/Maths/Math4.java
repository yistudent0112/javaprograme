package com.yi.Maths;

import java.util.HashMap;
import java.util.Map;
/*
 * �������ֵ����㷨�� :
 * 1.��ͬ��������д������ʾ�����ֵ�����Щ��ͬ������ӵĺ� �� III=3
 * 2.С�������ڴ�����ֵ��ұߣ�����ʾ�����ֵ�����Щ������ӵõ����� ��XII=12
 * 3.С������(����I,X,C)�ڴ�����ֵ���ߣ�����ʾ�����ֵ��ڴ�����С�����õ��Ĳ�
 * ��  IV=4  IX=9
 * 4.��һ���������滭һ�����ߣ���ʾ���������ֵ1000��
 */
public class Math4 {
//	private static final int I=1;
//	private static final int V=5;
//	private static final int X=10;
//	private static final int L=50;
//	private static final int C=100;
//	private static final int D=500;
//	private static final int M=1000;
	   public int romanToInt(String s) {
	        int result=0;
	        Map<Character,Integer >romanNumber=new HashMap<Character,Integer>();
	        romanNumber.put('I', 1);
	        romanNumber.put('V', 5);
	        romanNumber.put('X', 10);
	        romanNumber.put('L', 50);
	        romanNumber.put('C', 100);
	        romanNumber.put('D', 500);
	        romanNumber.put('M', 1000);
	        int digit=0;
	        //�����Ǵ��������ֵ����λ��ʼ��ȡ������ģ����������λ
	        for(int i=0,length=s.length();i<length;i++) {
	        	digit=romanNumber.get(s.charAt(i));
	        	//Ҫ����С����������������ȡ�����һ���ַ�ʱ�������������ֵ����һλ��
	        	//ֱ�Ӱ���һλ�����ּӸ����������
	        	
	        	if(i>=length-1||(digit>=romanNumber.get(s.charAt(i+1)))) {
	        	result+=digit;
	        	}else {
	        		result-=digit;
	        	}
	        }
	        return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Math4 test=new Math4();
test.romanToInt("IX");
	}

}
