package Bacial_program;

import java.util.Scanner;

/*
 * һ���ɹ�Աȥ���жһ�һ��yԪf�ֵ�֧Ʊ���������Ա�����fԪy�֡�
 * �ɹ�Ա��ȥ��n��֮��ŷ����д�����������������2yԪ2f�֣��ʸ�֧Ʊ����Ƕ��٣�
 * ������һ���и���С��100��������n��
 * ��һ���а���ʽy.f�����֧Ʊ��ԭʼ������޽⣬�����No Solution��
 */
public class programe_7_19 {
	private static double n;
	private static double f;
	private static double y;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.close();
	}

	public static void Calculate() {
		if (n < 0 || n > 98) {
			System.out.println("No Solution.");
		} else {
			f = (199 - 2 * n) / 3;
			y = (98 - n) / 3;
			System.out.println("the price is " + y + "." + f);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		Calculate();
	}

}
