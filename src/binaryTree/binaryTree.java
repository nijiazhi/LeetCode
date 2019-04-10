package binaryTree;

public class binaryTree {
	
	int data;
	binaryTree left;
	binaryTree right;
	
	public binaryTree(int data){
		this.data = data;
		left = null;
		right = null;
	}
	
	public void insert(binaryTree root, int data){
		if(data > root.data){//right
			if(root.right == null){
				root.right = new binaryTree(data);
			}else{
				this.insert(root.right, data);
			}
		}else{//left
			if(root.left == null){
				root.left = new binaryTree(data);
			}else{
				this.insert(root.left, data);
			}
		}
	}//end insert
	
}//end class
