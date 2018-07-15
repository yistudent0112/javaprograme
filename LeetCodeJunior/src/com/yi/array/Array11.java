package com.yi.array;
/**
 * 
    * @ClassName: Array11  
    * @Description: TODO
    * 给定一个 n × n 的二维矩阵表示一个图像。
    * 将图像顺时针旋转 90 度。  
    * @author yi  
    * @date 2018年7月15日  
    *
 */
public class Array11 {
    public void rotate(int[][] matrix) {
    	/*
    	 *java中没有二维数组，二维数组是以一维数组存放二维数组的行地址形式存在的
    	 *所以clone函数对于一维数组能够完成深拷贝，但对于二维数组就不能
    	 *下面就是正确对于二维数组完成深拷贝的代码
    	 */
        int [][]clone=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++) {
        	clone[i]=matrix[i].clone();
        }
        for(int i=0;i<matrix.length;i++) {
        	for(int j=0;j<matrix[0].length;j++) {
        		matrix[i][j]=clone[matrix.length-j-1][i];
        	}
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Array11 test=new Array11();
int [][]matrix= {{1,2,3},{4,5,6},{7,8,9}};
		test.rotate(matrix);
	}

}
