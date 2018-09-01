package com.yi.Math;

public class Math4 {
	//这题要实现一个pow函数，我是直接调用函数的,下面会总结一下pow函数的实现
	/*
	 * pow函数如果读入的指数只是整数类型的话，实现起来还是很简单的
	 * 即使读入的指数为负数的情况，也只要把底数取反就行了
	 * 但如果读入的指数是带小数的形式，问题就会变得复杂了
	 * 我目前还看不懂转换过程的原因，不过是有方法可以实现的
	 * 毕竟java自带的pow函数就是支持传入指数为double的
	 */
//	 public double myPow(double x, int n) {
//	        return Math.pow(x, n);
//	    }
	 //实现指数为int型 的pow函数,没有处理x过大的情况，运行速度会很慢
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
