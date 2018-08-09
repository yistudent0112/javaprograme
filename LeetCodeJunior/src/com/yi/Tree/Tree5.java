package com.yi.Tree;

public class Tree5 {
	/**
	 * ���������е�����ת��Ϊ�߶�ƽ�������
	 * ��Ҫ�㷨�ǽ������е��м�λ����ȡ������Ϊһ�����
	 * Ȼ���޸�����ȡֵ�ı߽緶Χ���ֱ�Ѱ�ҵ�ǰ����������ҽ��
	 * ͨ�����ϵĵݹ����������һ�������ĸ߶�ƽ�������
	 * 
	 */
	 public TreeNode sortedArrayToBST(int[] nums) {
	        if(nums==null||nums.length==0) {
	        	return null;
	        }
	        return findNode(nums,0,nums.length-1);
	    }
	 public TreeNode findNode(int []nums,int lower,int higher) {
		 if(lower<=higher) {
			 int middle=(lower+higher)/2;
			 TreeNode temp=new TreeNode(nums[middle]);
			 temp.left=findNode(nums, lower, middle-1);
			 temp.right=findNode(nums, middle+1, higher);
			 return temp;
		 }
		 else {
			 return null;
		 }
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//System.out.println((int)0.5+"");
		int[]nums= {  -10,-3,0,5,9};
		Tree5 test=new Tree5();
		test.sortedArrayToBST(nums);
	
	}

}
