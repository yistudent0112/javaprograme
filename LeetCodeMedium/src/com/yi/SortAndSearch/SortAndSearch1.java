package com.yi.SortAndSearch;

import java.util.Arrays;

public class SortAndSearch1 {
	/*
	 * 基础版解决方案，就是先做一次遍历，把三种颜色的数量都给数清楚
	 * 然后在按照数出来的数量对数组元素按照对应的先后顺序做赋值
	 * 
	 *以下是我的猜测：
	 * 如果要做性能优化的话，感觉给以在交换数组内两个元素的位置上想办法
	 * 就是从头尾两个方向上遍历，把找到的红色换到最前，找到的蓝色放到最后
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
	 * 这题的优化方案和我之前猜测的方案差不多
	 * 采用三个指针来进行控制，头尾两个方向进行读取，把最小的移到头部，把最大的移到尾部
	 * 具体方法如下
	 * 设置三个指针 1.头指针begin 2.中间指针cur 3.尾指针end
	 * begin和cur指针都指向数组头部 ，end指针指向数组尾部
	 * 循环的条件是cur<=end(即中间指针要是超过了尾指针就退出)
	 * 通过中间指针的移动来完成遍历，中间指针指向的内容有如下的三个可能：
	 * 1.指向 0 元素，这是应该被放在头部的元素，所以cur指针内容和begin指针内容交换  然后cur和begin指针后移一位
	 * 2.指向 1元素，这是应该被放在中间的元素，所以不需要移动它，只要让cur指针向后移动一位就行了
	 * 3.指向 2元素，这是应该被放在尾部的元素，所以cur指针内容和end指针内容交换，然后end指针向前移动一位。
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
