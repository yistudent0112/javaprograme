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
	 * ����Ľ���˼·���£�Ҫɾ��������n�����͵�ͬ��ɾ�����һ������ǰ��(n-1)�����
	 * ��ôͨ������������㣬����������֮����Ϊn-1������һ����㵽����������ʱ��
	 * ǰ����Ǹ�������Ҫ��ɾ�����Ǹ����
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
		//��Ϊ���������ǵ�ǰλ����Ҫ��ɾ���Ľ���ǰһ��λ��
		//����ֻҪ���������nextֵ���޸��˾�����
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