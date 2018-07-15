package com.yi.array;

import java.util.HashSet;
import java.util.Set;
/**
 * 
    * @ClassName: Array4  
    * @Description: TODO
    * 给定一个整数数组，判断是否存在重复元素。
    * 如果任何值在数组中出现至少两次，函数返回 true。
    * 如果数组中每个元素都不相同，则返回 false。
    * @author yi  
    * @date 2018年7月15日  
    *
 */
public class Array4 {
    public boolean containsDuplicate(int[] nums) {
        boolean flag=false;
        Set<Integer> KeySet=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++) {
        	if(!KeySet.add(nums[i])){
        		flag=true;
        		break;
        	}
        }
        return flag;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
