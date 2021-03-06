import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
private static double value=0.0;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		int number = in.nextInt();
		double price = in.nextDouble();
		double percent = in.nextDouble();
		int num = 0;
		Map<Integer, List> map = new HashMap<Integer, List>();
		List<Integer> list = new ArrayList<Integer>();
		// int []nums=new int[number];
		int[] sell = new int[number];
		// nums[0]=0;
		for (int i = 0; i < number; i++) {
			num = in.nextInt();
			if (num == 0) {
				map.put(i, null);
				sell[i] = in.nextInt();
			} else {
				list = new ArrayList<Integer>();
				for (int j = 0; j < num; j++) {
					list.add(in.nextInt());
					// nums[in.nextInt()]=nums[i]+1;
				}
				map.put(i, list);
			}
		}
		in.close();
findLevel(map, 0,sell,price,percent);
System.out.printf("%.1f",value);
	}
/*
 * 利用map来保存，供应节点之间的关系，等于变相实现了一个树，
 * 然后对这个数做深度遍历的同时，把最终的答案给算出来
 */
	public static void findLevel(Map<Integer, List> map, int key,int []sell,double price,double percent) {
             List<Integer>list=map.get(key);
             if(list==null||list.size()==0) {
            	 value+=sell[key]*price;
            	 return ;
             }
             int size=list.size();
             for(int i=0;i<size;i++) {
            	 //price=price*(1+percent/100);
            	 findLevel(map, list.get(i),sell,price*(1+percent/100),percent);
             }
	}
}
