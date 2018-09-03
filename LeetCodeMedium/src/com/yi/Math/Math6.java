package com.yi.Math;

public class Math6 {
	/*
	 * 这道除法我只考虑去处理int类型溢出的问题，也就是Integer.MIN__VALUE如果除以-1就会产生溢出
	 * 得到的值为Integer.MAX_VALUE大一的值，就变成了int类型最大值加一，变回最小值的情况了
	 * 处理方法也非常的简单，采用更大的long类型来存储数字，就能避免这个问题
	 * 
	 * 这道题想考的应该是计算机内除法的实现，我大致知道是通过移位操作来实现的
	 * 但后面具体的数学实现原理就不是特别的清楚了
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
