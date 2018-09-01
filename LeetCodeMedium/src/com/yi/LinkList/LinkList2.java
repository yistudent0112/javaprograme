package com.yi.LinkList;

public class LinkList2 {
	/*
	 * 这道题的思路就是拿着头结点，不断的去向后寻找，
	 * 然后设置两条结点链路，一条专门存放奇数结点，另一条专门存放偶数结点
	 * 然后在把奇偶两条结点链给拼接在一起，就可以了
	 * 需要注意的是在java中没有指针这一对象，而且在设置不同名字但内容一样的对象时，
	 * 是会指向同一块地址块的，所以有可能出现head.next=head的情况，
	 * 就会导致无限循环 例如 oddNode=head  oddNode.next=head 这就会引发错误
	 * 这个是我自己写的函数，虽然能够实现功能，但是空间和时间复杂度都达不到要求
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
	 * 这个方法设计的非常的巧妙，通过奇数结点和偶数结点两个节点不断的交换位置
	 * 得以达到遍历结点的目的，并完成了奇数位置和偶数位置结点的分离
	 * 例：  原先的结点链路    0 --> 1 --> 2 --> 3 --> 4 --> 5 --> 6
	 *                 ↑     ↑
	 *            奇数结点头       偶数节点头
	 * 第一次移动后                                   ↑     ↑    
	 *                  偶数节点头       奇数节点头   
	 * 第二次移动后                                                  ↑     ↑
	 *                          奇数结点头   偶数节点头
	 * 按照上图的交换后移的方式，就能够非常巧妙的实现奇偶位置结点的分离
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
