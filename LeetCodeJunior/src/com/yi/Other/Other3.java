package com.yi.Other;
/*
 * 这道题只需要调用Integer类的一个函数就能够实现对于的int类型的数作二进制转换的功能了
 * 通过观察源码，我看懂了这个reverse函数的实现原理，在此记录一下
 *  public static int reverse(int i) {
        这一步将32位的二进制数每隔一位进行一次互换 因为55H 等于 01010101B 所以正好实现了两位间的左右互换
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
        这一步将32位的二进制每隔二位进行一次互换 33H 等于 00110011B
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
        这一步将32位的二进制每隔四位进行一次互换  0fH 等于 00001111B
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
        这一步是将32位的二进制每隔8位进行一次互换 例 原来位 ABCDH 被更改位DCBAH
        原理如下 假设输入为ABCDH 第一个操作得到的是 D000H 第二个操作得到的是 0C00H 
        第三个操作得到的是 00B0H 第四个操作得到的是 000AH
        i = (i << 24) | ((i & 0xff00) << 8) |
            ((i >>> 8) & 0xff00) | (i >>> 24);
        return i;
        这个函数的原理就是逐步的做左右交换，直到完成全部的交换 非常的巧妙，时间复杂度很低
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
