package com.yi.LinkList;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LinkList1 {
	/**
	 * 
	 * 因为现在结点位置处于要删除的那个结点，所以要把当前结点后一个点的值赋给当前结点
	 * 并修改当前结点的next属性
	 */
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
