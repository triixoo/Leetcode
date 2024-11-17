package Hardtasks;
import java.util.Deque;
import java.util.LinkedList;
public class ShortestSubarray {


    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length;
            long[] prefix = new long[n + 1];

            // Compute prefix sum
            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }

            // Initialize deque and result
            Deque<Integer> deque = new LinkedList<>();
            int minLength = Integer.MAX_VALUE;

            for (int j = 0; j <= n; j++) {
                // Remove indices from the front if they satisfy the condition
                while (!deque.isEmpty() && prefix[j] - prefix[deque.peek()] >= k) {
                    minLength = Math.min(minLength, j - deque.poll());
                }

                // Remove indices from the back if current prefix is smaller
                while (!deque.isEmpty() && prefix[j] <= prefix[deque.peekLast()]) {
                    deque.pollLast();
                }

                // Add current index to the deque
                deque.offer(j);
            }

            return minLength == Integer.MAX_VALUE ? -1 : minLength;
        }
    }

}
