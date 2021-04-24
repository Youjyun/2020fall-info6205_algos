package edu.northeastern.info6205;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new ArrayList[numCourses];
		int[] inDegree = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList();
		}

		for (int[] pair : prerequisites) {
			int pre = pair[1];
			int cur = pair[0];
			graph[pre].add(cur);
			inDegree[cur]++;
		}

		int numChoose = 0;
		Queue<Integer> queue = new ArrayDeque();

		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			numChoose++;
			for (Integer child : graph[cur]) {
				inDegree[child]--;
				if (inDegree[child] == 0) {
					queue.offer(child);
				}
			}
		}

		return numCourses == numChoose;
	}

	public static void main(String[] args) {
		int[][] test = {{1,0}};
		System.out.print(canFinish(2,test));
	}

}
