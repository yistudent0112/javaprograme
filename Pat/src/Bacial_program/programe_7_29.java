package Bacial_program;

import java.util.Scanner;

/*
 * ����2���ַ���S1��S2��
 * Ҫ��ɾ���ַ���S1�г��ֵ������Ӵ�S2��
 * ������ַ����в��ܰ���S2��
 */
public class programe_7_29 {
	private static String s1;
	private static String s2;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		s1 = in.nextLine();
		s2 = in.next();
		in.close();
	}

	public static void delete() {
		System.out.println(s1);
		System.out.println(s2);
		String s[] = s1.split(s2);
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i] + "");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		delete();
	}

}
