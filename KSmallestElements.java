import java.util.*;

public class KSmallestElements {

	public static void main(String[] args) {
		int[] numbers = new int[]{6, 3, 2, 9, 7, 8, 6};
		int[] kSmallest = findKSmallestElements(numbers, 3);

		for (int i = 0; i < kSmallest.length; i++) {
			System.out.println(kSmallest[i]);
		}
	}

	private static int[] findKSmallestElements(int[] values, int k) {
		// check for empty or null array
		if (values == null || values.length == 0 || k <= 0){
			return new int[]{};
		} else if (k >= values.length) {
			return values;
		}

		quicksortK(values, 0, values.length - 1, k);
		int[] kSmallest = Arrays.copyOfRange(values, 0, k);
		return kSmallest;
	}

	private static void quicksortK(int[] values, int left, int right, int k) {
		if (left >= right) {
			return;
		}

		int pivot = values[right];
		int start = left;

		for (int i = left; i < right; i++) {
			if (values[i] <= pivot) {
				swap(values, start, i);
				start++;
			}
		}

		System.out.println("start = " + start);
		swap(values, start, right);
		if (start > k) {
			quicksortK(values, left, start - 1, k);
		} else if (start < k - 1) {
			quicksortK(values, start + 1, right, k);
		}
	}

	private static void swap(int[] values, int x, int y) {
		int temp = values[x];
		values[x] = values[y];
		values[y] = temp;
	}
}
