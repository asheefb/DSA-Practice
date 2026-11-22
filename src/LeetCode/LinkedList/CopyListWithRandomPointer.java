package LeetCode.LinkedList;

import java.util.HashMap;

/*
https://leetcode.com/problems/copy-list-with-random-pointer/description/
 */
public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {

        if (head == null)
            return null;

        Node temp = head;

        Node dummy = new Node(-1);
        Node newNode = dummy;

        HashMap<Node, Node> randoms = new HashMap<>();

        while (temp != null) {
            Node copiedNode = new Node(temp.val);

            randoms.put(temp, copiedNode);

            newNode.next = copiedNode;
            newNode = newNode.next;
            temp = temp.next;
        }

        Node current = head;
        Node copied = dummy.next;

        while (current != null) {
            copied.random = randoms.get(current.random);

            copied = copied.next;
            current = current.next;
        }

        return dummy.next;
    }
}
