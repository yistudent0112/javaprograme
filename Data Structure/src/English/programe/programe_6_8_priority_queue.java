package English.programe;

import java.util.Scanner;
/**
 * 
    * @ClassName: programe_6_8_priority_queue  
    * @Description: TODO(������������ʵ�ֵ����ȶ���)  
    * @author yi  
    * @date 2018��5��15��  
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
    * @Description: TODO(�����ȶ����ж���һ����)  
    * @param @param element    ����  
    * @return void    ��������  
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
    * @Description: TODO(�����ȶ����ж���һ����)  
    * @param @return    ����  
    * @return int    ��������  
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
    * @Description: TODO(�ҵ������������Ǹ������������ʹ��ŵ����һ��������λ��)  
    * @param     ����  
    * @return void    ��������  
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
