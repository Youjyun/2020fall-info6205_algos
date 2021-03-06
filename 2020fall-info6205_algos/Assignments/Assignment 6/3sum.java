package edu.northeastern.info6205;

class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		// List<List<Integer>> results = new ArrayList<>();
		List<List<Integer>> results = new LinkedList<>();
		if (nums == null || nums.length < 3) {
			return results;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			// skip duplicate triples with the same first numebr
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int left = i + 1, right = nums.length - 1;
			int target = -nums[i];
			twoSum(nums, left, right, target, results);
		}
		return results;
	}

	public void twoSum(int[] nums, int left, int right, int target, List<List<Integer>> results) {
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target) {
				// ArrayList<Integer> triple = new ArrayList<>();
				// triple.add(-target);
				// triple.add(nums[left]);
				// triple.add(nums[right]);
				// results.add(triple);
				results.add(Arrays.asList(-target, nums[left], nums[right]));

				left++;
				right--;

				while (left < right && nums[left] == nums[left - 1]) {
					left++;
				}
				while (left < right && nums[right] == nums[right + 1]) {
					right--;
				}
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
	}
}