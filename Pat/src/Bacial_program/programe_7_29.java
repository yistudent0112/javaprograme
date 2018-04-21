package Bacial_program;

import java.util.Scanner;

/*
 * 输入2个字符串S1和S2，
 * 要求删除字符串S1中出现的所有子串S2，
 * 即结果字符串中不能包含S2。
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
