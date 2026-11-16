package LeetCode.LinkedList;

/*
https://leetcode.com/problems/design-linked-list/description/
 */
public class DesignLinkedList {
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head;
    int size;

    public DesignLinkedList() {

    }

    public int get(int index) {

        if (index < 0 || index >= size)
            return -1;
        if (head == null)
            return -1;

        int count = 0;
        Node temp = head;

        while (temp != null) {
            if (count == index)
                return temp.val;

            count++;
            temp = temp.next;
        }

        return -1;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);

        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        size++;
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    public void addAtIndex(int index, int val) {

        if (index <= 0)
            addAtHead(val);
        else if (index == size)
            addAtTail(val);
        else if (index > size)
            return;
        else {
            int count = 0;

            Node newNode = new Node(val);

            Node temp = head;
            while (temp.next != null) {
                if (index == count + 1) {
                    newNode.next = temp.next;
                    temp.next = newNode;
                    size++;
                    return;
                }
                count++;
                temp = temp.next;
            }
        }
    }

    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size)
            return;
        else if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        int count = 0;
        Node temp = head;

        while (temp.next != null) {
            if (count == index - 1) {
                temp.next = temp.next.next;
                size--;
                return;
            }
            count++;
            temp = temp.next;
        }
    }
}