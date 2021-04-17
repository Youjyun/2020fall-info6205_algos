package edu.northeastern.info6205;

class Solution {
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		int wordStartIndex = s.length();
		int wordLastIndex = s.length();

		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == ' ') {
				if (wordStartIndex != wordLastIndex) {
					sb.append(s.substring(wordStartIndex, wordLastIndex));
					sb.append(' ');
					wordLastIndex = wordStartIndex;
				}

				wordStartIndex--;
				wordLastIndex--;
			} else {
				wordStartIndex--;
			}
		}
		sb.append(s.substring(wordStartIndex, wordLastIndex));
		return sb.toString().trim();
	}
}