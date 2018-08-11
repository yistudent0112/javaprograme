package com.yi.ArraysAndString;
/*
 * �����ĺ��ľ��Ǽ�¼��Ϊ0��������Ϣ�������������ͨ��һ������������ÿ�������Ϣ
 * ��һ��ķ�����ͨ����������ֱ����ÿ�к�ÿ���Ƿ�Ҫ���������Ϣ
 * ����õİ취�ǰ���Щ��Ϣ����������ĵ�һ�к͵�һ���ϣ�
 * �������ͻᵼ�µ�һ�к͵�һ���Ƿ������Ϣ�����ǣ�����Ҫʹ�����������������������ǵ���Ϣ
 * �����ռ�ʹ�öȾ�ֻ�г�����
 * ���о��Ƕ�������Ĺ��̣���һֱ��û���뵽�ȽϺõķ������ڿ����˼ҵķ���������ʶ��
 * ��ֻҪ����һ�������ڱ仯����һ��ֵΪ�̶��ľ����������л��������е�ȫ������
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
	        		//�������л������ж���Ϊ��
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
