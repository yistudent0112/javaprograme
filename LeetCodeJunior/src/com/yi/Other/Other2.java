package com.yi.Other;

public class Other2 {
	/**
	 * �������ǽ�����������������Ȼ��Ѷ�Ӧ�Ľ���ڶ������У�1�������������ͽ�����
	 * ����ʹ����һ��Ч����ߵ�����������1���㷨
	 * ԭ������
	 * ��һ������n��ȥ1���ٺ�ԭ�������������㣬
	 * ��Ѹ����������ұߵ�1���0��
	 * ��ô��һ�������Ķ��������ж��ٸ�1��
	 * �Ϳ��Խ��ж��ٴ������Ĳ�����ѭ��������������nΪ0��
	 * 
	 */
	 public int hammingDistance(int x, int y) {
	        int num=x^y;
	        int count=0;
	        while(num!=0) {
	        	  count++;
	              num=(num-1)&num;
	        }
	        return count;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Other2 test=new Other2();
test.hammingDistance(1, 4);
	}

}
