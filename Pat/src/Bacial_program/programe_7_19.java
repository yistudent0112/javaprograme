package Bacial_program;

import java.util.Scanner;

/*
 * 一个采购员去银行兑换一张y元f分的支票，结果出纳员错给了f元y分。
 * 采购员用去了n分之后才发觉有错，于是清点了余额尚有2y元2f分，问该支票面额是多少？
 * 输入在一行中给出小于100的正整数n。
 * 在一行中按格式y.f输出该支票的原始面额。如果无解，则输出No Solution。
 */
public class programe_7_19 {
	private static double n;
	private static double f;
	private static double y;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.close();
	}

	public static void Calculate() {
		if (n < 0 || n > 98) {
			System.out.println("No Solution.");
		} else {
			f = (199 - 2 * n) / 3;
			y = (98 - n) / 3;
			System.out.println("the price is " + y + "." + f);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		Calculate();
	}

}
