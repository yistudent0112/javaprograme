package Basical.program.set;

import java.util.Scanner;

/*
 * ����������6��������A�����Ǵ�A��ʼ������4�����֡�
 * �����������������ɵ����ظ����ֵ�3λ����
 * ������һ���и���A��
 * ������������ĵ�3λ����
 * Ҫ���С����ÿ��6���������������Կո�ָ�������ĩ�����ж���ո�
 */

public class programe_7_16 {
	private static int FirstNumber;
	private static int LastNumber;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		FirstNumber = in.nextInt();
		LastNumber = FirstNumber + 3;
		in.close();
	}
/*
 * ������ע
 * forѭ��������������Ҫȡ�������֣�
 * forѭ���ڵ��ж����������ˣ���Щ����ȡֵ��Χ
 */
	public static void Output() {
		int sum=0;
		//�²�ǰ��λ����
		for (int i = FirstNumber; i < FirstNumber + 4; i++) {
			for (int j = FirstNumber; j < FirstNumber + 4; j++) {
				//��ǰ��λ������ͬ���������һ�β²�
				if (i == j) {
					continue;
				}
				for (int k = FirstNumber; k < FirstNumber + 4; k++) {
					//����λ���ֶ�����ͬʱ���²�ɹ�
					if ((i != k) && (j != k)) {
						int number = i * 100 + j * 10 + k;
						sum++;
						System.out.println(number);
					}
				}
			}
		}
		System.out.println("sum : "+sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		Output();
	}

}
