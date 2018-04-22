package English.programe;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
    * @ClassName: programe_6_7  
    * @Description: TODO(
    * Two trees, T1 and T2,are isomorphic 
    * if T1 can be transformed into T2 by swapping 
    * left and rightchildren of (some of the) nodes in T1.
    *  For instance, 
    *  the two trees in Figure 1 are isomorphic 
    *  because they are the same if the children of A, B, 
    *  and G, but not the other nodes, are swapped. 
    *  Give a polynomial time algorithm to decide 
    *  if two trees are isomorphic.
    *  )   
    * @author yi  
    * @date 2018年4月21日  
    *
 */
public class programe_6_7 {
	private static Node Root1;
	private static Node Root2;
	private static List<Node>list1=new ArrayList<Node>();
	private static List<Node>list2=new ArrayList<Node>();
	private static int Length1;
	private static int Length2;
	public static void Input() {
		Scanner in=new Scanner(System.in);
		System.out.println("please input the tree1 length");
		Length1=in.nextInt();
		for(int i=0;i<Length1;i++) {
			list1.add(new Node(in.nextInt()));
		}
		BuildTree(1);
		System.out.println("please input the tree2 length");
		Length2=in.nextInt();
		for(int i=0;i<Length2;i++) {
			list2.add(new Node(in.nextInt()));
		}
		BuildTree(2);
		in.close();
	}
	/**
	 * 
	    * @ClassName: Node  
	    * @Description: TODO(节点类，内部类)  
	    * @author yi  
	    * @date 2018年4月22日  
	    *
	 */
	private static class Node {
		Node LeftNode;
		Node RightNode;
		int Data;

		public Node(int data) {
			LeftNode = null;
			RightNode = null;
			Data = data;
		}
	}
	public static void BuildTree(int TreeNumber) {
		if(TreeNumber==1) {
			Root1=list1.get(0);
			for (int NodeIndex = 0; NodeIndex < Length1 / 2 - 1; 
					NodeIndex++) {
				// 创建左结点
				list1.get(NodeIndex).LeftNode = list1.get(
						2 * NodeIndex + 1);
				// 创建右结点
				list1.get(NodeIndex).RightNode = list1.get(
						2 * NodeIndex + 2);
			}
			// 因为最后一个父结点可能没有右结点，所以特殊处理
			int LastNodeIndex = Length1 / 2 - 1;
			list1.get(LastNodeIndex).LeftNode = list1.get(
					2 * LastNodeIndex + 1);
			// 当树的结点数为奇数时，有右结点
			if (Length1 % 2 == 1) {
				list1.get(LastNodeIndex).RightNode = list1.get(
						2 * LastNodeIndex + 2);
			}
		}else if(TreeNumber==2){
			Root2=list2.get(0);
			for (int NodeIndex = 0; NodeIndex < Length2 / 2 - 1; 
					NodeIndex++) {
				// 创建左结点
				list2.get(NodeIndex).LeftNode = list2.get(
						2 * NodeIndex + 1);
				// 创建右结点
				list2.get(NodeIndex).RightNode = list2.get(
						2 * NodeIndex + 2);
			}
			// 因为最后一个父结点可能没有右结点，所以特殊处理
			int LastNodeIndex = Length2 / 2 - 1;
			list2.get(LastNodeIndex).LeftNode = list2.get(
					2 * LastNodeIndex + 1);
			// 当树的结点数为奇数时，有右结点
			if (Length2 % 2 == 1) {
				list2.get(LastNodeIndex).RightNode = list2.get(
						2 * LastNodeIndex + 2);
			}
		}else {
			System.out.println("we do not have this tree.");
		}
	}
    public static Node BuildTree() {
    	
    }
	public static boolean IsSameTree() {
		boolean flag=false;
		for(int i=0;i<Length1;i++) {
			
		}
		return flag;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
