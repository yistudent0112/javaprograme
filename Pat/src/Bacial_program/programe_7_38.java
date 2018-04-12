package Bacial_program;

import java.util.Scanner;

/*
 * 
    * @ClassName: programe_7_38  
    * @Description: TODO(给定某数字A（1≤A≤9）
    * 以及非负整数N（0≤N≤100000），
    * 求数列之和S=A+AA+AAA+⋯+AA⋯A（N个A）。
    * 例如A=1, N=3时，S=1+11+111=123。)  
    * @author yi  
    * @date 2018年4月12日  
    *
 */
public class programe_7_38 {
	private static int N;
	private static int Times;
	private static int Sum = 0;
	private static int Numbers[] = new int[100];

	public static void Input() {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		Times = in.nextInt();
		in.close();
	}

	/**
	 * 
	 * @Title: GeneratNumbers @Description: TODO(产生一个重复次数为time的数) @param @param
	 * time @param @return 参数 @return int 返回类型 @throws
	 */
	public static int GeneratNumbers(int time) {
		int temp = 0;
		for (int i = 1; i <= time; i++) {
			temp = temp * 10 + N;
		}
		return temp;
	}

	public static void CountSum() {
		for (int i = 0; i < Numbers.length; i++) {
			Sum += Numbers[i];
		}
	}

	public static void Calculate() {
		for (int i = 0; i < Times; i++) {
			Numbers[i] = GeneratNumbers(i + 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		Calculate();
		CountSum();
		System.out.println("sum is "+Sum);
	}

}
