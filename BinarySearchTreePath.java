import java.util.*;

public class BinarySearchTreePath {

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(7);

		List<Node> path = findPath(root, 1, 7);
		for (int i = 0; i < path.size(); i++) {
			System.out.println(path.get(i).val);
		}
	}

	private static List<Node> findPath(Node head, int x, int y) {
		List<Node> path = new ArrayList<Node>();
		Node ancestor = findCommonAncestor(head, x, y);
		if (ancestor == null) {
			return null;
		}
		System.out.println("ancestor = " + ancestor.val);

		List<Node> pathX = findShortestPath(ancestor, x);
		List<Node> pathY = findShortestPath(ancestor, y);
		if (pathX.size() == 0 || pathY.size() == 0) {
			return path;
		} else {
			// Remove the duplicate ancestor
			pathX.remove(0);
			if (x <= y) {
				Collections.reverse(pathX);
				path.addAll(pathX);
				path.addAll(pathY);
			} else {
				Collections.reverse(pathY);
				path.addAll(pathY);
				path.addAll(pathX);
			}
		}

		return path;
	}

	private static List<Node> findShortestPath(Node head, int value) {
		List<Node> path = new ArrayList<Node>();
		while (head != null) {
			path.add(head);
			if (head.val < value) {
				head = head.right;
			} else if (head.val > value) {
				head = head.left;
			} else {
				return path;
			}
		}
		path.clear();
		return path;
	}

	private static Node findCommonAncestor(Node head, int value1, int value2) {
		while (head != null) {
			if (head.val < value1 && head.val < value2) {
				head = head.right;
			} else if (head.val > value1 && head.val > value2) {
				head = head.left;
			} else {
				return head;
			}
		}

		return head;
	}

	private static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}
	}
}
