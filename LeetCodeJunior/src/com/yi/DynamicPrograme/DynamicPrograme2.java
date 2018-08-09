package com.yi.DynamicPrograme;
/**
 * 
 * �ڱ����н���Ŀ����Ϊ�������������
 * 1.���۸������������ʱ����ʼ���룬����ʼ������۸�
 * 2.����֮���뵱��ľ�ֵ���Ƚϣ�������ڳɱ���������󣬲���ԭ�ȵ�����ȡ���ֵ
 * 3.�����ֵ��쾻ֵ������۵�ʱ����������۸�
 *
 */
public class DynamicPrograme2 {
	public int maxProfit(int[] prices) {
		int profit = 0;
		int buy = -1;
		for (int i = 0; i < prices.length - 1; i++) {
			if (buy == -1) {
				if (prices[i] < prices[i + 1]) {
					buy = prices[i];
				}
			}
			if(buy!=-1) {
				if (buy < prices[i + 1]) {
					profit = Math.max(profit, prices[i + 1] - buy);
				} else  {
					buy = prices[i + 1];
				}
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		DynamicPrograme2 test = new DynamicPrograme2();
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		test.maxProfit(prices);

	}

}
