package com.yi.Other;

import java.util.HashSet;
import java.util.Set;

public class Other6 {
	/**
	 * 
	 * 这个方法使用了set来存贮应该要有的数字，然后再对应的一个个删掉数组中的数字
	 * 最后剩下的数字就是缺失的数字，虽然可以实现，但是时间和空间复杂度都较高
	 */
//public int missingNumber(int[] nums) {
//        int missNumber=0;
//        int length=nums.length;
//        Set<Integer>numbers=new HashSet<Integer>(length+1);
//        for(int i=0;i<length+1;i++) {
//        	numbers.add(i);
//        }
//        for(int i=0;i<length;i++) {
//        	numbers.remove(nums[i]);
//        }
//        for(int i:numbers) {
//        	missNumber=i;
//        }
//        return missNumber;
//    }
	/**
	 * 
	 * 这个方法使用一个数组来保存数组nums的信息，并以值为1来做标记，
	 * 这样通过数组下标就能够完成对应的遍历，找到缺失的那个数字
	 */
public int missingNumber(int[] nums) {
	int length=nums.length;
	int[]numbers=new int [length+1];
	for(int i=0;i<length;i++) {
		numbers[nums[i]]=1;
	}
	for(int i=0;i<length;i++) {
		if(numbers[i]==0) {
			return i;
		}
	}
	return length;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[]nums= {3,0,1};
Other6 test=new Other6();
test.missingNumber(nums);
	}

}
