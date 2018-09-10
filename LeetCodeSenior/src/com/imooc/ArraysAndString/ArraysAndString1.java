package com.imooc.ArraysAndString;
/*
 * 这道题利用类似kmp算法来实现，主要通过两个数组来推导出结果，这两个数组分别为前缀和与后缀和
 * 前缀和存贮的是当前数字前面所有元素的乘积(不包括当前元素)，后缀和存贮的当前数字后面所有元素的乘积(不包括当前元素)
 * 例      给定数组为           1        2         3          4
 *     当前数字              1        2         3          4
 *     前缀                      1        1        1*2       1*2*3
 *     后缀                  2*3*4    3*4        4           1
 *最后结果为前缀乘以后缀  
 *可以明显的看出前缀与后缀的组合关系，从而得出两个数组，分别存贮前缀和后缀，就能够计算出结果了
 */
public class ArraysAndString1 {
	//未采用空间优化策略，空间复杂度为O(n)，通过两个一维数组来保存前缀和后缀乘积
//	public int[] productExceptSelf(int[] nums) {
//		if (nums == null || nums.length == 0) {
//			return null;
//		}
//		int length = nums.length;
//		int[] result = new int[length];
//		int[] pre = new int[length];
//		int[] sub = new int[length];
//		int sum = 1;
//		pre[0] = sum;
//		for (int i = 1; i < length; i++) {
//			sum *= nums[i - 1];
//			pre[i] = sum;
//		}
//		sum = 1;
//		sub[length - 1] = sum;
//		for (int i = length - 2; i > -1; i--) {
//			sum *= nums[i + 1];
//			sub[i] = sum;
//		}
//		// for(int temp:pre) {
//		// System.out.print(temp+" ");
//		// }
//		// for(int temp:sub) {
//		// System.out.print(temp+" ");
//		// }
//		for (int i = 0; i < length; i++) {
//			result[i] = pre[i] * sub[i];
//		}
//		return result;
//	}
	//采用空间优化，空间复杂度为常数级，直接利用结果数组来保存中间结果
	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		int length = nums.length;
		int[] result = new int[length];
		result[0]=1;
		int sum=1;
		for(int i=1;i<length;i++) {
			sum*=nums[i-1];
			result[i]=sum;
		}
		sum=1;
		for(int i=length-2;i>-1;i--) {
			sum*=nums[i+1];
			result[i]=result[i]*sum;
		}
		return result;
	}
	public static void main(String[] args) {
	int []nums= {1,2,3,4};
	ArraysAndString1 test=new ArraysAndString1();
	int []result=test.productExceptSelf(nums);
for(int temp:result) {
	System.out.println(temp);
}
	}

}
