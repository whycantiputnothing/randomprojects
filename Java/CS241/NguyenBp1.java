import java.util.Scanner;

public class NguyenBp1	{
	
	public static void main(String[] args) {
		NguyenBp1 b = new NguyenBp1();
		BinaryTree bt = b.new BinaryTree();
		
		Scanner in = new Scanner(System.in);
		
		String input = "";
		String test = "";
		int data = 0;
		Node node = null;
		System.out.println("Program Start");
		while(true) {
			input = in.nextLine();
			test = input.substring(0, 1);
			if (test.equals("A") || test.equals("D"))
				if( input.length() > 2) {
					try {
						data = Integer.parseInt(input.substring(2));						
					}	catch (NumberFormatException nfe) {
						test = "Z";
					}
				}
				else
					test = "Z";
			switch (test) {
			case "A" :
				node = bt.add(data);
				if (node != null) {
					System.out.println("The entry already exists");
				}
				else
					System.out.println("Entry has been added");
				break;
			case "P" :
				bt.print();
				break;
			case "D" :
				node = bt.delete(data);
				if (node.data != data){
					System.out.println("The entry does not exist");
				}
				else
					System.out.println("Entry has been deleted");
				break;
			case "Q" :
				in.close();
				System.out.println("Program End");
				System.exit(0);
			default:
				System.out.println("Invalid Entry");
				break;
			}

		}
		
		
	}
	
	/**
	 * Nodes used to construct binary tree
	 *
	 */
	public class Node	{
		Node left;
		Node right;
		int data;
		
		public Node(){	
			left = null;
			right = null;
			data = 0;
		}
		
		public Node(int num){
			this(num,null,null);
		}
		
		public Node(int num, Node leftChild, Node rightChild){
			data = num;
			left = leftChild;
			right = rightChild;
			
		}
		
		public boolean isLeaf(){
			return (left == null) && (right == null);
		}
	}
	
	/**
	 * consists of nodes
	 *
	 */
	public class BinaryTree {
		Node root;
		public BinaryTree(){
			root = null;
		}
		
		public boolean isEmpty(){
			return root == null;
		}
		
		/**
		 * @param data: integer to be added to binary tree
		 * @return null if the addition was successful, the node of same data if it already exists
		 */
		public Node add(int data){
			Node result = null;
			
			if (isEmpty())
				root = new Node(data);
			
			else
				result = insert(root,data);
			
			return result;
		}
		
		/**
		 * recursively inserts a node
		 */
		private Node insert(Node node, int data){
			Node result = null;
			
			if (node.data == data){
				result = node;
			}
			
			else if (data < node.data) {
				if (node.left != null)
					result = insert(node.left, data);
				else
					node.left = new Node(data);
			}
			
			else {
				if(node.right != null)
					result = insert(node.right, data);
				else
					node.right = new Node(data);
			}

			
			
			return result;
		}
		
		/**
		 * @param entry: integer to be deleted from tree
		 * @return node with same data integer as entry if sucessful 
		 */
		public Node delete(int entry){
			Node old = new Node();
			root = removeEntry(root, entry, old);
			return old;
			
		}
		
		private Node removeEntry(Node root, int entry, Node old){
			if (root != null) {
				if (root.data == entry){
					old.data = root.data;
					root = removeFromRoot(root);
				}
				
				else if(entry < root.data){
					Node leftChild = root.left;
					Node subtreeRoot = removeEntry(leftChild, entry, old);
					root.left = subtreeRoot;
				}
				
				else {
					Node rightChild = root.right;
					root.right = removeEntry(rightChild, entry, old);
				}
				
			}
			return root;
		}

		private Node removeFromRoot(Node root) {
			if (root.left != null && root.right != null) {
				Node leftSubtreeRoot = root.left;
				Node largestNode = findLargest(leftSubtreeRoot);
				
				root.data = largestNode.data;
				root.left = removeLargest(leftSubtreeRoot);
			}
			
			else if(root.right != null) {
				root = root.right;
			}
			
			else
				root = root.left;
			
			return root;
		}

		private Node removeLargest(Node root) {
			if (root.right != null) {
				Node rightChild = root.right;
				Node tRoot = removeLargest(rightChild);
				root.right = tRoot;
			}
			
			else
				root = root.left;
			
			return root;
		}

		private Node findLargest(Node leftSubtreeRoot) {
			if (leftSubtreeRoot.right != null) {
				leftSubtreeRoot = findLargest(leftSubtreeRoot.right);
			}
			
			return leftSubtreeRoot;
		}
		
		private void PreOrder(Node root){
			if(root != null){
				System.out.print(root.data + " ");
				PreOrder(root.left);
				PreOrder(root.right);
			}
		}
		
		private void InOrder(Node root) {
			if(root != null) {
				InOrder(root.left);
				System.out.print(root.data + " ");
				InOrder(root.right);
			}
		}
		
		private void PostOrder(Node root) {
			if(root != null) {
				PostOrder(root.left);
				PostOrder(root.right);
				System.out.print(root.data + " ");
			}
		}
		
		/**
		 * used to display preorder inorder and postorder traversals
		 */
		public void print(){
			System.out.println("PreOrder:");
			PreOrder(root);
			System.out.println("\nInOrder:");
			InOrder(root);
			System.out.println("\nPostOrder");
			PostOrder(root);
			System.out.println();
			
		}
		
	}
	
	
}
