package Bacial_program;

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
