package Mediumtasks;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    class Solution {
            public static final String[] KEYPAD = {
                    "",
                    "",
                    "abc",
                    "def",
                    "ghi",
                    "jkl",
                    "mno",
                    "pqrs",
                    "tuv",
                    "wxyz",
            };
        public List<String> letterCombtions(String digits) {
            List<String> result = new ArrayList<>();
            if(digits == null || digits.length() == 0) return result;
            backtrack(result, new StringBuilder(), digits, 0);
            return result;
        }
        private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
            if(index == digits.length()) {
                result.add(current.toString());
                return;
            }
            String letter = KEYPAD[digits.charAt(index - '0')];

            for (char letters : letter.toCharArray()){
                current.append(letters);
                backtrack(result, current, digits, index + 1);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}
