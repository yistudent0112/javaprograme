package com.yi.Math;

public class Math2 {
	/*
	 * �����׳������м���0��������Ա�ת���ɣ������еĽ׳����г����˼���5����Ϊû�ӵ�һ��5����ֶ��2
	 * ������ 1,2,3,4,5 �� ����һ��5֮ǰ�Ѿ������˶��2  ��������ͱ�ת������ �� 1��n�ķ�Χ�ڳ����˼���5
	 * ��Ϊ��25 ���� 5*5 ��ɵ��� ���Խ�������Ǽ򵥵�n/5 ����Ҫ���ǵ� 25 50 �����������
	 * ��������������������5�ļ��η���Χ�� Ȼ���ڰѶ�Ӧ�Ķ����5������������ȥ  
	 * �ͱ���5�Ķ��η� ������ �� 25 50 75 ���һ��5   5�����η����� 125 250 �������5
	 * ������ȫ���е�5   �ڿ������ѵĽ����ҷ����Լ�����汾��Ϊ������math�⺯��
	 * �����ٶ�̫����    ����Ч�ʲ��ߣ����Ը������ѵĿ��ٰ�
	 */
//	 public int trailingZeroes(int n) {
//	        int result=n/5;
//	       int number=n;
//	       int length=0;
//	       while(number>=5) {
//	    	   length++;
//	    	   number=number/5;
//	       }
//	        int range=0;
//	        for(int i=2;i<=length;i++) {
//	        	range=(int)Math.pow(5, i);
//	        	result+=n/range;
//	        }
//	        return result;
//	    }
	 public int trailingZeroes(int n) {
		 int result=0;
		 while(n>4){
			 result+=n/5;
			 n=n/5;
		 }
		 return result;
	 }
	public static void main(String[] args) {
	Math2 test=new Math2();
	test.trailingZeroes(200);

	}

}
