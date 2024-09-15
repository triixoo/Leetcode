package Mediumtasks;

import java.util.HashMap;
import java.util.Map;

public class Find_The_Longest_Substring {
    class Solution{
        public int findTheLongestSubstring(String s){
            Map<Character, Integer> text = Map.of('a', 1, 'e', 2,'i', 4, 'o', 8,'u', 16);
            Map<Integer, Integer> maxIndex = new HashMap<>();
            maxIndex.put(0, -1);
            int mask =0, maxLength = 0;
            for (int i = 0; i < s.length(); i++) {
                if (text.containsKey(s.charAt(i))) mask ^= text.get(s.charAt(i));
                maxIndex.putIfAbsent(mask,i);
                maxLength = Math.max(maxLength, i - maxIndex.get(mask));
            }
            return maxLength;
        }
    }
}
