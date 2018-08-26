package com.yi.SortAndSearch;
/*
 * �Ұ������Ŀ���븴����
 * ����������Ҳ�������Ⱥ͹��ͬʱ��չ�ķ���������ʱ��ǳ�����
 * ��ʵ������һ���ǳ�����ķ����������������ά��������ԣ��ܹ��ǳ�����Ľ������
 * �����ά�����������ÿһ�ж��ǰ�����˳�����еģ�ÿһ��Ҳ���ǰ�����˳�����е�
 * 
 */
public class SortAndSearch6 {
	/*
	 * ������������ԣ���ɨ��ĳ�ʼλ�ö�λ��һ�е����һ��Ԫ�أ�
	 * ���������ǰ����Ԫ�ر�Ŀ����ˣ�������һ�е�ǰ��ȥ��
	 * �����ǰ����Ԫ�ر�Ŀ��С�ˣ�������һ�е�С��ȥ��
	 * ������������������
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
	  * ��������ǶԶ�ά����ͬʱ����Ⱥ͹�ȵı���
	  * ��������������ֱ�Ŀ��С�ͼ���Ѱ�ң�ֱ���ҵ�������߱�������
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


