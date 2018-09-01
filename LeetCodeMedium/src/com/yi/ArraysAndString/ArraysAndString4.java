package com.yi.ArraysAndString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraysAndString4 {
	/*
	 * 这个方法比较直观，通过使用list对象来保存当前的非重复字母连续字符串， 如果出现了重复的情况，就找到那个重复的字母第一次出现的位置
	 * 对当前的字符串进行截取，使用subList截取从重复字母后一个位置开始的新的字符串
	 * 从而重复循环，不断加入新的字母进来，来实现一个对于非重复字母的滑动区域，
	 * 这里使用里ArrayList的内部类SubList，在这记录一下sublist的特性和使用方法
	 */

//	public int lengthOfLongestSubstring(String s) {
//		if (s == null || s.length() == 0) {
//			return 0;
//		}
//		if (s.length() == 1) {
//			return 1;
//		}
//		int length = s.length();
//		int result = 0;
//		List<Character> list = new ArrayList<Character>();
//		list.add(s.charAt(0));
//		for (int i = 1; i < length; i++) {
//			if (list.contains(s.charAt(i))) {
//				int index = list.indexOf(s.charAt(i));
//				list = list.subList(index + 1, list.size());
//			}
//			list.add(s.charAt(i));
//			result = Math.max(result, list.size());
//		}
//		return result;
//	}
	/*
	 * sonList其实就是对于原有的ArrayList对象的一段截取对象， 所有对于sonList的操作，最后都会作用于parentList上
	 */
	public void SubListUse() {
		List<String> parentList = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			parentList.add(String.valueOf(i));
		}
		// output : 0,1,2,3,4,5,6,7,8,9
		for (String temp : parentList) {
			System.out.print(temp + " ");
		}
		System.out.println();
		// 截取一段parentList的内容作为sonList
		List<String> sonList = parentList.subList(1, 5);
		// output : 1,2,3,4
		for (String temp : sonList) {
			System.out.print(temp + " ");
		}
		// 改变sonList中的值，parentList的值也会被改变
		sonList.set(1, "new 2");
		System.out.println();
		// output: 1,new 2,3,4
		for (String temp : sonList) {
			System.out.print(temp + " ");
		}
		System.out.println();
		// output: 0,1,new 2,3,4,5,6,7,8,9
		for (String temp : parentList) {
			System.out.print(temp + " ");
		}
		// 向sonList中添加值，对于parentList中那个新加的元素的位置就是sonList被截取的位置前面
		sonList.add("4.5");
		System.out.println();
		// output: 1,new 2,3,4,4.5
		for (String temp : sonList) {
			System.out.print(temp + " ");
		}
		System.out.println();
		// output: 0,1,new 2,3,4,4.5,5,6,7,8,9
		for (String temp : parentList) {
			System.out.print(temp + " ");
		}
		// 对于sonList的删除对parentList同样有效
		sonList.remove(3);
		System.out.println();
		// output: 1,new 2,3,4.5
		for (String temp : sonList) {
			System.out.print(temp + " ");
		}
		System.out.println();
		// output: 0,1,new 2,3,4.5,5,6,7,8,9
		for (String temp : parentList) {
			System.out.print(temp + " ");
		}
	}
/*
 * 使用map配合两个int类型的变量来实现滑动窗口，运行效率比list实现的要高很多
 */
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		int result = 0;
		//表示当前无重复字符串的长度
		int nums = 0;
		int length = s.length();
		Map<Character, Integer> wordsLocation = new HashMap<Character, Integer>();
		for (int i = 0; i < length; i++) {
			if (wordsLocation.containsKey(s.charAt(i))) {
				int index = wordsLocation.get(s.charAt(i));
				//检查之前重复的字母是否还在当前字符串中，如果不在了，就把重复字母爱加入当前的字符串中
				if (index + nums < i) {
					nums++;
					//如果重复字母在当前字符串中，则将当前字符串的长度修改为重复字母后一个位置开始的长度
				} else {
					nums = i - index;
				}
			} else {
				nums++;
			}
			//如果字母没有被添加过，就将字母信息添加进map中，如果map中已有这个字母，则更新这一字母的最新位置
			wordsLocation.put(s.charAt(i), i);
			result = Math.max(result, nums);
		}
		return result;
	}

	public static void main(String[] args) {
		ArraysAndString4 test = new ArraysAndString4();
		 test.lengthOfLongestSubstring("abba");
		//test.SubListUse();
	}

}
