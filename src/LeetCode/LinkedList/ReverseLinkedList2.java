package LeetCode.LinkedList;

/*
https://leetcode.com/problems/reverse-linked-list-ii/description/
 */
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode beforeLeft = dummy;
        boolean isLeftFound = false, isRightFound = false;

        ListNode rightNode = null;

        ListNode temp = head;
        int count = 1;
        while (temp != null) {
            if (count == left - 1)
                beforeLeft = temp;

            if (count == right)
                rightNode = temp;

            count++;

            temp = temp.next;
        }

        if (rightNode == null)
            return head;

        ListNode leftNode = beforeLeft.next;
        ListNode afterRight = null;

        if (rightNode.next != null)
            afterRight = rightNode.next;

        int iter = 0;

        ListNode prev = afterRight;
        ListNode current = leftNode;

        while (iter <= right - left) {
            ListNode next = current.next;

            current.next = prev;
            prev = current;
            current = next;

            iter++;
        }

        beforeLeft.next = prev;

        return dummy.next;
    }
}
