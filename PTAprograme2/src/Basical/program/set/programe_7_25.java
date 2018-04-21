package Basical.program.set;

import java.util.Scanner;

/*
 * 输入一个整数，输出每个数字对应的拼音。
 * 当整数为负数时，先输出fu字。
 * 
 */
public class programe_7_25 {
	//用来存放数字中文名字的字符数组
	private static String[] Names = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
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
			sb.append("负");
		}
		if (number == 0) {
			sb.append("零");
		}
		GetNumbers();
		//将数按位进行读出的操作，并给每一位数命名
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
