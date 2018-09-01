package com.yi.LinkList;

public class LinkList3 {
	/*
	 * 这道题的思路是先找到两条结点链路的尾结点，
	 * 因为如果两条结点链路如果出现相交的话 他们的尾结点肯定是相同的，
	 * 然后根据两条结点链路的长度不同，屏蔽他们之间的长度差
	 * 也就是让长的那条结点先往后走（长度差）个结点，在这样的情况下，他们两条链路从后往前数的情况下是一样长的
	 * 然后就让两个节点一起往后走，寻找第一个两边结点相同的结点就是开始相交的结点
	 * 这个算法最核心的地方是，如果两条结点链路出现了相交，那他们的尾结点必然是相同的。
	 * 屏蔽长度差得原理是，两条结点链路相交的部分肯定是等长的，所以长的那条链路的长度差部分上的结点肯定不会是相交结点
	 * 可以被直接舍弃掉，从短的结点头部开始寻找
	 */
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		    ListNode tempA=headA;
		    ListNode tempB=headB;
	        int lengthA=0;
	        int lengthB=0;
	        while(headA!=null) {
	        	lengthA++;
	        	headA=headA.next;
	        }
	        while(headB!=null) {
	        	lengthB++;
	        	headB=headB.next;
	        }
	        //如果两条链路的尾结点不同，则说明没有相交的情况发生，返回null
	        if(headA!=headB) {
	        	return null;
	        }
	        //屏蔽两条结点的长度差
	        int differenceLength=lengthA-lengthB;
	        if(differenceLength>=0) {
	        	for(int i=0;i<differenceLength;i++) {
	        		tempA=tempA.next;
	        	}
	        }else {
	        	for(int i=0;i<(-differenceLength);i++) {
	        		tempB=tempB.next;
	        	}
	        }
	        //开始寻找两结点的第一个相交点
	        while(tempA!=tempB) {
	        	tempA=tempA.next;
	        	tempB=tempB.next;
	        }
	        return tempA;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
// class ListNode {
//	      int val;
//	      ListNode next;
//	      ListNode(int x) {
//	          val = x;
//	          next = null;
//	      }
//	  }
