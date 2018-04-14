package Basical.program.set;

import java.util.Scanner;

/*
 * 根据下面关系式，求圆周率的值，直到最后一项的值小于给定阈值。
*/

public class programe_7_15 {
	private static double pi;
	private static double threshold;// 阀值

	public static void Input() {
		Scanner in = new Scanner(System.in);
		threshold = in.nextDouble();
		in.close();
	}

	public static void Calculate() {
		double sum = 1;
		int n = 1;
		double temp = 1;
		//当没有满足阀值的精度是，循环计算下一个值
		while (threshold < temp) {	
			temp=0;
			int numerator = 1;
			int denominator = 1;
			for (int i = 1; i <= n; i++) {
				//给分子赋值
				numerator = numerator * i;
				//给分母赋值
				denominator = denominator * (2 * i + 1);
				//System.out.println(numerator);
				//System.out.println(denominator);
			}
			temp = (double) numerator / denominator;
			//System.out.println(temp);
			n++;
			sum += temp;
		}
		pi = sum * 2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		Calculate();
		System.out.println(pi);
	}

}
