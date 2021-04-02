package edu.northeastern.info6205;

import java.util.LinkedList;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

//Time O(n) & Space  O(1) complexity
class Solution {
	public static boolean areConverging(ListNode n1, ListNode n2) {
		int lengthA = getLength(n1);
		int lengthB = getLength(n2);

		ListNode tmpA = n1;
		ListNode tmpB = n2;

		// If list A is shorter, skip over the extra leading nodes in list B
		while (lengthA < lengthB) {
			lengthB--;
			tmpB = tmpB.next;
		} // End once the lists at the end of both pointers are the same length

		// If list B is shorter, skip over the extra leading nodes in list A
		while (lengthA > lengthB) {
			lengthA--;
			tmpA = tmpA.next;
		} // End once the lists at the end of both pointers are the same length

		
		// Now that both list heads are pointing to the same number of nodes,
		// walk the pointers forward until they match
		// We only need to check one node because the lists have the same length
		while (tmpA != null) {
			// If the two references point to the same node
			if (tmpA == tmpB) {
				return true;
			}
			tmpA = tmpA.next;
			tmpB = tmpB.next;
		}

		// No intersection found
		return false;

	}

	private static int getLength(ListNode head) {
		int length = 0;
		ListNode tmp = head;

		while (tmp != null) {
			length++;
			tmp = tmp.next;
		}
		return length;
	}
		 
	

	public static void main(String[] args) {
		
		// creating first linked list
		ListNode list1 = new ListNode(3);
		list1.next = new ListNode(6);
		list1.next.next = new ListNode(9);
		list1.next.next.next = new ListNode(15);
		list1.next.next.next.next = new ListNode(30);
		
		// creating second linked list
		ListNode list2 = new ListNode(10);
		list2.next = new ListNode(15);
		list2.next.next = new ListNode(30);

		System.out.println("The node of intersection is " + areConverging(list1,list2));

	}
}