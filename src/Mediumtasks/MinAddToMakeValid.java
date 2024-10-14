package Mediumtasks;
public class MinAddToMakeValid {
    class Solution {
        public int minAddToMakeValid(String s) {
            int openBrackets = 0; // Tracks unmatched '('
            int unmatchedClose = 0; // Tracks unmatched ')'

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    openBrackets++;
                } else if (c == ')') {
                    if (openBrackets > 0) {
                        openBrackets--; // We have a matching '('
                    } else {
                        unmatchedClose++; // We have an unmatched ')'
                    }
                }
            }

            // The result is the sum of unmatched '(' and unmatched ')'
            return openBrackets + unmatchedClose;
        }
    }

}

