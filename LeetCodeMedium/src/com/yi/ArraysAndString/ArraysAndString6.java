package com.yi.ArraysAndString;

public class ArraysAndString6 {
	/*
	 * ������˼·���Ǳ���һ��С�������ٱ���һ���ڶ�С���������ʵ�ֵ��������ֱȵڶ�������
	 * ���ҵ��˵�������Ԫ���У��Ϳ��Է��ؽ����
	 */
	 public boolean increasingTriplet(int[] nums) {
	        if(nums==null||nums.length<3) {
	        	return false;
	        }
	        int first=Integer.MAX_VALUE;
	        int second=Integer.MAX_VALUE;
	        for(int num:nums) {
	        	if(first>num) {
	        		first=num;
	        	}else if(first<num&&second>num) {
	        		second=num;
	        	}else if(num>second){
	        		return true;
	        	}
	        }
	        return false;
	    }
	public static void main(String[] args) {
		ArraysAndString6 test=new ArraysAndString6();
		int []nums= {1,1,-2,6};
		test.increasingTriplet(nums);

	}

}
