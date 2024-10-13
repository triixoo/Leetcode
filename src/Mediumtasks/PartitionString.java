package Mediumtasks;

import java.util.HashSet;

public class PartitionString {
    class Solution {
        public int partitionString(String s) {
            HashSet<Character> lookup = new HashSet();
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(lookup.contains(c)){
                    ans++;
                    lookup.clear();
                }
                lookup.add(c);
            }
            ans++;
            return ans;
        }
    }
}
