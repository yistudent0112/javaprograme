package com.yi.SortAndSearch;
/*
 * 我把这道题目给想复杂了
 * 对于这道题我采用了深度和广度同时开展的方法，运行时间非常的慢
 * 而实际上有一个非常巧妙的方法，利用了这个二维数组的特性，能够非常巧妙的解决问题
 * 这个二维数组的特性是每一行都是按递增顺序排列的，每一列也都是按递增顺序排列的
 * 
 */
public class SortAndSearch6 {
	/*
	 * 根据数组的特性，把扫描的初始位置定位第一行的最后一个元素，
	 * 这样如果当前数组元素比目标大了，就往这一行的前面去找
	 * 如果当前数组元素比目标小了，就往这一行的小面去找
	 * 充分利用了数组的特性
	 */
	 public boolean searchMatrix(int[][] matrix, int target) {
		 if(matrix==null||matrix.length==0||matrix[0].length==0) {
	        	return false;
	        }
		    int row=matrix.length;
	        int column=matrix[0].length;
	        int j=column-1;
	        int i=0;
	        boolean result=false;
	        while(j>=0&&i<row) {
	        	if(matrix[i][j]>target) {
	        		j--;
	        	}
	        	else if(matrix[i][j]==target) {
	        		result=true;
	        		break;
	        	}
	        	else if(matrix[i][j]<target) {
	        		i++;
	        	}
	        }
	        return result;
	 }
	 /*
	  * 这个方法是对二维数组同时做深度和广度的遍历
	  * 如果遍历到的数字比目标小就继续寻找，直到找到结果或者遍历到底
	  */
//	 public boolean searchMatrix(int[][] matrix, int target) {
//	        if(matrix==null||matrix.length==0||matrix[0].length==0) {
//	        	return false;
//	        }
//	        int row=matrix.length;
//	        int column=matrix[0].length;
//	        boolean [][]flags=new boolean[row][column];
//	        return search(matrix,target,0,0,row,column,flags);
//	    }
//	 public static boolean search(int [][]matrix,int target,int x,int y,int row,int column,boolean [][]flags) {
//		
//		 if(x>=row||y>=column) {
//			return false;
//		}
//		 if(flags[x][y]) {
//			 return false;
//		 }
//		 if(target<matrix[x][y]) {
//			 
//			 return false;
//		 }
//		 if(target==matrix[x][y]) {
//			 return true;
//		 }
//		 flags[x][y]=true;
//		 return search(matrix, target, x+1, y,row,column,flags)||search(matrix, target, x, y+1,row,column,flags);
//	 }
	public static void main(String[] args) {
	int [][]matrix= 
		{ {1,   4,  7, 11, 15},
			  {2,   5,  8, 12, 19},
			  {3,   6,  9, 16, 22},
			  {10, 13, 14, 17, 24},
			  {18, 21, 23, 26, 30}
	};
	SortAndSearch6 test=new SortAndSearch6();
	test.searchMatrix(matrix, 20);
	}

	}


