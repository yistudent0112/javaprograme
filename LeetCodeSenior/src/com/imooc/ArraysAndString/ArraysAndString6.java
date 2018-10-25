package com.imooc.ArraysAndString;

import java.util.ArrayList;
import java.util.List;

public class ArraysAndString6 {
	/*
	 * 使用了一个链表来存贮可能的最小数字情况，即一个长度为读入数组的长度，从1开始递增的链表
	 * 例如数组长度为   5   则最小数字情况为     1，2，3，4，5
	 * 然后去遍历数组，在链表中删去出现过的数组中的元素
	 * 最后链表的头元素就是我们要找的数组中丢失的最小整数
	 * 
	 * 需要注意一个特殊的情况，就是输入数组为从1开始的递增数组时
	 * 例  输入的数组为     5，4，3，2，1  时  做完遍历后会导致链表为空，
	 * 此时应该要另外处理，返回数组的长度值加一
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
