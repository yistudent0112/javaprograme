package Basical.program.set;

import java.util.Scanner;

/*
 * ���������ϵʽ����Բ���ʵ�ֵ��ֱ�����һ���ֵС�ڸ�����ֵ��
*/

public class programe_7_15 {
	private static double pi;
	private static double threshold;// ��ֵ

	public static void Input() {
		Scanner in = new Scanner(System.in);
		threshold = in.nextDouble();
		in.close();
	}

	public static void Calculate() {
		double sum = 1;
		int n = 1;
		double temp = 1;
		//��û�����㷧ֵ�ľ����ǣ�ѭ��������һ��ֵ
		while (threshold < temp) {	
			temp=0;
			int numerator = 1;
			int denominator = 1;
			for (int i = 1; i <= n; i++) {
				//�����Ӹ�ֵ
				numerator = numerator * i;
				//����ĸ��ֵ
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