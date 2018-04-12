package Bacial_program;

import java.util.Scanner;

/*
 * 本题要求编写程序，计算两个有理数的和。
 */
public class programe_7_33 {
	private static String s1;
	private static String s2;
	private static int numerator1;
	private static int numerator2;
	private static int denominator1;
	private static int denominator2;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		s1 = in.next();
		String[] numbers = s1.split("/");
		numerator1 = Integer.valueOf(numbers[0]);	
		denominator1 = Integer.valueOf(numbers[1]);
		s2 = in.next();
		numbers = s2.split("/");
		numerator2 = Integer.valueOf(numbers[0]);
		denominator2 = Integer.valueOf(numbers[1]);
		in.close();
	}

	public static void Calculate() {
		int numerator = denominator1 * numerator2 + denominator2 * numerator1;
		int denominator = denominator1 * denominator2;
		System.out.println(numerator + "/" + denominator);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		Calculate();
	}

}
