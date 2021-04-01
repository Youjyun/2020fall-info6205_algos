package edu.northeastern.info6205;

/**
 * @param root: the list
 * @param k: the split sum
 * @return: the answer
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int count = 0;
        ListNode curNode = root;
        while (curNode != null) {
            count++;
            curNode = curNode.next;
        }

        int size = count / k;
        int mod = count % k;

        ListNode[] result = new ListNode[k];
        curNode = root;
        for (int i = 0; curNode != null && i < k; i++) {
            result[i] = curNode;
            int curSize = size + (mod-- > 0 ? 1 : 0);
            for (int j = 0; curNode != null && j < curSize - 1; j++) {
                curNode = curNode.next;
            }
            ListNode nextNode = curNode.next;
            curNode.next = null;
            curNode = nextNode;
        }
        return result;
    }
}