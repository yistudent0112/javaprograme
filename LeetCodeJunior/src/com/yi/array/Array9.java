package com.yi.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName: Array9
 * @Description: TODO ����һ�����������һ��Ŀ��ֵ���ҳ������к�ΪĿ��ֵ����������
 *               ����Լ���ÿ������ֻ��Ӧһ�ִ𰸣���ͬ����Ԫ�ز��ܱ��ظ����á�
 * @author yi
 * @date 2018��7��15��
 *
 */
public class Array9 {
	public int[] twoSum(int[] nums, int target) {
		int[] index = new int[2];
		Map<Integer, Integer> KeyNums = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			KeyNums.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			if (KeyNums.containsKey(target - nums[i])) {
				if(i==KeyNums.get(target - nums[i]))
					continue;
				index[0] = i;
				index[1] = KeyNums.get(target - nums[i]);		
				break;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array9 test = new Array9();
		int[] nums = { 3, 4, 2 };
		test.twoSum(nums, 6);
	}

}
