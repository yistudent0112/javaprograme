package com.yi.array;

/**
 * 
 * @ClassName: Array7
 * @Description: TODO 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。 最高位数字存放在数组的首位，
 *               数组中每个元素只存储一个数字。 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * @author yi
 * @date 2018年7月15日
 *
 */
public class Array7 {
	public int[] plusOne(int[] digits) {
		int index = 1;
		digits[digits.length - index] = (digits[digits.length - index] + 1) % 10;
		while (((digits[digits.length - index]) % 10) == 0) {
			index++;
			//如果加一后会发生位溢出，那只有可能结果是1开头后面跟0的数字
			if(index>digits.length) {
				int[] res=new int[digits.length+1];
				res[0]=1;
				return res;
			}
			digits[digits.length - index] = (digits[digits.length - index] + 1) % 10;
		}
		
		return digits;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array7 test = new Array7();
		int[] digits = {  9 };
		test.plusOne(digits);
	}

}
