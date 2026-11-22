package LeetCode.LinkedList;

/*
https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class SwapTwoNodesInPair {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        else if (head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode sec = prev.next.next;

            ListNode newNodes = sec.next;

            prev.next = sec;
            sec.next = first;
            first.next = newNodes;

            prev = first;
        }

        return dummy.next;
    }
}
