package com.yi.Sort;

public class Sort1 {
//	public void merge(int[] nums1, int m, int[] nums2, int n) {
//		int nums1Index = 0;
//		int nums2Index = 0;
//if(n==0) {
//	return;
//}
//		while (nums1Index < nums1.length || nums2Index < n) {
//			if(nums1Index== nums1.length) {
//				nums2Index++;
//			}
//			else if(nums2Index==n) {
//				nums1Index++;
//			}
//			if(nums1Index==nums1.length&&nums2Index==n) {
//				break;
//			}
//			if (nums1[nums1Index] > nums2[nums2Index]) {
//				int temp = nums1[nums1Index];
//				nums1[nums1Index] = nums2[nums2Index];
//				nums2[nums2Index] = temp;
//				//nums2Index++;
//			} else if(nums1Index>m) {
//				int temp = nums1[nums1Index];
//				nums1[nums1Index] = nums2[nums2Index];
//				nums2[nums2Index] = temp;
//				nums2Index++;
//				
//			}
//			else {
//				nums1Index++;
//			}
//		}
//
//	}
	/**
	 * 
	 * ������Ϊ�˷�ֹ����nums1����Ϣ�����ǣ����ôӺ���ǰ��ֵ�ķ��� �ڸ�ֵ�Ĺ�����Ҫ���ǵ�һ�������ֵ�Ѿ����ÿ��ˣ� ʣ�µ�����Ԫ��ȫ��һ����������ȡ�����
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int i = m - 1, j = n - 1, k = m + n - 1; k > -1; k--) {
			// ����һ��ĩβֵ�����������ĩβֵ�����������ֵ�ѱ�������
			if ((i > -1 && j > -1 && nums1[i] > nums2[j]) || (i > -1 && j < 0)) {
				nums1[k] = nums1[i];
				i--;
			}
			// ����һ��ĩβֵС�ڵ����������ĩβֵ��������һ��ֵ�Ѿ���������
			else if ((i > -1 && j > -1 && nums1[i] <= nums2[j]) || (i < 0 && j > -1)) {
				nums1[k] = nums2[j];
				j--;
			}

		}
	}

	public static void main(String[] args) {
		Sort1 test = new Sort1();
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		test.merge(nums1, 3, nums2, 3);
	}

}
