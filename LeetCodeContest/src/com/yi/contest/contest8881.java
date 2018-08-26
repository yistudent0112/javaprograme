package com.yi.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class contest8881 {
	/*
	 * 在这个函数中使用了Arrays.asList()函数，这个函数中有以下坑
	 * 用这个函数转换基本数据类型的时候会出现问题
	 * 1.
	 * 因为这个函数的源码是使用泛型来处理的，而八个基本的数据类型是没有做包装的，没有对应的包装类
	 * 如果转换的对象是存放基本数据类型的数组，那么这个函数并不会把这个数组中每个元素都添加到list中
	 * 而是在list中添加了一个数组元素(list中只有一个数组元素)
	 * 例  int[]a={1,2,3,4,5}
	 * Arrays.list(a)  想象结果为  [[1],[2],[3],[4],[5]]
	 *                 实际结果为  [[1,2,3,4,5]]整个数组被作为一个元素添加进来
	 * 2.这个返回的list并不是我们常用的list对象，而是Arrays中的一个内部类
	 * asList 返回的列表只不过是一个披着 list 的外衣，它并没有 list 的基本特性（变长）.
	 * 该 list 是一个长度不可变的列表，传入参数的数组有多长，其返回的列表就只能是多长
	 * 他没有add函数，如果调用add函数是会报错的   
	 * 对于这个list只能做一些基本的查询      
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
