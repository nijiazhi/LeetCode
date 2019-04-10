package Tree;

import java.awt.print.Printable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreeNode implements Serializable {
	private int parentID;
	private int selfID;
	protected String nodeName;
	protected Object obj;
	protected TreeNode parentNode;
	protected List<TreeNode> childList;
	
	public TreeNode() {
		initChildList();
	}
	
	public TreeNode(TreeNode parentNode) {
		initChildList();
	}
	
	//init childrenList
	private void initChildList() {
		if(childList == null){
			childList = new ArrayList<TreeNode>();
		}
	}
	
	//insertChild
	public void addChildNode(TreeNode treeNode){
		initChildList();
		childList.add(treeNode);
	}
	
	public List<TreeNode> getChildlList(){
		return childList;
	}
	
	//get parent
	public TreeNode getParentNode(){
		return this.parentNode;
	}
		
	public boolean isValidTree(){
		return true;
	}
	
	//get parents nodesList
	public List<TreeNode> getElders(){
		List<TreeNode> elderList = new ArrayList<TreeNode>();
		TreeNode parentNode = this.getParentNode();
		if(parentNode == null){
			return elderList;
		}else{
			elderList.add(parentNode);
			elderList.addAll(parentNode.getElders());
			return elderList;
		}
	}
	
	//get juniorList
	public List<TreeNode> getJuniors(){
		List<TreeNode> juniorList = new ArrayList<TreeNode>();
		List<TreeNode> childList = this.getChildlList();
		if(childList == null){
			return juniorList;
		}else{
			for(int i=0; i<childList.size(); i++){
				TreeNode junior = childList.get(i);
				juniorList.add(junior);
				juniorList.addAll(junior.getJuniors());
			}
			return juniorList;
		}
	}
	
	public int getSelfID() {
		return selfID;
	}

	public void setSelfID(int selfID) {
		this.selfID = selfID;
	}

	//delete selfNode and its juniors
	public void deleteNode(){
		TreeNode parentNode = this.getParentNode();
		if(parentNode != null){
			deleteChildNode(parentNode.getSelfID());
		}
	}
	
	/*delete the child of current node*/
	public void deleteChildNode(int childID){
		List<TreeNode> childList = this.getChildlList();
		for (int i=0; i<childList.size(); i++){
			TreeNode child = childList.get(i);
			if(child.getSelfID() == childID){
				childList.remove(i);
				return ;
			}
		}
	}
	
	/*insert junior to the tree(by the current node)*/
	public boolean insertJuniorNode(TreeNode insertNode){
		int juniorParentID = insertNode.getParentNode().getSelfID();
		if(juniorParentID == this.parentID){
			addChildNode(insertNode);
			return true;
		}else{
			List<TreeNode> childList = this.getChildlList();
			boolean insertFlag = false;
			for (TreeNode tmpNode : childList){
				insertFlag = tmpNode.insertJuniorNode(insertNode);;
				if(insertFlag)
					return true;
			}
		}
		return false;
	}
	
	//search one node
	public TreeNode findTreeNodeById(int id){
		if(this.selfID == id)
			return this;
		if(this.childList == null || this.childList.isEmpty() )
			return null;
		for(TreeNode tmp : this.childList){
			TreeNode result = tmp.findTreeNodeById(id);
			if(result != null)
				return result;
		}
		return null;
	}
	
	//traverse---dfs
	public void traverse(){
		if(this.selfID < 0)
			return;
		print(this.selfID);
		if(this.childList == null || this.childList.isEmpty())
			return;
		for(TreeNode child : this.childList){
			child.traverse();
		}
	}
	
	public void print(int str){
		System.out.println(str);
	}
	
	
}//end class
