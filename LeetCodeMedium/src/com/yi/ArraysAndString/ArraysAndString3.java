package com.yi.ArraysAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraysAndString3 {
	/*
	 * ʹ�������������ʵ�ֹ��ܣ����������ٶȻ�ǳ��� ��Ҫԭ������Ϊ������ͨ���ж�list�����Ƿ񳤶�Ϊ0��Ϊ��������
	 * ���ı����������ģ��Ƚ�һ��������Ϊ�Ƚ϶��󣬱���һ��list�ҵ������칹�ĵ��� Ȼ���칹�ĵ��ʺ�����Ƚϵ��ʶ�ɾ����list
	 * �ٿ�ʼһ��ѭ��������Ѱ���칹�ĵ����ǣ�֪��list�ĳ��ȱ�Ϊ0���˳�ѭ���������� ����ʱ�临�ӶȾ�ΪO(n*n)
	 * ��ʵ����ͨ��һ�α������ܹ���ɣ�ʱ�临�Ӷȿ���ΪO(n)
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
	 * ���ַ�����ʱ�临�ӶȱȽϵͣ�ֻ��O(n)
	 * ����㷨������֮������ʹ����sort()���������Ƚ����������Ƿ�Ϊ�칹�����
	 * �����������칹ʱ�����ǵ���ĸ�����һ���ģ����Խ��������ĵ��ʾͿ�����Ϊmap��key��ʹ��
	 * ӵ��ͬ��key�ĵ��ʾ����칹�ĵ����飬�ͻᱻ�ӵ�ͬһ������ȥ
	 * ����ֻҪһ�μ򵥵ı����������String�������Ĺ���
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
			//����map����û��key���������Ҫ��������ʸ���ӽ�ȥ�����������������
			//��Ȼ����ֵ�һ����Ϊkey�ĵ��ʱ���©�����
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
