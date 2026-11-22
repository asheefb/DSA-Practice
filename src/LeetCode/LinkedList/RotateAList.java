package LeetCode.LinkedList;

/*
https://leetcode.com/problems/rotate-list/
 */
public class RotateAList {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null)
            return null;

        int size = getSize(head);

        ListNode oldTail = getOldTail(head);

        k = k % size;

        if (k == 0)
            return head;

        ListNode temp = head;

        int steps = size - k - 1;

        while (steps > 0) {
            temp = temp.next;
            steps--;
        }

        ListNode newTail = temp;
        ListNode newNode = temp.next;

        newTail.next = null;
        oldTail.next = head;
        head = newNode;

        return head;
    }

    private int getSize(ListNode head) {
        int size = 0;

        ListNode temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    private ListNode getOldTail(ListNode head) {

        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
}
