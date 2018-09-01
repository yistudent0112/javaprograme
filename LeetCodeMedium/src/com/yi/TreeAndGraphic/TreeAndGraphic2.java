package com.yi.TreeAndGraphic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/*
 * 这题就是利用树的层序遍历算法，用一个队列来存贮每一层的结点信息。
 * 然后不断向下一层读取结点，直到遍历完树，
 * 在这个过程中，做一个额外判断，每到偶数层的时候
 * 就将该层的数据做一个颠倒，使用collections的reverse函数就能实现
 * 在题目的过程中，我犯了一个错误，就是习惯性的使用push()去和pop()输出函数对应，这样这就是一个栈了
 * 而不是一个队列了，应该使用add()去和pop()对应
 */
public class TreeAndGraphic2 {
	  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		  if(root==null) {
			  return new ArrayList<List<Integer>>();
		  }
	        List<List<Integer>>result=new ArrayList<List<Integer>>();
	        LinkedList<TreeNode>queue=new LinkedList<TreeNode>();
	        boolean reverse=false;
	        queue.push(root);
	        TreeNode temp;
	        while(!queue.isEmpty()) {
	        	int nums=queue.size();
	        	List<Integer> level=new ArrayList<Integer>();
	        	for(int i=0;i<nums;i++) {
	        		temp=queue.pop();
	        		level.add(temp.val);
	        		if(temp.left!=null) {
	        			queue.add(temp.left);
	        		}
	        		if(temp.right!=null) {
	        			queue.add(temp.right);
	        		}
	        	}
	        	if(reverse) {
	        		Collections.reverse(level);
	        		reverse=false;
	        	}else {
	        		reverse=true;
	        	}
	        	result.add(level);
	        }
	        return result;
	    }
	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(9);
		root.right=new TreeNode(20);
		root.right.left=new TreeNode(15);
		root.right.right=new TreeNode(7);
		TreeAndGraphic2 test=new TreeAndGraphic2();
		test.zigzagLevelOrder(root);

	}

}
