package Basical.program.set;

import java.util.Scanner;

/*
 * 你的程序要读入一行文本，其中以空格分隔为若干个单词，以.结束。
 * 你要输出每个单词的长度。
 * 这里的单词与语言无关，可以包括各种符号，
 * 比如it's算一个单词，长度为4。
 * 注意，行中可能出现连续的空格；最后的.不计算在内。
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
