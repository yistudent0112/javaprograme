package com.yi.pat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


/*
 * 提高性能的方法，把arrayList换成map这样每次就不用补遍历查找对于值了
 * 只需要拿到对应的key对对应的所用值
 */
public class Main1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		double price = in.nextDouble();
		double percent = in.nextDouble();
		ArrayList<Integer> chains = new ArrayList<Integer>(number);
		for (int i = 0; i < number; i++) {
			chains.add(in.nextInt());
		}
		in.close();
		int length = chains.size();
		int[] result = new int[length];
		int rootIndex = chains.indexOf(-1);
		result[rootIndex] = 0;
		int key = 0;
		HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
		map.get(1);
		LinkedList<Integer> queue = new LinkedList<Integer>();
		LinkedList<Integer>range=new LinkedList<Integer>();
	    for(int i=0;i<length;i++) {
	 
	    	range.add(i);
	
	    }
		queue.add(rootIndex);
		while (!queue.isEmpty()) {
			key = queue.pop();
			for (int i=0;i<range.size();i++) {
				if (key == chains.get(range.get(i))) {
					result[range.get(i)] = result[key] + 1;
					queue.add(range.get(i));
					range.remove(new Integer(range.get(i)));
				}
			}
		}
		int max=0;
		for(int temp:result) {
			if(temp>max) {
				max=temp;
			}
		}
		int count=0;
		for(int i=0;i<length;i++) {
			if(result[i]==max) {
				count++;
			}
		}
		for(int i=0;i<max;i++) {
			price=price*(1+percent/100);
		}
		System.out.printf("%.2f %d",price,count);
	}

}
