package edu.northeastern.info6205;

class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		dfs(0, 0, "", n, result);
		return result;
	}

	private void dfs(int leftCount, int rightCount, String nowSeq, int n, List<String> result) {
		
		if (leftCount > n || rightCount > n) {
			return;
		}
		if (leftCount < rightCount) {
			return;
		}
		if (leftCount == n && rightCount == n) {
			result.add(nowSeq);
			return;
		}
		dfs(leftCount + 1, rightCount, nowSeq + "(", n, result);
		dfs(leftCount, rightCount + 1, nowSeq + ")", n, result);
	}
}