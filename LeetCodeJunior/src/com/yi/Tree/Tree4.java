package com.yi.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree4 {
	/**
	 * 
	 * 对于二叉树的层序遍历，采用一个队列才存贮每一层的结点，一层层的遍历
	 * 就能完成层序遍历
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
