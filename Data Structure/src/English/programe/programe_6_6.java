package English.programe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @ClassName: programe_6_6
 * @Description: TODO( Write a routine to list out the nodes of a binary tree in
 *               "level-order". List the root, then nodes at depth 1, followed
 *               by nodes at depth 2, and so on. You must do this in linear
 *               time.)
 * @author yi
 * @date 2018年4月19日
 *
 */
public class programe_6_6 {
	private static List<Node> list = new ArrayList<Node>();
	private static int[] temp = new int[100];
	private static int length = 0;
	private static Queue<Node>queue=new LinkedList<Node>();
	public static void Input() {
		Scanner in = new Scanner(System.in);
		length = in.nextInt();
		for (int i = 0; i < length; i++) {
			temp[i] = in.nextInt();
		}
		in.close();
	}

	/**
	 * 
	 * @ClassName: Node
	 * @Description: TODO(节点类，内部类)
	 * @author yi
	 * @date 2018年4月19日
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

	public static void CreateTree() {
		for (int i = 0; i < length; i++) {
			list.add(new Node(temp[i]));
		}
		for (int NodeIndex = 0; NodeIndex < length / 2 - 1; NodeIndex++) {
			// 创建左结点
			list.get(NodeIndex).LeftNode = list.get(2 * NodeIndex + 1);
			// 创建右结点
			list.get(NodeIndex).RightNode = list.get(2 * NodeIndex + 2);
		}
		// 因为最后一个父结点可能没有右结点，所以特殊处理
		int LastNodeIndex = length / 2 - 1;
		list.get(LastNodeIndex).LeftNode = list.get(2 * LastNodeIndex + 1);
		// 当树的结点数为奇数时，有右结点
		if (length % 2 == 1) {
			list.get(LastNodeIndex).RightNode = list.get(2 * LastNodeIndex + 2);
		}
	}
	//层序遍历
	public static void LevelOrder(){
		//先把跟节点加入到队列中
	     queue.add(list.get(0));
	     while(!queue.isEmpty()){
	    	 Node currentNode=queue.poll();
	    	 System.out.println(currentNode.Data);
	    	 //当前节点有左孩子时，左孩子入队列
	    	 if(currentNode.LeftNode!=null){
	    		 //System.out.println("left");
	    		 queue.add(currentNode.LeftNode);
	    	 }
	    	 //当前节点有右孩子时，右孩子入队列
	    	 if(currentNode.RightNode!=null){
	    		 //System.out.println("right");
	    		 queue.add(currentNode.RightNode);
	    	 }
	    	 
	     }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
