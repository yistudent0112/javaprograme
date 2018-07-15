package English.programe;

import java.util.ArrayList;
import java.util.List;

public class programe_6_9_Graphic {
	// ��Žڵ������
	private List<programe_6_9_Node> NodeList = new ArrayList<programe_6_9_Node>();
	// �Ѳ���Ľڵ���
	private int InputNodeNumber = 0;
	// �Ѳ���ı���
	private int InputArcNumber = 0;

	/**
	 * 
	 * @Title: AddNode @Description: TODO(��NodeList����ӽڵ�) @param @param NodeValue
	 * ���� @return void �������� @throws
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
	 * @Title: AddArc @Description: TODO(ͨ���ߵ���ʼ�ڵ�ֵ����ӱ���Ϣ) @param @param
	 * StartNodeValue @param @param EndNodeValue @param @param
	 * ArcValue @param @param weight ���� @return void �������� @throws
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
				System.out.println("��δ������ͷ�ڵ㣬�޷�������");
			}
		} else {
			System.out.println("��δ������β�ڵ㣬�޷�������");
		}
	}

	/**
	 * 
	 * @Title: GetNodeIndexByValue @Description: TODO(ͨ���ڵ����Ϣ����ȡ�ڵ���±�) @param @param
	 * value @param @return ���� @return int �������� @throws
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
	 * @Title: Print @Description: TODO(��ӡ�����е��ڽӱ��е���Ϣ) @param ���� @return void
	 * �������� @throws
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
	 * @Title: ResetNode @Description: TODO(�������нڵ�ı����ʹ���ϢΪ��) @param ���� @return void
	 * �������� @throws
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
