package edu.northeastern.info6205;

//3. Print all the leaves of a tree.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
	
	public List<List<Integer>> findLeaves(TreeNode root) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    helper(result, root);
	    return result;
	}
	 
	// traverse the tree bottom-up recursively
	private int helper(List<List<Integer>> list, TreeNode root){
	    if(root==null)
	        return -1;
	 
	    int left = helper(list, root.left);
	    int right = helper(list, root.right);
	    int curr = Math.max(left, right)+1;
	 
	    // the first time this code is reached is when curr==0,
	    //since the tree is bottom-up processed.
	    if(list.size()<=curr){
	        list.add(new ArrayList<Integer>());
	    }
	 
	    list.get(curr).add(root.val);
	 
	    return curr;
	}
	
	
	
}
