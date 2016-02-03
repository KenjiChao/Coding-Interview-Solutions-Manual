import java.util.*;

public class LinkedListIntegerAddition {

	public static void main(String[] args) {
		Node first = new Node(1);
		first.next = new Node(5);
		first.next.next = new Node(8);
		Node second = new Node(1);
		second.next = new Node(2);
		second.next.next = new Node(3);

		Node result = addLinkedListNumbers(first, second);

		while (result != null) {
			System.out.println(result.value);
			result = result.next;
		}
	}

	private static Node addLinkedListNumbers(Node first, Node second) {
		Node head = new Node(-1);
		Node cur = head;
		int carry = 0;

		while (first != null || second != null) {
			int sum = carry;
			if (first != null) {
				sum += first.value;
				first = first.next;
			}
			if (second != null) {
				sum += second.value;
				second = second.next;
			}
			carry = sum / 10;
			sum = sum % 10;
			cur.next = new Node(sum);
			cur = cur.next;
		}

		if (carry != 0) {
			cur.next = new Node(carry);
		}

		return head.next;
	}

	private static class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}
	}
}
