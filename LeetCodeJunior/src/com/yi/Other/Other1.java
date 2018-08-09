package com.yi.Other;
/**
 * 
 * 在给Long类型赋值的时候，要注意java内存机制会把所有没有被修饰过的数
 * 都默认为int类型，长度为4个字节
 * 例 long a=2147483648 此时右边的数字在堆中会被当做int类型处理，
 * 就超出了int值的范围，会报错
 * long a=2147483648L 多加一个long就告诉了堆需要的是8个字节的空间，就不会报错了
 * 在这个赋值的过程中，是将左边的long 类型的变量a
 * 在栈中的内容指向他真正在堆中存贮的数据内容
 *而不是直接的把在栈中的变量a的信息写成对应的2147483648
 */
/**
 * 在这个函数的判断中，不能使用0作为判断条件来判断，因为读入的数是被认为为无符号数读进来的
 * 而java中又没有无符号数这一类型，所以当读入的数大于2147483647时
 * ，读入的数就用负数来代替比它大的数了
 * 
 */
public class Other1 {
	public int hammingWeight( int n) {
//		System.out.println(n);
//		int count=0;
//        while(n!=0){//由于每次n和n-1相与都会导致，n的最右边的为1的元素变成0，因此总共要循环的次数就是1的个数次。
//            count++;
//            n=(n-1)&n;
//        }
//        return count;
	
		int number=0;
		while(n!=0) {
			if((1&n)==1) {
				number++;
			}
			n= n>>>1;
		}
		return number;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub0x80000000
		Other1 test=new Other1();
		//System.out.println(test.hammingWeight(0x80000000));
//int a=0xffffffff;
//System.out.println(a);
//System.out.println(a+1);
//a=-2;
//System.out.println(Integer.toBinaryString(a));
		int a=0xffffffff;
		Long b=(long)a+1L;
		System.out.println(b);
		Long c=(long)a;
		System.out.println(c);
	}

}
