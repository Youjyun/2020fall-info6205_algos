package edu.northeastern.info6205;

//4. Print sum of all the left leaves
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class solution {
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		if (root.left != null) {
			TreeNode left = root.left;
			//find leave nodes
			if (left.left == null && left.right == null) {
				sum += left.val;
			} else {
				sum += sumOfLeftLeaves(left);
			}

		}
		//traverse right leaves
		if (root.right != null) {
			TreeNode right = root.right;
			sum += sumOfLeftLeaves(right);
		}

		return sum;
	}

}
