package com.yi.DynamicPrograme;
/**
 * 
 * 在本题中将题目抽象为以下三步来解决
 * 1.当价格出现上扬趋势时，开始买入，即初始化买入价格
 * 2.买入之后，与当天的净值做比较，如果高于成本就算出利润，并与原先的利润取最大值
 * 3.当出现当天净值比买入价低时，更新买入价格
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
