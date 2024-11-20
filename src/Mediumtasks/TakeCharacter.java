package Mediumtasks;
import java.util.HashMap;
import java.util.Map;
public class TakeCharacter {
    class Solution {
        public int takeCharacters(String s, int k) {
            int n = s.length();
            Map<Character, Integer> totalCount = new HashMap<>();
            totalCount.put('a', 0);
            totalCount.put('b', 0);
            totalCount.put('c', 0);

            // Count total occurrences of each character
            for (char c : s.toCharArray()) {
                totalCount.put(c, totalCount.get(c) + 1);
            }

            // Check if it's possible to satisfy the condition
            for (char c : "abc".toCharArray()) {
                if (totalCount.get(c) < k) {
                    return -1; // Not enough characters to satisfy the condition
                }
            }

            // Sliding window to find the largest valid middle substring
            int maxMiddle = 0;
            Map<Character, Integer> currentCount = new HashMap<>();
            currentCount.put('a', 0);
            currentCount.put('b', 0);
            currentCount.put('c', 0);

            int left = 0;
            for (int right = 0; right < n; right++) {
                char c = s.charAt(right);
                currentCount.put(c, currentCount.get(c) + 1);

                // Ensure that the window is valid
                while (currentCount.get('a') > totalCount.get('a') - k ||
                        currentCount.get('b') > totalCount.get('b') - k ||
                        currentCount.get('c') > totalCount.get('c') - k) {
                    char leftChar = s.charAt(left);
                    currentCount.put(leftChar, currentCount.get(leftChar) - 1);
                    left++;
                }

                maxMiddle = Math.max(maxMiddle, right - left + 1);
            }

            return n - maxMiddle;
        }
    }

}
