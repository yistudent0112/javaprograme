package com.yi.Tree;

public class Tree5 {
	/**
	 * 将升序排列的数组转换为高度平衡二叉树
	 * 主要算法是将数组中的中间位置提取出来作为一个结点
	 * 然后将修改数组取值的边界范围来分别寻找当前结点的左结点和右结点
	 * 通过不断的递归掉用来生成一个完整的高度平衡二叉树
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
