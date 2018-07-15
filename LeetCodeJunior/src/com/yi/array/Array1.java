package com.yi.array;

/**
 * 
 * @ClassName: Array1
 * @Description: TODO 给定一个排序数组，你需要在原地删除重复出现的元素， 使得每个元素只出现一次，返回移除后数组的新长度。
 *               不要使用额外的数组空间， 你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @author yi
 * @date 2018年7月14日
 *
 */
public class Array1 {
	public int removeDuplicates(int[] nums) {
		int length = 0;
	for(int i=0;i<nums.length;i++) {
		if(nums[i]!=nums[length]) {
			length++;
			nums[length]=nums[i];
		}
	}
	length++;
		return length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array1 test = new Array1();
		int[] nums = { 1, 1, 1, 2, 2, 2, 3, 4 };
		System.out.println(test.removeDuplicates(nums));
	}

}
