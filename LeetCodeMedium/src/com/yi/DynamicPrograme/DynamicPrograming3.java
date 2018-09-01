package com.yi.DynamicPrograme;

/*
 * 本题采用动态规划的思想来解决
 * 用具体的例子来解释就是  给定三种大小的硬币 分别是   1,2,5  要用他们组合成11  求硬币数量最小的组合
 * 就是通过求    1.当总数为1 时硬币数量的最小值                             dp[1]=1
 *        2.再根据前面已知的总数为1时的硬币数量最小值    
 *        3.去求解总数为2时的解      dp[2]=dp[1]+一枚面值为(2-1)的硬币
 *        对于dp[11]来说   他的值就等于  dp[7]+一枚5硬币  dp[9]+一枚2硬币  dp[10]+一枚1硬币 中的最小值
 *        所以这个递推的公式为  dp[n]=min(一枚各种可能大小(即大小可以为给定范围中的任一种)的硬币 +对应的 dp[n-对应的硬币值的大小])
 */

public class DynamicPrograming3 {
	/*
	 * 自己尝试的，采用的是贪心算法，每次都加能加的最大值
	 * 逻辑上不正确，忽略了其他很多的可能性
	 */
//	public int coinChange(int[] coins, int amount) {
//		if (coins == null || coins.length < 1) {
//			return -1;
//		}
//		Arrays.sort(coins);
//		int length=coins.length;
//		int result = 0;
//		Long amount1=new Long(amount);
//		Long sum=0L;
//		while(sum<amount1) {
//			for(int i=length-1;i>=0;i--) {
//				if((sum+coins[i])<=amount1) {
//					sum+=coins[i];
//					result++;
//					break;
//				}
//			}
//			if(result==0||(sum<amount1&&(sum+coins[0])>amount1)) {
//				return -1;
//			}
//		}
//		
//		return result;
//	}
	//网上网友的答案
//	 public int coinChange(int[] coins, int amount) {
//	        if (amount < 0 || coins.length == 0) {
//	            return -1;
//	        }
//	        int[] f = new int[amount + 1];// 凑i元最少需要的硬币数
//	        f[0] = 0;
//	        for (int i = 1; i <= amount; i++) {
//	            int min = Integer.MAX_VALUE;
//	            for (int c : coins) {
//	                int j = i - c;// 记录用掉这个钱币，剩余的钱数
//	                if (j >= 0 && f[j] != -1) {// j元也能凑成功
//	                    min = Math.min(min, f[j]);
//	                }
//	                f[i] = min == Integer.MAX_VALUE ? -1 : min + 1;//min == Integer.MAX_VALUE 说明花掉这个硬币，不能凑成功，如果凑成功，硬币数+1
//	            }
//	        }
//	        return f[amount];
//	    }
	//这是我根据网页的程序，理解后仿写的
	 public int coinChange(int[] coins, int amount) {
		 //舍去不可能找到解的情况
	        if (amount < 0 || coins.length == 0) {
	            return -1;
	        }
	        //用来存放各种动态规划各个阶段的值
	        int dp[]=new int[amount+1];
	        dp[0]=0;
	        int result=-1;
	        int sum=0;
	        for(int i=1;i<=amount;i++) {
	        	result=Integer.MAX_VALUE;
	        	//寻找某一个具体的数值下的最小硬币数
	        	for(int coin:coins) {
	        		sum=i-coin;
	        		//表示找到了当前数值下能够由一枚给出硬币+剩余数值，并且剩余数值也存在最小硬币数
	        		if(sum>=0&&dp[sum]!=-1) {
	        			//通过不断比较，取最小值，找到剩余数值中的最小硬币数
	        			result=Math.min(dp[sum], result);
	        		}
	        	}
	        	//如果没能找到结果，就将这个数值的结果置位-1，表示没有硬币组合能够达到当前数值
	        	if(result==Integer.MAX_VALUE) {
	        		dp[i]=-1;
	        	}else {
	        		//如果找到结果就，在当前最小硬币数上加一，代表那枚这次新加上的硬币
	        	dp[i]=result+1;
	        	}
	        }
	        return dp[amount];
	 }
	public static void main(String[] args) {
int []nums= {1,2,5};
DynamicPrograming3 test=new DynamicPrograming3();
test.coinChange(nums,11);
	}
}
