package com.yi.Math;
/*
 * 这道就平方根的题目，在数学上可以通过牛顿迭代法来实现
 * 牛顿迭代法的原理如下    先拿到要被开跟的数a，然后对他进行一次随机猜测，值为x
 * 然后对x进行一下迭代   x=(x+a/x)/2  经过6,7次的迭代之后就能够得出a的开跟答案了
 * 这道理的数学原理是如下的  
 * 可以参考一下网址  http://www.matrix67.com/blog/archives/361
 */
public class Math5 {
//	 public int mySqrt(int x) {
//	        return (int)Math.sqrt(x);
//	    }
	 public int mySqrt(int x) {
		 if(x<0) {
			 return Integer.MIN_VALUE;
		 }
		 if(x==0) {
			 return 0;
		 }
		 long result=x;
		 while(result*result>x) {
			 result=(result+x/result)/2;
		 }
		 return (int)result;
	 }
	public static void main(String[] args) {
		Math5 test=new Math5();
		test.mySqrt(4);

	}

}
