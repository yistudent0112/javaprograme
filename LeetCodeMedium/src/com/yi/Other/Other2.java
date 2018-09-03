package com.yi.Other;

import java.util.LinkedList;
/*
 * 这道题没什么难点，只要理解了这个逆波兰式的原理就能够利用栈来写出解答公式了
 * 这个逆波兰式的使用主要是为了方便计算机，因为多括号的形式对人比较容易理解，但对机器就不容易了
 * 人的常用表达式    (2+1)*3     逆波兰式    2 1 + 3 *
 * 一开始我设计程序时，考虑的是先把数字给区分出来，再处理运算符，但这样处理负数时(-1)容易和-(减号)混淆
 * 虽然也能够区别，但是逻辑会比较混乱
 * 可以通过先处理运算符，将其他的都作为数字压栈，来避免这一问题
 */
public class Other2 {
	public int evalRPN(String[] tokens) {
		int result = 0;
		if (tokens == null || tokens.length == 0) {
			return result;
		}
		int length = tokens.length;
		LinkedList<String> stack = new LinkedList<String>();
		String temp = null;
		int a = 0;
		int b = 0;
		int res = 0;
		for (int i = 0; i < length; i++) {
			temp = tokens[i];
			switch (temp) {
			case "+":
				b = Integer.valueOf(stack.pop());
				a = Integer.valueOf(stack.pop());
				res = a + b;
				stack.push(res + "");
				break;
			case "-":
				b = Integer.valueOf(stack.pop());
				a = Integer.valueOf(stack.pop());
				res = a - b;
				stack.push(res + "");
				break;
			case "*":
				b = Integer.valueOf(stack.pop());
				a = Integer.valueOf(stack.pop());
				res = a * b;
				stack.push(res + "");
				break;
			case "/":
				b = Integer.valueOf(stack.pop());
				a = Integer.valueOf(stack.pop());
				res = a / b;
				stack.push(res + "");
				break;
			default:
				stack.push(temp);
			}

		}
		result = Integer.valueOf(stack.pop());
		return result;
	}

	public static void main(String[] args) {
		String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		Other2 test = new Other2();
		test.evalRPN(tokens);
	}

}
