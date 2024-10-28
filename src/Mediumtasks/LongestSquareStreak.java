package Mediumtasks;
import java.util.*;
public class LongestSquareStreak {

    class Solution {
        public int longestSquareStreak(int[] nums) {
            Arrays.sort(nums);  // Step 1: Sort the array
            Map<Integer, Integer> dp = new HashMap<>();
            int maxLength = -1;  // Initialize max length as -1 for cases with no valid square streak

            for (int x : nums) {
                // Step 2: Check if x has a square root that can form a sequence
                int root = (int) Math.sqrt(x);
                if (root * root == x && dp.containsKey(root)) {
                    dp.put(x, dp.get(root) + 1);
                } else {
                    dp.put(x, 1);
                }

                // Step 3: Update maximum streak length
                if (dp.get(x) >= 2) {
                    maxLength = Math.max(maxLength, dp.get(x));
                }
            }

            return maxLength;
        }
    }

}
