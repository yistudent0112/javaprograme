package English.programe;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * 
    * @ClassName: programe_6_9  
    * @Description: TODO(
    Suppose you have an array of N elements, 
    containing three distinct keys, 
    "true", "false", and "maybe".
    Given an O(N) algorithm to rearrange the list 
    so that all "false" elements precede "maybe" elements
    , which in turn precede "true" elements. 
    You may use only constant extra space.
 )  
    * @author yi  
    * @date 2018年5月31日  
    *
 */
public class programe_6_9 {
	private static String[] List;
	private static String[] Copy;
	private static Set<String> KeySet;
	private static Object[] KeyList;
	private static int KeyLength;
	private static int ListLength;

	public static void ReadList() {
		Scanner in = new Scanner(System.in);
		System.out.println("please input the length of the String"
				+ "(can not smaller than 2)");
		ListLength = in.nextInt();
		List = new String[ListLength];
		Copy = new String[ListLength];
		KeySet = new HashSet<String>();
		for (int i = 0; i < ListLength; i++) {
			String word = in.next();
			List[i] = word;
			AddKey(word);
		}
		in.close();
	}

	/**
	 * 
	 * @Title: AddKey @Description: TODO ( 把新加入的不同可以保存到一个set容器中去 ) @param @param key
	 *         参数 @return void 返回类型 @throws
	 */
	public static void AddKey(String key) {
		if (!KeySet.contains(key)) {
			KeySet.add(key);
		}
	}

	/**
	 * 
	 * @Title: SaveKey @Description: TODO ( 把set容器转换成一个数组，这样方便key值得取出 ) @param
	 *         参数 @return void 返回类型 @throws
	 */
	public static void SaveKey() {
		KeyList = new String[KeySet.size()];
		KeyList = KeySet.toArray();
		KeyLength = KeyList.length;
	}

	public static void PrintKey() {
		for (int i = 0; i < KeyLength; i++) {
			System.out.println(KeyList[i]);
		}
	}
/**
 * 
    * @Title: PrintList  
    * @Description: TODO
    * (
    * 顺序存有关键字的KeyList数组，并把关键字拿出来与copy数组中的信息进行比较
    * 并按照顺序把各关键字在copy数组中所占位置信息打印出来
    * )  
    * @param     参数  
    * @return void    返回类型  
    * @throws
 */
	public static void PrintList() {
		int i, k, length;
		i = k = 0;
		length = Copy.length;
		for (int j = 0; j < KeyLength; j++) {
			for (; i < length && Copy[i].equals(KeyList[j]); i++)
				;
			if (i > k) {
				System.out.printf(KeyList[j] + " in A[%d]-A[%d]\n", k, i - 1);
			}
			k = i;
		}
		if (i < length) {
			System.out.println("wrong answer.");
		}
	}

	/**
	 * 
	 * @Title: PrintA @Description: TODO ( 打印经过sortList函数排序过的 string数组 ) @param
	 *         参数 @return void 返回类型 @throws
	 */
	public static void PrintA() {
		int i, k, length;
		k = i = 0;
		length = List.length;
		for (; i < length && List[i].equals("false"); i++)
			;
		if (i > k) {
			System.out.printf("false in A[%d]-A[%d]\n", k, i - 1);
		}
		k = i;
		for (; i < length && List[i].equals("maybe"); i++)
			;
		if (i > k) {
			System.out.printf("maybe in A[%d]-A[%d]\n", k, i - 1);
		}
		k = i;
		for (; i < length && List[i].equals("true"); i++)
			;
		if (i > k) {
			System.out.printf("true in A[%d]-A[%d]\n", k, i - 1);
		}
		if (i < length) {
			System.out.println("wrong answer.");
		}
	}
	/**
	 * 
	    * @Title: SortList  
	    * @Description: TODO
	    * (
	    *  对读入的数组进行排序，排序按照关键字数组KeyList中的顺序来排序
	    *  把排序好的数组赋值给copy数组
	    *  注：当数组长度为偶数时，正常递归调用此函数不会出现问题
	    *  当数组长度为奇数时，会导致上下界为同一个数，此时会漏判处于数组中间位置的那一个元素
	    *  所以把跳出的递归条件改为上界和下届的的差的绝对值为一
	    *  以此来避免数组长度为奇数时所产生的问题
	    * )  
	    * @param @param front
	    * @param @param rear
	    * @param @param keyfront
	    * @param @param keyrear    参数  
	    * @return void    返回类型  
	    * @throws
	 */
	public static void SortList(int front, int rear, int keyfront, int keyrear) {
		//跳出递归的判断条件
		if (Math.abs(rear - front) == 1) {
			return;
		} else {
			//用来标记有没有在数组中找到前部关键字对应的信息
			boolean FrontFound = false;
			//用来标记有没有在数组中找到后部关键字对应的信息
			boolean RearFound = false;
			for (int i = 0; i < List.length; i++) {
				//若找到前部关键字对应的信息，则将其放置在copy数组的前部，并修改标记信息
				if (List[i].equals(KeyList[keyfront])) {
					Copy[front++] = List[i];
					FrontFound = true;
				} 
				//若找到后部关键字对应的信息，则将其放置在copy数组的后部，并修改标记信息
				else if (List[i].equals(KeyList[keyrear])) {
					Copy[rear--] = List[i];
					RearFound = true;
				}
			}
			//若前部查找标记为真，则将前部查找下标加一
			if (FrontFound) {
				keyfront++;
			}
			//若后部查找标记为真，则将后部查找下标减一
			if (RearFound) {
				keyrear--;
			}
			//递归调用函数
			SortList(front, rear, keyfront, keyrear);
		}
	}

	/**
	 * 
	 * @Title: SortList 
	 * @Description: TODO 
	 * ( 
	 * 对string数组list进行排序
	 * 把为false的值放置在数组的前部，为true的值放置在数组的后部
	        为其他任意情况的值，把值改为maybe之后放置在false和true的值之间
	         最后把修改后的数组复制给原先的数组list
	 * 完成对string数组list的排序
	 * 
	 *         ) 
	 * @param 参数
	 * @return void 返回类型
	 * @throws
	 */
	public static void SortList() {
		// 复制数组的前部下标
		int front = 0;
		// 复制数组的后部下标
		int rear = List.length - 1;
		// 复制数组
		String[] temp = new String[ListLength];
		for (int i = 0; i < List.length; i++) {
			// 把值为false的放置在复制数组的前部
			if (List[i].equals("false")) {
				temp[front++] = List[i];
			}
			// 把值为true1的放置在复制数组的后部
			else if (List[i].equals("true")) {
				temp[rear--] = List[i];
			}
		}
		// 将其他情况的值放置在数组的中部，并把它的值赋为maybe
		for (int i = front; i <= rear; i++) {
			temp[i] = "maybe";
		}
		// 把复制数组的值给原数组赋值
		for (int i = 0; i < List.length; i++) {
			List[i] = temp[i];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadList();
		SaveKey();
		SortList(0, List.length - 1, 0, KeyLength - 1);
		PrintList();

		// PrintKey();
	}

}
