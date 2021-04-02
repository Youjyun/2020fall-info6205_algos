package edu.northeastern.info6205;

//Time O(logN)& Space O(1) complexity
class Solution {
	public static int getIndex(int[] nums, int x) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int start = 0;
		int end = nums.length - 1;

		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == x) {
				end = mid;
			} else if (nums[mid] < x) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		if (nums[start] == x) {
			return start;
		}
		if (nums[end] == x) {
			return end;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 4, 4, 4, 6, 7, 7, 7, 8, 9, 9, 9 };
		System.out.println(getIndex(nums, 7));
	}
}