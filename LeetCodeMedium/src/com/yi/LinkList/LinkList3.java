package com.yi.LinkList;

public class LinkList3 {
	/*
	 * ������˼·�����ҵ����������·��β��㣬
	 * ��Ϊ������������·��������ཻ�Ļ� ���ǵ�β���϶�����ͬ�ģ�
	 * Ȼ��������������·�ĳ��Ȳ�ͬ����������֮��ĳ��Ȳ�
	 * Ҳ�����ó�����������������ߣ����Ȳ����㣬������������£�����������·�Ӻ���ǰ�����������һ������
	 * Ȼ����������ڵ�һ�������ߣ�Ѱ�ҵ�һ�����߽����ͬ�Ľ����ǿ�ʼ�ཻ�Ľ��
	 * ����㷨����ĵĵط��ǣ�������������·�������ཻ�������ǵ�β����Ȼ����ͬ�ġ�
	 * ���γ��Ȳ��ԭ���ǣ����������·�ཻ�Ĳ��ֿ϶��ǵȳ��ģ����Գ���������·�ĳ��Ȳ���ϵĽ��϶��������ཻ���
	 * ���Ա�ֱ�����������Ӷ̵Ľ��ͷ����ʼѰ��
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
	        //���������·��β��㲻ͬ����˵��û���ཻ���������������null
	        if(headA!=headB) {
	        	return null;
	        }
	        //�����������ĳ��Ȳ�
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
	        //��ʼѰ�������ĵ�һ���ཻ��
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
