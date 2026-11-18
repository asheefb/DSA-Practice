package LeetCode.LinkedList;

/*
https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            tail.next = new ListNode(sum % 10);
            carry = sum / 10;

            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;

            tail.next = new ListNode(sum % 10);
            carry = sum / 10;

            tail = tail.next;
            l1 = l1.next;

        }

        while (l2 != null) {
            int sum = l2.val + carry;

            tail.next = new ListNode(sum % 10);
            carry = sum / 10;

            tail = tail.next;
            l2 = l2.next;
        }

        if (carry != 0)
            tail.next = new ListNode(carry);

        return dummy.next;
    }
}
