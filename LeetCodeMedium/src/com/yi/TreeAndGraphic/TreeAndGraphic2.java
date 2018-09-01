package com.yi.TreeAndGraphic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/*
 * ��������������Ĳ�������㷨����һ������������ÿһ��Ľ����Ϣ��
 * Ȼ�󲻶�����һ���ȡ��㣬ֱ������������
 * ����������У���һ�������жϣ�ÿ��ż�����ʱ��
 * �ͽ��ò��������һ���ߵ���ʹ��collections��reverse��������ʵ��
 * ����Ŀ�Ĺ����У��ҷ���һ�����󣬾���ϰ���Ե�ʹ��push()ȥ��pop()���������Ӧ�����������һ��ջ��
 * ������һ�������ˣ�Ӧ��ʹ��add()ȥ��pop()��Ӧ
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
