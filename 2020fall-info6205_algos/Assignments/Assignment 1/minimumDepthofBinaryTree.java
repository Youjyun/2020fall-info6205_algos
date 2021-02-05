package edu.northeastern.info6205;

//2. Find Minimum depth of all the leaves in a tree.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
    	 if (root == null){
             return 0;
         }
         int leftDepth = minDepth(root.left);
         int rightDepth = minDepth(root.right);
         
         // when leaves of left or leaves of right is empty
         if (leftDepth == 0 || rightDepth == 0){
             return leftDepth + rightDepth + 1;
         }
         
         return Math.min(leftDepth, rightDepth) + 1;
    }
}