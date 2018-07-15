package com.yi.array;

/**
 * 
 * @ClassName: Array1
 * @Description: TODO ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ� ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
 *               ��Ҫʹ�ö��������ռ䣬 �������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
 * @author yi
 * @date 2018��7��14��
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
