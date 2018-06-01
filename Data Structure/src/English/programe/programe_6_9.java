package English.programe;

import java.util.ArrayList;
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
    * @date 2018Äê5ÔÂ31ÈÕ  
    *
 */
public class programe_6_9 {
	private static String[] List;
	private static Set KeySet;
	private static String[] KeyList;
	private static int KeyLength;

	public static void ReadList() {
		Scanner in = new Scanner(System.in);
		int Length = in.nextInt();
		for (int i = 0; i < Length; i++) {
			String word = in.nextLine();
			List[i] = word;
			AddKey(word);
		}
		in.close();
	}

	public static void AddKey(String key) {
		if (!KeySet.contains(key)) {
			KeySet.add(key);
		}
	}

	public static void SaveKey() {
		 KeyList= (String[]) KeySet.toArray();
		 KeyLength=KeyList.length;
	}
	public static void PrintList() {
	int start=0;
	int end=0;
	int j;
		for(int i=0;i<KeyLength;i++) {
			String word=KeyList[i];
			start=0;
			for(j=0;j<List.length&&(word.equals(List[j]));j++) {
			    
			}
			if(j>start) {
				System.out.println();
			}
		}
	}

	public static void SortList() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
