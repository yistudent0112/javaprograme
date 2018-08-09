package com.yi.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Tree1 {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		int depth = 0;
		queue.add(root);
		while (!queue.isEmpty()) {
			int m=queue.size();
			for(int i=0;i<m;i++) {
				TreeNode temp = queue.pop();
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
			depth++;
		}
		return depth;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree1 test = new Tree1();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		test.maxDepth(root);
	}

}
