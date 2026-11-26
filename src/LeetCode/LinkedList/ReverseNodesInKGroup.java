package LeetCode.LinkedList;

/*
https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode groupPrev = dummy;

        int count = 0;

        ListNode current = head;
        while (current != null) {

            if (count == k - 1) {
                ListNode prev = current.next;
                ListNode tempCur = groupPrev.next;
                ListNode oldhead = groupPrev.next;
                int revCount = 1;

                while (revCount <= k) {
                    ListNode next = tempCur.next;
                    tempCur.next = prev;
                    prev = tempCur;
                    tempCur = next;
                    revCount++;
                }

                groupPrev.next = prev;
                groupPrev = oldhead;
                current = groupPrev.next;
                count = 0;
            } else {
                current = current.next;
                count++;
            }
        }

        return dummy.next;
    }
}
