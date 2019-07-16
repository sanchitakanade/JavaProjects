/*
 * Name: Sanchita Kanade
 * Class: CS310
 */
import java.util.ArrayList;
import java.util.List;

public class BST {
	public class Node {
		public final int data;
		public Node left;
		public Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node root;
	private int currSize;

	public BST() {
		root = null;
		currSize = 0;
	}

	public List<Integer> inOrder() {
		if (root == null) {
			return null;
		}
		ArrayList<Integer> list = new ArrayList<>();
		fillArrayList(root, list);
		return list;

	}
	private void fillArrayList(Node n, List<Integer> list) {
		if(n == null) {
			return;
		}
		fillArrayList(n.left, list);
		list.add(n.data);
		fillArrayList(n.right,list);
	}


	public boolean add (int data) {
		if(root == null) {
			root = new Node(data);
		} else {
			insert(data, root,null, false);
		}
		currSize++;
		return true;
	}

	private void insert(int data, Node n, Node parent, boolean wasleft) {
		if(n == null) {
			if(wasleft) {
				parent.left = new Node(data);
			}else {
				parent.right = new Node(data);
			}
		}else if (data < n.data) {
			insert(data,n.left,n,true);
		}else {
			insert(data, n.right, n, false);
		}
	}

	public int height(int data) {
		if (root == null) {
			return 0;
		}
		Node current = root;
		while (current != null) {
			if (data < current.data) {
				current = current.left;
			} else if (data > current.data) {
				current = current.right;
			} else return height(current);
		}
		return 0;
	}

	public static int height(Node root) {
		if(root == null) {
			return -1;
		}
		return 1+ Math.max(height(root.left),height(root.right));
	}
}
