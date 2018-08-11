package com.yi.ArraysAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 这道题对于性能的要求比较高，我现在只能勉强达到要求，之后有时间还会尝试对这道题做性能上的优化
 * 这道题的思路是这样的，要找到3个数相加和为0
 * 就先将无序的数组做排序，之后先设置一个头指针，固定住一个数，去做两个数相加等于固定数的判断
 * 在做两数和为固定数的判断时，从头尾两个方向上去寻找，一个为头指针加一的位置，还有一个为尾指针
 * 一头一尾不断的缩小检索范围，直到上下边界产生了碰撞就跳出当前的判断，去从下一个头指针的位置开始判断
 * 当头指针遍历完数组的时，就找到了所有的答案
 */
public class ArraysAndString1 {
	public List<List<Integer>> threeSum(int[] nums) {
		if (nums.length < 3) {
			return new ArrayList<List<Integer>>();
		}
		int length = nums.length;
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		//i表示头指针
		int i = 0;
		int j = 0;
		int k = 0;
		int sum = 0;
		for (i = 0; i < length;) {
			//当当前数已经大于0时，表面已经不可能找到相加和为1的情况了，跳出循环
			if (nums[i] > 0) {
				break;
			}
			j = i + 1;
			k = length - 1;
			while (j < k) {
				sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(nums[k]);
					j++;
					k--;
					//判断找出的结果是否重复
					if (!result.contains(temp)) {
						result.add(temp);
						// break;
					}
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
			i++;
			//当出现头结点数字和前一次判断相同时，跳过这些相同的数字，从一个数值不同的地方开始寻找
			while (i < length - 2 && nums[i] == nums[i - 1]) {
				i++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ArraysAndString1 test = new ArraysAndString1();
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		test.threeSum(nums);
	}

}
