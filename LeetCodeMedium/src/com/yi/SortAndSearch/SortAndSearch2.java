package com.yi.SortAndSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortAndSearch2 {
	/*
	 * 这道题的思路就是建立一个map来存贮每一个不同的数字出现的频率
	 * 通过遍历一遍数组，把所有的数字都在map中记录一遍
	 * 然后把map转换为list，根据map中value的大小来做排序(需要自己定义一个比较器来进行比较)
	 * 最后把需要读出的频率高的数字给读出就行了
	 * 
	 * 这里的难点就是要自己定义一个比较器，因为没有内置的给存放map类型的list数组的比较器
	 * 
	 * 本题还有一种方法，是用桶排序来实现，但是原理是差不多的
	 * 
	 */
	 public List<Integer> topKFrequent(int[] nums, int k) {
	        List<Integer>result=new ArrayList<Integer>();
	        if(nums==null||(nums.length<k)) {
	        	return result;
	        }
	        int length=nums.length;
	        Map<Integer,Integer>numsFrequent=new HashMap<Integer,Integer>();
	        for(int i=0;i<length;i++) {
	        	if(numsFrequent.containsKey(nums[i])) {
	        		numsFrequent.replace(nums[i], numsFrequent.get(nums[i])+1);
	        	}else {
	        		numsFrequent.put(nums[i], 1);
	        	}
	        }
	        //将map类型的对象转换为list类型的对象，好进行排序操作
	        List<Map.Entry<Integer, Integer>>list=new 
	        		ArrayList<Map.Entry<Integer,Integer>>(numsFrequent.entrySet());
	        //新建一个比较器，来实现根据map的value值进行排序的功能
	     Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// 实现一个降序排列
				return o2.getValue().compareTo(o1.getValue());
			}
		});
	     for(int i=0;i<k;i++) {
	    	 result.add(list.get(i).getKey());
	     }
	        return result;
	    }
	public static void main(String[] args) {
		int []nums= {1,1,1,2,2,2,2,3,3,4};
		SortAndSearch2 test=new SortAndSearch2();
		test.topKFrequent(nums, 3);

	}

}
