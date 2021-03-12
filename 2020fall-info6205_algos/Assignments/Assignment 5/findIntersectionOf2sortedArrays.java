package edu.northeastern.info6205;

class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> intersect = new HashSet<>();
		// nums1 sort
		Arrays.sort(nums1);
		// Compare evey elements in nums2 whether is in num1
		for (int i = 0; i < nums2.length; i++) {
			if (intersect.contains(nums2[i])) {
				continue;
			}
			if (binarySearch(nums1, nums2[i])) {
				intersect.add(nums2[i]);
			}
		}
		// put element of intersect to res
		int[] result = new int[intersect.size()];
		int index = 0;
		for (Integer num : intersect) {
			result[index++] = num;
		}
		
		return result;
	}

	private boolean binarySearch(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		
		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = (end - start) / 2 + start;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (nums[start] == target) {
			return true;
		}

		if (nums[end] == target) {
			return true;
		}
		return false;
	}
}
