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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(slow!=null && fast!=null && slow.next != null && fast.next != null)
        {
            slow = slow.next; //by 1 step ahead
            fast = fast.next.next; //by 2 steps ahead
        }
        
        return slow;
    }
}