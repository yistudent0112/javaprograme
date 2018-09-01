package com.yi.LinkList;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
public class LinkList1 {
	/*
	 * 两个节点分别连接一串数做加法运算，没有什么难点，
	 * 要注意的是对两边数的长度不一样，出现一边节点已遍历到头
	 * 而另一边还有不少节点的情况的处理
	 */
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    int sum=l1.val+l2.val;
	    int carry=0;
	    if(sum>9) {
	    	sum=sum%10;
	    	carry=1;
	    }
        ListNode temp=new ListNode(sum);
        ListNode head=temp;
       
        while((l1!=null&&l1.next!=null)||(l2!=null&&l2.next!=null)) {
        //对当前节点做判断，如果已是空节点了就不往后走了，不然会发生空指针错误
        	if(l1!=null) {
        		l1=l1.next;
        	}if(l2!=null) {
        		l2=l2.next; 
        	}
        	if(l1!=null&&l2!=null) {
        	sum=l1.val+l2.val+carry;
        	}else if(l1==null&&l2!=null) {
        		sum=l2.val+carry;
        	}else if(l1!=null&&l2==null) {
        		sum=l1.val+carry;
        	}
        	carry=0;
        	if(sum>9) {
    	    	sum=sum%10;
    	    	carry=1;
    	    }
        	temp.next=new ListNode(sum);
        	temp=temp.next;
        }
        if(carry==1) {
        	temp.next=new ListNode(1);
        }
        return head;
    }
	public static void main(String[] args) {
	LinkList1 test=new LinkList1();
	ListNode l1=new ListNode(2);
	l1.next=new ListNode(4);
	l1.next.next=new ListNode(3);
	ListNode l2=new ListNode(5);
//	l2.next=new ListNode(6);
//	l2.next.next=new ListNode(4);
	test.addTwoNumbers(l1, l2);
	

	}

}
