package com.yi.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
    * @ClassName: Array5  
    * @Description: TODO
    * 给定一个非空整数数组，
    * 除了某个元素只出现一次以外，其余每个元素均出现两次。
    * 找出那个只出现了一次的元素。
    * @author yi  
    * @date 2018年7月15日  
    *
 */
public class Array5 {
    public int singleNumber(int[] nums) {
 
        if(nums.length==0) {
        	return -1;
        }
       Arrays.sort(nums);
       int SingleNumber=nums[nums.length-1];
       for(int i=0;i<nums.length-1;i=i+2) {
    	   if(nums[i]!=nums[i+1]) {
    		   SingleNumber=nums[i];
    		   break;
    	   }
       }
        return SingleNumber;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
