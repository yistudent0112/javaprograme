package com.imooc.ArraysAndString;

import java.util.ArrayList;
import java.util.List;
/*
 * 这道题就是要仔细观察横坐标和纵坐标的变换状态，总结他们变换的过程，就能够模拟出内螺旋矩阵
 * 点的扫描方向是向下图所示的那样 
 *         1 
 * 左上角--------------→右上角             1列索引递增
 *  ↑                   |       2行索引递增  
 * 4|                   | 2     3列索引递减 
 *  |                   |       4行索引递减
 *  |                   ↓
 * 左下角←--------------右下角
 *            3
 * 当完成一个循环后，就需要更新边界条件，使得不会重复遍历边界上的元素
 * 需要注意的是要考虑只有一行或一列的特殊情况
 * 这是不能去更新边界条件，不然会出现错误
 * 例         只有一列元素           1
 *                   2
 *                   3
 *     当遍历到2的时候就会满足更新边界的条件，这时如果更新了边界，就会导致有点不被扫描到              
 */
public class ArraysAndString2 {
	 public List<Integer> spiralOrder(int[][] matrix) {
		 List<Integer>list=new ArrayList<Integer>();
	        if(matrix==null||matrix.length==0||matrix[0].length==0) {
	        	return list;
	        }
	        int rowEnd=matrix.length;
	        int columnEnd=matrix[0].length;
//	        System.out.println("rowend"+rowEnd);
//	        System.out.println("columnend"+columnEnd);
	        int rowStart=0;
	        int columnStart=0;
	        int number=rowEnd*columnEnd;
	        rowEnd--;
	        columnEnd--;
	        int i=0;
	        int j=0;
	        while(number>0) {
	        	list.add(matrix[i][j]);
	        	number--;
	        	if(columnEnd!=columnStart&&i-1==rowStart&&j==columnStart) {
	        		rowEnd--;
	        		columnEnd--;
	        		rowStart++;
	        		columnStart++;
	        	}
	        	if(i==rowStart&&j<columnEnd) {
	        		j++;
	        	}
	        	else if(j==columnEnd&&i<rowEnd) {
	        		i++;
	        	}else if(i==rowEnd&&j>columnStart) {
	        		j--;
	        	}else if(j==columnStart&&i>rowStart) {
	        		i--;
	        	}
	        }
	        return list;
	        
	    }
	public static void main(String[] args) {
		int [][]matrix= {
//				{2,3,4},
//				{5,6,7},
//				{8,9,10},
//				{11,12,13},
//				{14,15,16}
				{1},
				{2},
				{3}
		};
		ArraysAndString2 test=new ArraysAndString2();
		List<Integer>list=test.spiralOrder(matrix);
		for(int temp:list) {
			System.out.println(temp);
		}

	}

}
