public class Quicksort {

	public void sort(int[] values) {
		// check for empty or null array
		if (values == null || values.length == 0){
			return;
		}

		quicksort(values, 0, values.length - 1);
	}

	private void quicksort(int[] values, int left, int right) {
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
		swap(values, start, right);
		quicksort(values, left, start - 1);
		quicksort(values, start + 1, right);
	}

	private void swap(int[] values, int x, int y) {
		int temp = values[x];
		values[x] = values[y];
		values[y] = temp;
	}
}
