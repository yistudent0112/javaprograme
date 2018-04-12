package Bacial_program;

import java.util.Scanner;

/*
 * 我们已经知道了将N个整数按从小到大排序的冒泡排序法。
 * 本题要求将此方法用于字符串序列，
 * 并对任意给定的K（<N），
 * 输出扫描完第K遍后的中间结果序列。
 */
public class programe_7_30 {
	private static int N;
	private static int K;
	private static String[] s;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
		s=new String[N];
		for (int i = 0; i < N; i++) {
			s[i] = in.next();
		}
		in.close();
	}

	public static void BubbleSort() {
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (!compare(s[j], s[j + 1])) {
					String temp = s[j];
					s[j] = s[j + 1];
					s[j + 1] = temp;
				}
			}
		}
	}

	public static void Print() {
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i] + " ");
		}
	}

	public static boolean compare(String a, String b) {
		int flag=a.compareTo(b);
		if (flag<0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		BubbleSort();
		Print();
	}

}
