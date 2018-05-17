package English.programe;

import java.util.Scanner;
/**
 * 
    * @ClassName: programe_6_8_priority_queue  
    * @Description: TODO(基于无序数组实现的优先队列)  
    * @author yi  
    * @date 2018年5月15日  
    *
 */
public class programe_6_8_priority_queue {
	private static int[] arr;
	private static int Length;
	private static int Capcity;

	public programe_6_8_priority_queue(int n) {
		/*
		 * Scanner in =new Scanner(System.in); int n=in.nextInt();
		 */
		Capcity = n;
		arr = new int[n];
	}

	public boolean IsFull() {
		boolean flag = true;
		if (Length < Capcity) {
			flag = false;
		}
		return flag;
	}

	public boolean IsEmpty() {
		boolean flag = true;
		if (Length > 0) {
			flag = false;
		}
		return flag;
	}
/**
 * 
    * @Title: AddElement  
    * @Description: TODO(从优先对列中读入一个数)  
    * @param @param element    参数  
    * @return void    返回类型  
    * @throws
 */
	public void AddElement(int element) {
		if (!IsFull()) {
			arr[Length++] = element;
		}
	}
/**
 * 
    * @Title: DeleteElement  
    * @Description: TODO(从优先对列中读出一个数)  
    * @param @return    参数  
    * @return int    返回类型  
    * @throws
 */
	public int DeleteElement() {
		int element = -1;
		if(!IsEmpty()) {
			SwapLarge();
			element = arr[Length - 1];
			arr[Length - 1] = 0;
			Length--;
		}
		return element;
	}
/**
 * 
    * @Title: SwapLarge  
    * @Description: TODO(找到数组中最大的那个数，并把它和存着的最后一个数交换位置)  
    * @param     参数  
    * @return void    返回类型  
    * @throws
 */
	public void SwapLarge() {
		int max = arr[0];
		int index = 0;
		for (int i = 1; i < Length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				index = i;
			}
		}
		// int temp=0;
		// temp=max;
		arr[index] = arr[Length - 1];
		arr[Length - 1] = max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		programe_6_8_priority_queue p = new programe_6_8_priority_queue(10);
		p.AddElement(10);
		p.AddElement(11);
		p.AddElement(14);
		System.out.println(p.DeleteElement());
		System.out.println(p.DeleteElement());
/*		p.AddElement(100);
		p.AddElement(122);*/
		System.out.println(p.DeleteElement());
		p.AddElement(1);
		System.out.println(p.DeleteElement());
		System.out.println(p.DeleteElement());
		System.out.println(p.DeleteElement());
	}

}
