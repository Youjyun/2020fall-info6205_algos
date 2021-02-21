package edu.northeastern.info6205;

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: The first node of linked list
     * @param n: the start index
     * @param m: the end node
     * @return: A ListNode
     */
    public ListNode deleteNode(ListNode head, int n, int m) 
    {
        if (head == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode nxt = head;
        
        while(n-- != 0)
        {
            prev = prev.next;
        }
        while(m-- != 0)
        {
            nxt = nxt.next;
        }
    
        prev.next = nxt.next;
        return dummy.next;
    }
}