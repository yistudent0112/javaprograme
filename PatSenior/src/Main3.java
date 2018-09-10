import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
	private static Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
	private static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		Long number = in.nextLong();
		Long copy=number;
		in.close();
		
		Long range=(long) Math.sqrt(number);
		for(int i=2;i<=range+1;i++) {
			if(isPrime(i)) {
				while(copy%i==0) {
					if(map.containsKey(i)) {
						map.put(i, map.get(i)+1);
					}else {
						map.put(i, 1);
					}
					copy=copy/i;
				}
				list.add(i);
			}
			if(copy==1) {
				break;
			}
		}
//		for(int key:map.keySet()) {
//			System.out.println(key+" "+map.get(key));
//		}
		System.out.print(number + "=");
		List<Map.Entry<Integer, Integer>>list=new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
		int length=list.size();
		if(length==0) {
			System.out.println(number);
		}else {
		int i;
		for(i=0;i<length-1;i++) {
			if(list.get(i).getValue()==1) {
				System.out.print(list.get(i).getKey()); 
			}else {
				 System.out.print(list.get(i).getKey()+"^"+list.get(i).getValue());
			}
			 System.out.print("*");
		}
		if(list.get(i).getValue()==1) {
			System.out.print(list.get(i).getKey()); 
		}else {
			 System.out.print(list.get(i).getKey()+"^"+list.get(i).getValue());
		}
		}
		if(copy!=1) {
			System.out.print("*"+copy);
		}
//		 for(int key:map.keySet()) {
//			 if(map.get(key)==1) {
//				System.out.print(key); 
//			 }else {
//		 System.out.print(key+"^"+map.get(key));
//			 }
//			 {
//				 System.out.print("*");
//			 }
//		 }
	}

	public static boolean isPrime(long n) {
		boolean flag = true;
		if (n < 2) {
			flag = false;
		}
		int length = list.size();
		for (int i = 0; i < length; i++) {
			if (n % list.get(i) == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
