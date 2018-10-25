package com.imooc.ArraysAndString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/*
 *这道题 
 *我的做法是将读入的字符串去除空格后进行数字和符号的分离，
 *得到两个数组分别按照顺序存放数字和运算符。
 *然后遍历一下运算符，优先处理(* /)运算的操作符，
 *处理完之后，把对应的数字位更新，删除不需要的数字和运算符
 *例     数字数组为   2  3   3   4
 *  运算符数组为   +  *   /
 *  这里通过利用数字数组的长度为运算符数组长度加一的规律来定位 被运算数 和 运算数
 *  例   如果运算符的下标为1                读入String为    2 + 3 * 3 / 4 
 *    则被运算数对应的下标为1 运算数的下标为2   对应下标为        0 0 1 1 2 2 3  
 *  在遍历运算符数组的过程中发现了*，优先对这个乘运算做处理
 *  从数字数组中取出对应的操作数   得到运算结果为  3 * 3 =9
 *  将9放回运算数位置，更新他的运算后的值   数字数组为  2  3  9  4
 *                             运算符数组为  +  *  /
 *   删除多余的运算符和数字                    数字数组为 2  9  4
 *                          运算符数组为+  /                            
 *   对乘除运算做了优先处理之后，就可以简单的执行加减运算了
 *   过程和上面一样 
 *   这个方法运行速度不快，排44%
 *   好的方法是只把加减运算符给放入运算符数组，对于乘除操作就直接执行
 *   这样就能够节省空间了 
 */
public class ArraysAndString9 {
	public int calculate(String s) {
		s = s.replaceAll(" ", "");
		if (s != null && !Objects.equals(s, "")) {
			List<Integer> numbers = new ArrayList<Integer>();
			List<Character> operators = new ArrayList<Character>();
			int length = s.length();
			int numberStart=0;
			int numberLength=0;
			for (int i = 0; i < length; i++) {
				if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					numberLength++;
				} else {
					if(numberLength>0) {
						numbers.add(Integer.valueOf(s.substring(numberStart, numberStart+numberLength)));
					}
					operators.add(s.charAt(i));
					numberStart=i+1;
					numberLength=0;
				}
			}
			if(numberLength>0) {
				numbers.add(Integer.valueOf(s.substring(numberStart, numberStart+numberLength)));
			}
			//int numberLength = numbers.size();
			int operatorLength = operators.size();
			// int numberIndex=0;
			// int operatorIndex=0;
			int index=0;
			while(index<operators.size()) {
				if(operators.get(index)=='*') {
					numbers.set(index+1, numbers.get(index)*numbers.get(index+1));
					numbers.remove(index);
					operators.remove(index);
				}else if(operators.get(index)=='/') {
					numbers.set(index+1, numbers.get(index)/numbers.get(index+1));
					numbers.remove(index);
					operators.remove(index);
				}else {
					index++;
				}
			}
//			for (int i = 0; i < operatorLength; i++) {
//				if (operators.get(i) == '*') {
//					numbers.set(i + 1, numbers.get(i) * numbers.get(i + 1));
//					numbers.remove(i);
//					operators.remove(i);
//					i=-1;
//					operatorLength = operators.size();
//				} else if (operators.get(i) == '/') {
//					numbers.set(i + 1, numbers.get(i) / numbers.get(i + 1));
//					numbers.remove(i);
//					operators.remove(i);
//					i=-1;
//					operatorLength = operators.size();
//				}
//			}
		
			operatorLength = operators.size();
			for (int i = 0; i < operatorLength; i++) {
				if (operators.get(i) == '+') {
					numbers.set(i + 1, numbers.get(i) + numbers.get(i + 1));
				} else if (operators.get(i) == '-') {
					numbers.set(i + 1, numbers.get(i) - numbers.get(i + 1));
				}
	    	 else if(operators.get(i)=='*') {
	    		 numbers.set(i+1, numbers.get(i)*numbers.get(i+1));
	    	 }else if(operators.get(i)=='/') {
	    		 numbers.set(i+1, numbers.get(i)/numbers.get(i+1));
	    	 }
			}
			// System.out.println(s);
			return numbers.get(operatorLength);
		} else {
			return -1;
		}

	}

	public static void main(String[] args) {
		ArraysAndString9 test = new ArraysAndString9();
		int a = test.calculate("2+3/3");
		System.out.println(a);
	}

}
