package edu.northeastern.info6205;

/**
 * @param root: the list
 * @param k: the split sum
 * @return: the answer
 */
 class Solution {
    
    public int[][] splitLinkedListinParts(int[] root, int k) {
        // Write your code here.
        int n = root.length;
        int sum = n % k;
        int start = 0;
        int [][]ans = new int[k][];
        int sign;
        for (int i = 0; i < k; i++) {
            if (start >= n) {
                ans[i] = new int[0];
            }
            else {
                if (sum > 0) sign = n / k + 1;
                else sign = n / k;
                ans[i] = new int[sign];
                for (int j = 0; j < sign ; j++) {
                    ans[i][j] = root[start];
                    start++;
                }
                if (sum > 0) {

                    sum--;
                }
            }
        }

        return ans;
    }
}
