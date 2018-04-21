package Bacial_program;

import java.util.Scanner;

/*
 * 输入一个字符串和一个非负整数N，
 * 要求将字符串循环左移N次。
 */
public class programe_7_31 {
	private static String word;
	private static int N;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		word = in.nextLine();
		N = in.nextInt();
		in.close();
	}

	/*
	 * 先进行局部反转，在全局反转
	 */
	public static void LeftMove() {
		if (N < 0) {
			System.out.println(" invalid input ");
		} else {
			String first = word.substring(0, N);
			String second = word.substring(N);
			first = ReChange(first);
			second = ReChange(second);
			String result = first + second;
			result = ReChange(result);
			System.out.println(result);
		}
	}

	/*
	 * 先全局反转，在局部反转
	 */
	public static void RightMove() {
		if (N < 0) {
			System.out.println(" invalid input ");
		} else {
			String result = word;
			result = ReChange(result);
			String first = result.substring(0, N);
			String second = result.substring(N);
			first = ReChange(first);
			second = ReChange(second);
			result = first + second;
			System.out.println(result);
		}
	}

	/*
	 * 把输入的字符串反转后并返回
	 */
	public static String ReChange(String words) {
		char[] result = words.toCharArray();
		for (int i = 0; i < (result.length / 2); i++) {
			char temp = words.charAt(i);
			result[i] = result[result.length - i - 1];
			result[result.length - i - 1] = temp;
		}
		return String.valueOf(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		LeftMove();
		RightMove();
	}

}
