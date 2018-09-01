package com.yi.SortAndSearch;

import java.util.Arrays;
/*
 * 这道题就用了最简单的方法，对数组做个排序，然后返回相应要求的数字
 * 优化的方案应该是对排序的过程做一定的处理，让他能够更快的找到第k大的数
 */
public class SortAndSearch3 {
public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
