package edu.northeastern.info6205;

class Solution {
    /*
     * @param k an integer
     * @param nums an integer array
     * @return kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
    	
    return quickSelect(nums, 0, nums.length - 1, k - 1);
    }
    
    private int quickSelect(int[] A, int start, int end , int k) {
    	if (start >= end) {
            return A[start];
    	}    	
    	 int left= start, int right=end;
    	 int pivot = A[(start+end)/2];
    	 
    	 while(left<=right) {
    		 while(left<=right && A[left]<pivot) {
    			 left++;
    		 }
             while(left<=right && A[right]>pivot) {
            	 right--:
    		 }
             if(left<=right) {
            	 int temp= A[left];
            	 A[left]=A[right];
            	 A[right] = temp;
            	 
            	 left++;
            	 right--:
             }    		 
             
             if (k <= right) {
                 return quickSelect(nums, start, right, k);
             }
             if (k >= left) {
                 return quickSelect(nums, left, end, k);
             }
             return nums[k];
    		 
    	 }
    }
}
