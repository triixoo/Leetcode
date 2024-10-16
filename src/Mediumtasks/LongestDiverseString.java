package Mediumtasks;
import java.util.PriorityQueue;
public class LongestDiverseString {

    class Solution {
        public String longestDiverseString(int a, int b, int c) {
            // Create a max heap to store counts of a, b, and c
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[0] - x[0]);

            // Add counts to the max heap if they are greater than zero
            if (a > 0) maxHeap.offer(new int[]{a, 'a'});
            if (b > 0) maxHeap.offer(new int[]{b, 'b'});
            if (c > 0) maxHeap.offer(new int[]{c, 'c'});

            StringBuilder result = new StringBuilder();

            while (!maxHeap.isEmpty()) {
                int[] current = maxHeap.poll();
                int count = current[0];
                char letter = (char) current[1];

                // Check if we can add the current character
                int length = result.length();
                if (length >= 2 && result.charAt(length - 1) == letter && result.charAt(length - 2) == letter) {
                    // Need to use a different character
                    if (maxHeap.isEmpty()) break; // No other options available
                    int[] next = maxHeap.poll();
                    // Append the next character
                    result.append((char) next[1]);
                    // Decrement its count
                    if (next[0] - 1 > 0) maxHeap.offer(new int[]{next[0] - 1, next[1]});
                    // Put the current character back in the heap
                    maxHeap.offer(current);
                } else {
                    // Append the current character
                    result.append(letter);
                    // Decrement its count
                    if (count - 1 > 0) maxHeap.offer(new int[]{count - 1, letter});
                }
            }

            return result.toString();
        }
    }

}
