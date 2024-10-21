package Mediumtasks;
import java.util.HashSet;
import java.util.Set;

public class MaxUniqueSplit {
    class Solution {
        int maxSplits = 0;  // To keep track of the maximum number of unique substrings

        public int maxUniqueSplit(String s) {
            Set<String> seen = new HashSet<>();
            backtrack(s, 0, seen);
            return maxSplits;
        }

        private void backtrack(String s, int start, Set<String> seen) {
            if (start == s.length()) {
                // If we have reached the end of the string, update the maximum splits
                maxSplits = Math.max(maxSplits, seen.size());
                return;
            }

            // Early termination: If the current size of 'seen' plus remaining characters
            // can't exceed the current maxSplits, we can return early
            if (seen.size() + (s.length() - start) <= maxSplits) {
                return;
            }

            // Try splitting the string at every possible position from `start` to the end
            for (int end = start + 1; end <= s.length(); end++) {
                String substring = s.substring(start, end);

                // If the substring is unique, add it to the set and continue splitting
                if (!seen.contains(substring)) {
                    seen.add(substring);
                    backtrack(s, end, seen);  // Recurse on the remaining part of the string
                    seen.remove(substring);   // Backtrack by removing the substring
                }
            }
        }
    }
}
