package com.yi.SortAndSearch;

public class SortAndSearch5 {
	/*
	 * 这道题的做法也是巧妙利用翻转数组的定义来做题
	 * 因为一个这是一个升序排列的数组做了一次翻转后的结果
	 * 也就是说这个数组的大部分地方还是升序排列的，只不过从一个特殊的点开始，它会比前面所有的数字都要小
	 * 对于这样的数组来寻找目标，还是使用二分查找的方式来实现
	 * 只不过会多了一些判断，先对这个数组对半分，来分别观察这两部分是否为正常的升序队列，还是存在了翻转部分的队列
	 * 比较是否为升序队列的方法是，比价队列的头尾元素大小情况，如果尾部元素大于头部元素则表明正常，反之这是翻转队列
	 * 先对前半部分做是否为升序数组的判断，如果是，就按照二分查找来处理
	 * 如果不是就再判断这个数是否是在后半部分的范围内，如果是就把范围缩到后半部分，如果不是就在前半部分递归查找
	 * 例    数组信息     4  5  6  7  1  2
	 *            ↑     ↑  ↑     ↑
	 * 前半部分的头结点        前尾节点            后半部分的尾节点
	 * 说明前半部分为正常升序队列      后半部分包括了翻转队列      对前半部分采取普通的二分查找
	 * 对后半部分做特殊处理           7    1    2
	 *                    ↑    ↑    ↑
	 *                 头结点                   尾节点
	 *   如果查找关键数小于头头结点元素，但大于尾节点元素，说明不在这个范围内，去另一个范围寻找
	 *   反之，则在这个范围内，继续递归查找
	 *                 
	 */
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int result = -1;
		int left = 0;
		int right = nums.length - 1;
		int middle = (left + right) / 2;
		//times表示查找的次数，因为没有设计好退出循环的条件
		//所以只能通过控制查找次数来退出循环
		int times=0;
		while (left <= right&&(times<nums.length)) {
			//当找到目标时，跳出循环
			if (target == nums[middle]) {
				result = middle;
				break;
			}
			if(target==nums[right]) {
				result=right;
				break;
			}
			//为正常的升序队列时的处理方法
			if (nums[left] < nums[middle]) {
				if (target < nums[left] || target > nums[middle]) {
					left = middle + 1;
				} else if (target < nums[middle]) {
					right = middle;
				}

			}
			//为翻转队列时的处理方法
			else if (nums[left] > nums[middle]) {
				if (target > nums[middle] && target < nums[left]) {
					left = middle;
				} else {
					right = middle;
				}
			}
			middle = (left + right) / 2;
			times++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		SortAndSearch5 test = new SortAndSearch5();
		test.search(nums, 6);

	}

}
