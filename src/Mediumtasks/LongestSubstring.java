package Mediumtasks;
import java.util.HashSet;

public class LongestSubstring {
    static class Solution {
        public int lengthOfLongestSubstring(String s){
            HashSet<Character> set = new HashSet<>();
            int maxLength = 0;
            int start = 0;

            for (int end = 0; end< s.length(); end++){
                char currentChar = s.charAt(end);


                while(set.contains(currentChar)){
                    set.remove(s.charAt(start));
                    start++;

                }
                set.add(currentChar);
                maxLength = Math.max(maxLength, end - start + 1 );
            }
            return maxLength;
            }
    }
}
