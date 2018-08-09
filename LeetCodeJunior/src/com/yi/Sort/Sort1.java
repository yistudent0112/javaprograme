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
	 * 本题中为了防止数组nums1的信息被覆盖，采用从后往前赋值的方法 在赋值的过程中要考虑到一个数组的值已经被拿空了， 剩下的数组元素全从一个数组中拿取的情况
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int i = m - 1, j = n - 1, k = m + n - 1; k > -1; k--) {
			// 数组一的末尾值大于数组二的末尾值或者数组二的值已被赋完了
			if ((i > -1 && j > -1 && nums1[i] > nums2[j]) || (i > -1 && j < 0)) {
				nums1[k] = nums1[i];
				i--;
			}
			// 数组一的末尾值小于等于数组二的末尾值或者数组一的值已经被赋完了
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
