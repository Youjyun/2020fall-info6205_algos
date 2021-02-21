package edu.northeastern.info6205;

class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
    }
}
class Solution {
	 public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		 if(list1 == null && list2 == null){
		        return null;
		    }
		    else if(list1 == null){
		        return list2;
		    }
		    else if(list2 == null){
		        return list1;
		    }
		 
		    ListNode dummy = new ListNode(0), prev = dummy;
	        dummy.next = list1;

	        for (int i = 0; i < a; i++) {
	            prev = prev.next;
	        }

	        ListNode next = prev;
	        for (int i = 0; i < b - a + 2; i++) {
	            next = next.next;
	        }

	        prev.next = list2;
	        while (prev.next != null) {
	            prev = prev.next;
	        }

	        prev.next = next;
	        return dummy.next;
		 
	 }
}
