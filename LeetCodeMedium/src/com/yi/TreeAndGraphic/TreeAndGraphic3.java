package com.yi.TreeAndGraphic;

import java.util.Arrays;

public class TreeAndGraphic3 {
	/*
	 * 这道题的做题思路是充分利用前序遍历，和中序遍历的特点
	 * 前序的根，左，右，结点访问顺序和中序的左，根，右结点访问顺序
	 * 因为前序遍历序列的第一个元素必然为根结点，再根据这个结点的信息去中序遍历序列中区分根结点的左右子树的遍历序列
	 * 然后通过不断递归的方式，构建完成整个树
	 * 算法举例
	 * 前序遍历序列： 3   9   20   15   7
	 * 中序遍历序列： 9   3   15   20   7
	 * 第一次寻找根结点    
	 * 前序遍历序列     3   9   20   15   7
	 *            ↑  
	 *           根节点
	 * 中序遍历序列     9   3   15   20   7
	 *            ↑   ↑   ↑
	 *         左子树   根节点   右子树
	 *  对应前序遍历序列中属于 左子树的结点 9  右子树的结点 20 15 7
	 *  对左右子树采取相同的手法，直到遍历完结点
	 *  
	 * 这里在编程中遇到的问题是，去中序遍历结果中查找根结点对应的下标位置时，
	 * 我一开始使用了arrays.binarysearch()函数
	 * 结果出现查找不出的结果，原因是因为二分查找是对于已排好序的数组进行查找的，而我这里的数组还没有排序
	 * 
	 * 这个函数的运行效率不高，主要是因为每次递归的时候，我都要切割数组，在内存空间中要申请位置新建两个左右子数组
	 * 空间复杂度较高，比较好的方法是只传递左右子树的边界，不重新分配内存空间
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
