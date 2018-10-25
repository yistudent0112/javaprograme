package com.imooc.ArraysAndString;

import java.util.Deque;
import java.util.LinkedList;

/*
 * ��������null������
 * new int[0]�ǿ����� null�ǿ�
 * ������ĺ����ǳ���Ϊ0�����飬��Ȼ���治�����κε�Ԫ�أ�
 * ����������鲻Ϊnull �Ͳ��ᱻһЩ��null�����ɾ��
 */
public class ArraysAndString10 {
	/*
	 * ������������ �������һ�����ֶ���������
	 * �������ڵ����ֶ����������Ȼ���������
	 * �Ӷ��õ��������������ֵ������ 
	 * �����������ʵ�֣�����Ч�ʽϵ�
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
	 * �Լ�����˫�˶��еĶ���д�ĳ����߼��жϲ����Ż������ܻ��Ƚϲ�
	 * ��¼һ���ƶ����������е�˫�˶�������
	 * ˫�˶��������µĹ����壺
	 * ����˫�˶��е�����Ϊqmax�������ŵĲ���������±�ֵ�����Ƕ�Ӧ���±�����
	 * ���赱ǰ��Ϊarr[i]
	 * ����������£�
	 * 1.���qmaxΪ�գ�ֱ�Ӱ��±����qmax��
	 * 2.���qmax��Ϊ�գ�ȡ����ǰqmax��β��ŵ��±�j��
	 * ���arr[j]>arr[i],ֱ�Ӱ��±�i�Ž�qmax�Ķ�β
	 * 3.���arr[j]<=arr[i],��һֱ��qmax�Ķ�β�����±꣬
	 * ֱ��ĳ���±���qmax�ж�Ӧ��ֵ����arr[i],��i����qmax�Ķ�β
	 * 
	 * ������������:
	 * ���qmax��ͷ���±��Ѿ��ڴ��ڷ�Χ���ˣ��򵯳�qmax��ǰ����ͷ
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
			 * ���˵�˫�˶��У������Ժ����ҵ�
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
	 * ���ڻ����������⣬��õķ�����ʹ��˫�˶��������
	 * ������ֻ���浱ǰ�����ڵĽ������ֽ�������������ڵ����־Ͱ���������
	 * ͨ��ά��һ��˫�˶��о��ܹ���һ�α����������½��������������
	 */
/*
 * �������������������ʵ��˫�˶��У�����front��back����ָ�������ƶ��еĽ�������̫�����
 */
	public int[] slide(int[] arr, int n, int w) {
		// result�����б���ÿ������״̬�µ����ֵ
		int[] result = new int[n - w + 1];
		// ��¼˫�˶��ж�ͷ���±� ����β�±�
		int[] qmax = new int[n];
		int front = 0, back = 0;
		// j ����Ƿ�ﵽ���ڴ�С,ͬʱ��¼result����һ��Ӧ�÷����Ԫ�ص��±�
		int j = 0;
		for (int i = 0; i < n; i++) {
			while (front < back && arr[qmax[back - 1]] < arr[i])
				// backΪ��ǰҪ��qmax�з����ֵ
				back--;
			qmax[back++] = i;
			if (j + w - 1 == i) {
				// �ﵽ���ڳ���
				result[j] = arr[qmax[front]];
				j++;
			}
			if (qmax[front] + w - 1 == i) {
				// ��ͷ����
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
