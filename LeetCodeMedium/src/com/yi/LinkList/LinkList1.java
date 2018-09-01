package com.yi.LinkList;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
public class LinkList1 {
	/*
	 * �����ڵ�ֱ�����һ�������ӷ����㣬û��ʲô�ѵ㣬
	 * Ҫע����Ƕ��������ĳ��Ȳ�һ��������һ�߽ڵ��ѱ�����ͷ
	 * ����һ�߻��в��ٽڵ������Ĵ���
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
        //�Ե�ǰ�ڵ����жϣ�������ǿսڵ��˾Ͳ��������ˣ���Ȼ�ᷢ����ָ�����
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
