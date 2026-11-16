package LeetCode.LinkedList;

/*
https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
 */
public class BinaryToDecimal {

    public static int getDecimalValue(ListNode head) {
        if (head == null)
            return 0;
        else if (head.next == null)
            return head.val;

        ListNode temp = head;
        String value = "";
        while (temp != null) {
            value = value + temp.val;
            temp = temp.next;
        }
        return Integer.parseInt(value, 2);
    }

    public int getDecimalValue2(ListNode head) {
        if (head == null)
            return 0;
        else if (head.next == null)
            return head.val;

        ListNode temp = head;
        int res = 0;
        while (temp != null) {
            res = res * 2 + temp.val;
            temp = temp.next;
        }
        return res;
    }
}

