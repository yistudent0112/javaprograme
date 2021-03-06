package Basical.program.set;

import java.util.Scanner;

/*
 * 乌龟与兔子进行赛跑，跑场是一个矩型跑道，跑道边可以随地进行休息。
 * 乌龟每分钟可以前进3米，兔子每分钟前进9米；
 * 兔子嫌乌龟跑得慢，觉得肯定能跑赢乌龟，
 * 于是，每跑10分钟回头看一下乌龟，若发现自己超过乌龟，就在路边休息，
 * 每次休息30分钟，否则继续跑10分钟；
 * 而乌龟非常努力，一直跑，不休息。
 * 假定乌龟与兔子在同一起点同一时刻开始起跑，
 * 请问T分钟后乌龟和兔子谁跑得快？
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
