/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
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
    public ListNode swapPairs(ListNode head) {
        return swapWithPrev(null, head);
    }

    private ListNode swapWithPrev(ListNode prev, ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        // 2 or more
        final ListNode second = head.next;
        final ListNode third = second.next;
        second.next = head;
        head.next = third;
        head = second;
        if (prev != null) {
            prev.next = head;
        }

        swapWithPrev(head.next, head.next.next);

        return head;
    }
}