package Basical.program.set;

import java.util.Scanner;

/*
 * 股票价格涨跌趋势，常用蜡烛图技术中的K线图来表示，
 * 分为按日的日K线、按周的周K线、按月的月K线等。以日K线为例，
 * 每天股票价格从开盘到收盘走完一天，对应一根蜡烛小图，
 * 要表示四个价格：开盘价格Open（早上刚刚开始开盘买卖成交的第1笔价格）、
 * 收盘价格Close（下午收盘时最后一笔成交的价格）、
 * 中间的最高价High和最低价Low。

如果Close<Open，表示为“BW-Solid”（即“实心蓝白蜡烛”）；
如果Close>Open，表示为“R-Hollow”（即“空心红蜡烛”）；
如果Open等于Close，则为“R-Cross”（即“十字红蜡烛”）。
如果Low比Open和Close低，称为“Lower Shadow”（即“有下影线”），
如果High比Open和Close高，称为“Upper Shadow”（即“有上影线”）。
请编程序，根据给定的四个价格组合，判断当日的蜡烛是一根什么样的蜡烛。
 */

public class programe_7_13 {
	private static double Open;
	private static double High;
	private static double Low;
	private static double Close;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		Open = in.nextDouble();
		High = in.nextDouble();
		Low = in.nextDouble();
		Close = in.nextDouble();
		in.close();
	}
//按照给定的条件作出相应的蜡烛图判断
	public static void Output() {
		String candle;
		if (Open < Close) {
			candle = "R-Hollow";
		} else if (Open == Close) {
			candle = "R-Cross";
		} else {
			candle = "BW-Solid";
		}
		if ((Low < Open) && (Low < Close)) {
			candle += " with Lower Shadow";
			if ((High > Open) && (High > Close)) {
				candle += " and High Shadow";
			}
		}
		if ((High > Open) && (High > Close)) {
			candle += " with High Shadow";
		}
		System.out.println(candle);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		Output();
	}

}
