package com.yi.Maths;

import java.util.HashMap;
import java.util.Map;
/*
 * 罗马数字的运算法则 :
 * 1.相同的数字连写，所表示的数字等于这些相同数字相加的和 例 III=3
 * 2.小的数字在大的数字的右边，所表示的数字等于这些数字相加得到的数 例XII=12
 * 3.小的数字(限于I,X,C)在大的数字的左边，所表示的数字等于大数减小数所得到的差
 * 例  IV=4  IX=9
 * 4.在一个数的上面画一条横线，表示这个数字增值1000倍
 */
public class Math4 {
//	private static final int I=1;
//	private static final int V=5;
//	private static final int X=10;
//	private static final int L=50;
//	private static final int C=100;
//	private static final int D=500;
//	private static final int M=1000;
	   public int romanToInt(String s) {
	        int result=0;
	        Map<Character,Integer >romanNumber=new HashMap<Character,Integer>();
	        romanNumber.put('I', 1);
	        romanNumber.put('V', 5);
	        romanNumber.put('X', 10);
	        romanNumber.put('L', 50);
	        romanNumber.put('C', 100);
	        romanNumber.put('D', 500);
	        romanNumber.put('M', 1000);
	        int digit=0;
	        //这里是从罗马数字的最高位开始读取并运算的，而不是最低位
	        for(int i=0,length=s.length();i<length;i++) {
	        	digit=romanNumber.get(s.charAt(i));
	        	//要考虑小标溢出的情况，当读取到最后一个字符时，代表罗马数字的最后一位，
	        	//直接把这一位的数字加给结果就行了
	        	
	        	if(i>=length-1||(digit>=romanNumber.get(s.charAt(i+1)))) {
	        	result+=digit;
	        	}else {
	        		result-=digit;
	        	}
	        }
	        return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Math4 test=new Math4();
test.romanToInt("IX");
	}

}
