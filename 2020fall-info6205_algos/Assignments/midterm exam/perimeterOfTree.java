package edu.northeastern.info6205;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
//Time O(n) & Space O(n) complexity
class Solution {
	public static void printPerimeter(TreeNode root) {

		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return;
		}
		if (!isLeaf(root)) {
			res.add(root.val);
		}
		TreeNode t = root.right;
		while (t != null) {
			if (!isLeaf(t)) {
				res.add(t.val);
			}
			if (t.right != null) {
				t = t.right;
			} else {
				t = t.left;
			}

		}
		addLeaves(res, root);
		Deque<Integer> s = new ArrayDeque<Integer>();
		t = root.left;
		while (t != null) {
			if (!isLeaf(t)) {
				s.push(t.val);
			}
			if (t.left != null) {
				t = t.left;
			} else {
				t = t.right;
			}
		}
		while (!s.isEmpty()) {
			res.add(s.pop());
		}
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

	private static boolean isLeaf(TreeNode t) {
		return t.left == null && t.right == null;
	}

	private static void addLeaves(List<Integer> res, TreeNode root) {
		if (isLeaf(root)) {
			res.add(root.val);
		} else {
			if (root.right != null) {
				addLeaves(res, root.right);
			}
			if (root.left != null) {
				addLeaves(res, root.left);
			}
		}
	}

	public static void main(String[] args) {
		String str = "[1,2,3,4,5,6,null,null,null,7,8,9,10]";
		TreeNode node = TreeNode.mkTree(str);
		printPerimeter(node);
	}

	static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		public String toString() {
			return Integer.toString(val);
		}

		private static int[] StrToIntArray(String str) {
			str = str.substring(1, str.length() - 1);
			String[] strs = str.split(",");
			int[] arr = new int[strs.length];

			for (int i = 0; i < arr.length; i++) {
				if (strs[i].equals("null")) {
					arr[i] = Integer.MAX_VALUE;
				} else {
					arr[i] = Integer.parseInt(strs[i]);
				}
			}

			return arr;
		}

		public static TreeNode mkTree(String str) {

			int[] arr = StrToIntArray(str);
			TreeNode[] nodes = new TreeNode[arr.length + 1];
			for (int i = 1; i < nodes.length; i++) {
				if (arr[i - 1] != Integer.MAX_VALUE) {
					nodes[i] = new TreeNode(arr[i - 1]);
				} else {
					nodes[i] = null;
				}
			}

			TreeNode node = null;
			for (int i = 1; i < nodes.length / 2; i++) {
				node = nodes[i];
				if (node == null)
					continue;
				node.left = nodes[2 * i];
				node.right = nodes[2 * i + 1];
			}
			return nodes[1];
		}
	}

}
