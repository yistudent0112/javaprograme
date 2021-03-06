package com.yi.array;

/**
 * 
 * @ClassName: Array2
 * @Description: TODO 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 设计一个算法来计算你所能获取的最大利润。
 *               你可以尽可能地完成更多的交易（多次买卖一支股票）。 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 
 * @author yi
 * @date 2018年7月14日
 *
 */
public class Array2 {
	public int maxProfit(int[] prices) {
		int MaxProfit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i] < prices[i + 1]) {
				MaxProfit += prices[i+1]-prices[i];
			} 
		}
		return MaxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array2 test = new Array2();
		int[] prices = { 1, 2, 4, 3, 6, 4 };
		System.out.println(test.maxProfit(prices));
	}

}
