package Basical.program.set;

import java.util.Scanner;

/*
 * ��ĳ���Ҫ����һ���ı��������Կո�ָ�Ϊ���ɸ����ʣ���.������
 * ��Ҫ���ÿ�����ʵĳ��ȡ�
 * ����ĵ����������޹أ����԰������ַ��ţ�
 * ����it's��һ�����ʣ�����Ϊ4��
 * ע�⣬���п��ܳ��������Ŀո�����.���������ڡ�
 */
public class programe_7_26 {
	private static String sentence;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		sentence = in.nextLine();
		in.close();
	}

	public static void Count() {
		String words[] = sentence.split(" ");
		for (int i = 0; i < words.length; i++) {
			System.out.print(words[i].length() + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		Count();
	}

}