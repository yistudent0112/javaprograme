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
    * @date 2018��5��31��  
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
		System.out.println("please input the length of the String");
		ListLength = in.nextInt();
		List = new String[ListLength];
		Copy=new String[ListLength];
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
	 * @Title: AddKey @Description: TODO ( ���¼���Ĳ�ͬ���Ա��浽һ��set������ȥ ) @param @param key
	 * ���� @return void �������� @throws
	 */
	public static void AddKey(String key) {
		if (!KeySet.contains(key)) {
			KeySet.add(key);
		}
	}

	/**
	 * 
	 * @Title: SaveKey @Description: TODO ( ��set����ת����һ�����飬��������keyֵ��ȡ�� ) @param
	 * ���� @return void �������� @throws
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

	public static void PrintList() {
		int i, k, length;
		i = k = 0;
		length = Copy.length;
		for(int j=0;j<KeyLength;j++) {
			for (; i < length && Copy[i].equals(KeyList[j]); i++)
				;
			if (i > k) {
				System.out.printf(KeyList[j]+" in A[%d]-A[%d]\n", k, i - 1);
			}
			k = i;
		}
		if (i < length) {
			System.out.println("wrong answer.");
		}
	}

	/**
	 * 
	 * @Title: PrintA @Description: TODO ( ��ӡ����sortList����������� string���� ) @param
	 * ���� @return void �������� @throws
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
public static void SortList(int front,int rear,int keyfront,int keyrear) {
	if(Math.abs(rear-front)==1) {
		return;	
	}
	else {
		boolean FrontFound=false;
		boolean RearFound=false;
		for(int i=0;i<List.length;i++) {
			if(List[i].equals(KeyList[keyfront])) {
				Copy[front++]=List[i];
				FrontFound=true;
			}
			else if(List[i].equals(KeyList[keyrear])) {
				Copy[rear--]=List[i];
				RearFound=true;
			}
		}
		if(FrontFound) {
			keyfront++;
		}
		if(RearFound) {
			keyrear--;
		}
		SortList(front,rear,keyfront,keyrear);
	}
}
	/**
	 * 
	 * @Title: SortList @Description: TODO ( ��string����list��������
	 * ��Ϊfalse��ֵ�����������ǰ����Ϊtrue��ֵ����������ĺ� Ϊ�������������ֵ����ֵ��Ϊmaybe֮�������false��true��ֵ֮��
	 * �����޸ĺ�����鸴�Ƹ�ԭ�ȵ�����list ��ɶ�string����list������
	 * 
	 * ) @param ���� @return void �������� @throws
	 */
	public static void SortList() {
		// ���������ǰ���±�
		int front = 0;
		// ��������ĺ��±�
		int rear = List.length - 1;
		// ��������
		String[] temp = new String[ListLength];
		for (int i = 0; i < List.length; i++) {
			// ��ֵΪfalse�ķ����ڸ��������ǰ��
			if (List[i].equals("false")) {
				temp[front++] = List[i];
			}
			// ��ֵΪtrue1�ķ����ڸ�������ĺ�
			else if (List[i].equals("true")) {
				temp[rear--] = List[i];
			}
		}
		// �����������ֵ������������в�����������ֵ��Ϊmaybe
		for (int i = front; i <= rear; i++) {
			temp[i] = "maybe";
		}
		// �Ѹ��������ֵ��ԭ���鸳ֵ
		for (int i = 0; i < List.length; i++) {
			List[i] = temp[i];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadList();
		SaveKey();
		SortList(0,List.length-1,0,KeyLength-1);
		PrintList();
	
		//PrintKey();
	}

}
