package Basical.program.set;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 
    * @ClassName: programe_7_37  
    * @Description: TODO(��һ��������N�ֽ�ɼ�����������ӣ�
    * �����ж��ַֽⷽ����
    * ����7=6+1��7=5+2��7=5+1+1������
    * ������������N�����������ֽ�ʽ�ӡ�)  
    * @author yi  
    * @date 2018��4��12��  
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
