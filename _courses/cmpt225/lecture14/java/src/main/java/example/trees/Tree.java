package example.trees;

public class Tree<T> {
	private Node<T> root;
	
	public Tree(Node<T> root) {
		this.root = root;
	}
	
	public Node<T> getRoot() {
		return root;
	}
}
