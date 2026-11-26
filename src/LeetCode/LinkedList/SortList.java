package LeetCode.LinkedList;

/*
https://leetcode.com/problems/sort-list/description/
 */
public class SortList {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;
        ListNode current = head;
        int size = 0;
        while (current != null) {
            current = current.next;
            size++;
        }

        int splitSize = size / 2;

        ListNode firstHalf = head;
        ListNode temp = head;

        int count = 1;
        //5 → 6 → 3 → 2 → 1 → 4

        while (count < splitSize) {
            temp = temp.next;
            count++;
        }

        ListNode secondHalf = temp.next;
        temp.next = null;

        ListNode sortedFirstHalf = sortList(firstHalf);
        ListNode sortedSecondHalf = sortList(secondHalf);

        return mergeSortList(sortedFirstHalf, sortedSecondHalf);
    }

    private ListNode mergeSortList(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
        }

        if (l1 != null)
            temp.next = l1;

        if (l2 != null)
            temp.next = l2;

        return dummy.next;
    }
}
