package com.yi.Tree;

import java.util.ArrayList;

public class Tree2 {
	/**
	 * 
	 * ���ݶ���ƽ�����Ķ���������ÿһ�����ķ�Χ
	 * �������Ƽбյķ��������ϵ���Сֵ�ķ�Χ��
	 * ����һ���ж�ÿһ��Ľ���Ƿ����Ҫ��
	 */
//	public boolean isValidBST(TreeNode root) {
//		if (root == null) {
//			return true;
//		}
//		return vaild(root,Long.MIN_VALUE,Long.MAX_VALUE);
//	}
//    public boolean vaild(TreeNode temp,long min,long max) {
//    	if(temp==null) {
//    		return true;
//    	}
//    	if(temp.val<=min||temp.val>=max) {
//    		return false;
//    	}
//    	return vaild(temp.left,min,temp.val)&&vaild(temp.right,temp.val,max);
//    }
	/*
	 * ��Ϊ���������������������������������,
	 * ���ԶԴ�����Ķ���������һ���������,
	 * Ȼ��鿴���Ľ���Ƿ�Ϊ˳������ľ����б�
	 */
	public boolean isValidBST(TreeNode root) {
		ArrayList<TreeNode>array=new ArrayList<TreeNode>();
		addTreeNode(root,array);
		for(int i=0;i<array.size()-1;i++) {
			if(array.get(i).val>=array.get(i+1).val) {
				return false;
			}
		}
	return true;
	}
	public void addTreeNode(TreeNode temp,ArrayList<TreeNode>array) {
		if(temp==null) {
			return ;
		}
		addTreeNode(temp.left, array);
		array.add(temp);
		addTreeNode(temp.right, array);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree2 test = new Tree2();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(20);
		test.isValidBST(root);
	}

}
