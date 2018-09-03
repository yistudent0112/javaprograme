package com.yi.Other;

import java.util.Arrays;
/*
 * 众数的概念是这个数在数组只出现的次数为一半及以上
 * 所有就对数组做个排序，然后按顺序去找出现次数超过一半的数就行了
 */
public class Other3 {
    public int majorityElement(int[] nums) {
        if(nums==null||nums.length==0) {
        	return 0;
        }
        int result=0;
        int length=nums.length;
        Arrays.sort(nums);
        int number=0;
        int res=nums[0];
        for(int temp:nums) {
        	if(temp==res) {
        		number++;
        	}else {
        		res=temp;
        		number=1;
        	}
        	if(number>length/2) {
        		break;
        	}
        }
        result=res;
        return result;
    }
	public static void main(String[] args) {
	int []nums= {2,2,1,1,1,2,2};
Other3 test=new Other3();
test.majorityElement(nums);
	}

}
