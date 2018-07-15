
    
package English.programe;

  
    /**  
    * @ClassName: programe_6_9_Node  
    * @Description: TODO(邻接表实现图的节点类)  
    * @author yi  
    * @date 2018年7月8日  
    *    
    */

public class programe_6_9_Node {

private int NodeIndex;
private String NodeValue;
private programe_6_9_Arc FirstArc;
private boolean IsVisited=false;
	public boolean isIsVisited() {
	return IsVisited;
}

public void setIsVisited(boolean isVisited) {
	IsVisited = isVisited;
}

	public programe_6_9_Arc getFirstArc() {
	return FirstArc;
}

public void setFirstArc(programe_6_9_Arc firstArc) {
	FirstArc = firstArc;
}

	public int getNodeIndex() {
	return NodeIndex;
}

public void setNodeIndex(int nodeIndex) {
	NodeIndex = nodeIndex;
}

public String getNodeValue() {
	return NodeValue;
}

public void setNodeValue(String nodeValue) {
	NodeValue = nodeValue;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
