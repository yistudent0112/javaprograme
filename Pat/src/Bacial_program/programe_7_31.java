package Bacial_program;

import java.util.Scanner;

/*
 * ����һ���ַ�����һ���Ǹ�����N��
 * Ҫ���ַ���ѭ������N�Ρ�
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
	 * �Ƚ��оֲ���ת����ȫ�ַ�ת
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
	 * ��ȫ�ַ�ת���ھֲ���ת
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
	 * ��������ַ�����ת�󲢷���
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
