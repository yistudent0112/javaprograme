package com.yi.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree4 {
	/**
	 * 
	 * ���ڶ������Ĳ������������һ�����вŴ���ÿһ��Ľ�㣬һ���ı���
	 * ������ɲ������
	 */

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int m = queue.size();
			List<Integer> ceil = new ArrayList<Integer>();
			for (int i = 0; i < m; i++) {
				TreeNode temp = queue.pop();
				ceil.add(temp.val);
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
			result.add(ceil);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
