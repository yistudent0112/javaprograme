package com.yi.SortAndSearch;
/*
 * 寻找一个高点数字的下标，这道题也不能 
 * 高点数的定义数，这个数比他前后位置的数都要大  例  1 2 3 4 1 中 4 就是高点数
 * 我的做法就是利用高点数的这个定义，来遍历数组寻找，找一个比前后位置都大的数，然后返回他的下标
 * 然后要处理一下特殊情况，就比如数组长度为2的时候，就不能做上面的遍历数组的操作了，要单独判断
 * 还有就是数组本身是递增或者递减的，这样是找不到答案的，
 * 要根据给定的附加条件 数组的[-1]和[length]的大小为无穷小 来判断
 * 
 * 现在这个遍历数组的方式速度不够快，还是可以提高性能的
 */
public class SortAndSearch4 {
//	 public int findPeakElement(int[] nums) {
//	      int length=nums.length;
//	      //当数组的长度为2时，做特殊处理
//	      if(length==2) {
//	    	 if(nums[0]>nums[1]) {
//	    		 return 0;
//	    	 }else {
//	    		 return 1;
//	    	 }
//	      }
//	      int result=0;
//	      //标志数组为递增的状态
//	      boolean increase=true;
//	      for(int i=0;i<length-2;i++) {
//	    	  //如果存在满足高点数定义的情况，返回这个数的下标
//	    	  if((nums[i]<nums[i+1])&&(nums[i+1]>nums[i+2])) {
//	    		  result=i+1;
//	    		  break;	
//	    	  }if(nums[i]>nums[i+1]) {
//	    		  increase=false;
//	    	  }
//	      }
//	      //如果数组递增，返回数组的最后一个位置
//	      if(increase&&result==0) {
//	    	  result=length-1;
//	      }
//	      return result;      
//	    }
	/*
	 * 这道题的优化方式是使用二分查找来寻找高点数，能够使用二分查找的原理如下
	 * 如果中间元素大于其相邻的后续元素，则中间元素左侧（包括中间元素）必然包含一个局部最大值，
	 * 等于在中间元素的后部出现了拐点，前部就肯定能有解
	 * 如果中间元素小于其相邻的后续元素，则中间元素右侧必然包含一个局部最大值
	 * 等于中间元素的前部有拐点，后部就会有解
	 */
	 public int findPeakElement(int[] nums) {
		 int length=nums.length;
		 if(length==1) {
			 return 0;
		 }
		 if(nums[0]>nums[1]) {
			 return 0;
		 }
		 if(nums[length-2]<nums[length-1]) {
			 return length-1;
		 }
		 int index=0;
		 int left=0;
		 int right=length-1;
		 //采用二分查找来寻找高点数
		 while(left<right) {
			 index=(left+right)/2;
			 if(nums[index-1]<nums[index]&&nums[index]>nums[index+1]) {
				 break;
			 }
			 if(nums[index]>nums[index+1]) {
				 right=index;
			 }else {
				 left=index;
			 }
		 }
		 return index;
	 }
	public static void main(String[] args) {
		int []nums= {1,2,3,1};
		SortAndSearch4 test=new SortAndSearch4();
		test.findPeakElement(nums);

	}

}
