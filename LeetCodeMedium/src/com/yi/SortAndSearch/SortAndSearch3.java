package com.yi.SortAndSearch;

import java.util.Arrays;
/*
 * ������������򵥵ķ�������������������Ȼ�󷵻���ӦҪ�������
 * �Ż��ķ���Ӧ���Ƕ�����Ĺ�����һ���Ĵ��������ܹ�������ҵ���k�����
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
