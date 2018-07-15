package com.yi.array;

/**
 * 
 * @ClassName: Array8
 * @Description: TODO 给定一个数组 nums， 编写一个函数将所有 0 移动到数组的末尾， 同时保持非零元素的相对顺序。
 * @author yi
 * @date 2018年7月15日
 *
 */
public class Array8 {
	public void moveZeroes(int[] nums) {
		int[] copynums = nums.clone();
		for (int i = 0; i < copynums.length; i++) {
			if (copynums[i] == 0) {
				copynums[i] = -1000;
			}
		}
		int start = 0;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = 0;
		}
		for (int i = 0; i < copynums.length; i++) {
			if (copynums[i] != -1000) {
				nums[start] = copynums[i];
				start++;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array8 test = new Array8();
		int[] nums = { 1, 0, 2, 0, 3 };
		test.moveZeroes(nums);
	}

}
