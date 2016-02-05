public class MaximalSubarray {

	public static void main(String[] args) {
		int[] nums = new int[]{1, -3, 5, 2, 9, -8, -6, 4};
		// int[] nums = new int[]{-1, 1, 0};

		System.out.println(maxSubarray(nums));
	}

	private static int maxSubarray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}

		int max = nums[0];
		int maxEndingHere = nums[0];

		for (int i = 1; i < nums.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			max = Math.max(max, maxEndingHere);
		}

		// int max = nums[0];
		// int maxEndIndex = 0;

		// for (int i = 1; i < nums.length; i++) {
		// 	if (maxEndIndex == i - 1 && nums[i] >= 0 && max >= 0) {
		// 		max += nums[i];
		// 		maxEndIndex = i;
		// 	} else if (nums[i] >= max) {
		// 		max = nums[i];
		// 		maxEndIndex = i;
		// 	}
		// }

		return max;
	}
}
