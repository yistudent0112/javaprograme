package com.yi.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * transient修饰符可以阻止数据成员被序列化
 * 
 * LinkedList内部采用双向链表的形式来存贮结点
 * LinkedList的常用的数据成员
 * 1.int size 当前list中已有的结点数量
 * 2.Node first  链表的头结点
 * 3.Node last   链表的尾结点
 * Node结点内部类的结构
 * 1.E item  泛型的结点数据      
 * 2.Node<E>  prev 当前结点的前一个结点     
 * 3.Node<E>  next 当前结点的后一个结点4
 * 4.Node(Node<E> prev, E element, Node<E> next) 结点的构造函数
 * 
 *  由于LinkedList内部采用双向链表作为数据结构，所以对结点进行增删操作时，
 *  都需要设置结点的头尾结点信息，还需要考虑头尾结点为空的情况下，对空节点进行特别的处理
 *  LinkedList中常用的函数:
 *  1.LinkedList(Collection<? extends E> c) 构造函数，传入的参数为实现collection的存贮一串数据的参数
 *  2.addAll(int index,Collection<? extends E> c) 向指定的结点后部添加一串结点，并考虑了结点下标非法的问题
 *  3.checkPositionIndex(int index)  判断输入的结点下标是否在范围内，如果不是则抛出异常
 *  4.add(int index,E element)  通过结点下标向指定的结点后部添加一个新的结点
 *  5.void unlink(Node <E> x)  删除一个结点的信息，并把它的前后结点的信息更新为新的信息
 *  6.void clear()    删除现在存贮在双向链表中的所有的信息，把LinkedList中的元素清空
 *  7.Node<E> node(int index)  在双向链表中根据给定的下标查找到指定的结点
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
