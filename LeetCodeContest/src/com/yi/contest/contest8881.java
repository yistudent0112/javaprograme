package com.yi.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class contest8881 {
	/*
	 * �����������ʹ����Arrays.asList()��������������������¿�
	 * ���������ת�������������͵�ʱ����������
	 * 1.
	 * ��Ϊ���������Դ����ʹ�÷���������ģ����˸�����������������û������װ�ģ�û�ж�Ӧ�İ�װ��
	 * ���ת���Ķ����Ǵ�Ż����������͵����飬��ô�����������������������ÿ��Ԫ�ض���ӵ�list��
	 * ������list�������һ������Ԫ��(list��ֻ��һ������Ԫ��)
	 * ��  int[]a={1,2,3,4,5}
	 * Arrays.list(a)  ������Ϊ  [[1],[2],[3],[4],[5]]
	 *                 ʵ�ʽ��Ϊ  [[1,2,3,4,5]]�������鱻��Ϊһ��Ԫ����ӽ���
	 * 2.������ص�list���������ǳ��õ�list���󣬶���Arrays�е�һ���ڲ���
	 * asList ���ص��б�ֻ������һ������ list �����£�����û�� list �Ļ������ԣ��䳤��.
	 * �� list ��һ�����Ȳ��ɱ���б���������������ж೤���䷵�ص��б��ֻ���Ƕ೤
	 * ��û��add�������������add�����ǻᱨ���   
	 * �������listֻ����һЩ�����Ĳ�ѯ      
	 */
	public int[] fairCandySwap(int[] A, int[] B) {
		int sumA = 0;
		int sumB = 0;
		int lengthA = A.length;
		int lengthB = B.length;
		int difference = 0;
		boolean biggerA = true;
		int[] result = new int[2];
		for (int i = 0; i < lengthA; i++) {
			sumA += A[i];
		}
		for (int i = 0; i < lengthB; i++) {
			sumB += B[i];
		}
		if (sumA > sumB) {
			difference = sumA - sumB;
		} else {
			difference = sumB - sumA;
			biggerA = false;
		}
		List<Integer> listA = new ArrayList<Integer>();
		List<Integer> listB = new ArrayList<Integer>();
		for (int a : A) {
			listA.add(a);
		}
		for (int b : B) {
			listB.add(b);
		}
		if (biggerA) {
			for (int i = 0; i < lengthA; i++) {
				if (listB.contains(A[i] - difference / 2)) {
					result[0] = A[i];
					result[1] = B[listB.indexOf(A[i] - difference / 2)];
					break;
				}
			}
		} else {
			for (int i = 0; i < lengthB; i++) {
				if (listA.contains(B[i] - difference / 2)) {
					result[0] = A[listA.indexOf(B[i] - difference / 2)];
					result[1] = B[i];
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		contest8881 test = new contest8881();
		int[] a = { 1, 2, 5 };
		int[] b = { 2, 4 };
		test.fairCandySwap(a, b);
Arrays.asList(a);
int c=1;
List list=Arrays.asList(c);
//list.add(1);
System.out.println(list);
	}

}
