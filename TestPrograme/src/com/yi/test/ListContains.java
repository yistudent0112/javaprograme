package com.yi.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
/**
 * 
 * ���� :
 * �ڸ�����������Ѱ���ض���Ԫ��
 * ����ͨ�������ַ�����ʵ����һ����
 * 1.ʹ��List�е�contains��������
 * 2.ʹ��Set�е�contains��������
 * 3.ʹ��forѭ��������������
 * 4.ʹ��org.apache���µ�ArrayUtil����
 *
 *ʹ��forѭ��������Ч�����
 *����ʵ��Ӧ������Ҫʹ�÷���4����Ϊ��һ�����ײ�Ҳ��ʹ��forѭ����ʵ�ֵ�
 *�������ÿ�����Ա��д���룬���ٳ���Ŀ���
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
	    System.out.println("useList����");
		long time = System.currentTimeMillis();
		test.useList(words, "1");
		System.out.println("ʱ������" + (System.currentTimeMillis() - time));

		   System.out.println("useSet����");
			 time = System.currentTimeMillis();
			test.useSet(words, "1");
			System.out.println("ʱ������" + (System.currentTimeMillis() - time));

			   System.out.println("useLoop����");
				 time = System.currentTimeMillis();
				test.useLoop(words, "1");
				System.out.println("ʱ������" + (System.currentTimeMillis() - time));

				   System.out.println("useArrayUtil����");
					 time = System.currentTimeMillis();
					test.useArrayUtil(words, "1");
					System.out.println("ʱ������" + (System.currentTimeMillis() - time));

	}

}
