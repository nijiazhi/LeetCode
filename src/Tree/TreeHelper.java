package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeHelper {
	private TreeNode root;
	private List<TreeNode> tempNodeList;
	private boolean isValidTree = true;
	
	public TreeHelper(){}
	
	public TreeHelper(List<TreeNode> tempNodeList){
		this.tempNodeList = tempNodeList;
		generateTree();
	}
	
	private void generateTree() {
		HashMap nodeMap = putNodesIntoMap();
		putChildIntoParent(nodeMap);
	}

	private void putChildIntoParent(HashMap<String,TreeNode> nodeMap) {
		for(Map.Entry<String,TreeNode> tmp : nodeMap.entrySet()){
			TreeNode node = tmp.getValue();
			int parentID = node.getParentNode().getSelfID();
			String key_parentID = String.valueOf(parentID);
			if(nodeMap.containsKey(key_parentID)){
				TreeNode parenetNode = nodeMap.get(key_parentID);
				parenetNode.addChildNode(node);
			}
		}
	}

	private HashMap putNodesIntoMap() {
		int maxID = Integer.MAX_VALUE;
		HashMap nodeMap = new HashMap<String,TreeNode>();
		for (TreeNode node : this.tempNodeList){
			int id = node.getSelfID();
			if(id < maxID){
				maxID = id;
				this.root = node;
			}
			String keyID = String.valueOf(id);
			nodeMap.put(keyID, node);
		}
		return nodeMap;
	}
	
	public static void main(String[] args){
		List<TreeNode> tempNodeList = new ArrayList<TreeNode>();
		TreeHelper tree = new TreeHelper(tempNodeList);
	}
}
