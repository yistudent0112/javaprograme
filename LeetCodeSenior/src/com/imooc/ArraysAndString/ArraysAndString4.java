package com.imooc.ArraysAndString;

public class ArraysAndString4 {
	/*
	 * 这道题我查看了网友的提示，根据他们的思路写出了程序
	 * 想法其实非常的简单，就是从数组的两边往中间走
	 * 有左边高度和右边高度两个变量，哪个变量比较小，就移动哪个变量
	 * 在每一次移动变量的时候，计算当前能放下的水的体积。
	 * 并和之前能够放下水的体积的最大值比较，来更新最大放水区域的值
	 * 当左高度走到和右高度重合的时候，就结束循环。
	 * 返回之前保留的最大放水区域的值
	 */
	 public int maxArea(int[] height) {
	     if(height==null||height.length==0||height.length==1) {
	    	 return 0;
	     }
	     int result=0;
	     int length=height.length;
	     int leftIndex=0;
	     int rightIndex=length-1;
	     int left=height[leftIndex];
	     int right=height[rightIndex];
	     int shortLevel=0;
	     while(leftIndex<rightIndex) {
	    	 left=height[leftIndex];
	    	 right=height[rightIndex];
	    	 shortLevel=Math.min(left, right);
	    	 result=Math.max(result, shortLevel*(rightIndex-leftIndex));
	    	if(left<right) {
	    		leftIndex++;
	    	}else {
	    	    rightIndex--;
	    	}
	    	
	     }
	     return result;
	    }
	public static void main(String[] args) {
		ArraysAndString4 test=new ArraysAndString4();
		int []height= {1,8,6,2,5,4,8,3,7};
		int result=test.maxArea(height);
		System.out.println(result);
	}

}
