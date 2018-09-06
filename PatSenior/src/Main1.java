import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
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

	}

	public static void findLevel(Map<Integer, List> map, int key, int level) {

	}
}
