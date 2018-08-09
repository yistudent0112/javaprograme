package com.yi.DynamicPrograme;

import java.util.Arrays;
/**
 * 
 * ������Ľ�𷽰�����Ϊһ�¼���
 * 1.�ҵ�һ��ֵΪ������㿪ʼ��������
 * 2.����Ϊ��������£�������������ͣ������������֮ǰ�������ֵ���Ƚϣ�ȡ����Ǹ��������ֵ
 * 3.����Ϊ��������£�������ǰ�ĺͣ����¿�ʼѰ�����
 * 
 *�����������Ƶ�ʱ��û�п��Ƕ��������ȫΪ������������Ե���������ȫΪ����ʱ��
 *Ч�ʻ�ǳ��ĵ�
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
