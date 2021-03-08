package edu.northeastern.info6205;

import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    	 Arrays.sort(nums1);
         Arrays.sort(nums2);
         
         //two pointer traverse
         int i = 0, j = 0;
         
         Set<Integer> intersect = new HashSet<>();
         
         while(i<nums1.length&&j<nums2.length) {
        	 if (nums1[i] < nums2[j]) {
                 i ++;
             } 
             else if (nums1[i] > nums2[j]) {
                 j ++;
             }
             //
             else {
            	 intersect.add(nums1[i]);
                 i ++;
                 j ++;
             }
         }
         
         int[] result = new int[intersect.size()];
         int index= 0;
         for(int num : intersect) {
        	 result[index++] = num;
         }
         return result;
    }
}