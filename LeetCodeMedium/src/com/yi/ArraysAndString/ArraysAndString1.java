package com.yi.ArraysAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * �����������ܵ�Ҫ��Ƚϸߣ�������ֻ����ǿ�ﵽҪ��֮����ʱ�仹�᳢�Զ�������������ϵ��Ż�
 * ������˼·�������ģ�Ҫ�ҵ�3������Ӻ�Ϊ0
 * ���Ƚ����������������֮��������һ��ͷָ�룬�̶�סһ������ȥ����������ӵ��ڹ̶������ж�
 * ����������Ϊ�̶������ж�ʱ����ͷβ����������ȥѰ�ң�һ��Ϊͷָ���һ��λ�ã�����һ��Ϊβָ��
 * һͷһβ���ϵ���С������Χ��ֱ�����±߽��������ײ��������ǰ���жϣ�ȥ����һ��ͷָ���λ�ÿ�ʼ�ж�
 * ��ͷָ������������ʱ�����ҵ������еĴ�
 */
public class ArraysAndString1 {
	public List<List<Integer>> threeSum(int[] nums) {
		if (nums.length < 3) {
			return new ArrayList<List<Integer>>();
		}
		int length = nums.length;
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		//i��ʾͷָ��
		int i = 0;
		int j = 0;
		int k = 0;
		int sum = 0;
		for (i = 0; i < length;) {
			//����ǰ���Ѿ�����0ʱ�������Ѿ��������ҵ���Ӻ�Ϊ1������ˣ�����ѭ��
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
					//�ж��ҳ��Ľ���Ƿ��ظ�
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
			//������ͷ������ֺ�ǰһ���ж���ͬʱ��������Щ��ͬ�����֣���һ����ֵ��ͬ�ĵط���ʼѰ��
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
