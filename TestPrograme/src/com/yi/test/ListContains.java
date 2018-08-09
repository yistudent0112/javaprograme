package com.yi.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
/**
 * 
 * 问题 :
 * 在给定的数组中寻找特定的元素
 * 这里通过了四种方法来实现这一问题
 * 1.使用List中的contains函数来做
 * 2.使用Set中的contains函数来做
 * 3.使用for循环遍历数组来做
 * 4.使用org.apache包下的ArrayUtil来做
 *
 *使用for循环来遍历效率最高
 *但在实际应用中主要使用方法4，因为这一方法底层也是使用for循环来实现的
 *还可以让开发人员少写代码，减少出错的可能
 */
public class ListContains {
	public boolean useList(String[] words, String target) {
		return Arrays.asList(words).contains(target);
	}

	public boolean useSet(String[] words, String target) {
		Set<String> set = new HashSet<String>(Arrays.asList(words));
		return set.contains(target);
	}

	public boolean useLoop(String[] words, String target) {
		for (int i = 0; i < words.length; i++) {
			if (target.equals(words[i])) {
				return true;
			}
		}
		return false;
	}

	public boolean useArrayUtil(String[] words, String target) {
		return ArrayUtils.contains(words, target);
	}

	public static void main(String[] args) {
		ListContains test=new ListContains();
		int stringLength=1000000;
		String[] words=new String[stringLength];
	    for(int i=0;i<stringLength;i++) {
	    	words[i]=String.valueOf(Math.random()*10);
	    }
	    System.out.println("useList方法");
		long time = System.currentTimeMillis();
		test.useList(words, "1");
		System.out.println("时间间隔：" + (System.currentTimeMillis() - time));

		   System.out.println("useSet方法");
			 time = System.currentTimeMillis();
			test.useSet(words, "1");
			System.out.println("时间间隔：" + (System.currentTimeMillis() - time));

			   System.out.println("useLoop方法");
				 time = System.currentTimeMillis();
				test.useLoop(words, "1");
				System.out.println("时间间隔：" + (System.currentTimeMillis() - time));

				   System.out.println("useArrayUtil方法");
					 time = System.currentTimeMillis();
					test.useArrayUtil(words, "1");
					System.out.println("时间间隔：" + (System.currentTimeMillis() - time));

	}

}
