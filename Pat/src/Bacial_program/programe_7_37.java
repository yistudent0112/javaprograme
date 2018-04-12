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
		if (GetSum() == N) {
			/*
			 * System.out.println(); for(int i=0;i<result.length;i++) {
			 * System.out.print(result[i]+" "); } System.out.println();
			 */
			int[] temp = new int[N];
			for (int i = 0; i < result.length; i++) {
				temp[i] = result[i];
				//result[i] = 0;
			}
			for(int i=Length-1;i<result.length;i++) {
				result[i]=0;;
			}
			results.add(temp);

			Length = 0;
			return;
		} else if (GetSum() > N) {
			return;
		} else if (GetSum()< N) {
			for (int j = n; j < N; j++) {
				System.out.println("j is " + j);
				System.out.println("Length is " + Length);
				result[Length++] = j;
				// System.out.println("result is "+result[Length]);			
				Calculate(j);		
				if (Length == 0) {

				} else {
					Length--;
				}
			}
		}

	}
   public static int GetSum() {
	   Sum=0;
	   for(int temp:result) {
		   Sum+=temp;
	   }
	   return Sum;
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
			for (i = 0; i < temp.length; i++) {
				if (temp[i] != 0) {
					System.out.print(temp[i]);
				} else {
					break;
				}
				System.out.print("+");
			}
			System.out.print("/n");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		Calculate(1);
		//System.out.println(results.size());
		Print1();
	}

}
