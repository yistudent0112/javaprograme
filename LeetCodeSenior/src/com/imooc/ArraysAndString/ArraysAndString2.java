package com.imooc.ArraysAndString;

import java.util.ArrayList;
import java.util.List;
/*
 * ��������Ҫ��ϸ�۲�������������ı任״̬���ܽ����Ǳ任�Ĺ��̣����ܹ�ģ�������������
 * ���ɨ�跽��������ͼ��ʾ������ 
 *         1 
 * ���Ͻ�--------------�����Ͻ�             1����������
 *  ��                   |       2����������  
 * 4|                   | 2     3�������ݼ� 
 *  |                   |       4�������ݼ�
 *  |                   ��
 * ���½ǡ�--------------���½�
 *            3
 * �����һ��ѭ���󣬾���Ҫ���±߽�������ʹ�ò����ظ������߽��ϵ�Ԫ��
 * ��Ҫע�����Ҫ����ֻ��һ�л�һ�е��������
 * ���ǲ���ȥ���±߽���������Ȼ����ִ���
 * ��         ֻ��һ��Ԫ��           1
 *                   2
 *                   3
 *     ��������2��ʱ��ͻ�������±߽����������ʱ��������˱߽磬�ͻᵼ���е㲻��ɨ�赽              
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
