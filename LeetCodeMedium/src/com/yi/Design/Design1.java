package com.yi.Design;

import java.util.LinkedList;
import java.util.Objects;
/*
 * ���������ǲ��ò�����������л��������ģ�
 * ���Զ�Ӧ�ķ����л�ʱ��Ҳ�Ƕ�Ӧ��ʹ�ò������������
 * �����ж��ַ�������ѡ�����������ֱ����������ķ�����
 * ֻҪ���л��ͷ����л�ʱ�ı�����������һ�¾Ͷ��ܹ��ɹ�
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
