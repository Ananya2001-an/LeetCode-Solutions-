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
    public ListNode reverseList(ListNode head) {
        
        if(head == null)
            return head;
        
        
        ListNode copy = head;
        ListNode q = copy;
        ListNode p = copy.next;
        
        while(p != null)
        {
            copy = p;
            p = copy.next;
            copy.next = q;
            q = copy;
        }
        
        head.next = null;
        head = copy;
        
        return head;
        
    }
}