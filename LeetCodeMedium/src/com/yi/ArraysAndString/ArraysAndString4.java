package com.yi.ArraysAndString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraysAndString4 {
	/*
	 * ��������Ƚ�ֱ�ۣ�ͨ��ʹ��list���������浱ǰ�ķ��ظ���ĸ�����ַ����� ����������ظ�����������ҵ��Ǹ��ظ�����ĸ��һ�γ��ֵ�λ��
	 * �Ե�ǰ���ַ������н�ȡ��ʹ��subList��ȡ���ظ���ĸ��һ��λ�ÿ�ʼ���µ��ַ���
	 * �Ӷ��ظ�ѭ�������ϼ����µ���ĸ��������ʵ��һ�����ڷ��ظ���ĸ�Ļ�������
	 * ����ʹ����ArrayList���ڲ���SubList�������¼һ��sublist�����Ժ�ʹ�÷���
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
	 * sonList��ʵ���Ƕ���ԭ�е�ArrayList�����һ�ν�ȡ���� ���ж���sonList�Ĳ�������󶼻�������parentList��
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
		// ��ȡһ��parentList��������ΪsonList
		List<String> sonList = parentList.subList(1, 5);
		// output : 1,2,3,4
		for (String temp : sonList) {
			System.out.print(temp + " ");
		}
		// �ı�sonList�е�ֵ��parentList��ֵҲ�ᱻ�ı�
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
		// ��sonList�����ֵ������parentList���Ǹ��¼ӵ�Ԫ�ص�λ�þ���sonList����ȡ��λ��ǰ��
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
		// ����sonList��ɾ����parentListͬ����Ч
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
 * ʹ��map�������int���͵ı�����ʵ�ֻ������ڣ�����Ч�ʱ�listʵ�ֵ�Ҫ�ߺܶ�
 */
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		int result = 0;
		//��ʾ��ǰ���ظ��ַ����ĳ���
		int nums = 0;
		int length = s.length();
		Map<Character, Integer> wordsLocation = new HashMap<Character, Integer>();
		for (int i = 0; i < length; i++) {
			if (wordsLocation.containsKey(s.charAt(i))) {
				int index = wordsLocation.get(s.charAt(i));
				//���֮ǰ�ظ�����ĸ�Ƿ��ڵ�ǰ�ַ����У���������ˣ��Ͱ��ظ���ĸ�����뵱ǰ���ַ�����
				if (index + nums < i) {
					nums++;
					//����ظ���ĸ�ڵ�ǰ�ַ����У��򽫵�ǰ�ַ����ĳ����޸�Ϊ�ظ���ĸ��һ��λ�ÿ�ʼ�ĳ���
				} else {
					nums = i - index;
				}
			} else {
				nums++;
			}
			//�����ĸû�б���ӹ����ͽ���ĸ��Ϣ��ӽ�map�У����map�����������ĸ���������һ��ĸ������λ��
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
