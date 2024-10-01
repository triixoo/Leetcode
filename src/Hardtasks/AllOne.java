package Hardtasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AllOne {
    private class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Map<String, Node> keyMap;
    private Node head, tail;

    public AllOne() {
        keyMap = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    private Node addNodeAfter(Node prev, int count) {
        Node newNode = new Node(count);  // Correct count initialization
        newNode.next = prev.next;
        newNode.prev = prev;
        prev.next.prev = newNode;
        prev.next = newNode;
        return newNode;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void inc(String key) {
        if (!keyMap.containsKey(key)) {
            // Key does not exist, insert into count 1
            if (head.next.count != 1) {
                addNodeAfter(head, 1);
            }
            head.next.keys.add(key);
            keyMap.put(key, head.next);
        } else {
            // Key exists, increment the count
            Node curNode = keyMap.get(key);
            Node nextNode = curNode.next;

            if (nextNode.count != curNode.count + 1) {
                nextNode = addNodeAfter(curNode, curNode.count + 1);  // Use curNode here
            }

            nextNode.keys.add(key);
            keyMap.put(key, nextNode);
            curNode.keys.remove(key);

            if (curNode.keys.isEmpty()) {
                removeNode(curNode);
            }
        }
    }

    public void dec(String key) {
        Node curNode = keyMap.get(key);

        if (curNode.count == 1) {
            // If count is 1, remove the key
            keyMap.remove(key);
        } else {
            // Decrement the count
            Node prevNode = curNode.prev;

            if (prevNode.count != curNode.count - 1) {
                prevNode = addNodeAfter(curNode.prev, curNode.count - 1);
            }

            prevNode.keys.add(key);
            keyMap.put(key, prevNode);
        }

        curNode.keys.remove(key);

        if (curNode.keys.isEmpty()) {
            removeNode(curNode);
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }
}
