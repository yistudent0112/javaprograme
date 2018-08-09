package com.yi.DynamicPrograme;

import java.util.Arrays;
/**
 * 
 * 将本题的解答方案抽象为一下几步
 * 1.找到一个值为正的起点开始计算最大和
 * 2.当和为正的情况下，继续保留这个和，并将这个和与之前存下最大值做比较，取大的那个更新最大值
 * 3.当和为负的情况下，舍弃当前的和，从新开始寻找起点
 * 
 *这个函数在设计的时候没有考虑读入的数组全为负的情况，所以当读入数组全为负的时候
 *效率会非常的低
 */
public class DynamicPrograme3 {
	public int maxSubArray(int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int sum = 0;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (sum == 0) {
				if (nums[i] > sum) {
					sum = nums[i];
					max = Math.max(sum, max);
				}
			} else {
				if ((sum + nums[i]) > 0) {
					max = Math.max(max, sum + nums[i]);
					sum = sum + nums[i];
				} else {
					sum = 0;
				}
			}
		}
		if (max == 0) {
			Arrays.sort(nums);
			max = nums[nums.length - 1];
		}
		return max;
	}

	public static void main(String[] args) {
		DynamicPrograme3 test = new DynamicPrograme3();
		int[] nums = { 8, -19, 5, -4, 20 };
		int i = test.maxSubArray(nums);
		System.out.println(i);
	}

}
