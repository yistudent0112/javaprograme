package com.yi.ArraysAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraysAndString3 {
	/*
	 * 使用这个函数可以实现功能，但是运行速度会非常慢 主要原因是因为，这里通过判断list数组是否长度为0作为结束条件
	 * 它的遍历是这样的，先将一个单词作为比较对象，遍历一次list找到和他异构的单词 然后将异构的单词和这个比较单词都删除出list
	 * 再开始一次循环，接着寻找异构的单词们，知道list的长度变为0，退出循环，输出结果 这样时间复杂度就为O(n*n)
	 * 而实际上通过一次遍历就能够完成，时间复杂度可以为O(n)
	 */
//	public List<List<String>> groupAnagrams(String[] strs) {
//		ArrayList<List<String>> result = new ArrayList<List<String>>();
//		if (strs.length < 1) {
//			return result;
//		}
//		List<String> words = new ArrayList<String>(Arrays.asList(strs));
//		while (words.size() > 0) {
//			List<String> temp = new ArrayList<String>();
//			temp.add(words.get(0));
//			words.remove(0);
//			for (int i = 0; i < words.size(); i++) {
//				if (isValidAnagram(temp.get(0), words.get(i))) {
//					temp.add(words.get(i));
//					words.remove(words.get(i));
//					if (i > 0) {
//						i--;
//					}
//				}
//			}
//			if (words.size() == 1) {
//				if (isValidAnagram(temp.get(0), words.get(0))) {
//					temp.add(words.get(0));
//					words.remove(words.get(0));
//
//				}
//			}
//			result.add(temp);
//		}
//		return result;
//	}
	/*
	 * 这种方法的时间复杂度比较低，只有O(n)
	 * 这个算法的巧妙之处在于使用了sort()排序函数来比较两个单词是否为异构的情况
	 * 当两个单词异构时，他们的字母组成是一样的，所以进行排序后的单词就可以作为map的key来使用
	 * 拥有同样key的单词就是异构的单词组，就会被加到同一个组中去
	 * 这样只要一次简单的遍历就能完成String数组分组的功能
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		
		if(strs==null||strs.length<1) {
			return new ArrayList<List<String>>();
		}
		Map<String, List<String>>result=new HashMap<String,List<String>>();
		for(int i=0;i<strs.length;i++) {
			char[]temp=strs[i].toCharArray();
			Arrays.sort(temp);
			String key=String.valueOf(temp);
			if(!result.containsKey(key)) {
				result.put(key, new ArrayList<String>());
			}
			//不管map中有没有key的情况，都要把这个单词给添加进去，不能忘了添加它，
			//不然会出现第一次作为key的单词被遗漏的情况
			result.get(key).add(strs[i]);
		}
		return new ArrayList<List<String>>(result.values());
	}
	public static boolean isValidAnagram(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		boolean flag = true;
		int[] wordsA = new int[26];
		int[] wordsB = new int[26];
		int length = a.length();
		for (int i = 0; i < length; i++) {
			wordsA[a.charAt(i) - 'a']++;
		}
		for (int i = 0; i < length; i++) {
			wordsB[b.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (wordsA[i] != wordsB[i]) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArraysAndString3 test = new ArraysAndString3();
		// boolean result=test.isValidAnagram("abcccc", "cccbca");
		// System.out.println(result);
		String words[] = { "eat","tea","tan","ate","nat","bat"};
		// List<String>word=Arrays.asList(words);
		// word.remove("eat");
		test.groupAnagrams(words);
		/*
		 * ArrayList<Integer> integers = new ArrayList<Integer>(); integers.add(1);
		 * integers.add(2); System.out.println(integers); integers.remove(1);
		 * System.out.println(integers);
		 */
	}

}
