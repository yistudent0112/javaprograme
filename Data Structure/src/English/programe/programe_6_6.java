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
 * @date 2018��4��19��
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
	 * @Description: TODO(�ڵ��࣬�ڲ���)
	 * @author yi
	 * @date 2018��4��19��
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
			// ��������
			list.get(NodeIndex).LeftNode = list.get(2 * NodeIndex + 1);
			// �����ҽ��
			list.get(NodeIndex).RightNode = list.get(2 * NodeIndex + 2);
		}
		// ��Ϊ���һ����������û���ҽ�㣬�������⴦��
		int LastNodeIndex = length / 2 - 1;
		list.get(LastNodeIndex).LeftNode = list.get(2 * LastNodeIndex + 1);
		// �����Ľ����Ϊ����ʱ�����ҽ��
		if (length % 2 == 1) {
			list.get(LastNodeIndex).RightNode = list.get(2 * LastNodeIndex + 2);
		}
	}
	//�������
	public static void LevelOrder(){
		//�ȰѸ��ڵ���뵽������
	     queue.add(list.get(0));
	     while(!queue.isEmpty()){
	    	 Node currentNode=queue.poll();
	    	 System.out.println(currentNode.Data);
	    	 //��ǰ�ڵ�������ʱ�����������
	    	 if(currentNode.LeftNode!=null){
	    		 //System.out.println("left");
	    		 queue.add(currentNode.LeftNode);
	    	 }
	    	 //��ǰ�ڵ����Һ���ʱ���Һ��������
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
