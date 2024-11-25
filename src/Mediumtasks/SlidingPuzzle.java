package Mediumtasks;
import java.util.*;
public class SlidingPuzzle {
    class Solution {
        public int slidingPuzzle(int[][] board) {
            // Flatten the board into a string
            StringBuilder start = new StringBuilder();
            for (int[] row : board) {
                for (int cell : row) {
                    start.append(cell);
                }
            }

            // Solved state
            String target = "123450";

            // Define valid moves for each position
            int[][] neighbors = {
                    {1, 3},    // 0
                    {0, 2, 4}, // 1
                    {1, 5},    // 2
                    {0, 4},    // 3
                    {1, 3, 5}, // 4
                    {2, 4}     // 5
            };

            // BFS setup
            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            queue.offer(start.toString());
            visited.add(start.toString());

            int moves = 0;

            // BFS loop
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String current = queue.poll();

                    // Check if solved
                    if (current.equals(target)) {
                        return moves;
                    }

                    // Find position of '0'
                    int zeroIndex = current.indexOf('0');

                    // Generate neighbors
                    for (int neighbor : neighbors[zeroIndex]) {
                        String next = swap(current, zeroIndex, neighbor);
                        if (!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
                moves++;
            }

            return -1; // If no solution is found
        }

        // Helper to swap characters in a string
        private String swap(String s, int i, int j) {
            char[] chars = s.toCharArray();
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            return new String(chars);
        }
    }

}
