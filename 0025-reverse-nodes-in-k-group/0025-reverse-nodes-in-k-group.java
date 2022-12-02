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
    public ListNode reverseKGroup(ListNode head, int k) {
        int length  = checkLength(head);
        return reorder(head, length, k);
    }
    private static ListNode reorder(ListNode head, int length, int k) {
        if (length < k) {
            return head;
        }
        int group = k;
        ListNode root = head;
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(group != 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            group--;
        }
        root.next = reorder(curr, length - k, k);
        return prev;
    }
    private static int checkLength(ListNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + checkLength(root.next);
    } 
}