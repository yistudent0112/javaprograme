package com.yi.Other;
/*
 * �����ֻ��Ҫ����Integer���һ���������ܹ�ʵ�ֶ��ڵ�int���͵�����������ת���Ĺ�����
 * ͨ���۲�Դ�룬�ҿ��������reverse������ʵ��ԭ���ڴ˼�¼һ��
 *  public static int reverse(int i) {
        ��һ����32λ�Ķ�������ÿ��һλ����һ�λ��� ��Ϊ55H ���� 01010101B ��������ʵ������λ������һ���
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
        ��һ����32λ�Ķ�����ÿ����λ����һ�λ��� 33H ���� 00110011B
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
        ��һ����32λ�Ķ�����ÿ����λ����һ�λ���  0fH ���� 00001111B
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
        ��һ���ǽ�32λ�Ķ�����ÿ��8λ����һ�λ��� �� ԭ��λ ABCDH ������λDCBAH
        ԭ������ ��������ΪABCDH ��һ�������õ����� D000H �ڶ��������õ����� 0C00H 
        �����������õ����� 00B0H ���ĸ������õ����� 000AH
        i = (i << 24) | ((i & 0xff00) << 8) |
            ((i >>> 8) & 0xff00) | (i >>> 24);
        return i;
        ���������ԭ������𲽵������ҽ�����ֱ�����ȫ���Ľ��� �ǳ������ʱ�临�ӶȺܵ�
    }
 */
public class Other3 {
	  public int reverseBits(int n) {
		
	       return Integer.reverse(n);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Other3 test=new Other3();
test.reverseBits(1);
//int a=1;
//System.out.println(test.reverseBits(a));
//a++;
//System.out.println(test.reverseBits(a));
	}

}
