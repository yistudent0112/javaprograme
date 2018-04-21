package Bacial_program;

import java.util.Scanner;

/*
 * 给定一句英语，要求你编写程序，
 * 将句中所有单词的顺序颠倒输出。
 */
public class programe_7_32 {
	public static String word;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		word = in.nextLine();
		in.close();
	}

	public static void Transverse() {
		String[] words = word.split(" ");
		String temp;
		for (int i = 0; i < (words.length/2); i++) {
			temp = words[i];
			words[i] = words[words.length - i-1];
			words[words.length - i-1] = temp;
		}
		print(words);
	}

	public static void print(String[] words) {
		for (int i = 0; i < words.length; i++) {
			System.out.print(words[i] + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		Transverse();
	}

}
