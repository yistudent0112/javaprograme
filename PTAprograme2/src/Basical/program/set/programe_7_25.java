package Basical.program.set;

import java.util.Scanner;

/*
 * ����һ�����������ÿ�����ֶ�Ӧ��ƴ����
 * ������Ϊ����ʱ�������fu�֡�
 * 
 */
public class programe_7_25 {
	//������������������ֵ��ַ�����
	private static String[] Names = { "��", "Ҽ", "��", "��", "��", "��", "½", "��", "��", "��" };
	private static int number;
	private static int[] numbers = new int[100];
	private static int length = 0;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		number = in.nextInt();
		in.close();
	}

	public static void Trans() {
		StringBuffer sb = new StringBuffer();
		if (number < 0) {
			sb.append("��");
		}
		if (number == 0) {
			sb.append("��");
		}
		GetNumbers();
		//������λ���ж����Ĳ���������ÿһλ������
		for (int i = length-1; i > -1; i--) {
			switch (numbers[i]) {
			case 0:
				sb.append(Names[0]);
				break;
			case 1:
				sb.append(Names[1]);
				break;
			case 2:
				sb.append(Names[2]);
				break;
			case 3:
				sb.append(Names[3]);
				break;
			case 4:
				sb.append(Names[4]);
				break;
			case 5:
				sb.append(Names[5]);
				break;
			case 6:
				sb.append(Names[6]);
				break;
			case 7:
				sb.append(Names[7]);
				break;
			case 8:
				sb.append(Names[8]);
				break;
			case 9:
				sb.append(Names[9]);
				break;
			}
		}
		System.out.println(sb);

	}

	public static void GetNumbers() {
		number = Math.abs(number);
		while (number > 0) {
			numbers[length] = number % 10;
			number = number / 10;
			length++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		Trans();
	}

}