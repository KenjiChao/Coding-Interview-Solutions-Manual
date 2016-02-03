public class BinarySearchTreeValidity {

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(7);
		// root.right.left.left = new Node(3);
		System.out.println(isValidBST(root));
	}

	private static boolean isValidBST(Node root) {
		if (root == null) {
			return false;
		}
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isValidBST(Node current, int min, int max) {
		if (current.val > max || current.val < min) {
			return false;
		}

		if (current.left != null && !isValidBST(current.left, min, current.val)) {
			return false;
		}

		if (current.right != null && !isValidBST(current.right, current.val, max)) {
			return false;
		}

		return true;
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
