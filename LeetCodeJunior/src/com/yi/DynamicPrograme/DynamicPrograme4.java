package com.yi.DynamicPrograme;
/**
 * 
 * 这题使用动态规划无法明显的找出规律
 * 所有先通过枚举的方式，尝试寻找规律
 * 1.S(1)=f(1)
 * 2.S(2)=Max(0+f(2),S(1))
 * 3.S(3)=Max(S(1)+f(3),S(2))
 * 4.S(4)=Max(S(2)+f(4),S(3))
 * 5.S(5)=Max(S(3)+f(5),S(4))
 * 通过枚举的方式可以发现，对于S(n)是存在对前几项的依赖关系的
 * S(n)=Max(S(n-2)+f(n),S(n-1))
 * 通过这一公式就可以写出对应的求解算法了
 *
 */
public class DynamicPrograme4 {
	  public int rob(int[] nums) {
		  if(nums.length<0) {
			  return 0;
		  }
		 
	        int last=0;
	        int max=0;
	        for(int i=0;i<nums.length;i++) {
	        	//保存一下位于当前项前一格的结果
	        	int temp=max;
	        	//更新max的值
	        	max=Math.max(last+nums[i], max);
	        	last=temp;
	        }
	        return max;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
DynamicPrograme4 test=new DynamicPrograme4();
int []house= {2,7,9,3,1};
test.rob(house);
	}

}
