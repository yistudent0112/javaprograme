package English.programe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @ClassName: programe_6_4
 * @Description: TODO(Write a nonrecursive procedure to reverse a singly linked
 *               list in O(N) time using constant extra space.)
 * @author yi
 * @date 2018年4月18日
 *
 */
public class programe_6_4 {
	private static List<Integer> list = new ArrayList<Integer>();
/**
 * 
    * @Title: Read  
    * @Description: TODO(读入数组的长度，和数组中的数)  
    * @param     参数  
    * @return void    返回类型  
    * @throws
 */
	public static void Read() {
		Scanner in = new Scanner(System.in);
		System.out.println("please input how many number you want to insert.");
		int number = in.nextInt();
		for (int i = 0; i < number; i++) {
			list.add(i, in.nextInt());
		}
		in.close();
	}
/**
 * 
    * @Title: Print  
    * @Description: TODO(打印数组中的数)  
    * @param     参数  
    * @return void    返回类型  
    * @throws
 */
	public static void Print() {
		for (int temp : list) {
			System.out.print(temp + " ");
		}
	}
/**
 * 
    * @Title: Transe  
    * @Description: TODO(对数组中的数进行一次前后交换)  
    * @param     参数  
    * @return void    返回类型  
    * @throws
 */
	public static void Transe() {
		for (int i = 0; i < list.size() / 2; i++) {
			int temp = list.get(i);
			list.set(i, list.get(list.size() - i - 1));
			list.set(list.size() - i - 1, temp);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Read();
		Print();
		Transe();
		Print();
	}

}
