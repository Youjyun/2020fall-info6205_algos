package edu.northeastern.info6205;

public class Solution {
    /**
     * @param A: an array
     * @return: any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     */
    public int peakIndexInMountainArray(int[] A) {
        // Write your code here
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid - 1]) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (A[start] > A[start - 1] && A[start] > A[start + 1]) {
            return start;
        }
        else {
            return end;
        }
    }
}
