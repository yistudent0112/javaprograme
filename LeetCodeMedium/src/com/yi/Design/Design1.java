package com.yi.Design;

import java.util.LinkedList;
import java.util.Objects;
/*
 * 在这里我是采用层序遍历来序列化二叉树的，
 * 所以对应的反序列化时就也是对应的使用层序遍历来处理
 * 在这有多种方法可以选择，无论是哪种遍历二叉树的方法，
 * 只要序列化和反序列化时的遍历方法保持一致就都能够成功
 */
public class Design1 {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		int nodeindex = 0;
		StringBuffer sb = new StringBuffer();
		if (root == null) {
//			sb.append(nodeindex);
//			sb.append(":");
			sb.append("null");
			return sb.toString();
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode temp = null;
		while (!queue.isEmpty()) {
			temp = queue.pop();
			if(temp==null) {
//				sb.append(nodeindex++);
//				sb.append(":");
				sb.append("null");
				sb.append(",");
			}
			if(temp!=null) {
//			sb.append(nodeindex++);
//			sb.append(":");
			sb.append(temp.val);
			sb.append(",");
			queue.add(temp.left);
			queue.add(temp.right);
}
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String []nodes=data.split(",");
		int length=nodes.length-1;
		if(Objects.equals(nodes[0], "null")) {
			return null;
		}
		LinkedList<TreeNode>queue=new LinkedList<TreeNode>();
		TreeNode head = new TreeNode(Integer.valueOf(nodes[0]));
		queue.add(head);
		TreeNode temp=null;
		int index=1;
		while(!queue.isEmpty()) {
			temp=queue.pop();
			if(!Objects.equals(nodes[index], "null")) {
				temp.left=new TreeNode(Integer.valueOf(nodes[index]));
				queue.add(temp.left);
			}
			index++;
			if(!Objects.equals(nodes[index], "null")) {
				temp.right=new TreeNode(Integer.valueOf(nodes[index]));
				queue.add(temp.right);
			}
			index++;
		}
		return head;
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.right.left = new TreeNode(4);
		head.right.right = new TreeNode(5);
		Design1 test = new Design1();
		String word=test.serialize(null);
test.deserialize(word);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
