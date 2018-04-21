package Basical.program.set;

import java.util.Scanner;

/*
 * 给定不超过6的正整数A，考虑从A开始的连续4个数字。
 * 请输出所有由它们组成的无重复数字的3位数。
 * 输入在一行中给出A。
 * 输出满足条件的的3位数，
 * 要求从小到大，每行6个整数。整数间以空格分隔，但行末不能有多余空格。
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
 * 函数标注
 * for循环的数量表明了要取几个数字，
 * for循环内的判断条件决定了，这些数的取值范围
 */
	public static void Output() {
		int sum=0;
		//猜测前两位数字
		for (int i = FirstNumber; i < FirstNumber + 4; i++) {
			for (int j = FirstNumber; j < FirstNumber + 4; j++) {
				//若前两位数字相同，则进行下一次猜测
				if (i == j) {
					continue;
				}
				for (int k = FirstNumber; k < FirstNumber + 4; k++) {
					//当三位数字都不相同时，猜测成功
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
