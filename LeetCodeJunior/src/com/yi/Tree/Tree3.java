package com.yi.Tree;

import java.util.LinkedList;

public class Tree3 {
	/**
	 * 
	 * 利用递归,来遍历左子树和右子树的结点是否对称
	 */
	  public boolean isSymmetric(TreeNode root) {
		  if (root == null) {
				return true;
			}
		  return compare(root.left,root.right);
	    }
	  public boolean compare(TreeNode left,TreeNode right) {
		  if(left==null&&right==null) {
			  return true;
		  }
		  if(left==null||right==null) {
			  return false;
		  }
		  return(left.val==right.val)
				  &&compare(left.left, right.right)&&
				  compare(left.right, right.left);
	  }
	  /**
	   * 
	   * 利用层序遍历,把每一层的结点都拿出来进行比较,
	   * 但没有考虑结点在层中的结构位置(因为层序遍历只能拿到有值的点)
	   * 所以当树出现同构的情况下,就会无法判断
	   */
//	  public boolean isSymmetric(TreeNode root) {
//		  if (root == null) {
//				return true;
//			}
//			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
//			queue.add(root);
//			while (!queue.isEmpty()) {
//				int m=queue.size();
//				int[]tempValue=new int[m];
//				for(int i=0;i<m;i++) {
//					TreeNode temp = queue.pop();
//					tempValue[i]=temp.val;
//					if (temp.left != null) {
//						queue.add(temp.left);
//					}
//					if (temp.right != null) {
//						queue.add(temp.right);
//					}
//				}
//				for(int i=0;i<m/2;i++) {
//					if(tempValue[i]!=tempValue[m-1-i]) {
//						return false;
//					}
//				}
//			}  
//			return true;
//	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
