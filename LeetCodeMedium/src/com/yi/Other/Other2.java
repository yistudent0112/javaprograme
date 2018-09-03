package com.yi.Other;

import java.util.LinkedList;
/*
 * �����ûʲô�ѵ㣬ֻҪ���������沨��ʽ��ԭ����ܹ�����ջ��д�����ʽ��
 * ����沨��ʽ��ʹ����Ҫ��Ϊ�˷�����������Ϊ�����ŵ���ʽ���˱Ƚ�������⣬���Ի����Ͳ�������
 * �˵ĳ��ñ��ʽ    (2+1)*3     �沨��ʽ    2 1 + 3 *
 * һ��ʼ����Ƴ���ʱ�����ǵ����Ȱ����ָ����ֳ������ٴ����������������������ʱ(-1)���׺�-(����)����
 * ��ȻҲ�ܹ����𣬵����߼���Ƚϻ���
 * ����ͨ���ȴ�����������������Ķ���Ϊ����ѹջ����������һ����
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
