package Basical.program.set;

import java.util.Scanner;

/*
 * 输入一个整数（位数不超过9位）代表一个人民币值（单位为元），
 * 请转换成财务要求的大写中文格式。
 * 如23108元，转换后变成“贰万叁仟壹百零捌”元。
 * 为了简化输出，用小写英文字母a-j顺序代表大写数字0-9，
 * 用S、B、Q、W、Y分别代表拾、百、仟、万、亿。
 * 于是23108元应被转换输出为“cWdQbBai”元。
 */
public class programe_7_23 {
	private static int number;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		number = in.nextInt();
		in.close();
	}

	public static void Transe() {
		int numbers[] = new int[10];
		int i = 0;
		while (number > 0) {
			numbers[i] = number % 10;
			number = number / 10;
			i++;
		}
		int length = i;
		String name = "";
		// 用于判断是否存在连续的0，如果存在，只读一次0
		boolean zero = false;
		while (length > 0) {
		
			switch (numbers[length - 1]) {
			case 9:
				name += "九";
				zero = false;
				break;
			case 8:
				name += "八";
				zero = false;
				break;
			case 7:
				name += "七";
				zero = false;
				break;
			case 6:
				name += "六";
				zero = false;
				break;
			case 5:
				name += "五";
				zero = false;
				break;
			case 4:
				name += "四";
				zero = false;
				break;
			case 3:
				name += "三";
				zero = false;
				break;
			case 2:
				name += "二";
				zero = false;
				break;
			case 1:
				name += "一";
				zero = false;
				break;
			case 0:
				if (length == 1) {
					break;
				}
				if (zero && length == 5) {
					name += "万";
				}
				if (!zero) {
					name += "零";
					zero = true;
				}
				break;

			}
		
			if (!zero) {
				switch (length) {
				case 9:
					name += "亿";
					break;
				case 8:
					name += "仟";
					break;
				case 7:
					name += "百";
					break;
				case 6:
					name += "十";
					break;
				case 5:
					name += "万";
					break;
				case 4:
					name += "仟";
					break;
				case 3:
					name += "百";
					break;
				case 2:
					name += "十";
					break;

				default:

					break;
				}
			}

			length--;
		}
		// 除去留在字符串最后一个位置的可能存在的零字
		if (name.substring(name.length() - 1).equals("零")) {
			name = name.substring(0, name.length() - 1);
		}
		System.out.println(name);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		Transe();
	}

}
