package com.imooc.ArraysAndString;

import java.util.ArrayList;
import java.util.List;

public class ArraysAndString6 {
	/*
	 * ʹ����һ���������������ܵ���С�����������һ������Ϊ��������ĳ��ȣ���1��ʼ����������
	 * �������鳤��Ϊ   5   ����С�������Ϊ     1��2��3��4��5
	 * Ȼ��ȥ�������飬��������ɾȥ���ֹ��������е�Ԫ��
	 * ��������ͷԪ�ؾ�������Ҫ�ҵ������ж�ʧ����С����
	 * 
	 * ��Ҫע��һ������������������������Ϊ��1��ʼ�ĵ�������ʱ
	 * ��  ���������Ϊ     5��4��3��2��1  ʱ  ���������ᵼ������Ϊ�գ�
	 * ��ʱӦ��Ҫ���⴦����������ĳ���ֵ��һ
	 * 
	 */
	 public int firstMissingPositive(int[] nums) {
	        if(nums==null||nums.length==0) {
	        	return 0;
	        }
	        int result=0;
	        int length=nums.length;
	        List<Integer>list=new ArrayList<Integer>();
	        for(int i=0;i<length;i++) {
	        	list.add(i+1);
	        }
	        int index=0;
	        for(int i=0;i<length;i++) {
	        	if(list.contains(new Integer(nums[i]))) {
	        		index=list.indexOf(new Integer(nums[i]));
	        		list.remove(index);
	        	}
	        }
	        if(list.size()==0) {
	        	result=length+1;
	        }else {
	        result=list.get(0);
	        }
	        return result;
	    }
	public static void main(String[] args) {
	int []nums= {7,8,9,11,12};
	ArraysAndString6 test=new ArraysAndString6();
     int i=test.firstMissingPositive(nums);
System.out.println(i);
	}

}
