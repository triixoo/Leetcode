package Mediumtasks;
    public class InsertGreatest {
        public class ListNode {
            int val;
            ListNode next;

            ListNode() {}

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

        class Solution {
            private int nod(int a, int b) {
                while (b != 0) {
                    int temp = b;
                    b = a % b;
                    a = temp;
                }
                return a;
            }

            public ListNode insertGreatestCommonDivisor(ListNode head) {
                if (head == null || head.next == null) {
                    return head;
                }

                ListNode current = head;

                while (current != null && current.next != null) {
                    int nodValue = nod(current.val, current.next.val);
                    ListNode nodNode = new ListNode(nodValue);
                    nodNode.next = current.next;
                    current.next = nodNode;
                    current = nodNode.next;
                }

                return head;
            }
        }
    }

