package LeetCode.LinkedList;

/*
https://leetcode.com/problems/lru-cache/description/
 */
import java.util.HashMap;

class LRUCache {


    int capacity;

    HashMap<Integer, Node> map = new HashMap<>();
    Node dummyHead = new Node(-1, -1);
    Node dummyTail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node current = map.get(key);

            moveMru(current);

            insertNode(current);

            return current.val;
        }
        return -1;
    }

    public void put2(int key, int value) {

        if (map.containsKey(key)) {
            Node current = map.get(key);
            current.val = value;

            moveMru(current);
            insertNode(current);
            return;
        }

        // Case 2: Cache is full
        if (map.size() == capacity) {
            Node lru = dummyHead.next;

            map.remove(lru.key);

            dummyHead.next = lru.next;
            lru.next.prev = dummyHead;
        }

        // Case 3: Insert new node
        Node newNode = new Node(key, value);

        map.put(key, newNode);
        insertNode(newNode);

    }

    public void put(int key, int value) {
        if (map.size() < capacity) {
            if (map.containsKey(key)) {
                Node current = map.get(key);
                current.val = value;
                moveMru(current);
                insertNode(current);
            } else {
                Node newNode = new Node(key, value);

                map.put(key, newNode);
                insertNode(newNode);
            }

        } else {
            if (map.containsKey(key)) {
                Node current = map.get(key);
                current.val = value;
                moveMru(current);
                insertNode(current);
            } else {
                Node lru = dummyHead.next;
                Node lruNext = lru.next;

                map.remove(lru.key);

                dummyHead.next = lruNext;
                lruNext.prev = dummyHead;
                Node newNode = new Node(key, value);

                map.put(key, newNode);
                insertNode(newNode);
            }
        }
    }

    private void insertNode(Node newNode) {
        Node dummyPrev = dummyTail.prev;
        dummyTail.prev = newNode;
        newNode.next = dummyTail;
        newNode.prev = dummyPrev;
        dummyPrev.next = newNode;
    }

    private void moveMru(Node current) {
        Node curNext = current.next;
        Node curPrev = current.prev;

        current.next = null;
        current.prev = null;

        curNext.prev = curPrev;
        curPrev.next = curNext;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */