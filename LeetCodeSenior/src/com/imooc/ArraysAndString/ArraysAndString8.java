package com.imooc.ArraysAndString;




public class ArraysAndString8 {
	/*
	 * 这道题目的要求是需要使用O(1)空间复杂度和O(n二次方)的时间复杂度
	 * 我直接使用一个set来暴力破解，不满足题目的要求，之后补上符合限制条件的巧妙方法
	 */
//	 public int findDuplicate(int[] nums) {
//	        if(nums==null||nums.length==0) {
//	        	return 0;
//	        }
//	        int result=0;
//	        int length=nums.length;
//	       Set<Integer>set=new HashSet<>();
//	        for(int i=0;i<length;i++) {
//	        	if(set.contains(nums[i])) {
//	        		result=nums[i];
//	        		break;
//	        	}else {
//	        	   set.add(nums[i]);
//	        	}
//	        }
//	        return result;
//	    }
	/*
	 * 这个函数充分利用了这个数组的定义
	 * 因为这个长度为n+1的数组中只会出先1-n范围内的数字
	 * 例   数组长度为10 即9+1
	 *  则这个数组中只会出现1-9中的数字 而不会出现范围外的数字
	 * 所以用了一个类似二分查找的函数来实现功能
	 * 在这统计的是在某一范围内的数字，
	 * 如果这个范围内的数字不是正常的值(即范围的宽度)
	 * 就表明在这个范围内存在重复的数，然后使用二分查找的方式，在这个方向进行递归查找就行了
	 * 
	 * 例 读入的数组为  1 2 2 2 3 4 5 6 7 这个数组的长度为9
	 * 则这个数组中应该出现的数字为1-8
	 * 然后根据二分查找的定义，找到1-8中的中间数4
	 * 然后遍历去数有多少个比中间数4小的数  结果为6，但按照数组的定义结果应该为4
	 * 说明在1-4的范围内存在重复的数字
	 * 
	 * 之后就递归调用，缩减中间数查找的范围为1-4，生成新的中间数2
	 * 然后遍历去数有多少个比中间数2小的数  结果为4， 结果应该为2
	 * 说明在1-2的范围内存在重复的数字
	 * 
	 * 通过不断的递归，知道中间数的范围上下界碑替换了，就能够找到重复的数字
	 */
//	 public int findDuplicate(int[] nums) {
//	        int high=nums.length-1;
//	        int low=0;  
//	        while(high>low){
//	        	int mid=(high+low)/2;
//	        	int count=0;
//	        	for(int i=0;i<nums.length;i++){
//	        		if(nums[i]<=mid)
//	        			count++;
//	        	}
//	        	if(count>mid)
//	        		high=mid;
//	        	else
//	        		low=mid+1;
//	        }
//	        return low;
//	    }
	 public int findDuplicate(int[] nums) {
		 if(nums==null||nums.length==0) {
			 return 0;
		 }
		 int low=0;
		 int length=nums.length;
		int high=length-1;
		int middle=high;
		int temp=0;
		while(low<high) {
			temp=0;
			middle=(low+high)/2;
			for(int i=0;i<length;i++) {
				if(nums[i]<=middle) {
					temp++;
				}
			}
			if(temp>middle) {
				high=middle;
			}else {
				low=middle+1;
			}
		}
		 return low;
	 }
	public static void main(String[] args) {
		ArraysAndString8 test=new ArraysAndString8();
		int []nums= {1,5,4,2,3,4};
		test.findDuplicate(nums);
	}

}
