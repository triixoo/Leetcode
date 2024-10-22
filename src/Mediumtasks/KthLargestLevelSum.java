package Mediumtasks;
import java.util.*;
public class KthLargestLevelSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        public long kthLargestLevelSum(TreeNode root, int k) {
            if (root == null) {
                return -1;  // No levels if the tree is empty
            }

            // BFS to calculate level sums
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            // Min-heap to track the k largest sums
            PriorityQueue<Long> minHeap = new PriorityQueue<>(k);

            while (!queue.isEmpty()) {
                int size = queue.size();
                long levelSum = 0;

                // Process all nodes at the current level
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    levelSum += node.val;

                    // Add left and right children to the queue
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }

                // Add the current level sum to the heap
                if (minHeap.size() < k) {
                    minHeap.offer(levelSum);
                } else if (levelSum > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(levelSum);
                }
            }

            // If there are fewer than k levels, return -1
            if (minHeap.size() < k) {
                return -1;
            }

            // The kth largest sum is at the top of the min-heap
            return minHeap.peek();
        }
    }
}
