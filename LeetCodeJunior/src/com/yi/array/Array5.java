package com.yi.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
    * @ClassName: Array5  
    * @Description: TODO
    * ����һ���ǿ��������飬
    * ����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ�
    * �ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
    * @author yi  
    * @date 2018��7��15��  
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
