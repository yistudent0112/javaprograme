package Bacial_program;

public class programe_7_28_Linklist {
public static class Node{
	 int value;
	 Node next=null;
	 public Node(int value) {
		 this.value=value;
	 }
}
 private static Node head=null;
 public static void AddNode(int n) {
	 Node n1=new Node(n);
	 if(head==null) {
		 head=n1;
		 return;
	 }
	 else {
		 Node temp=head;
	 while(temp.next!=head) {
		 temp=temp.next;
	 }
	 temp.next=n1;
   n1.next=head;
	 }
 }
 public static int GetLength() {
	 int length=0;
	 if(head==null) {
		 
	 }else {
	 Node temp=head;
	 length++;
	 while(temp.next!=head) {
		 length++;
	System.out.println(length);
		 temp=temp.next;
	 }
	 }
	 return length;
 }
 public static boolean DeleteNode(int index) {
	 boolean success=false;
	 
	 return success;
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
AddNode(1);
AddNode(2);
AddNode(3);
AddNode(4);
AddNode(5);
System.out.println(GetLength());

	}

}
