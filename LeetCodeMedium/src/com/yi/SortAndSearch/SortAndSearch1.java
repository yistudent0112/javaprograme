package com.yi.SortAndSearch;

import java.util.Arrays;

public class SortAndSearch1 {
	/*
	 * ����������������������һ�α�������������ɫ���������������
	 * Ȼ���ڰ���������������������Ԫ�ذ��ն�Ӧ���Ⱥ�˳������ֵ
	 * 
	 *�������ҵĲ²⣺
	 * ���Ҫ�������Ż��Ļ����о������ڽ�������������Ԫ�ص�λ������취
	 * ���Ǵ�ͷβ���������ϱ��������ҵ��ĺ�ɫ������ǰ���ҵ�����ɫ�ŵ����
	 */
//	   public void sortColors(int[] nums) {
//	        if(nums==null||nums.length<2) {
//	           return ;
//	        }
//	        int length=nums.length;
//	        int redNum=0;
//	        int whiteNum=0;
//	        for(int i=0;i<length;i++) {
//	        	if(nums[i]==0) {
//	        		redNum++;
//	        	}else if(nums[i]==1) {
//	        		whiteNum++;
//	        	}
//	        }
//	        int i=0;
//	        for(;i<redNum;i++) {
//	        	nums[i]=0;
//	        }
//	        for(;i<redNum+whiteNum;i++) {
//	        	nums[i]=1;
//	        }
//	        for(;i<length;i++) {
//	        	nums[i]=2;
//	        }
//	    }
	/*
	 * ������Ż���������֮ǰ�²�ķ������
	 * ��������ָ�������п��ƣ�ͷβ����������ж�ȡ������С���Ƶ�ͷ�����������Ƶ�β��
	 * ���巽������
	 * ��������ָ�� 1.ͷָ��begin 2.�м�ָ��cur 3.βָ��end
	 * begin��curָ�붼ָ������ͷ�� ��endָ��ָ������β��
	 * ѭ����������cur<=end(���м�ָ��Ҫ�ǳ�����βָ����˳�)
	 * ͨ���м�ָ����ƶ�����ɱ������м�ָ��ָ������������µ��������ܣ�
	 * 1.ָ�� 0 Ԫ�أ�����Ӧ�ñ�����ͷ����Ԫ�أ�����curָ�����ݺ�beginָ�����ݽ���  Ȼ��cur��beginָ�����һλ
	 * 2.ָ�� 1Ԫ�أ�����Ӧ�ñ������м��Ԫ�أ����Բ���Ҫ�ƶ�����ֻҪ��curָ������ƶ�һλ������
	 * 3.ָ�� 2Ԫ�أ�����Ӧ�ñ�����β����Ԫ�أ�����curָ�����ݺ�endָ�����ݽ�����Ȼ��endָ����ǰ�ƶ�һλ��
	 */
	   public void sortColors(int[] nums) {
	        if(nums==null||nums.length<2) {
	           return ;
	        }
	        int length=nums.length;
	        int cur=0,begin=0,end=length-1;
	        while(cur <= end)
	        {
	            if(nums[cur] ==0)
	            {
	                swap(begin, cur,nums);
	                begin++;
	                cur++;
	                
	            }else if(nums[cur] == 1)
	            {
	                cur++;
	                
	            }else if(nums[cur] == 2)
	            {
	                swap(cur, end,nums);
	                end--;
	            }
	        }

	   }
	   public void swap(int i,int j,int []nums) {
		   int temp=nums[j];
		   nums[j]=nums[i];
		   nums[i]=temp;
	   }
public static void main(String[] args) {
	int[]nums= {2,1,0,2,1,0};
	SortAndSearch1 test=new SortAndSearch1();
	test.sortColors(nums);
}
}
