package edu.northeastern.info6205;

class Solution {
	public void rotate(int[][] matrix) {
		int top = 0;
		int left = 0;
		int bottom = matrix.length - 1;
		int right = matrix[0].length - 1;
		int n = matrix.length;
		while (n > 1) {
			for (int i = 0; i < n - 1; i++) {
				int temp = matrix[top][left + i];
				matrix[top][left + i] = matrix[bottom - i][left];
				matrix[bottom - i][left] = matrix[bottom][right - i];
				matrix[bottom][right - i] = matrix[top + i][right];
				matrix[top + i][right] = temp;
			}
			top++;
			left++;
			bottom--;
			right--;
			n -= 2;
		}
	}
}