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
 * @date 2018��4��18��
 *
 */
public class programe_6_4 {
	private static List<Integer> list = new ArrayList<Integer>();
/**
 * 
    * @Title: Read  
    * @Description: TODO(��������ĳ��ȣ��������е���)  
    * @param     ����  
    * @return void    ��������  
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
    * @Description: TODO(��ӡ�����е���)  
    * @param     ����  
    * @return void    ��������  
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
    * @Description: TODO(�������е�������һ��ǰ�󽻻�)  
    * @param     ����  
    * @return void    ��������  
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
