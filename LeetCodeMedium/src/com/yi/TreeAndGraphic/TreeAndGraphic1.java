package com.yi.TreeAndGraphic;

import java.util.ArrayList;
import java.util.List;
/*
 * �������������Ϊ���㣬����㣬�ҽ�����ʽ
 * ���õݹ���ʵ�֣�ʹ�ý��Ϊnull����Ϊ�˳�����
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