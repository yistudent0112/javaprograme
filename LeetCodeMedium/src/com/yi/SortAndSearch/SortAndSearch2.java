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
	 * ������˼·���ǽ���һ��map������ÿһ����ͬ�����ֳ��ֵ�Ƶ��
	 * ͨ������һ�����飬�����е����ֶ���map�м�¼һ��
	 * Ȼ���mapת��Ϊlist������map��value�Ĵ�С��������(��Ҫ�Լ�����һ���Ƚ��������бȽ�)
	 * ������Ҫ������Ƶ�ʸߵ����ָ�����������
	 * 
	 * ������ѵ����Ҫ�Լ�����һ���Ƚ�������Ϊû�����õĸ����map���͵�list����ıȽ���
	 * 
	 * ���⻹��һ�ַ���������Ͱ������ʵ�֣�����ԭ���ǲ���
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
	        //��map���͵Ķ���ת��Ϊlist���͵Ķ��󣬺ý����������
	        List<Map.Entry<Integer, Integer>>list=new 
	        		ArrayList<Map.Entry<Integer,Integer>>(numsFrequent.entrySet());
	        //�½�һ���Ƚ�������ʵ�ָ���map��valueֵ��������Ĺ���
	     Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// ʵ��һ����������
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
