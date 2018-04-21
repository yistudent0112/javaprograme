package Bacial_program;

import java.util.Scanner;

/*
 * 一条蠕虫长1寸，在一口深为N寸的井的底部。
 * 已知蠕虫每1分钟可以向上爬U寸，但必须休息1分钟才能接着往上爬。
 * 在休息的过程中，蠕虫又下滑了D寸。
 * 就这样，上爬和下滑重复进行。
 * 请问，蠕虫需要多长时间才能爬出井？

这里要求不足1分钟按1分钟计，
并且假定只要在某次上爬过程中蠕虫的头部到达了井的顶部，
那么蠕虫就完成任务了。
初始时，蠕虫是趴在井底的（即高度为0）。
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
		//当蠕虫往上爬的长度小于下落的长度时，跳出计算，直接显示不可能成功
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
