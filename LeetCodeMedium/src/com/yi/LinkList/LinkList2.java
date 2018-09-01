package com.yi.LinkList;

public class LinkList2 {
	/*
	 * ������˼·��������ͷ��㣬���ϵ�ȥ���Ѱ�ң�
	 * Ȼ���������������·��һ��ר�Ŵ��������㣬��һ��ר�Ŵ��ż�����
	 * Ȼ���ڰ���ż�����������ƴ����һ�𣬾Ϳ�����
	 * ��Ҫע�������java��û��ָ����һ���󣬶��������ò�ͬ���ֵ�����һ���Ķ���ʱ��
	 * �ǻ�ָ��ͬһ���ַ��ģ������п��ܳ���head.next=head�������
	 * �ͻᵼ������ѭ�� ���� oddNode=head  oddNode.next=head ��ͻ���������
	 * ��������Լ�д�ĺ�������Ȼ�ܹ�ʵ�ֹ��ܣ����ǿռ��ʱ�临�Ӷȶ��ﲻ��Ҫ��
	 * 
	 */
//	 public ListNode oddEvenList(ListNode head) {
//		 if(head==null) {
//			 return null;
//		 }
//		 if(head.next==null) {
//			 return head;
//		 }
//	        ListNode oddNode=new ListNode(head.val);
//	        ListNode oddHead=oddNode;
//	        ListNode evenNode=new ListNode(head.next.val);
//	        ListNode evenHead=evenNode;
//	        int length=0;
//	        head=head.next.next;
//	        while(head!=null) {
//	        	length++;
//	        	if((length&1)==1) {
//	        	oddNode.next=head;
//	        	oddNode=oddNode.next;
//	        	}else {
//	        		evenNode.next=head;
//	        		evenNode=evenNode.next;
//	        	}
//	        	head=head.next;
//	        }
//	        oddNode.next=evenHead;
//	        return oddHead;
//	    }
	/*
	 * ���������Ƶķǳ������ͨ����������ż����������ڵ㲻�ϵĽ���λ��
	 * ���Դﵽ��������Ŀ�ģ������������λ�ú�ż��λ�ý��ķ���
	 * ����  ԭ�ȵĽ����·    0 --> 1 --> 2 --> 3 --> 4 --> 5 --> 6
	 *                 ��     ��
	 *            �������ͷ       ż���ڵ�ͷ
	 * ��һ���ƶ���                                   ��     ��    
	 *                  ż���ڵ�ͷ       �����ڵ�ͷ   
	 * �ڶ����ƶ���                                                  ��     ��
	 *                          �������ͷ   ż���ڵ�ͷ
	 * ������ͼ�Ľ������Ƶķ�ʽ�����ܹ��ǳ������ʵ����żλ�ý��ķ���
	 */
	 public ListNode oddEvenList(ListNode head) {
		 if(head==null) {
			 return null;
		 }
		 if(head.next==null) {
			 return head;
		 }
		 ListNode oddHead=head;
		 ListNode evenHead=head.next;
		 ListNode oddNode=oddHead;
		 ListNode evenNode=evenHead;
		 while(oddNode.next!=null&&evenNode.next!=null) {
			 oddNode.next=evenNode.next;
			 oddNode=oddNode.next;
			 evenNode.next=oddNode.next;
			 evenNode=evenNode.next;
		 }
		 oddNode.next=evenHead;
		 return oddHead;
	 }
	 public ListNode oddEvenList1(ListNode head) {
	        if(head == null)
	            return head;
	        ListNode oddHead = head,evenHead =head.next;
	        ListNode prevOdd = oddHead,prevEven = evenHead;

	        while(prevOdd.next != null && prevEven.next != null){
	            prevOdd.next = prevEven.next;
	            prevOdd = prevOdd.next;

	            prevEven.next = prevOdd.next;
	            prevEven = prevEven.next;
	        }
	        prevOdd.next = evenHead;

	        return oddHead;
	    }
	public static void main(String[] args) {
	ListNode head=new ListNode(0);
	head.next=new ListNode(1);
	head.next.next=new ListNode(2);
	head.next.next.next=new ListNode(3);
	head.next.next.next.next=new ListNode(4);
	head.next.next.next.next.next=new ListNode(5);
	head.next.next.next.next.next.next=new ListNode(6);
	head.next.next.next.next.next.next.next=new ListNode(7);
		LinkList2 test=new LinkList2();
		test.oddEvenList(head);
//		System.out.println(test);
//		LinkList2 test1=test;
//		System.out.println(test1);

	}

}
