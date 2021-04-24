package edu.northeastern.info6205;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (beginWord.equals(endWord)) {
			return 1;
		}
		if (!wordList.contains(endWord)) {
			return 0;
		}
		Deque<String> queue = new ArrayDeque<>();
		Set<String> set = new HashSet<>(wordList);
		queue.offer(beginWord);

		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String word = queue.poll();
				char[] wordChar = word.toCharArray();

				for (int start = 0; start < wordChar.length; start++) {
					char temp = wordChar[start];
					for (char c = 'a'; c <= 'z'; c++) {
						wordChar[start] = c;
						String s = new String(wordChar);
						if (s.equals(endWord)) {
							return level + 1;
						}
						if (set.contains(s)) {
							queue.offer(s);
							set.remove(s);
						}
					}
					wordChar[start] = temp;
				}
			}
			level++;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.print(ladderLength("hit","cog",Arrays.asList("hot","dot","dog","lot","log","cog")));

	}

}
