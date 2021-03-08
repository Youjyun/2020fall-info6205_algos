package edu.northeastern.info6205;

class Solution {
    public void sortColors(int[] nums) {
    	 int left = 0;
         int right = nums.length - 1;
         int mid = 0;
         
         //when mid > right stop
         while (mid <= right){
             if (nums[mid] == 0){
                 swap(nums, mid, left);
                 mid ++;
                 left ++;
             }
             else if (nums[mid] == 2){
                 swap(nums, mid, right);
                 right --;
             }
             else{
                 mid ++;
             }
         }
     }
     
     private void swap(int[] a, int i, int j) {
         int tmp = a[i];
         a[i] = a[j];
         a[j] = tmp;
     }
    }
}