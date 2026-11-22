package LeetCode.LinkedList;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 */

public class ReverseDuplicateFromSortedList2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode current = head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        while (current != null) {

            if (current.next != null && current.val == current.next.val) {
                ListNode temp = current;
                while (temp.next != null && temp.next.val == current.val)
                    temp = temp.next;

                prev.next = temp.next;
                current = temp.next;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return dummy.next;
    }
}
