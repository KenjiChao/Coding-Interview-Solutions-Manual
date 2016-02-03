public class LeastCommonAncestor {

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(7);

		Node common = findCommonAncestor(root, 1, 3);
		if (common != null) {
			System.out.println(common.val);
		} else {
			System.out.println("There is no common node!!");
		}
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
