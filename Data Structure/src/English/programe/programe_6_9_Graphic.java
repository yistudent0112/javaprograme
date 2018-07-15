package English.programe;

import java.util.ArrayList;
import java.util.List;

public class programe_6_9_Graphic {
	// 存放节点的容器
	private List<programe_6_9_Node> NodeList = new ArrayList<programe_6_9_Node>();
	// 已插入的节点数
	private int InputNodeNumber = 0;
	// 已插入的边数
	private int InputArcNumber = 0;

	/**
	 * 
	 * @Title: AddNode @Description: TODO(向NodeList中添加节点) @param @param NodeValue
	 * 参数 @return void 返回类型 @throws
	 */
	public void AddNode(String NodeValue) {
		programe_6_9_Node TempNode = new programe_6_9_Node();
		TempNode.setNodeValue(NodeValue);
		TempNode.setNodeIndex(InputNodeNumber);
		NodeList.add(TempNode);
		InputNodeNumber++;
	}

	/**
	 * 
	 * @Title: AddArc @Description: TODO(通过边的起始节点值来添加边信息) @param @param
	 * StartNodeValue @param @param EndNodeValue @param @param
	 * ArcValue @param @param weight 参数 @return void 返回类型 @throws
	 */
	public void AddArc(String StartNodeValue, String EndNodeValue, String ArcValue, int weight) {
		int EndNodeIndex = GetNodeIndexByValue(EndNodeValue);
		if (EndNodeIndex != -1) {
			programe_6_9_Arc TempArc = new programe_6_9_Arc();
			TempArc.setArcValue(ArcValue);
			TempArc.setWeight(weight);
			TempArc.setEndNodeIndex(EndNodeIndex);
			int StartNodeIndex = GetNodeIndexByValue(StartNodeValue);
			if (StartNodeIndex != -1) {
				TempArc.setNextArc(NodeList.get(StartNodeIndex).getFirstArc());
				NodeList.get(StartNodeIndex).setFirstArc(TempArc);
				InputArcNumber++;
			} else {
				System.out.println("还未创建弧头节点，无法创建边");
			}
		} else {
			System.out.println("还未创建弧尾节点，无法创建边");
		}
	}

	/**
	 * 
	 * @Title: GetNodeIndexByValue @Description: TODO(通过节点的信息来获取节点的下标) @param @param
	 * value @param @return 参数 @return int 返回类型 @throws
	 */
	public int GetNodeIndexByValue(String value) {
		int index = -1;
		for (int i = 0; i < NodeList.size(); i++) {
			if (value.equals(NodeList.get(i).getNodeValue())) {
				index = i;
			}
		}
		return index;
	}

	public int GetFirstNeighbour(String value) {
		int index = -1;
		int Index = GetNodeIndexByValue(value);
		if (Index != -1) {
			programe_6_9_Arc TempArc = NodeList.get(Index).getFirstArc();
			index = TempArc.getEndNodeIndex();
		}
		return index;
	}

	/**
	 * 
	 * @Title: Print @Description: TODO(打印出所有的邻接表中的信息) @param 参数 @return void
	 * 返回类型 @throws
	 */
	public void Print() {
		for (programe_6_9_Node temp : NodeList) {
			System.out.println(temp.getNodeIndex() + " : " + temp.getNodeValue());
			programe_6_9_Arc TempArc = temp.getFirstArc();

			while (TempArc != null) {
				System.out.println(TempArc.getArcValue() + " : " + TempArc.getWeight());
				TempArc = TempArc.getNextArc();
			}
		}
	}

	/**
	 * 
	 * @Title: ResetNode @Description: TODO(重置所有节点的被访问过信息为无) @param 参数 @return void
	 * 返回类型 @throws
	 */
	public void ResetNode() {
		for (int i = 0; i < NodeList.size(); i++) {
			NodeList.get(i).setIsVisited(false);
		}
	}

	public void DepthFirstTraverse(int NodeIndex) {
		System.out.println(NodeList.get(NodeIndex).getNodeValue());
		NodeList.get(NodeIndex).setIsVisited(true);
		programe_6_9_Arc TempArc = NodeList.get(NodeIndex).getFirstArc();
		while (TempArc != null) {
			if (!NodeList.get(TempArc.getEndNodeIndex()).isIsVisited()) {
				DepthFirstTraverse(TempArc.getEndNodeIndex());
			}
			TempArc = TempArc.getNextArc();

		}

	}

	public void BreadthFirstTraverse(int NodeIndex) {
		System.out.println(NodeList.get(NodeIndex).getNodeValue());
		NodeList.get(NodeIndex).setIsVisited(true);
		List<programe_6_9_Node> CurrentNodeList = new ArrayList<programe_6_9_Node>();
		CurrentNodeList.add(NodeList.get(NodeIndex));
		BreadthFirstTraverseImpl(CurrentNodeList);
	}

	public void BreadthFirstTraverseImpl(List<programe_6_9_Node> PreNodeList) {
		List<programe_6_9_Node> CurrentNodeList = new ArrayList<programe_6_9_Node>();
		for (int i = 0; i < PreNodeList.size(); i++) {
			programe_6_9_Arc TempArc = PreNodeList.get(i).getFirstArc();
			while (TempArc != null) {
				if (!NodeList.get(TempArc.getEndNodeIndex()).isIsVisited()) {
					CurrentNodeList.add(NodeList.get(TempArc.getEndNodeIndex()));
					NodeList.get(TempArc.getEndNodeIndex()).setIsVisited(true);
					//System.out.println(TempArc.getArcValue() + " : " + TempArc.getWeight());
				System.out.println(NodeList.get(TempArc.getEndNodeIndex()).getNodeValue());
				}
				TempArc = TempArc.getNextArc();
			}
		}
		if (CurrentNodeList.size() == 0) {
			return;
		} else {
			BreadthFirstTraverseImpl(CurrentNodeList);
		}
	}

	public static void test() {
		programe_6_9_Graphic test = new programe_6_9_Graphic();
		/*
		 * test.AddNode("A"); test.AddNode("B"); test.AddNode("C"); test.AddNode("D");
		 * test.AddArc("A", "B", "A-B", 1); test.AddArc("A", "C", "A-C", 2);
		 * test.AddArc("C", "D", "C-D", 3); test.AddArc("D", "A", "D-A", 4);
		 * test.AddArc("A", "D", "A-D", 5);
		 */
		test.AddNode("A");
		test.AddNode("B");
		test.AddNode("C");
		test.AddNode("D");
		test.AddNode("E");
		test.AddNode("F");
		test.AddNode("G");
		test.AddNode("H");
		test.AddArc("A", "B", "A-B", 1);
		test.AddArc("A", "C", "A-C", 2);
		test.AddArc("B", "D", "B-D", 3);
		test.AddArc("B", "E", "B-E", 4);
		test.AddArc("C", "F", "C-F", 5);
		test.AddArc("C", "G", "C-G", 6);
		test.AddArc("D", "H", "D-H", 7);
		test.AddArc("E", "H", "E-H", 8);
		test.AddArc("F", "G", "F-G", 9);
		test.Print();
		test.BreadthFirstTraverse(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();

	}

}
