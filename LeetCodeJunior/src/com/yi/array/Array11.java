package com.yi.array;
/**
 * 
    * @ClassName: Array11  
    * @Description: TODO
    * ����һ�� n �� n �Ķ�ά�����ʾһ��ͼ��
    * ��ͼ��˳ʱ����ת 90 �ȡ�  
    * @author yi  
    * @date 2018��7��15��  
    *
 */
public class Array11 {
    public void rotate(int[][] matrix) {
    	/*
    	 *java��û�ж�ά���飬��ά��������һά�����Ŷ�ά������е�ַ��ʽ���ڵ�
    	 *����clone��������һά�����ܹ��������������ڶ�ά����Ͳ���
    	 *���������ȷ���ڶ�ά�����������Ĵ���
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
