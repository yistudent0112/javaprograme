package Bacial_program;

import java.util.Scanner;

/*
 * ����Ҫ������������һλ������N�������1*1��N*N�Ĳ��ֿھ���
 */
public class programe_7_20 {
	private static int n;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.close();
	}

	// ��ӡ�˷���ֻ��10���ڵ����ܹ��Զ�����
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
