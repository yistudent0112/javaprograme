package Basical.program.set;

import java.util.Scanner;

/*
 * ��Ʊ�۸��ǵ����ƣ���������ͼ�����е�K��ͼ����ʾ��
 * ��Ϊ���յ���K�ߡ����ܵ���K�ߡ����µ���K�ߵȡ�����K��Ϊ����
 * ÿ���Ʊ�۸�ӿ��̵���������һ�죬��Ӧһ������Сͼ��
 * Ҫ��ʾ�ĸ��۸񣺿��̼۸�Open�����ϸոտ�ʼ���������ɽ��ĵ�1�ʼ۸񣩡�
 * ���̼۸�Close����������ʱ���һ�ʳɽ��ļ۸񣩡�
 * �м����߼�High����ͼ�Low��

���Close<Open����ʾΪ��BW-Solid��������ʵ���������򡱣���
���Close>Open����ʾΪ��R-Hollow�����������ĺ����򡱣���
���Open����Close����Ϊ��R-Cross��������ʮ�ֺ����򡱣���
���Low��Open��Close�ͣ���Ϊ��Lower Shadow������������Ӱ�ߡ�����
���High��Open��Close�ߣ���Ϊ��Upper Shadow������������Ӱ�ߡ�����
�����򣬸��ݸ������ĸ��۸���ϣ��жϵ��յ�������һ��ʲô��������
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
//���ո���������������Ӧ������ͼ�ж�
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
