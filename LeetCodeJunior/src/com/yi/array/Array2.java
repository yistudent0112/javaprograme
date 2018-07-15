package com.yi.array;

/**
 * 
 * @ClassName: Array2
 * @Description: TODO ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸� ���һ���㷨�����������ܻ�ȡ���������
 *               ����Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ���� ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 * 
 * 
 * @author yi
 * @date 2018��7��14��
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
