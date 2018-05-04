package English.programe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class programe_6_7_node {
	private static class Node {
		int LeftIndex;
		int RightIndex;
		String Value;

		public Node(String value, int left, int right) {
			Value = value;
			LeftIndex = left;
			RightIndex = right;
		}

	}

	private static List<Node> list1 = new ArrayList<Node>();
	private static List<Node> list2 = new ArrayList<Node>();
	private static int Root1;
	private static int Root2;
	private static int Length1;
	private static int Length2;

	/**
	 * 
	 * @Title: FindRoot @Description: TODO(�ҵ����ڸ��������ĸ��ڵ�) @param @param listnumber
	 *         ���� @return void �������� @throws
	 */
	public static void FindRoot(int listnumber) {
		if (listnumber == 1) {
			int[] temp = new int[list1.size()];
			for (Node t : list1) {
				if (t.LeftIndex >= 0) {
					temp[t.LeftIndex] = 1;
				}
				if (t.RightIndex >= 0) {
					temp[t.RightIndex] = 1;
				}
			}
			for (int i = 0; i < Length1; i++) {
				if (temp[i] == 0) {
					Root1 = i;
					break;
				}
			}
		}
		if (listnumber == 2) {
			int[] temp = new int[list1.size()];
			for (Node t : list2) {
				if (t.LeftIndex >= 0) {
					temp[t.LeftIndex] = 1;
				}
				if (t.RightIndex >= 0) {
					temp[t.RightIndex] = 1;
				}
			}
			for (int i = 0; i < Length2; i++) {
				if (temp[i] == 0) {
					Root2 = i;
					break;
				}
			}
		}
	}
/**
 * 
    * @Title: CreateTree  
    * @Description: TODO(��ȡ�����������ݣ�������������)  
    * @param     ����  
    * @return void    ��������  
    * @throws
 */
	public static void CreateTree() {
		Scanner in = new Scanner(System.in);
		System.out.println("�������һ�����Ĵ�С��");
		Length1 = in.nextInt();
		System.out.println("�뿪ʼ�����һ�����Ľڵ�ֵ");
		for (int i = 0; i < Length1; i++) {
			String value = in.next();
			String left1 = in.next();
			String right1 = in.next();
			int left;
			int right;
			if (left1.equals("-")) {
				left = -1;
			} else {
				left = Integer.valueOf(left1);
			}
			if (right1.equals("-")) {
				right = -1;
			} else {
				right = Integer.valueOf(right1);
			}
			Node node = new Node(value, left, right);
			list1.add(node);
		}
		FindRoot(1);
		System.out.println("������ڶ������Ĵ�С��");
		Length2 = in.nextInt();
		System.out.println("�뿪ʼ����ڶ������Ľڵ�ֵ");
		for (int i = 0; i < Length2; i++) {
			String value = in.next();
			String left1 = in.next();
			String right1 = in.next();
			int left;
			int right;
			if (left1.equals("-")) {
				left = -1;
			} else {
				left = Integer.valueOf(left1);
			}
			if (right1.equals("-")) {
				right = -1;
			} else {
				right = Integer.valueOf(right1);
			}
			Node node = new Node(value, left, right);
			list2.add(node);
		}
		FindRoot(2);

		in.close();
	}
	/**
	 * 
	    * @Title: Isomorphic  
	    * @Description: TODO(�����������ĸ��ڵ㣬�Ƚ��������Ƿ�ͬ��)  
	    * @param @param Root1
	    * @param @param Root2
	    * @param @return    ����  
	    * @return boolean    ��������  
	    * @throws
	 */
    public static boolean Isomorphic(int Root1,int Root2) {
    	if(Root1==-1&&Root2==-1) {
    		return true;
    	}
    	if((Root1==-1&&Root2!=-1)||(Root1!=-1&&Root2==-1)){
    		return false;
    	}
    	if(!list1.get(Root1).Value.equals(list2.get(Root2).Value)) {
    		return false;
    	}
    	//�����һ����������������Ϊ�գ���ֻ�ñȽ�������
    	if((list1.get(Root1).LeftIndex==-1)&&(list2.get(Root2).LeftIndex==-1)) {
    		return Isomorphic(list1.get(Root1).RightIndex, list2.get(Root2).RightIndex);
    	}
    	//�����һ������������������Ϊ����ֵ��ȣ���Ƚ�������
    	if((list1.get(Root1).LeftIndex!=-1)&&(list2.get(Root2).LeftIndex!=-1)&&
    			(list1.get(list1.get(Root1).LeftIndex).Value.equals(list2.get(list2.get(Root2).LeftIndex).Value))) {
    		return Isomorphic(list1.get(Root1).RightIndex, list2.get(Root2).RightIndex);
    	}
    	//ʣ��������򽻻���һ�����������ҽڵ㣬�����бȽ�
    	else {
    		return Isomorphic(list1.get(Root1).RightIndex, list2.get(Root2).LeftIndex)&&
    				Isomorphic(list1.get(Root1).LeftIndex, list2.get(Root2).RightIndex);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateTree();
		System.out.println("Root1 : " + Root1 + " Root2 : " + Root2);
		System.out.println(Isomorphic(Root1, Root2));
	}

}
