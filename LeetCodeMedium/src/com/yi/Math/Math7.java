package com.yi.Math;

import java.util.ArrayList;
/*
 *这道题的难点在于区分无限循环小数和有限小数，而对于无限循环小数来说又要准确的找到小数的循环部分  
 *例  要 区分   0.2  和    0.11111111    还要区分       0.16666666  和    0.3333333333
 *一开始我直接保存小数部分，发现这样并没有办法区分后一种情况，后来发现需要记录的是每次除法运算之后余数
 *如果余数出现重复，就代表了循环的开始   那么在循环之前的数就应该被写在(的前面
 *这个算法的具体步骤是如下这样的
 *先通过做long类型的除法    拿到整数部分的值，同时也拿到余数
 *接着处理小数部分
 *然后就模拟除法运算的过程，对后面借位(余数*10)去除以除数，如果被除数还不够大，就继续去借位
 *通过不断的重复上面的过程，直到余数为0(结果为有限小数)，或者余数产生了重复停止(结果为无限循环小数)
 *然后去找直到那个重复的余数第一次出现的地方，把在他之前算出的数(也就是非循环小数)在(前先输出
 *然后在(输出循环部分的小数)
 *最后根据结果正负号打印结果
 *
 *这里需要注意的是Int类型的溢出问题，因为存在各种各样的可能导致溢出
 *所以所有的处理都要使用long类型来避免这一类问题    
 *溢出举例    -Integer.MIN_VALUE   /   -1   这时候值为     Integer.MAX_VALUE  +1   产生了溢出
 */
public class Math7 {
	public String fractionToDecimal(int numerator, int denominator) {
		//判断除数和被除数为0的情况
		  if(numerator==0){
	          return "0";
	      }
	      if(denominator==0){
	          return "";
	      }
		StringBuffer result = new StringBuffer();
		boolean flag1 = true;
		boolean flag2 = true;
		boolean loop = false;
		if (numerator < 0) {
			flag1 = false;
		}
		if (denominator < 0) {
			flag2 = false;
		}
		//把除数，被除数，整数部分，余数都转成long类型
		long absNumerator = Math.abs((long)numerator);
		long absDenominator = Math.abs((long)denominator);
		//代表整数部分的结果
		long res = absNumerator / absDenominator;
		long remainder = absNumerator % absDenominator;
		//结果为负数时，加上-号
		if ((flag1 && !flag2) || (!flag1 && flag2)) {
			result.append("-");
		}
		
		if (remainder == 0) {
			result.append(res);
		} else {
			result.append(res);
			//对小数部分的处理
			result.append(".");
			StringBuffer sb = new StringBuffer();
			//存放余数的容器
			ArrayList<Long> list = new ArrayList<Long>();
			while (remainder > 0) {
				//如果余数不重复，就继续运算
				if (!list.contains(new Long(remainder))) {
					list.add(remainder);
					sb.append(remainder * 10 / absDenominator);
					remainder = remainder * 10 % absDenominator;
				} else {
					list.add(remainder);
					loop = true;
					break;
				}
			}
			if (loop) {
				//处理非循环部分的小数
				int index = list.indexOf(list.get(list.size() - 1));

				for (int i = 0; i < index; i++) {
					result.append(sb.charAt(0));
					sb.deleteCharAt(0);
				}

				result.append("(");
				result.append(sb);
				result.append(")");
			} else {
				result.append(sb);
			}
		}
		return result.toString();
	}

	// public String fractionToDecimal(int numerator, int denominator) {
	// String result="";
	// if(numerator==0) {
	// return "0";
	// }
	// if(denominator==0) {
	// return result;
	// }
	// long absNumerator=Math.abs(numerator);
	// long absDenominator=Math.abs(denominator);
	// int res=(int) (absNumerator/absDenominator);
	// int remainder=(int)(absNumerator%absDenominator);
	// while(remainder>0&&) {
	//
	// }
	// if((numerator>0&&denominator>0)||(numerator<0&&denominator<0)) {
	// return result;
	// }else {
	// return "-"+result;
	// }
	// }
	public static void main(String[] args) {
		Math7 test = new Math7();
		test.fractionToDecimal(-2147483648, 1);
	}
}
