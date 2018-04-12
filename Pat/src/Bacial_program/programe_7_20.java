package Bacial_program;

import java.util.Scanner;

/*
 * 本题要求对任意给定的一位正整数N，输出从1*1到N*N的部分口诀表。
 */
public class programe_7_20 {
	private static int n;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.close();
	}

	// 打印乘法表，只有10以内的数能够自动对齐
	public static void Print() {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				sum = i * j;
				System.out.print(i + "*" + j + "=" + sum + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		Print();
	}

}
