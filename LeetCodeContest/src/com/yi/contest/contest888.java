package com.yi.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/*
 * ���������ʱ����Ҫ�õ���̬�������顣
 * ���Ƕ���һ��String���͵����飬�����һ��Ԫ�غ�����ĳ��Ȼ��һ
 * ����������ָ��������ĳ��ȣ������Ͳ��ܽ�����Ȳ����õ�������(�������˳���Ϊ10�������Ҫ���11��Ԫ��)
 * ��java�Դ��Ļ����������͵��������������У������ڳ�ʼ����ʱ����Ҫָ������ĳ���
 * �Ӷ��̶��ķ���һ���ڴ�ռ�ģ�����ֻ��ʹ��list���͵ĸ߼�������ʵ�ֶ�̬���ӵĹ���
 * ��ͨ��toarray��������ת��Ϊ��������
 * �����¼һ�¾�̬����ĳ�ʼ����ʽ��list����ת���е�����
 */
public class contest888 {
	public void arrayInit() {
		// ��ֻ�Ƕ���һ��string�������͵ı�������������û�н��г�ʼ��������Ҳ�Ͳ��ܶ�������ʹ��
		// ��Ҫʹ������ʱ�򣬻�����Ҫ�������г�ʼ����
		String[] a = null;
		// �̶����ȵĳ�ʼ�����������ַ�����Ϊ��������Ĭ�ϵĽ������ڵ�ֵ��λnull�������int����0
		// �����double����0.0�������boolean����false
		String[] b = new String[10];
		// ���ݸ�������������ʼ�����飬����ĳ���Ϊ��ʼ���ַ���������
		String[] c = {};
		// ��һ�ֳ�ʼ���ַ����ķ�ʽ���������Ǹ�һ�ֵ�������һ���ģ�ֻ�����ǲ��õ�д��
		String[] d = new String[] {};
	}

	public void transList() {
		ArrayList<String> result = new ArrayList<String>();
		result.add("1");
		result.add("2");
		result.add("3");
		result.add("4");
		result.add("5");
		// ����һ������Ϊ�յ��ַ�������
		String[] temp = new String[] {};
		// ��Ϊ��ʱ��temp���ܹ�����ת����String���������(tempΪ�գ����ܴ����Ϣ)��
		// �ͻ᷵��һ��String����
		result.toArray(temp);
		// ��ʱ��ʹ��temp�����������ת���õ�����������ת��
		temp = result.toArray(temp);
		// ����ֱ�ӽ�temp1����Ϊ�ܹ������������㹻��С��string���飬��ʱ��Ϳ���ֱ�ӽ���ת����
		String[] temp1 = new String[result.size()];
		result.toArray(temp1);
	}

	public String[] uncommonFromSentences(String A, String B) {
		if (Objects.equals("", A.trim()) && Objects.equals("", B.trim())) {
			return null;
		}
		if (Objects.equals("", A.trim())) {
			return B.split(" ");
		}
		if (Objects.equals(" ", B.trim())) {
			return A.split(" ");
		}
		String[] result = new String[] {};
		// StringBuffer sb=new StringBuffer();
		String[] resultA = A.split(" ");
		String[] resultB = B.split(" ");
		int lengthA = resultA.length;
		int lengthB = resultB.length;
		int index = 0;
		Set<String> setA = new HashSet<String>();
		for (int i = 0; i < lengthA; i++) {
			if (!setA.add(resultA[i])) {
				setA.remove(resultA[i]);
			}
		}
		Set<String> setB = new HashSet<String>();
		for (int i = 0; i < lengthB; i++) {
			if (!setB.add(resultB[i])) {
				setB.remove(resultB[i]);
			}
		}

		for (int j = 0; j < lengthB; j++) {
			if (!setA.contains(resultB[j])) {
				result[index++] = resultB[j];
				// sb.append(resultB[j]);
				// sb.append(" ");
			}
		}
		for (int i = 0; i < lengthA; i++) {
			if (!setB.contains(resultA[i])) {
				result[index++] = resultA[i];
				// sb.append(resultA[i]);
				// sb.append(" ");
			}
		}
		// ArrayList<String>result=new ArrayList<String>();
		// return result.toArray(String[]{} );
		// return sb.toString().trim().split(" ");
		return result;
	}

	public String[] test() {
		ArrayList<String> result = new ArrayList<String>();
		result.add("1");
		result.add("2");
		result.add("3");
		result.add("4");
		result.add("5");
		String[] temp = new String[] {};
		// result.toArray(temp);
		// temp[0]="1";
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		contest888 test = new contest888();
		String a = "this apple is sweet";
		String b = "this apple is sour";
		test.uncommonFromSentences(a, b);
		// String[]result=test.test();
		// for(String word:result) {
		// System.out.println(word);
		// }
	}

}
