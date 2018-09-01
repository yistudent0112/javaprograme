package com.yi.Math;

public class Math2 {
	/*
	 * 这道求阶乘数后有几个0的问题可以被转换成，在所有的阶乘数中出现了几次5，因为没加到一次5会出现多次2
	 * 就例如 1,2,3,4,5 中 出现一个5之前已经出现了多个2  所以问题就被转换成了 在 1到n的范围内出现了几次5
	 * 因为有25 这种 5*5 组成的数 所以结果并不是简单的n/5 还需要考虑到 25 50 这种数的情况
	 * 在这我是先算出这个数在5的几次方范围内 然后在把对应的多出的5的数量给加上去  
	 * 就比如5的二次方 的数中 例 25 50 75 会多一个5   5的三次方的数 125 250 会多两个5
	 * 这样找全所有的5   在看了网友的解答后我发现自己这个版本因为调用了math库函数
	 * 所以速度太慢了    运行效率不高，所以附上网友的快速版
	 */
//	 public int trailingZeroes(int n) {
//	        int result=n/5;
//	       int number=n;
//	       int length=0;
//	       while(number>=5) {
//	    	   length++;
//	    	   number=number/5;
//	       }
//	        int range=0;
//	        for(int i=2;i<=length;i++) {
//	        	range=(int)Math.pow(5, i);
//	        	result+=n/range;
//	        }
//	        return result;
//	    }
	 public int trailingZeroes(int n) {
		 int result=0;
		 while(n>4){
			 result+=n/5;
			 n=n/5;
		 }
		 return result;
	 }
	public static void main(String[] args) {
	Math2 test=new Math2();
	test.trailingZeroes(200);

	}

}
