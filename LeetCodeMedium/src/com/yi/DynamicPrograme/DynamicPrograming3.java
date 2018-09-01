package com.yi.DynamicPrograme;

/*
 * ������ö�̬�滮��˼�������
 * �þ�������������;���  �������ִ�С��Ӳ�� �ֱ���   1,2,5  Ҫ��������ϳ�11  ��Ӳ��������С�����
 * ����ͨ����    1.������Ϊ1 ʱӲ����������Сֵ                             dp[1]=1
 *        2.�ٸ���ǰ����֪������Ϊ1ʱ��Ӳ��������Сֵ    
 *        3.ȥ�������Ϊ2ʱ�Ľ�      dp[2]=dp[1]+һö��ֵΪ(2-1)��Ӳ��
 *        ����dp[11]��˵   ����ֵ�͵���  dp[7]+һö5Ӳ��  dp[9]+һö2Ӳ��  dp[10]+һö1Ӳ�� �е���Сֵ
 *        ����������ƵĹ�ʽΪ  dp[n]=min(һö���ֿ��ܴ�С(����С����Ϊ������Χ�е���һ��)��Ӳ�� +��Ӧ�� dp[n-��Ӧ��Ӳ��ֵ�Ĵ�С])
 */

public class DynamicPrograming3 {
	/*
	 * �Լ����Եģ����õ���̰���㷨��ÿ�ζ����ܼӵ����ֵ
	 * �߼��ϲ���ȷ�������������ܶ�Ŀ�����
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
	//�������ѵĴ�
//	 public int coinChange(int[] coins, int amount) {
//	        if (amount < 0 || coins.length == 0) {
//	            return -1;
//	        }
//	        int[] f = new int[amount + 1];// ��iԪ������Ҫ��Ӳ����
//	        f[0] = 0;
//	        for (int i = 1; i <= amount; i++) {
//	            int min = Integer.MAX_VALUE;
//	            for (int c : coins) {
//	                int j = i - c;// ��¼�õ����Ǯ�ң�ʣ���Ǯ��
//	                if (j >= 0 && f[j] != -1) {// jԪҲ�ܴճɹ�
//	                    min = Math.min(min, f[j]);
//	                }
//	                f[i] = min == Integer.MAX_VALUE ? -1 : min + 1;//min == Integer.MAX_VALUE ˵���������Ӳ�ң����ܴճɹ�������ճɹ���Ӳ����+1
//	            }
//	        }
//	        return f[amount];
//	    }
	//�����Ҹ�����ҳ�ĳ��������д��
	 public int coinChange(int[] coins, int amount) {
		 //��ȥ�������ҵ�������
	        if (amount < 0 || coins.length == 0) {
	            return -1;
	        }
	        //������Ÿ��ֶ�̬�滮�����׶ε�ֵ
	        int dp[]=new int[amount+1];
	        dp[0]=0;
	        int result=-1;
	        int sum=0;
	        for(int i=1;i<=amount;i++) {
	        	result=Integer.MAX_VALUE;
	        	//Ѱ��ĳһ���������ֵ�µ���СӲ����
	        	for(int coin:coins) {
	        		sum=i-coin;
	        		//��ʾ�ҵ��˵�ǰ��ֵ���ܹ���һö����Ӳ��+ʣ����ֵ������ʣ����ֵҲ������СӲ����
	        		if(sum>=0&&dp[sum]!=-1) {
	        			//ͨ�����ϱȽϣ�ȡ��Сֵ���ҵ�ʣ����ֵ�е���СӲ����
	        			result=Math.min(dp[sum], result);
	        		}
	        	}
	        	//���û���ҵ�������ͽ������ֵ�Ľ����λ-1����ʾû��Ӳ������ܹ��ﵽ��ǰ��ֵ
	        	if(result==Integer.MAX_VALUE) {
	        		dp[i]=-1;
	        	}else {
	        		//����ҵ�����ͣ��ڵ�ǰ��СӲ�����ϼ�һ��������ö����¼��ϵ�Ӳ��
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
