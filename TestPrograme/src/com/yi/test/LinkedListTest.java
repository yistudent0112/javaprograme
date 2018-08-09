package com.yi.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * transient���η�������ֹ���ݳ�Ա�����л�
 * 
 * LinkedList�ڲ�����˫���������ʽ���������
 * LinkedList�ĳ��õ����ݳ�Ա
 * 1.int size ��ǰlist�����еĽ������
 * 2.Node first  �����ͷ���
 * 3.Node last   �����β���
 * Node����ڲ���Ľṹ
 * 1.E item  ���͵Ľ������      
 * 2.Node<E>  prev ��ǰ����ǰһ�����     
 * 3.Node<E>  next ��ǰ���ĺ�һ�����4
 * 4.Node(Node<E> prev, E element, Node<E> next) ���Ĺ��캯��
 * 
 *  ����LinkedList�ڲ�����˫��������Ϊ���ݽṹ�����ԶԽ�������ɾ����ʱ��
 *  ����Ҫ���ý���ͷβ�����Ϣ������Ҫ����ͷβ���Ϊ�յ�����£��Կսڵ�����ر�Ĵ���
 *  LinkedList�г��õĺ���:
 *  1.LinkedList(Collection<? extends E> c) ���캯��������Ĳ���Ϊʵ��collection�Ĵ���һ�����ݵĲ���
 *  2.addAll(int index,Collection<? extends E> c) ��ָ���Ľ������һ����㣬�������˽���±�Ƿ�������
 *  3.checkPositionIndex(int index)  �ж�����Ľ���±��Ƿ��ڷ�Χ�ڣ�����������׳��쳣
 *  4.add(int index,E element)  ͨ������±���ָ���Ľ������һ���µĽ��
 *  5.void unlink(Node <E> x)  ɾ��һ��������Ϣ����������ǰ�������Ϣ����Ϊ�µ���Ϣ
 *  6.void clear()    ɾ�����ڴ�����˫�������е����е���Ϣ����LinkedList�е�Ԫ�����
 *  7.Node<E> node(int index)  ��˫�������и��ݸ������±���ҵ�ָ���Ľ��
 */
public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> test=new LinkedList<String>();
		List<String> a = new ArrayList<>();
		a.add("1");
		a.add("2");
		a.add("3");
		a.add("4");
		test.addAll(a);
		List<String> b = new ArrayList<>();
		b.add("5");
		b.add("6");
		test.addAll(2, b);
	}

}
