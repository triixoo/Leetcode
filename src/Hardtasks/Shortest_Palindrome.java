package Hardtasks;

public class Shortest_Palindrome {
    public class Solution {
        public String shortestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }

            String reversed = new StringBuilder(s).reverse().toString();
            String combined = s + "#" + reversed;

            int[] kmpTable = buildKMPTable(combined);
            int longestPalindromePrefix = kmpTable[combined.length() - 1];

            String suffixToAdd = reversed.substring(0, s.length() - longestPalindromePrefix);
            return suffixToAdd + s;
        }

        private int[] buildKMPTable(String s) {
            int[] table = new int[s.length()];
            int j = 0;

            for (int i = 1; i < s.length(); i++) {
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = table[j - 1];
                }
                if (s.charAt(i) == s.charAt(j)) {
                    j++;
                }
                table[i] = j;
            }

            return table;
        }
    }

}
