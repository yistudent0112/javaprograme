package com.yi.LinkList;

public class LinkList3 {
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
	        if(headA!=headB) {
	        	return null;
	        }
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
 class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
