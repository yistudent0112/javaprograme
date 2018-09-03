package com.yi.Math;
/*
 * �����ƽ��������Ŀ������ѧ�Ͽ���ͨ��ţ�ٵ�������ʵ��
 * ţ�ٵ�������ԭ������    ���õ�Ҫ����������a��Ȼ���������һ������²⣬ֵΪx
 * Ȼ���x����һ�µ���   x=(x+a/x)/2  ����6,7�εĵ���֮����ܹ��ó�a�Ŀ�������
 * ��������ѧԭ�������µ�  
 * ���Բο�һ����ַ  http://www.matrix67.com/blog/archives/361
 */
public class Math5 {
//	 public int mySqrt(int x) {
//	        return (int)Math.sqrt(x);
//	    }
	 public int mySqrt(int x) {
		 if(x<0) {
			 return Integer.MIN_VALUE;
		 }
		 if(x==0) {
			 return 0;
		 }
		 long result=x;
		 while(result*result>x) {
			 result=(result+x/result)/2;
		 }
		 return (int)result;
	 }
	public static void main(String[] args) {
		Math5 test=new Math5();
		test.mySqrt(4);

	}

}
