package Bacial_program;

import java.util.Scanner;

/*
 * 本题要求编写程序，
 * 顺序读入浮点数1、整数、字符、浮点数2，
 * 再按照字符、整数、浮点数1、浮点数2的顺序输出。
 * 在一行中按照字符、整数、浮点数1、浮点数2的顺序输出，
 * 其中浮点数保留小数点后2位。
 */

public class programe_7_6 {
	private float f1;
	private float f2;
	private int i1;
	private String s1;

	public void input() {
		Scanner in = new Scanner(System.in);
		f1 = in.nextFloat();
		i1 = in.nextInt();
		s1 = in.next();
		f2 = in.nextFloat();
		in.close();
	}

	public void format() {
		int i=1;
		float t=(float) 1.0;
		String s="yi";
		System.out.printf("%+f\n",t);//+号表示输出的格式中带有+ —号
		System.out.printf("%9.2f",t);//'9.2'中的9表示输出的长度，2表示小数点后的位数。
		}
	public void output() {
	
		System.out.printf("%s ",s1);
		System.out.printf("%d ",i1);
		System.out.printf("%.2f ", f1);
		System.out.printf("%.2f ", f2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		programe_7_6 p = new programe_7_6();
	/*	p.input();
		p.output();*/
	p.format();
	}

}
