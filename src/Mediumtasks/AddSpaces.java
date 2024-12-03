package Mediumtasks;

public class AddSpaces {
    class Solution {
        public String addSpaces(String s, int[] spaces) {
            StringBuilder result = new StringBuilder();
            int spaceIndex = 0; // Pointer for the spaces array
            int n = spaces.length;

            for (int i = 0; i < s.length(); i++) {
                // If the current index matches the next space index, add a space
                if (spaceIndex < n && i == spaces[spaceIndex]) {
                    result.append(' ');
                    spaceIndex++;
                }
                // Add the current character from the string
                result.append(s.charAt(i));
            }

            return result.toString();
        }
    }

}
