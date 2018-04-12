package Bacial_program;

import java.util.Scanner;

/*
 * ����Ҫ������������������N��
 * �󷽳�X*X+Y*Y=N��ȫ���������⡣
 */
public class programe_7_21 {
	private static int N;
	private static int X;
	private static int Y;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		in.close();
	}

	public static void Solve() {
		int n=0;
		int result = (int) Math.sqrt(N);
		int x2 = 0;
		int y2 = 0;
		for (int i = 0; i <= result; i++) {
			x2 = SquareN(i);
			for (int j = 0; j <= result; j++) {
				y2 = SquareN(j);
				if ((x2 + y2) == N) {
					System.out.println("there is a result x=" + i + " y=" + j);
					n++;
					break;
				}
			}
		}
		if(n>0) {
			System.out.println("there are "+n+" results.");
		}else {
			System.out.println("there is no result.");
		}
	}
//�����������ƽ��
	public static int SquareN(int n) {
		return n * n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		Solve();
	}

}
