package com.yi.TreeAndGraphic;

import java.util.ArrayList;
import java.util.List;

public class TreeAndGraphic5 {
	/*
	 * 这道题利用了二叉搜索数的特点，就是二叉搜索树的中序遍历结果正好是对应的数字的升序排列
	 * 所以对二叉树做一次中序遍历就能够完成任务了
	 * 
	 * 这道题可以做性能优化，我现在是要完成一次完整的中序遍历，再查找结果
	 * 而要找到第k小的节点也可以被等价与做中序遍历找到的第k个节点，(因为中序遍历所找到的都是当前最小的那个节点)
	 * 这样能减少平均时间复杂度为原来的一半
	 */
	 public int kthSmallest(TreeNode root, int k) {
	List<Integer>result=new ArrayList<Integer>();
	inorder(root, result);
	return result.get(k-1);
	    }
	 public void inorder(TreeNode root,List<Integer> result) {
		 if(root==null) {
			 return ;
		 }
		 inorder(root.left,result);
		 result.add(root.val);
		 inorder(root.right,result);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

