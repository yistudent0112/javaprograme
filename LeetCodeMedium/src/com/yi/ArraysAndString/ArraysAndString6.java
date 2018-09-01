package com.yi.ArraysAndString;

public class ArraysAndString6 {
	/*
	 * 这道题的思路就是保存一个小的数，再保存一个第二小的数，如果实现第三个数字比第二个数大，
	 * 就找到了递增的三元序列，就可以返回结果了
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
