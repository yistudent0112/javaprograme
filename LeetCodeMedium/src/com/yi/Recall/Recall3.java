package com.yi.Recall;

import java.util.ArrayList;
import java.util.List;

public class Recall3 {
	//public static   List<List<Integer>>result=new ArrayList<List<Integer>>();
//public List<List<Integer>> permute(int[] nums) {
//        if(nums==null||nums.length==0) {
//        	return result;
//        }
//        int length=nums.length;
//        boolean []visit=new boolean[length];
//        List<Integer>currentResult=new ArrayList<Integer>();
//        backTracking(currentResult, 0,0, length, visit,nums);
//        return result;
//    }
/*
 * 没法向前两题一样，把还未递归完的结果作为参数传入递归函数了
 * 因为前两道都是用String类型来保存不完整结果的，String被final给修饰了
 * 所以每次都会重新分配内存空间，也就是每个递归的线程都拥有一份自己的暂时结果
 * 而这里用的不是String类型作为临时变量，所以所有递归的线程拥有的是同一份结果
 * 这样就只能找到一个解而无法找全全部的解了
 */
//public void backTracking(List<Integer>currentResult,int index,int currentLength,int length,boolean[]visit,int []nums) {
//	if(index<0||index>=length) {
//		return;
//	}
//	if(visit[index]) {
//		return ;
//	}
//	visit[index]=true;
//	currentResult.add(nums[index]);
//	currentLength++;
//	if(currentLength==length) {
//		result.add(currentResult);
//		return;
//	}
//	for(int i=0;i<length;i++) {
//		backTracking(currentResult, i, currentLength, length, visit, nums);
//	}
//}
	 public List<List<Integer>> permute(int[] nums) {
		 List<List<Integer>>result=new ArrayList<List<Integer>>();
		 if(nums==null||nums.length==0) {
	        	return result;
	        }
		 List<Integer>temp=new ArrayList<Integer>();
		 backTracking(nums, temp,result);
		 return result;
	    }
	 public static void backTracking(int []nums,List<Integer> temp, List<List<Integer>>result) {
		int length=nums.length;
		 if(length==temp.size()) {
			 //每个单独的解还是需要重新申请内存空间,这样能保证最后的答案里，每个解都被保存进去了
			 //不然存放进去的只是对象，最后会导致所有的答案都指向同一块地址
			 List<Integer>tempresult=new ArrayList<Integer>();
		     for(int a:temp) {
		    	 tempresult.add(a);
		     }
			 result.add(tempresult);
			 return ;
		 }
		 for(int i=0;i<length;i++) {
			 if(temp.contains(nums[i])) {
				 continue;
			 }
			 temp.add(nums[i]);
			 backTracking(nums, temp,result);
			 //因为这里的临时变量在内存中只拥有一份，而不是各个递归的线程都拥有一份独自的临时变量temp
			 //所以要在递归结束后退出一个信息，保证恢复到递归前的状态，已达到真正的回溯
			 //例，比如已经找到一个答案为 1,2,3 现在temp中存放的就是 1,2,3 的数据   
			 //当回溯到 2结点的时候 temp的信息应该为 1,2 而因为这是一份共享的内存，
			 //所以 temp 还是之前找到的 1,2,3,就需要人为去删除最后的元素，来完成真正的回溯
			 temp.remove(temp.size()-1);
		 }
	 }
	 /*
	  * 这是网上另一种效率更高的交换数组中元素的方法
	  * 我对这个方法，还不理解原理
	  */
	  public List<List<Integer>> permute1(int[] nums) {
		  List<List<Integer>>res=new ArrayList<List<Integer>>();
	        int len = nums.length;
	        if (len==0||nums==null)  return res;

	        // 采用前后元素交换的办法，dfs解题
	        exchange(nums, 0, len,res);
	        return res;
	    }

	    public void exchange(int[] nums, int i, int len,List<List<Integer>> res) {
	        // 将当前数组加到结果集中
	        if(i==len-1) {
	            List<Integer> list = new ArrayList<>();
	            for (int j=0; j<len; j++){
	                list.add(nums[j]);
	            }
	            res.add(list);
	            return ;
	        }
	        // 将当前位置的数跟后面的数交换，并搜索解
	        for (int j=i; j<len; j++) {
	            swap(nums, i, j);
	            exchange(nums, i+1, len,res);
	            swap(nums, i, j);
	        }
	    }

	    public void swap(int[] nums, int i, int j) {
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	public static void main(String[] args) {
		int []nums= {1,2,3};
		Recall3 test=new Recall3();
		test.permute1(nums);

	}

}
