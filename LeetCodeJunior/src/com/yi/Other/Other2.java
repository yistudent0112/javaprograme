package com.yi.Other;

public class Other2 {
	/**
	 * 这道题就是将两个数做异或操作，然后把对应的结果在二进制中，1的数量数出来就结束了
	 * 这里使用了一个效率最高的数二级制中1的算法
	 * 原理如下
	 * 把一个整数n减去1，再和原来的整数与运算，
	 * 会把该整数的最右边的1变成0，
	 * 那么，一个整数的二进制中有多少个1，
	 * 就可以进行多少次这样的操作。循环结束的条件是n为0；
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
