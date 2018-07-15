package com.yi.array;

import java.util.ArrayList;
import java.util.List;
/**
 * 
    * @ClassName: Array6  
    * @Description: TODO
    * 给定两个数组，写一个方法来计算它们的交集。
    * @author yi  
    * @date 2018年7月15日  
    *
 */
public class Array6 {
	public int[] intersect(int[] nums1, int[] nums2) {
		int length1 = nums1.length;
		int length2 = nums2.length;
		int SmallLength = 0;
		int LongLength = 0;
		if (length1 == 0 || length2 == 0) {
			return new int[0];
		}
		boolean flag = false;
		if (length1 > length2) {
			SmallLength = length2;
			LongLength = length1;
		} else {
			SmallLength = length1;
			LongLength = length2;
			flag = true;
		}
		List<Integer> temp = new ArrayList<Integer>();

		for (int i = 0; i < SmallLength; i++) {
			for (int j = 0; j < LongLength; j++) {
				if (flag) {
					if (nums1[i] == nums2[j]) {
						temp.add(nums1[i]);
						nums2[j]=-1;
						break;
					}
				} else {
					if (nums2[i] == nums1[j]) {
						temp.add(nums2[i]);
						nums1[j]=-1;
						break;
					}
				}
			}
		}
		int[] num = new int[temp.size()];
		int index = 0;
		for (int t : temp) {
			num[index++] = t;
		}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array6 test = new Array6();
		int[] num1 = { 3, 1, 2 };
		int[] num2 = { 1 };
		test.intersect(num1, num2);
	}

}
