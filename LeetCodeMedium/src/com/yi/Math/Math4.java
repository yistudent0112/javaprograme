package com.yi.Math;

public class Math4 {
	//����Ҫʵ��һ��pow����������ֱ�ӵ��ú�����,������ܽ�һ��pow������ʵ��
	/*
	 * pow������������ָ��ֻ���������͵Ļ���ʵ���������Ǻܼ򵥵�
	 * ��ʹ�����ָ��Ϊ�����������ҲֻҪ�ѵ���ȡ��������
	 * ����������ָ���Ǵ�С������ʽ������ͻ��ø�����
	 * ��Ŀǰ��������ת�����̵�ԭ�򣬲������з�������ʵ�ֵ�
	 * �Ͼ�java�Դ���pow��������֧�ִ���ָ��Ϊdouble��
	 */
//	 public double myPow(double x, int n) {
//	        return Math.pow(x, n);
//	    }
	 //ʵ��ָ��Ϊint�� ��pow����,û�д���x���������������ٶȻ����
	 public double myPow(double x, int n) {
		 double result=1;
		 if(n==0||x==1) {
			 return 1;
		 }
		 if(n<0) {
			 x=1/x;
			 n=-n;
		 }
		 for(int i=0;i<n;i++) {
			 result*=x;
		 }
		 return result;
	 }
	public static void main(String[] args) {
		Math4 test=new Math4();
		double num=test.myPow(2.0, -2);
        System.out.println(num);
	}

}
