package Basical.program.set;

import java.util.Scanner;

/*
 * ������������A��B�������A��B�����������Լ���Щ���ĺ͡�
 */
public class programe_7_14 {
	private static int A;
	private static int B;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		A = in.nextInt();
		B = in.nextInt();
		in.close();
	}

	public static void OutPut() {
		if (A >= B) {
			System.out.println("Invaild Input");
		}
		int sum = 0;
		int temp = 0;
		for (int i = A; i <= B; i++) {
			System.out.print(i + "\t");
			sum += i;
			//temp�������Ƹ��������ֽ��л��д���
			temp++;
			if (temp % 5 == 0) {
				System.out.println();
			}	
		}
		System.out.println("sum : " + sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		OutPut();
	}

}