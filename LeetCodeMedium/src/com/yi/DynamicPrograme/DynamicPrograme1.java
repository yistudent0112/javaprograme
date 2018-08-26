package com.yi.DynamicPrograme;
/*
 * 这题我又采用了暴力破解的方法，去遍历所有可能的情况。
 * 对每一个情况做深度搜素，来查看是否可行
 * 因为做了多层递归，所以运行的效率很低
 * 
 * 后来又尝试了一种从后往前找的方法，即计算最后一个点是否能达到终点，根据这个信息来判断前一个点能否到达，
 * 从而不断动态规划，向前判断。
 * 但是这个方法忽略了这是可以进行跳步的，也就是说有一个到不了终点，并不等于它前面那个点也到不了
 * 例     2   0   8   3   0   0   0   1
 *            ↑    ↑
 *         可以到达  不可到达 
 * 后来我看了网上的解答，写了第三个方法，这个思路和第二种很像，只不过是从前往后推的。保存的是能走的最远跳数
 * 如果这个跳数小于0了，就代表无法向后跳跃了。  
 * 这里有一个需要注意的点，如果这个跳数正好在最后一个点上为0，是代表可以到达终点的。
 * 所以要和其他跳数为0，但不是停在最后一个点的情况给区分开来
 * 例    2    0    0    判断为true
 *    2    1    0     1  判断为false     
 */
public class DynamicPrograme1 {
	//对每种可能都做深度搜素，可以运行，效率极低
//	   public boolean canJump(int[] nums) {
//	        if(nums==null||nums.length<1) {
//	        	return false;
//	        }
//	        if(nums.length==1){
//	            return true;
//	        }
//	        boolean result=true;
//	        int length=nums.length-1;
//	        boolean[] flags=new boolean [length+1];
//	        result=jump(nums,length,0,flags);
//	        return result;
//	    }
//	   public static boolean jump(int []nums,int length,int index,boolean[]flags) {
//		  if(flags[index]) {
//			  return false;
//		  }
//		   if(index>length) {
//			   return false;
//		   }
//		   if(nums[index]==0) {
//			   return false;
//		   }
//		   if(nums[index]>=(length-index)) {
//			   return true;
//		   }
//		   boolean flag=false;
//		   for(int i=nums[index];i>0;i--) {
//			   flag=jump(nums,length,index+i,flags);
//			   if(flag) {
//				   return true;
//			   }
//		   }
//		   flags[index]=true;
//		   return false;
//	   }
	//方法逻辑上存在问题
//	   public boolean canJump(int[] nums) {
//		   if(nums==null||nums.length<1) {
//	        	return false;
//	        }
//	        if(nums.length==1){
//	            return true;
//	        }
//	        boolean result=true;
//	        int length=nums.length-1;
//	        int zero=0;
//	        while(nums[length]==0) {
//	        	zero++;
//	        	length--;
//	        }
//	        if(nums[length]<zero) {
//	        	return false;
//	        }
//	        if(nums[length]==zero) {
//	        	return true;
//	        }
//	        zero=0;
//	        for(int i=length;i>-1;i--) {
//	        
//	        	if(nums[i]>zero) {
//	        		zero=0;
//	        		continue;
//	        	}
//	        	if(nums[i]==0) {
//	        		zero++;
//	        	}else {
//	        		result=false;
//	        		break;
//	        	}
//	        	
//	        }
//	        if(zero>0) {
//	        	result=false;
//	        }
//	        return result;
//	   }
	
	//使用动态规划的方法来处理      
	//递推公式为   
	//下一跳的跳数 等于 这一位置的跳力(即这个位置能跳多远)和 上一条的跳数减一之间的最大值
    public boolean canJump(int[] nums) {
		   if(nums==null||nums.length<1) {
	        	return false;
	        }
		   //当长度为1时，肯定能够到达
	        if(nums.length==1){
              return true;
          }
	        int result=0;
	        int length=nums.length;
	        for(int i=0;i<length;i++) {
	        	//跳力的递推公式
	        		result=Math.max(nums[i], result-1);
	        		
              if(result<0) {
	        		return false;
	        	}
              //处理跳数为0，却不是停在终点上的情况
              if(result==0&&i!=length-1) {
            	  return false;
              }
	        }
	        return result>=0;
	   }
	public static void main(String[] args) {
	int []nums= {0,1};
	DynamicPrograme1 test=new DynamicPrograme1();
	test.canJump(nums);
	}

}
