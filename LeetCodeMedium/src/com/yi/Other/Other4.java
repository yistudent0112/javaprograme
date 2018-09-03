package com.yi.Other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * ��������ŵ���Ŀ�ѵ�������ΰ���������в��ܹ�������ͬ������ʱ���Ҫ��
 * ���������ҵ��ظ�������������Ȼ�����������Ϊģ�壬
 * ���ճ����ʱ�䣬�����������������������ͬ����֮��
 * 
 * ��  �������   A,A,A,B,B,B,C,C   N=3
 *    �ҵ����ִ�����ߵ�����   A     ������Ӧ�Ŀո�    A _ _ _ A _ _ _ A _ _ _ 
 *    Ȼ���������������           B                 A B _ _ A B _ _ A B _ _
 *    ����������                      C                 A B C _ A B C _ A B _ _
 *    ���Ҫ��ȥ���һ����������Ŀո�
 *    ���ܹ��õ���̵�������Ҫ��Ķ���������
 *   �����һ�������ĳ��Ⱦ�ȡ�����ж��ٸ�ͬΪ�ظ������������� 
 *   ���Ĺ�ʽ����   (��ظ��������-1)*(������ʱ��+1)+ͬΪ�ظ�������������
 *   
 */
public class Other4 {
	public int leastInterval(char[] tasks, int n) {
		if (tasks == null || tasks.length == 0) {
			return 0;
		}
		int result = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char temp : tasks) {
			if (map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}
		List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		int a = list.get(0).getValue();
		int same = 0;
		for (Entry<Character, Integer> temp1 : list) {
			if (temp1.getValue() == a) {
				same++;
			} else {
				break;
			}
		}
		result = Math.max(tasks.length, (a - 1) * (n + 1) + same);
		return result;
	}

	public static void main(String[] args) {
		char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'D' };
		Other4 test = new Other4();
		int result = test.leastInterval(tasks, 2);
		System.out.println(result);
	}

}
