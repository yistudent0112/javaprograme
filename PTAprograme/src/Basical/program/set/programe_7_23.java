package Basical.program.set;

import java.util.Scanner;

/*
 * ����һ��������λ��������9λ������һ�������ֵ����λΪԪ����
 * ��ת���ɲ���Ҫ��Ĵ�д���ĸ�ʽ��
 * ��23108Ԫ��ת�����ɡ�������ǪҼ����ơ�Ԫ��
 * Ϊ�˼��������СдӢ����ĸa-j˳�������д����0-9��
 * ��S��B��Q��W��Y�ֱ����ʰ���١�Ǫ�����ڡ�
 * ����23108ԪӦ��ת�����Ϊ��cWdQbBai��Ԫ��
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
		// �����ж��Ƿ����������0��������ڣ�ֻ��һ��0
		boolean zero = false;
		while (length > 0) {
		
			switch (numbers[length - 1]) {
			case 9:
				name += "��";
				zero = false;
				break;
			case 8:
				name += "��";
				zero = false;
				break;
			case 7:
				name += "��";
				zero = false;
				break;
			case 6:
				name += "��";
				zero = false;
				break;
			case 5:
				name += "��";
				zero = false;
				break;
			case 4:
				name += "��";
				zero = false;
				break;
			case 3:
				name += "��";
				zero = false;
				break;
			case 2:
				name += "��";
				zero = false;
				break;
			case 1:
				name += "һ";
				zero = false;
				break;
			case 0:
				if (length == 1) {
					break;
				}
				if (zero && length == 5) {
					name += "��";
				}
				if (!zero) {
					name += "��";
					zero = true;
				}
				break;

			}
		
			if (!zero) {
				switch (length) {
				case 9:
					name += "��";
					break;
				case 8:
					name += "Ǫ";
					break;
				case 7:
					name += "��";
					break;
				case 6:
					name += "ʮ";
					break;
				case 5:
					name += "��";
					break;
				case 4:
					name += "Ǫ";
					break;
				case 3:
					name += "��";
					break;
				case 2:
					name += "ʮ";
					break;

				default:

					break;
				}
			}

			length--;
		}
		// ��ȥ�����ַ������һ��λ�õĿ��ܴ��ڵ�����
		if (name.substring(name.length() - 1).equals("��")) {
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