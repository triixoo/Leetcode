package Easytasks;

public class MakeFancyString {
    public class Solution {
        public String makeFancyString(String s) {
            StringBuilder result = new StringBuilder();
            int count = 1;  // To keep track of consecutive characters

            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);
                int len = result.length();

                if (len > 0 && result.charAt(len - 1) == current) {
                    count++;  // Increment count if it's a repeat
                } else {
                    count = 1;  // Reset count if it's a different character
                }

                // Append the character if it doesn't make three consecutive ones
                if (count < 3) {
                    result.append(current);
                }
            }

            return result.toString();
        }
    }

}
