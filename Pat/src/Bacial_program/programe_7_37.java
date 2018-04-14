package Bacial_program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 
    * @ClassName: programe_7_37  
    * @Description: TODO(将一个正整数N分解成几个正整数相加，
    * 可以有多种分解方法，
    * 例如7=6+1，7=5+2，7=5+1+1，…。
    * 编程求出正整数N的所有整数分解式子。)  
    * @author yi  
    * @date 2018年4月12日  
    *
 */
public class programe_7_37 {
	private static int N;
	private static List<int[]> results = new ArrayList<int[]>();
	private static int[] result;
	private static int Sum = 0;
	private static int Length = 0;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		result = new int[N];
		in.close();
	}

	public static void Calculate(int n) {
		if (Sum == N) {
			int[] temp = new int[N];
			for (int i = 0; i < result.length; i++) {
				temp[i] = result[i];
				
			}
			results.add(temp);

			return;
		} else if (Sum > N) {
			return;
		} else if (Sum < N) {
			for (int j = n; j < N; j++) {
				result[Length++] = j;
				Sum+=j;
				Calculate(j);
				Length--;
				Sum-=j;
				result[Length] = 0;
			}
		}

	}


	public static void Print1() {
		for (int[] temp : results) {
			for (int i = 0; i < temp.length; i++) {
				System.out.print(temp[i] + " ");
			}
			System.out.println();
		}
	}

 
	public static void Print() {
		for (int[] temp : results) {
			System.out.print(N + "=");
			int i;
			for (i = 0; i < temp.length-1; i++) {
				if(temp[i+1]!=0) {
					System.out.print(temp[i]+"+");
				}else {
					break;
				}
			}
			System.out.print(temp[i]);
			System.out.printf("\n");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		Calculate(1);
		// System.out.println(results.size());
		Print();
	}

}
