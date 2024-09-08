package Mediumtasks;
public class SplitLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode[] splitListToParts(ListNode head, int k) {
            int length = 0;
            ListNode current = head;
            while (current != null) {
                length++;
                current = current.next;
            }

            int partSize = length / k;
            int largerParts = length % k;

            ListNode[] result = new ListNode[k];
            current = head;

            for (int i = 0; i < k; i++) {
                ListNode partHead = current;
                int currentPartSize = partSize + (i < largerParts ? 1 : 0);

                for (int j = 0; j < currentPartSize - 1 && current != null; j++) {
                    current = current.next;
                }

                if (current != null) {
                    ListNode nextPart = current.next;
                    current.next = null;
                    current = nextPart;
                }

                result[i] = partHead;
            }

            return result;
        }
    }
}


