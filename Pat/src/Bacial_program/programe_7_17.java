package Bacial_program;

import java.util.Scanner;

/*
 * һ����泤1�磬��һ����ΪN��ľ��ĵײ���
 * ��֪���ÿ1���ӿ���������U�磬��������Ϣ1���Ӳ��ܽ�����������
 * ����Ϣ�Ĺ����У�������»���D�硣
 * ���������������»��ظ����С�
 * ���ʣ������Ҫ�೤ʱ�������������

����Ҫ����1���Ӱ�1���Ӽƣ�
���Ҽٶ�ֻҪ��ĳ����������������ͷ�������˾��Ķ�����
��ô������������ˡ�
��ʼʱ�������ſ�ھ��׵ģ����߶�Ϊ0����
 */
public class programe_7_17 {
	private static int Length = 1;
	private static int Up;
	private static int Down;
	private static int Height;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		Up = in.nextInt();
		Down = in.nextInt();
		Height = in.nextInt();
		in.close();
	}

	public static int Count() {
		int minute = 0;
		int distance = Length;
		//������������ĳ���С������ĳ���ʱ���������㣬ֱ����ʾ�����ܳɹ�
		if (Up <= Down) {
			System.out.println("Can not success.");
			return -1;
		}
		while (distance < Height) {
			minute++;
			distance = distance + Up;
			if (distance >= Height) {
				break;
			}
			distance = distance - Down;
		}
		return minute;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		System.out.println(Count());
	}

}
