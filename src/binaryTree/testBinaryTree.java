package binaryTree;

public class testBinaryTree {
	
	public static void preOrder(binaryTree root){
		if(root == null){
//			System.out.println("tree empty!");
		}else{
			System.out.print(root.data+"-");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public static void inOrder(binaryTree root){
		if(root == null){
//			System.out.println("tree empty");
		}else{
			inOrder(root.left);
			System.out.print(root.data+"-");
			inOrder(root.right);
		}
	}
	
	public static void postOrder(binaryTree root){
		if(root != null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+"-");
		}
	}
	
	
	public static void main(String[] args){
		int[] a = {12,76,35,22,16,48,90,46,9,40};
		binaryTree root = new binaryTree(a[0]);
		for(int i=1; i<a.length; i++){
			root.insert(root, a[i]);
		}
		
		System.out.println("preOrder");
		preOrder(root);
		
		System.out.println("\ninOrder");
		inOrder(root);

		System.out.println("\npostOrder");
		postOrder(root);
	}
}
