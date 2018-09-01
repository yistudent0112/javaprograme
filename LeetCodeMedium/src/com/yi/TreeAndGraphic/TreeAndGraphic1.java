package com.yi.TreeAndGraphic;

import java.util.ArrayList;
import java.util.List;
/*
 * 树的中序遍历，为左结点，跟结点，右结点的形式
 * 采用递归来实现，使用结点为null，作为退出条件
 */
public class TreeAndGraphic1 {
public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>inorder=new ArrayList<Integer>();
        inorderTraversal(root, inorder);
        return inorder;
    }
public static void inorderTraversal(TreeNode root,List<Integer> temp) {
	if(root==null)
		return ;
	inorderTraversal(root.left, temp);
	temp.add(root.val);
	inorderTraversal(root.right, temp);
	return ;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }