package com.yi.pat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Node {
	public int front;
	public int value;
	public int rear;
	public Node next;

	public Node(int front, int val, int rear) {
		this.front = front;
		value = val;
		this.rear = rear;
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int start = in.nextInt();
		int number = in.nextInt();
		Node[] nodes = new Node[number];
		for (int i = 0; i < number; i++) {
			nodes[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
		}
		in.close();
		int length = nodes.length;
		int head = 0;
		for (int i = 0; i < length; i++) {
			if (nodes[i].front == start) {
				head = i;
				break;
			}
		}
		Node head1 = nodes[head];
		Node temp = head1;
//		Arrays.sort(nodes,new Comparator<Node>() {
//
//			@Override
//			public int compare(Node o1, Node o2) {
//				// TODO Auto-generated method stub
//				return Integer.compare(o1.value, o2.value);
//			}
//		});
//		Node []delete=new Node[length];
//		int index=0;
//		for(int i=0;i<length;i++)
		while (number > 1) {
			for (int i = 0; i < length; i++) {
				if (temp.rear == nodes[i].front) {
					temp.next = nodes[i];
					temp = temp.next;
					number--;
					break;
				}
			}
		}
		Node[] delete = new Node[length];
		int index = 0;
		Node head2 = head1;
		Set<Integer> set = new HashSet<Integer>();
		Node cur = head1.next;
		set.add(Math.abs(head1.value));
		do {
			if (set.contains(Math.abs(cur.value))) {
				head1.next = cur.next;
				delete[index++] = cur;
			} else {
				set.add(Math.abs(cur.value));
			}
			head1 = head1.next;
			cur = cur.next;
		} while (cur.next != null);
		while (head2 != null) {
			System.out.printf("%05d %05d %05d \n", head2.front, head2.value, head2.rear);
			head2 = head2.next;
		}
		for (int i = 0; i < index; i++) {
			System.out.printf("%05d %05d %05d \n", delete[i].front, delete[i].value, delete[i].rear);
		}
	}
}
