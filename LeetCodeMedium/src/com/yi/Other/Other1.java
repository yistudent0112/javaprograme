package com.yi.Other;

public class Other1 {
	/*
	 * 在设计上，
	 * 我考虑的是将int数字全部转换成二进制数字，然后做二进制加法，最后再转回为int类型结果
	 * 但是在java中byte类型的加法也是通过转换为int类型来实现的，所以这个方法并走不通
	 * 例       -1          加       -1         int  结果     -2      byte类型加法最后结果为上一种
	 *  1111,1111 1111,1111    byte  结果为       1111,1110
	 */
//	  public int getSum(int a, int b) {
//	        int result=0;
//	    byte[]a1=new byte[4];
//	    a1[0]=(byte)((a>>24)&0xFF);
//	    a1[1]=(byte)((a>>16)&0xFF);
//	    a1[2]=(byte)((a>>8)&0xFF);
//	    a1[3]=(byte)(a&0xFF);
//	    byte[]b1=new byte[4];
//	    b1[0]=(byte)((b>>24)&0xFF);
//	    b1[1]=(byte)((b>>16)&0xFF);
//	    b1[2]=(byte)((b>>8)&0xFF);
//	    b1[3]=(byte)(b&0xFF);
//	    byte[]result1=new byte[4];
//	    int count2=0;
//	    int count1=0;
//	    int count=0;
//	    if((((a1[3]&0x80)^(b1[3]&0x80))^((a1[3]&0x40)^(b1[3]&0x40)))==1) {
//	    	count2=1;
//	    }
//	    result1[3]=(byte) (b1[3]+a1[3]);
//	    if((((a1[2]&0x80)^(b1[2]&0x80))^((a1[2]&0x40)^(b1[2]&0x40)))==1) {
//	    	count1=1;
//	    }
//	    result1[2]=(byte) (b1[2]+a1[2]+count2);
//	    if((((a1[1]&0x80)^(b1[1]&0x80))^((a1[1]&0x40)^(b1[1]&0x40)))==1) {
//	    	count=1;
//	    }
//	    result1[1]=(byte) (b1[1]+a1[1]+count1);
//	    result1[0]=(byte) (b1[0]+a1[0]+count);
//	    result=result1[3] & 0xFF;
//	    result|=((result1[2] <<8)& 0xFF00);
//	    result|=((result1[1] <<16)& 0xFF0000);
//	    result|=((result1[0] <<24)& 0xFF0000);
//	        return result;
//	    }
	/*
	 * 这个是真正的二进制加法，做加法其实要考虑两部分事情
	 * 一个是简单的加法和  ，还有一个是进位的情况
	 * 然后再不断的递归这样的加法，直到进位为0时，就返回真正的加法和
	 * 
	 * 
	 * 比如是如何得出5+17=22这个结果的。实际上，我们可以分成两步进行：
	 * 1.只做各位相加不进位，此时相加的结果是12（个位数5和7相加不要进位是2，十位数0和1相加结果是1）。
	 * 2.做进位，5+7中有进位，进位的值是10;第三步把前面两个结果加起来，12+10的结果是22，刚好5+17=22。
	 */
	  public int getSum(int a, int b) {
		  if(b==0) {
			  return a;
		  }
		  //对两个数做异或操作就是得到没有进位的加法和，因为 当两个二进制数都是1时就会产生进位
		  int result=a^b;
		  //对两个数做与操作就是拿到进位，而要做左移操作时因为进位操作都是往上一位去做的
		  int count=(a&b)<<1;
		  //不断递归，直到进位数为0
		  return getSum(result,count);
	  }
	public static void main(String[] args) {
		Other1 test=new Other1();
		test.getSum(-8, -13);
		
System.out.println();
	}

}
