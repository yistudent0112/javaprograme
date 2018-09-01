package com.yi.DynamicPrograme;




/*
 * 这道题的解题思路还没有理解，等有空了就补上这道题的思路
 * 总算是看懂了这道动态规划的原理，现在来填上之前的坑
 * 这道题的难点在于对第j种情况做判断时，实际上要考虑到从 1，1~2 ,1~3 到 1~j的所有组合情况
 * 并考虑到nums[j]上这个元素的大小情况，能否和之前的组合组成递增数列
 * 虽然后一项的解还是依赖于之前的解，但不是简单的只依赖于前一项的解了，而是要用到前面所有的解去寻找答案
 * 
 * 例  对数组      1    4    7    6     2      3      8
 * 已求出的解为1    2    3    
 * 现在要求3位置(6)的解  
 * 首先去和0位置(1)去做比较            1<6  所以6的值更新为f(1)+1   为2
 * 然后和1位置(也就是4)去做比较     4<6  所以6的值先更新为f(4)+1  为3
 * 最后再和2位置(7)去作比较            7>6  所以保留原来的值为3     求出6位置的解为3
 * 
 * 将数组的值更新为      1     4     7     6      2     3     8
 *               1     2     3     3
 * 通过这样的方法去做遍历，找到所有的解就能够得到每个位置上的最长递增数列信息了
 */
public class DynamicPrograming4 {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int length = nums.length;
	    int result=0;
	    int []longest=new int[length];
	    //先将所有点的最长递增数列信息初始化为1，即只包括它自己这个点
	    for(int i=0;i<length;i++) {
	    	longest[i]=1;
	    }
	    for(int i=1;i<length;i++) {
	    	for(int j=0;j<i;j++) {
	    		//做判断，如果当前元素大于之前的点，且他的最长递增数列信息还没有被更新过，则更新他的数据
	    		if(nums[i]>nums[j]&&longest[i]<(longest[j]+1)) {
	    			longest[i]=longest[j]+1;
	    		}
	    	}
	    }
	    //遍历所有的结果，并找到其中的最大值
	    for(int temp:longest) {
	    	if(result<temp) {
	    		result=temp;
	    	}
	    }
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 4, 7, 6, 2, 3, 8 };
		DynamicPrograming4 test = new DynamicPrograming4();
		test.lengthOfLIS(nums);
	}

}
