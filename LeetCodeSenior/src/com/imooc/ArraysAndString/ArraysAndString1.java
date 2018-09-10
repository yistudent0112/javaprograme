package com.imooc.ArraysAndString;
/*
 * �������������kmp�㷨��ʵ�֣���Ҫͨ�������������Ƶ������������������ֱ�Ϊǰ׺�����׺��
 * ǰ׺�ʹ������ǵ�ǰ����ǰ������Ԫ�صĳ˻�(��������ǰԪ��)����׺�ʹ����ĵ�ǰ���ֺ�������Ԫ�صĳ˻�(��������ǰԪ��)
 * ��      ��������Ϊ           1        2         3          4
 *     ��ǰ����              1        2         3          4
 *     ǰ׺                      1        1        1*2       1*2*3
 *     ��׺                  2*3*4    3*4        4           1
 *�����Ϊǰ׺���Ժ�׺  
 *�������ԵĿ���ǰ׺���׺����Ϲ�ϵ���Ӷ��ó��������飬�ֱ����ǰ׺�ͺ�׺�����ܹ�����������
 */
public class ArraysAndString1 {
	//δ���ÿռ��Ż����ԣ��ռ临�Ӷ�ΪO(n)��ͨ������һά����������ǰ׺�ͺ�׺�˻�
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
	//���ÿռ��Ż����ռ临�Ӷ�Ϊ��������ֱ�����ý�������������м���
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
