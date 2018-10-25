package com.imooc.ArraysAndString;

import java.util.HashMap;


public class ArraysAndString7 {
	/*
	 * 暴力破解法，对数组进行排序，然后寻找前后为连续整数的数字个数
	 * 要注意的是在这道题中，会出现两个相同整数的情况，要考虑对这个问题的处理
	 */
//	 public int longestConsecutive(int[] nums) {
//	        if(nums==null||nums.length==0) {
//	        	return 0;
//	        }
//	        if(nums.length==1) {
//	        	return 1;
//	        }
//	        int length=nums.length;
//	        Arrays.sort(nums);
//	        int result=1;
//	        int temp=1;
//	        for(int i=0;i<length-1;i++) {
//	            while(nums[i]==nums[i+1]) {
//	        		i++;
//	        		if(i==length-1) {
//	        			break;
//	        		}
//	        	}
//	            if(i==length-1) {
//	        			break;
//	        		}
//	        	if(nums[i]==nums[i+1]-1) {
//	        		temp++;
//	        	}else {
//	        		temp=1;
//	        	}
//	        	result=Math.max(temp, result);
//	        }
//	        return result;
//	    }
	/*
	 * 自己写的改进版函数，逻辑上有问题并不能够通过
	 * 写的逻辑是记录每一次出现连续的情况，而不是最长连续数的个数
	 * 例 输入为      -1 0 1   3 4 5 6
	 * 我统计的是       1 1     1 1 1 答案为5
	 * 而实际上要统计的是   3,4,5,6 的长度，应该为4 
	 */
//	 public int longestConsecutive(int[] nums) {
//	        if(nums==null||nums.length==0) {
//	        	return 0;
//	        }
//	        if(nums.length==1) {
//	        	return 1;
//	        }
//	        int temp=1;
//	        int result=1;
//	        int length=nums.length;
//	      Set<Integer>set=new HashSet<>();
//	        for(int i=0;i<length;i++) {
//	        	if(set.contains(nums[i])) {
//	        		continue;
//	        	}if(set.contains(nums[i]+1)) {
//	        		temp++;
//	        		set.add(nums[i]);
//	        	}if(set.contains(nums[i]-1)) {
//	        		temp++;
//	        		set.add(nums[i]);
//	        	}
//	        	if(!set.contains(nums[i]-1)&&!set.contains(nums[i]+1)) {
//	        		temp=1;
//	        		set.add(nums[i]);
//	        	}
//	        	result=Math.max(result, temp);
//	        }
//	        return result;
//	 }
	/*
	 * java8中新增的map函数getOrDefault(int key,int defaultValue)
	 * 根据输入的key值去map中进行查找，如果找到对应的value就返回value的值
	 * 如果map中不存在对应的key，就返回defaultValue
	 */
	/*
	 * 这是网上网友的优秀算法，我看懂了他的思路，在这总结一下
	 * 1.我们先遍历数组，然后建立一个map来存贮信息，key为数组中出现的数字，value为这个数字所组成的连续数字的长度
	 * 需要注意的是只对连续数字的首尾数字更新为最新值，在中段的数字的value值可能并不正确
	 * 例         1  2  3  4
	 * 只保证1,4的值为4  而2,3的值并不保证为4
	 * 2.在往map中插入元素的过程中，会有两个情况
	 * 2.1map中不存在这个元素(nums[i])，但是存在这个数字连接的数字(例如 nums[i]-1或nums[i]+1)
	 * 则需要更新这个被连接成的数字串的首尾元素的长度信息，因为一个数字串只有可能在首尾被加入新的元素
	 * 将这个数字串的首尾信息更新后，只需要将这个新的数字也加入到map中去就行了
	 * 2.2map中不存在这个元素，也不存在与这个数字连接的元素。
	 * 意味着当前元素所在的连续序列长度就是1，只需要在map中插入这个元素就行了
	 * 
	 * 
	 * 例  读入的数组为   9  1  4  7  3  -1   0  5  8  1   6
	 * 在这个就模拟最后三个数字读入map的过程，前面的就略过了
	 * map中的情况为   key：   -1  0  1    3   4   5  7      9
	 *          value：     3  2  3    3   2   3  1      1
	 *          下一个插入的数字为8：
	 *          map中不存在这个数字，但是存在于他连接的首尾数字，然后获取他的首尾数字的value
	 *          得到的值都为1，表示在未插入8时，7,9两个数字没能够组成连续数字，在插入了8后，组成了7,8,9的连续数字
	 *          更新首尾数字的map信息   7=3 9=3 并且将元素8加入map中
	 *          下一个插入的数字为1：
	 *          因为map中已经存在1了，不进行操作
	 *          最后插入的数字为6：
	 *  map中的情况为   key：   -1  0  1    3   4   5  7   8   9
	 *           value：     3  2  3    3   2   3  3   3   3  
	 *   map中不存在这个数字，但是存在于他连接的首尾数字，然后获取他的首尾数字的value
	 *          得到的值都为3，表示在未插入6时，5,7两个数字都组成连续数字，分别为 3,4,5 和7,8,9 
	 *          在插入了6后，组成了3,4,5,6,7,8,9的连续数字
	 *          更新首尾数字的map信息   3=7 9=7 并且将元素6加入map中   
	 */
	 public int longestConsecutive(int[] nums) {
	        int max = 0;
	        HashMap<Integer,Integer> map = new HashMap<>();
	        for (int i:nums){
	            if(map.getOrDefault(i,0)==0){
	            	//为连续元素的左边界
	                int left = map.getOrDefault(i-1,0);
	                //为连续元素的右边界
	                int right = map.getOrDefault(i+1,0);
	                map.put(i,left+right+1);
	                //更新元素左边界的值
	                if(left!=0){
	                    map.put(i-left,left+right+1);
	                }
	                //更新元素右边界的值
	                if(right!=0){
	                    map.put(i+right,right+left+1);
	                }
	                max = max>(left+right+1)?max:(left+right+1);
	            }
	        }
	        return max;
	    }
	public static void main(String[] args) {
int []nums= {9,1,4,7,3,-1,0,5,8,-1,6};
ArraysAndString7 test=new ArraysAndString7();
int number=test.longestConsecutive(nums);
System.out.println(number);
	}

}
