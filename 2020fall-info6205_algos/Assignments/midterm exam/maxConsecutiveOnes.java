package edu.northeastern.info6205;
//Time O(n) & Space O(1) complexity
class Solution {
	public static int getMaxConsecutiveOnes(int[] nums) {
		int result = 0;
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
        	count++;
        	result = Math.max(count, result);
            }
            else count = 0;
        }
        return result;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {0,1,0,1,1,0,1,1,1,0,0,0};
		System.out.println(getMaxConsecutiveOnes(nums));
	}
}