package com.imooc.ArraysAndString;

import java.util.Deque;
import java.util.LinkedList;

/*
 * 空数组与null的区别
 * new int[0]是空数组 null是空
 * 空数组的含义是长度为0的数组，虽然里面不包含任何的元素，
 * 但是这个数组不为null 就不会被一些对null处理的删除
 */
public class ArraysAndString10 {
	/*
	 * 滑动窗口问题 这里采用一个数字队列来处理，
	 * 将窗口内的数字都放入队列中然后进行排序
	 * 从而得到滑动窗口内最大值得数组 
	 * 这个方面容易实现，但是效率较低
	 */
//	 public int[] maxSlidingWindow(int[] nums, int k) {
//		 if(nums==null||nums.length<1) {
//			 int []result = {};
//			 return result;
//		 }
//		 List<Integer>queue=new ArrayList<Integer>(k);
//		 int length=nums.length;
//	        int []results=new int[length-k+1];
//	        for(int i=0;i<k;i++) {
//	         queue.add(nums[i]);
//	        }
//	        Collections.sort(queue);
//	        for(int i=0;i<length-k+1;i++) {
//	        	results[i]=queue.get(queue.size()-1) ;
//	        	queue.remove(new Integer(nums[i]));
//	        	if(k+i<length) {
//	        		queue.add(nums[k+i]);
//	        	}
//	        	Collections.sort(queue);
//	        }
//	        return results;
//	    }
	/*
	 * 自己按照双端队列的定义写的程序，逻辑判断不够优化，性能还比较差
	 * 记录一下移动窗口问题中的双端队列做法
	 * 双端队列有如下的规则定义：
	 * 定义双端队列的名字为qmax，里面存放的不是数组的下标值，而是对应的下标索引
	 * 假设当前数为arr[i]
	 * 放入规则如下：
	 * 1.如果qmax为空，直接把下标放入qmax中
	 * 2.如果qmax不为空，取出当前qmax队尾存放的下标j，
	 * 如果arr[j]>arr[i],直接把下标i放进qmax的队尾
	 * 3.如果arr[j]<=arr[i],则一直从qmax的队尾弹出下标，
	 * 直到某个下标在qmax中对应的值大于arr[i],把i放入qmax的队尾
	 * 
	 * 弹出规则如下:
	 * 如果qmax队头的下标已经在窗口范围外了，则弹出qmax当前队列头
	 */
	
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length < 1) {
			int[] result = {};
			return result;
		}
		int length = nums.length;
		int[] results = new int[length - k + 1];
		Deque<Integer>queue=new LinkedList<Integer>();
		//List<Integer>queue=new ArrayList<Integer>(k);
		for(int i=0;i<length;i++) {
			while(!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]) {
				queue.pollLast();
			}
		//	queue.addLast(i);
			if(queue.isEmpty()) {
				queue.add(i);
			}else if(nums[i]<nums[queue.peekLast()]){
			   queue.addLast(i);
			}
			if(i>=k-1) {
				results[i-k+1]=nums[queue.peekFirst()];
			}
			if(i-queue.peekFirst()==k-1) {
				queue.pollFirst();
			}
			/*
			 * 别人的双端队列，性能略好于我的
			 */
//			while(!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]) {
//				queue.pollLast();
//			}
//			while(!queue.isEmpty()&&queue.getFirst()<i-(k-1)) {
//				queue.pollFirst();
//			}
//			queue.addLast(i);
//			if(i>=k-1) {
//				results[i-k+1]=nums[queue.peekFirst()];
//			}
		
		}
		return results;
	}
	/*
	 * 对于滑动窗口问题，最好的方法是使用双端队列来解决
	 * 队列中只保存当前窗口内的降序数字结果，遇到出窗口的数字就把他出队列
	 * 通过维护一个双端队列就能够在一次遍历的条件下解决滑动窗口问题
	 */
/*
 * 这个方法采用了数组来实现双端队列，用了front，back两个指针来控制队列的进出，不太好理解
 */
	public int[] slide(int[] arr, int n, int w) {
		// result数组中保存每个窗口状态下的最大值
		int[] result = new int[n - w + 1];
		// 记录双端队列队头的下标 ，队尾下标
		int[] qmax = new int[n];
		int front = 0, back = 0;
		// j 标记是否达到窗口大小,同时记录result中下一个应该放入的元素的下标
		int j = 0;
		for (int i = 0; i < n; i++) {
			while (front < back && arr[qmax[back - 1]] < arr[i])
				// back为当前要往qmax中放入的值
				back--;
			qmax[back++] = i;
			if (j + w - 1 == i) {
				// 达到窗口长度
				result[j] = arr[qmax[front]];
				j++;
			}
			if (qmax[front] + w - 1 == i) {
				// 队头过期
			   front++;
			}

		}

		return result;

	}

	public static void main(String[] args) {
		ArraysAndString10 test = new ArraysAndString10();
		int[] nums = { 1,3,1,2,0,5};
		int k = 3;
		nums = test.maxSlidingWindow(nums, k);
		//nums=test.slide(nums, nums.length, k);
		for (int temp : nums) {
			System.out.println(temp);
		}

	}

}
