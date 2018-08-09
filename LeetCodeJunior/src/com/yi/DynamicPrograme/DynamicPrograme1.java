package com.yi.DynamicPrograme;

/**
 * 
 * 这里使用了动态规划的思想来解决问题
 * 动态规划中有三个重要概念：
 * 1.最优子结构  2.边界  3.状态转换公式
 * 对于这道爬楼梯的问题来说
 * 对于第n级楼梯来说他的可能情况为上一次爬了一节楼梯或者上一次爬了两节楼梯
 * 那么就可以得到一个最优子结构即     S(10)=S(9)+S(8)
 * 边界是当楼梯个数为1或2时，可以得到一个确切的值 S(1)=1，S(2)=2
 * 状态转换公式为  S(n)=S(n-1)+S(n-2)
 * 在这道题中，这个值也正好等于斐波那契数列
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
