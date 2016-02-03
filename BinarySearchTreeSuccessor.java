public class BinarySearchTreeSuccessor {

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(7);

		for (int i = 0; i < 8; i++) {
			System.out.println("target = " + i);
			System.out.println("successor = " + getSuccessor(root, i));
		}
	}

	private static Node getLeftMost(Node head) {
		Node current = head;
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	private static Node getRightMost(Node head) {
		Node current = head;
		while (current.right != null) {
			current = current.right;
		}
		return current;
	}

	private static int getSuccessor(Node head, int target) {
		Node current = head;
		int successor = 0;
		while (current != null) {
			if (target > current.val && current.right != null) {
				current = current.right;
			} else if (target < current.val) {
				if (current.left != null
					&& getRightMost(current.left).val > target) {
					current = current.left;
				} else {
					successor = current.val;
					current = null;
				}
			} else {
				if (current.right != null) {
					successor = getLeftMost(current.right).val;
				} else {
					successor = current.val;
				}
				current = null;
			}
		}
		return successor;
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
