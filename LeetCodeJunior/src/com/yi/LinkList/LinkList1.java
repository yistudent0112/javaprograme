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
	 * ��Ϊ���ڽ��λ�ô���Ҫɾ�����Ǹ���㣬����Ҫ�ѵ�ǰ����һ�����ֵ������ǰ���
	 * ���޸ĵ�ǰ����next����
	 */
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
