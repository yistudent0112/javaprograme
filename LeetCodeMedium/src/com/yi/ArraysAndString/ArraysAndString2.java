package com.yi.ArraysAndString;
/*
 * 这道题的核心就是记录点为0的坐标信息，常规的做法是通过一个链表来存贮每个点的信息
 * 好一点的方法是通过两个数组分别存贮每行和每列是否要被清零的信息
 * 而最好的办法是把这些信息覆盖在数组的第一行和第一列上，
 * 但这样就会导致第一行和第一列是否赋零的信息被覆盖，所以要使用两个布尔变量来保存他们的信息
 * 这样空间使用度就只有常数级
 * 还有就是对于清零的过程，我一直都没有想到比较好的方法，在看了人家的方法后我意识到
 * 我只要控制一个变量在变化，另一个值为固定的就能做到整行或者是整列的全部赋零
 */
public class ArraysAndString2 {
	 public void setZeroes(int[][] matrix) {
	        int row=matrix.length;
	        int column=matrix[0].length;
	        boolean rowClean=false;
	        boolean columnClean=false;
	        for(int i=0;i<row;i++) {
	        	for(int j=0;j<column;j++) {
	        		if(i!=0&&j!=0&&matrix[i][j]==0) {
	        			matrix[0][j]=0;
	        			matrix[i][0]=0;
	        		}
	        		else if(matrix[i][j]==0) {
	        			if(i==0)
	        				columnClean=true;
	        			if(j==0)
	        				rowClean=true;
	        		}
	        	}
	        }
	        for(int i=1;i<row;i++) {
	        	for(int j=1;j<column;j++) {
	        		//控制整行或者整列都赋为零
	        		if(matrix[i][0]==0||matrix[0][j]==0) {
	        			matrix[i][j]=0;
	        		}
	        	}
	        }
	        if(rowClean) {
	        	for(int i=0;i<row;i++) {
	        		matrix[i][0]=0;
	        	}
	        }
	        if(columnClean) {
	        	for(int i=0;i<column;i++) {
	        		matrix[0][i]=0;
	        	}
	        }
	    }
	public static void main(String[] args) {
		ArraysAndString2 test=new ArraysAndString2();
		int [][]nums= {{1,1,1},{1,0,1},{1,1,1}};
test.setZeroes(nums);
	}

}
