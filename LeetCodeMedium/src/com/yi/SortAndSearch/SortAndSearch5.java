package com.yi.SortAndSearch;

public class SortAndSearch5 {
	/*
	 * ����������Ҳ���������÷�ת����Ķ���������
	 * ��Ϊһ������һ���������е���������һ�η�ת��Ľ��
	 * Ҳ����˵�������Ĵ󲿷ֵط������������еģ�ֻ������һ������ĵ㿪ʼ�������ǰ�����е����ֶ�ҪС
	 * ����������������Ѱ��Ŀ�꣬����ʹ�ö��ֲ��ҵķ�ʽ��ʵ��
	 * ֻ���������һЩ�жϣ��ȶ��������԰�֣����ֱ�۲����������Ƿ�Ϊ������������У����Ǵ����˷�ת���ֵĶ���
	 * �Ƚ��Ƿ�Ϊ������еķ����ǣ��ȼ۶��е�ͷβԪ�ش�С��������β��Ԫ�ش���ͷ��Ԫ���������������֮���Ƿ�ת����
	 * �ȶ�ǰ�벿�����Ƿ�Ϊ����������жϣ�����ǣ��Ͱ��ն��ֲ���������
	 * ������Ǿ����ж�������Ƿ����ں�벿�ֵķ�Χ�ڣ�����ǾͰѷ�Χ������벿�֣�������Ǿ���ǰ�벿�ֵݹ����
	 * ��    ������Ϣ     4  5  6  7  1  2
	 *            ��     ��  ��     ��
	 * ǰ�벿�ֵ�ͷ���        ǰβ�ڵ�            ��벿�ֵ�β�ڵ�
	 * ˵��ǰ�벿��Ϊ�����������      ��벿�ְ����˷�ת����      ��ǰ�벿�ֲ�ȡ��ͨ�Ķ��ֲ���
	 * �Ժ�벿�������⴦��           7    1    2
	 *                    ��    ��    ��
	 *                 ͷ���                   β�ڵ�
	 *   ������ҹؼ���С��ͷͷ���Ԫ�أ�������β�ڵ�Ԫ�أ�˵�����������Χ�ڣ�ȥ��һ����ΧѰ��
	 *   ��֮�����������Χ�ڣ������ݹ����
	 *                 
	 */
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int result = -1;
		int left = 0;
		int right = nums.length - 1;
		int middle = (left + right) / 2;
		//times��ʾ���ҵĴ�������Ϊû����ƺ��˳�ѭ��������
		//����ֻ��ͨ�����Ʋ��Ҵ������˳�ѭ��
		int times=0;
		while (left <= right&&(times<nums.length)) {
			//���ҵ�Ŀ��ʱ������ѭ��
			if (target == nums[middle]) {
				result = middle;
				break;
			}
			if(target==nums[right]) {
				result=right;
				break;
			}
			//Ϊ�������������ʱ�Ĵ�����
			if (nums[left] < nums[middle]) {
				if (target < nums[left] || target > nums[middle]) {
					left = middle + 1;
				} else if (target < nums[middle]) {
					right = middle;
				}

			}
			//Ϊ��ת����ʱ�Ĵ�����
			else if (nums[left] > nums[middle]) {
				if (target > nums[middle] && target < nums[left]) {
					left = middle;
				} else {
					right = middle;
				}
			}
			middle = (left + right) / 2;
			times++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		SortAndSearch5 test = new SortAndSearch5();
		test.search(nums, 6);

	}

}
