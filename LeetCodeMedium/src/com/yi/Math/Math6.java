package com.yi.Math;

public class Math6 {
	/*
	 * ���������ֻ����ȥ����int������������⣬Ҳ����Integer.MIN__VALUE�������-1�ͻ�������
	 * �õ���ֵΪInteger.MAX_VALUE��һ��ֵ���ͱ����int�������ֵ��һ�������Сֵ�������
	 * ������Ҳ�ǳ��ļ򵥣����ø����long�������洢���֣����ܱ����������
	 * 
	 * ������뿼��Ӧ���Ǽ�����ڳ�����ʵ�֣��Ҵ���֪����ͨ����λ������ʵ�ֵ�
	 * ������������ѧʵ��ԭ��Ͳ����ر�������
	 */
public int divide(int dividend, int divisor) {
	long divisor1=(long)divisor;
        long result=(long) (dividend/divisor1);
        if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE) {
        	result=(long) Integer.MAX_VALUE;
        }
        return (int)result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
