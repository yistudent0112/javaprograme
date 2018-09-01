package com.yi.Math;

public class Math3 {
	/*
	 * �������excel��Ӧ�е���ĸ��ӡ��Ӧ���ֲ���
	 * ��Ҫ��Ҫȷ��ÿһ����ĸ����Ӧ�Ļ���    
	 * ͨ��������ĸ���ַ�������ռ��λ����ȷ�����ǻ����Ĵ�С
	 * ��     A        B        C
	 *    ��        ��        ��
	 * ����Ϊ26��2�η�  1�η�      0�η���(1)
	 * ȷ���˻�����Ѱ�ҽ�ͺܼ���
	 */
	 public int titleToNumber(String s) {
	        if(s==null||s.length()==0){
	            return 0;
	        }
	        int length=s.length();
	        int result=0;
	        int base=0;
	        for(int i=length-1;i>=0;i--) {
	        	base=(int)Math.pow(26, i);
	        	result+=base*(s.charAt(length-1-i)+1-'A');
	        }
	        return result;
	    }
	public static void main(String[] args) {
	Math3 test=new Math3();
	test.titleToNumber("AZ");

	}

}
