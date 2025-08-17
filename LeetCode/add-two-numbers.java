/**
 * https://leetcode.com/problems/add-two-numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        sum(l1, l2, sum, 0);
        return sum;
    }

    public void sum(ListNode l1, ListNode l2, ListNode result, int prev) {
        final int num1 = l1 != null ? l1.val : 0;
        final int num2 = l2 != null ? l2.val : 0;
        final int sum = num1 + num2 + prev;
        int addNext = 0;
        int unit = 0;
        if (sum >= 10) {
            unit = sum % 10;
            addNext = sum / 10;
        } else {
            unit = sum;
        }
        result.val = unit;

        final ListNode nextL1 = l1 != null ? l1.next : null;
        final ListNode nextL2 = l2 != null ? l2.next : null;
        if (nextL1 == null && nextL2 == null && addNext == 0) return;

        result.next = new ListNode();
        sum(nextL1, nextL2, result.next, addNext);
    }
}