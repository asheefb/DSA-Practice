package LeetCode.LinkedList;

/*
https://leetcode.com/problems/partition-list/description/
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        if (head == null)
            return null;
        else if (head.next == null)
            return head;

        ListNode temp = head;
        ListNode smallDummy = new ListNode(-1);
        ListNode smallTail = smallDummy;
        ListNode largeDummy = new ListNode(-1);
        ListNode largeTail = largeDummy;

        while (temp != null) {
            if (temp.val < x) {
                smallTail.next = temp;
                smallTail = smallTail.next;
            } else {
                largeTail.next = temp;
                largeTail = largeTail.next;
            }

            temp = temp.next;
        }

        smallTail.next = largeDummy.next;
        largeTail.next = null;

        return smallDummy.next;
    }
}
