package Basical.program.set;

import java.util.Scanner;

/*
 * �ڹ������ӽ������ܣ��ܳ���һ�������ܵ����ܵ��߿�����ؽ�����Ϣ��
 * �ڹ�ÿ���ӿ���ǰ��3�ף�����ÿ����ǰ��9�ף�
 * �������ڹ��ܵ��������ÿ϶�����Ӯ�ڹ꣬
 * ���ǣ�ÿ��10���ӻ�ͷ��һ���ڹ꣬�������Լ������ڹ꣬����·����Ϣ��
 * ÿ����Ϣ30���ӣ����������10���ӣ�
 * ���ڹ�ǳ�Ŭ����һֱ�ܣ�����Ϣ��
 * �ٶ��ڹ���������ͬһ���ͬһʱ�̿�ʼ���ܣ�
 * ����T���Ӻ��ڹ������˭�ܵÿ죿
 */
public class programe_7_22 {
	private static int minute;
	private static int TurtleSpeed = 3;
	private static int RabbitSpeed = 9;
	private static String TurtleWin = "@_@";
	private static String RabbitWin = "^_^";
	private static String Tie = "-_-";

	public static void Input() {
		Scanner in = new Scanner(System.in);
		minute = in.nextInt();
		in.close();
	}

	public static void WhoWin() {
		int TurtleDistance = 0;
		int RabbitDistance = 0;
		int temp = minute;
		if (minute <= 0) {
			System.out.println("Invaild input");
		}
		while (minute > 0) {
			if(minute<10) {
				TurtleDistance = TurtleDistance + TurtleSpeed * minute;
				RabbitDistance = RabbitDistance + RabbitSpeed * minute;
				minute=0;
			}else {
			minute = minute - 10;
			TurtleDistance = TurtleDistance + TurtleSpeed * 10;
			RabbitDistance = RabbitDistance + RabbitSpeed * 10;
			}
			if (minute < 0) {
				break;
			}
			if (TurtleDistance < RabbitDistance) {
				if (minute < 30) {
					TurtleDistance = TurtleDistance + TurtleSpeed * minute;
					minute = 0;
					break;
				} else {
					minute = minute - 30;
					TurtleDistance = TurtleDistance + TurtleSpeed * 30;
				}
			}
		}
		if (temp > 0) {
			System.out.println(temp + " later");
			if (TurtleDistance < RabbitDistance) {
				System.out.println(RabbitWin);
			} else if (TurtleDistance > RabbitDistance) {

				System.out.println(TurtleWin);
			} else {
				System.out.println(Tie);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		WhoWin();
	}

}