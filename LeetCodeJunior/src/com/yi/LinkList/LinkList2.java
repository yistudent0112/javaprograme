package com.yi.LinkList;
/**
 * Given a linked list, 
 * remove the n-th node from the end of list 
 * and return its head
 * Note:
 * Given n will always be valid.
 * 
 * Follow up:
 * Could you do this in one pass?
 *
 */
public class LinkList2 {
	/**
	 * 
	 * 这题的解题思路如下，要删除倒数第n个结点就等同于删除最后一个结点的前第(n-1)个结点
	 * 那么通过设置两个结点，让他们两者之间间隔为n-1，当后一个结点到达链表的最后时，
	 * 前面的那个结点就是要被删除的那个结点
	 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode tailNode=head;
		ListNode currentNode=head;
		for(int i=0;i<n;i++) {
			tailNode=tailNode.next;
		}
		if(tailNode==null) {
			return currentNode.next;
		}
		while(tailNode.next!=null) {
			tailNode=tailNode.next;
			currentNode=currentNode.next;
		}
		//因为这里的情况是当前位置是要被删除的结点的前一格位置
		//所以只要把这个结点的next值给修改了就行了
		currentNode.next=currentNode.next.next;
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
 class ListNode {
    int val;
     ListNode next;
     ListNode(int x) { val = x; }
}