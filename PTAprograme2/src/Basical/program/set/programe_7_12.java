package Basical.program.set;

import java.util.Scanner;

/*
 * ����Ҫ���дһ���򵥼��������򣬿ɸ���������������
 * ��2���������мӡ������ˡ������������㡣
 * ��Ŀ��֤�������������������ͷ�Χ
 * ������һ�����������������1���������������2�������1���ո�ָ���
 * ����������������Ϊ���ͣ��ұ�֤����������ķ�ĸ���㡣
 * �������Ϊ+��-��*��/��%ʱ����һ�������Ӧ����������
 * �������ǷǷ����ţ������˼ӡ������ˡ������������������������������ţ�
 * �����ERROR��
 */
public class programe_7_12 {
	private static int type = 0;
	private static int a;
	private static int b;

	// ����ֵΪ-1ʱ����������������������
	public static int Calculate() {
		int result = -1;
		switch (type) {
		case 1:
			result = a + b;
			break;
		case 2:
			result = a - b;
			break;
		case 3:
			result = a * b;
			break;
		case 4:
			result = (int) a / b;
			break;
		case 5:
			result = a % b;
			break;
		default:
			System.out.println("error");
		}
		return result;
	}

	public static void input() {
		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		String temp = in.next();
		b = in.nextInt();
		in.close();
		/*
		 * ����ͬ�����㸳�費ͬ��typeֵ��Ϊ��ǣ� ������δ���������ʱ��typeֵΪ-1
		 */
		if (temp.equals("+")) {
			type = 1;
		} else if (temp.equals("-")) {
			type = 2;
		} else if (temp.equals("*")) {
			type = 3;
		} else if (temp.equals("/")) {
			type = 4;
		} else if (temp.equals("%")) {
			type = 5;
		} else {
			type = -1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		System.out.println(Calculate());
	}

}