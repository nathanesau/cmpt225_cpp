// java -jar target/example-1.0-SNAPSHOT.jar
package example;

import java.util.Arrays;
import java.util.ArrayList;

import example.binarytrees.BinaryTree;
import example.binarytrees.BTNode;

public class App {

	public static BinaryTree<Integer> createTree() {
		// creating the tree
		//       5
		//      / \
		//     2   6
		//    / \   \
		//   1   4   8
		BTNode<Integer> node8 = new BTNode<Integer>(8);
		BTNode<Integer> node6 = new BTNode<Integer>(6, null, node8, null);

		BTNode<Integer> node1 = new BTNode<Integer>(1);
		BTNode<Integer> node4 = new BTNode<Integer>(4);
		BTNode<Integer> node2 = new BTNode<Integer>(2, node1, node4, null);

		BTNode<Integer> node5 = new BTNode<Integer>(5, node2, node6, null);

		return new BinaryTree<Integer>(node5);
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = createTree();
		System.out.println("Printing prePrder: ");
		tree.printPreOrder();

		System.out.println("Print inOrder: ");
		tree.printInOrder();

		System.out.println("Print postOrder: ");
		tree.printPostOrder();
		
		System.out.println("Inorder: ");
		ArrayList<BTNode<Integer>> inOrderList = tree.inOrder();
		inOrderList.iterator().forEachRemaining(node -> System.out.print(node.getData() + " "));
		System.out.println();

		System.out.println("Preorder: ");
		ArrayList<BTNode<Integer>> preOrderList = tree.preOrder();
		preOrderList.iterator().forEachRemaining(node -> System.out.print(node.getData() + " "));
		System.out.println();

		System.out.println("Postorder: ");
		ArrayList<BTNode<Integer>> postOrderList = tree.postOrder();
		postOrderList.iterator().forEachRemaining(node -> System.out.print(node.getData() + " "));
		System.out.println();


		System.out.println("PreOrder iterative: ");
		ArrayList<BTNode<Integer>> preOrderIterList = tree.preOrderIterative();
		preOrderIterList.iterator().forEachRemaining(node -> System.out.print(node.getData() + " "));
		System.out.println();


		System.out.println("BFS: ");
		ArrayList<BTNode<Integer>> BFSList = tree.BFS();
		BFSList.iterator().forEachRemaining(node -> System.out.print(node.getData() + " "));
		System.out.println();

		System.out.println("print BFS layer by layer: ");
		tree.printBFSseparated();

	}
	
}
