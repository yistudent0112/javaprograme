package com.yi.DynamicPrograme;

/**
 * 
 * ����ʹ���˶�̬�滮��˼�����������
 * ��̬�滮����������Ҫ���
 * 1.�����ӽṹ  2.�߽�  3.״̬ת����ʽ
 * ���������¥�ݵ�������˵
 * ���ڵ�n��¥����˵���Ŀ������Ϊ��һ������һ��¥�ݻ�����һ����������¥��
 * ��ô�Ϳ��Եõ�һ�������ӽṹ��     S(10)=S(9)+S(8)
 * �߽��ǵ�¥�ݸ���Ϊ1��2ʱ�����Եõ�һ��ȷ�е�ֵ S(1)=1��S(2)=2
 * ״̬ת����ʽΪ  S(n)=S(n-1)+S(n-2)
 * ��������У����ֵҲ���õ���쳲���������
 *
 */

public class DynamicPrograme1 {
	 public int climbStairs(int n) {
	        if(n==1||n==2) {
	        	return n;
	        }
	       int a=1;
	       int b=2;
	       int result=0;
	        for(int i=2;i<n;i++) {
	        	result=a+b;
	        	a=b;
	        	b=result;
	        }
	        return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
