package Bacial_program;

import java.util.Scanner;

/*
 * ����Ҫ���д����
 * ����N����������ƽ��ֵ��
 */
public class programe_7_35 {
	private static int numerator;
	private static int denominator;
	private static int N;
	private static double Sum;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		String temp;
		for (int i = 0; i < N; i++) {
			temp=in.next();
			String []temps=temp.split("/");
			numerator = Integer.valueOf(temps[0]);
			denominator = Integer.valueOf(temps[1]);
			Sum += (double)numerator / denominator;
		}
		in.close();
	}

	public static double GetSum() {
		return Sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		System.out.println(GetSum());
	}

}
