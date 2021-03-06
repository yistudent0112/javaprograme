package Basical.program.set;

import java.util.Scanner;

/*
 * 将N个整数按从小到大排序的冒泡排序法是这样工作的：
 * 从头到尾比较相邻两个元素，如果前面的元素大于其紧随的后面元素，
 * 则交换它们。通过一遍扫描，则最后一个元素必定是最大的元素。
 * 然后用同样的方法对前N−1个元素进行第二遍扫描。
 * 依此类推，最后只需处理两个元素，就完成了对N个数的排序。

本题要求对任意给定的K（<N），输出扫描完第K遍后的中间结果数列。
 */
public class programe_7_27 {
	private static int N;
	private static int K;
	private static int[] numbers;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
		numbers = new int[N];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = in.nextInt();
		}
		in.close();
	}

	public static void BubbleSort() {
		int first = 0;
		int last = numbers.length - 1;
		for (int j = 0; j < K; j++) {
			for (int i = first; i < last; i++) {
				if (numbers[i] > numbers[i + 1]) {
					int temp = numbers[i];
					numbers[i] = numbers[i + 1];
					numbers[i + 1] = temp;
				}
			}
		}

	}
   public static void Print() {
	   for(int i=0;i<numbers.length;i++) {
		   System.out.print(numbers[i]+" ");
	   }
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		BubbleSort();
		Print();
	}

}
