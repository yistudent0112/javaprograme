package com.yi.TreeAndGraphic;

import java.util.ArrayList;
import java.util.List;

public class TreeAndGraphic5 {
	/*
	 * ����������˶������������ص㣬���Ƕ��������������������������Ƕ�Ӧ�����ֵ���������
	 * ���ԶԶ�������һ������������ܹ����������
	 * 
	 * ���������������Ż�����������Ҫ���һ������������������ٲ��ҽ��
	 * ��Ҫ�ҵ���kС�Ľڵ�Ҳ���Ա��ȼ�������������ҵ��ĵ�k���ڵ㣬(��Ϊ����������ҵ��Ķ��ǵ�ǰ��С���Ǹ��ڵ�)
	 * �����ܼ���ƽ��ʱ�临�Ӷ�Ϊԭ����һ��
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

