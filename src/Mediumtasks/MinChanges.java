package Mediumtasks;

public class MinChanges {
    class Solution{
        public int minChange(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(i + 1)) {
                    count++;
                }
            }
            return count;
        }
    }
}
