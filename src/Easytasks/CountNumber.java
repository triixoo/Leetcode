package Easytasks;
import java.util.HashSet;
import java.util.Set;
public class CountNumber {
    class Solution{
        public int countConsistentStrings(String allowed, String[] words){
            Set<Character> allowset = new HashSet<>();
            for (char c : allowed.toCharArray()){
                allowset.add(c);
            }
            int count = 0;

            for (String word : words){
                boolean isConsistent = true;


                for (char c : word.toCharArray()){
                    if(!allowset.contains(c)){
                        isConsistent = false;
                        break;
                    }
                }
                if (isConsistent){
                    count++;
                }
            }
            return count;
        }
    }
}
