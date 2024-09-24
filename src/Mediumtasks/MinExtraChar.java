package Mediumtasks;
import java.util.HashSet;
import java.util.Set;

public class MinExtraChar {
    public class Solution {
        public int minExtraChar(String s, String[] dictionary) {
            int n = s.length();
            Set<String> dict = new HashSet<>();

            // Add all dictionary words to a set for O(1) look-up time.
            for (String word : dictionary) {
                dict.add(word);
            }

            // dp[i] will store the minimum extra characters in the first i characters of s
            int[] dp = new int[n + 1];

            // Initialize all dp values to a large number
            for (int i = 0; i <= n; i++) {
                dp[i] = i;  // At most, all characters are unused, so the max value for dp[i] is i
            }

            dp[0] = 0;  // Base case: No extra characters when the string is empty

            // Process the string s from left to right
            for (int i = 1; i <= n; i++) {
                // Try to take each substring ending at i
                for (int j = 0; j < i; j++) {
                    // Substring s[j:i]
                    String sub = s.substring(j, i);
                    if (dict.contains(sub)) {
                        // If the substring is in the dictionary, no extra characters for this segment
                        dp[i] = Math.min(dp[i], dp[j]);
                    }
                }
                // Otherwise, if no valid substring found, the extra character at index i-1 is counted
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }

            // The result is the minimum extra characters needed for the entire string
            return dp[n];
        }
    }

}
