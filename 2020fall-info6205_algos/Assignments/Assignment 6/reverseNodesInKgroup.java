package edu.northeastern.info6205;

class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null | head.next == null || k == 1) {
			return head;
		}

		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode cur = head;
		int count = 0;
		while (cur != null) {
			cur = cur.next;
			count++;
		}

		int timeToFlip = count / k;
		cur = head;
		ListNode before = dummyHead;
		ListNode after = null;
		for (int i = 0; i < timeToFlip; i++) {
			int numNodes = k;
			ListNode temp = null;
			ListNode pre = null;

			while (numNodes != 0) {
				numNodes--;
				temp = cur.next;
				cur.next = pre;
				pre = cur;
				cur = temp;
				after = cur;
			}

			before.next = pre;
			while (pre.next != null) {
				pre = pre.next;
			}
			pre.next = after;

			before = pre;
			cur = before.next;
		}
		return dummyHead.next;
	}
}