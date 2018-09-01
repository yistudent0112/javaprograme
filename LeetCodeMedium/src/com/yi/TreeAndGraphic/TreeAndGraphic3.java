package com.yi.TreeAndGraphic;

import java.util.Arrays;

public class TreeAndGraphic3 {
	/*
	 * ����������˼·�ǳ������ǰ�������������������ص�
	 * ǰ��ĸ������ң�������˳���������󣬸����ҽ�����˳��
	 * ��Ϊǰ��������еĵ�һ��Ԫ�ر�ȻΪ����㣬�ٸ������������Ϣȥ����������������ָ��������������ı�������
	 * Ȼ��ͨ�����ϵݹ�ķ�ʽ���������������
	 * �㷨����
	 * ǰ��������У� 3   9   20   15   7
	 * ����������У� 9   3   15   20   7
	 * ��һ��Ѱ�Ҹ����    
	 * ǰ���������     3   9   20   15   7
	 *            ��  
	 *           ���ڵ�
	 * �����������     9   3   15   20   7
	 *            ��   ��   ��
	 *         ������   ���ڵ�   ������
	 *  ��Ӧǰ��������������� �������Ľ�� 9  �������Ľ�� 20 15 7
	 *  ������������ȡ��ͬ���ַ���ֱ����������
	 *  
	 * �����ڱ���������������ǣ�ȥ�����������в��Ҹ�����Ӧ���±�λ��ʱ��
	 * ��һ��ʼʹ����arrays.binarysearch()����
	 * ������ֲ��Ҳ����Ľ����ԭ������Ϊ���ֲ����Ƕ������ź����������в��ҵģ�������������黹û������
	 * 
	 * �������������Ч�ʲ��ߣ���Ҫ����Ϊÿ�εݹ��ʱ���Ҷ�Ҫ�и����飬���ڴ�ռ���Ҫ����λ���½���������������
	 * �ռ临�ӶȽϸߣ��ȽϺõķ�����ֻ�������������ı߽磬�����·����ڴ�ռ�
	 */
public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length<1) {
        	return null;
        }
        int rootValue=preorder[0];
        TreeNode root=new TreeNode(rootValue);

        int rootIndexInorder=0;
        for(int temp:inorder) {
        	if(temp==rootValue) {
        		break;
        	}
        	rootIndexInorder++;
        }
        int[]leftInorder=Arrays.copyOf(inorder, rootIndexInorder);
        int[]rightInorder=Arrays.copyOfRange(inorder, rootIndexInorder+1,inorder.length);
        int[]leftPreorder=Arrays.copyOfRange(preorder, 1, rootIndexInorder+1);
        int[]rightPreorder=Arrays.copyOfRange(preorder, rootIndexInorder+1,preorder.length);
        root.left=buildTree(leftPreorder, leftInorder);
        root.right=buildTree(rightPreorder, rightInorder);
        return root;
    }
	public static void main(String[] args) {
		int[] preorder= {3,9,20,15,7};
		int[] inorder= {9,3,15,20,7}; 
		TreeAndGraphic3 test=new TreeAndGraphic3();
		test.buildTree(preorder, inorder);
//System.out.println(Arrays.binarySearch(inorder, 3));
	}

}
