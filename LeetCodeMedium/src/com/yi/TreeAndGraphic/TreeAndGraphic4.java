package com.yi.TreeAndGraphic;

import java.util.LinkedList;

public class TreeAndGraphic4 {
/*
 * 本题就是对于树结构的层序遍历，然后保留一下层序遍历时
 * 每一层的前后结点，把他们连接起来就行了
 */
	public void connect(TreeLinkNode root) {
		if (root != null) {
			LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
			queue.add(root);
			TreeLinkNode preNode;
			TreeLinkNode curNode = null;
			while (!queue.isEmpty()) {
				int num = queue.size();
				curNode = null;
				for (int i = 0; i < num; i++) {
					preNode = curNode;
					curNode = queue.pop();
					if (curNode.left != null) {
						queue.add(curNode.left);
					}
					if (curNode.right != null) {
						queue.add(curNode.right);
					}
					if(preNode!=null&&(preNode!=curNode)) {
						preNode.next=curNode;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		TreeLinkNode root=new TreeLinkNode(1);
		root.left=new TreeLinkNode(2);
		root.right=new TreeLinkNode(3);
		root.left.left=new TreeLinkNode(4);
		root.left.right=new TreeLinkNode(5);
		root.right.left=new TreeLinkNode(6);
		root.right.right=new TreeLinkNode(7);
		TreeAndGraphic4 test=new TreeAndGraphic4();
		test.connect(root);
				

	}

}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}