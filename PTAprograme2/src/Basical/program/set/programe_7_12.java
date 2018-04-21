package Basical.program.set;

import java.util.Scanner;

/*
 * 本题要求编写一个简单计算器程序，可根据输入的运算符，
 * 对2个整数进行加、减、乘、除或求余运算。
 * 题目保证输入和输出均不超过整型范围
 * 输入在一行中依次输入操作数1、运算符、操作数2，其间以1个空格分隔。
 * 操作数的数据类型为整型，且保证除法和求余的分母非零。
 * 当运算符为+、-、*、/、%时，在一行输出相应的运算结果。
 * 若输入是非法符号（即除了加、减、乘、除和求余五种运算符以外的其他符号）
 * 则输出ERROR。
 */
public class programe_7_12 {
	private static int type = 0;
	private static int a;
	private static int b;

	// 返回值为-1时，表明输入的运算符有问题
	public static int Calculate() {
		int result = -1;
		switch (type) {
		case 1:
			result = a + b;
			break;
		case 2:
			result = a - b;
			break;
		case 3:
			result = a * b;
			break;
		case 4:
			result = (int) a / b;
			break;
		case 5:
			result = a % b;
			break;
		default:
			System.out.println("error");
		}
		return result;
	}

	public static void input() {
		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		String temp = in.next();
		b = in.nextInt();
		in.close();
		/*
		 * 给不同的运算赋予不同的type值作为标记， 当出现未标明运算符时，type值为-1
		 */
		if (temp.equals("+")) {
			type = 1;
		} else if (temp.equals("-")) {
			type = 2;
		} else if (temp.equals("*")) {
			type = 3;
		} else if (temp.equals("/")) {
			type = 4;
		} else if (temp.equals("%")) {
			type = 5;
		} else {
			type = -1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		System.out.println(Calculate());
	}

}
