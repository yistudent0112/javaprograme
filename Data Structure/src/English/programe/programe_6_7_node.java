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
	 * @Title: FindRoot @Description: TODO(找到对于给定的数的根节点) @param @param listnumber
	 *         参数 @return void 返回类型 @throws
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
    * @Description: TODO(读取两棵树的数据，并创建两棵树)  
    * @param     参数  
    * @return void    返回类型  
    * @throws
 */
	public static void CreateTree() {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入第一个树的大小：");
		Length1 = in.nextInt();
		System.out.println("请开始输入第一棵树的节点值");
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
		System.out.println("请输入第二个树的大小：");
		Length2 = in.nextInt();
		System.out.println("请开始输入第二棵树的节点值");
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
	    * @Description: TODO(传入两棵树的根节点，比较两棵树是否同构)  
	    * @param @param Root1
	    * @param @param Root2
	    * @param @return    参数  
	    * @return boolean    返回类型  
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
    	//如果树一和树二的左子树都为空，则只用比较右子树
    	if((list1.get(Root1).LeftIndex==-1)&&(list2.get(Root2).LeftIndex==-1)) {
    		return Isomorphic(list1.get(Root1).RightIndex, list2.get(Root2).RightIndex);
    	}
    	//如果树一和树二的左子树都不为空且值相等，则比较右子树
    	if((list1.get(Root1).LeftIndex!=-1)&&(list2.get(Root2).LeftIndex!=-1)&&
    			(list1.get(list1.get(Root1).LeftIndex).Value.equals(list2.get(list2.get(Root2).LeftIndex).Value))) {
    		return Isomorphic(list1.get(Root1).RightIndex, list2.get(Root2).RightIndex);
    	}
    	//剩余情况，则交换树一和树二的左右节点，并进行比较
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
