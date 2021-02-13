package edu.northeastern.info6205;


/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/
 
class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            head = new Node(insertVal);
            head.next = head;
        } else {
            Node curNode = head;
            while(!(curNode.val <= insertVal && insertVal <= curNode.next.val) && // 3 -> 5,  insert 4;
                 !(curNode.val > curNode.next.val 
                   && (insertVal >= curNode.val || insertVal <= curNode.next.val)) && // 5 - > 1, insert, 6 || 0;
                 curNode.next != head) { 
                curNode = curNode.next;
            }
            Node temp = curNode.next;
            curNode.next = new Node(insertVal);
            curNode.next.next = temp;
        }
        return head;
    }
}
