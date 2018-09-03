package com.yi.Other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * 这道任务安排的题目难点在于如何安排任务队列才能够满足相同任务间隔时间的要求
 * 处理方法是找到重复次数最多的任务，然后以这个任务为模板，
 * 向后空出间隔时间，来方便其他任务放在两个相同任务之间
 * 
 * 例  任务队列   A,A,A,B,B,B,C,C   N=3
 *    找到出现次数最高的任务   A     留出相应的空格    A _ _ _ A _ _ _ A _ _ _ 
 *    然后插入其他的任务           B                 A B _ _ A B _ _ A B _ _
 *    最后插入任务                      C                 A B C _ A B C _ A B _ _
 *    最后要舍去最后一个任务多留的空格
 *    就能够得到最短的满足间隔要求的队伍序列了
 *   而最后一个任务块的长度就取决于有多少个同为重复次数最多的任务 
 *   最后的公式就是   (最长重复任务个数-1)*(任务间隔时间+1)+同为重复次数最多的任务
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
