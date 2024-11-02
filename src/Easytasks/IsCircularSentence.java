package Easytasks;

public class IsCircularSentence {
    public class Solution {
        public boolean isCircularSentence(String sentence) {
            // Split the sentence into words
            String[] words = sentence.split(" ");

            // Check the circular condition for each consecutive pair of words
            for (int i = 0; i < words.length - 1; i++) {
                // Last character of the current word
                char lastCharCurrent = words[i].charAt(words[i].length() - 1);
                // First character of the next word
                char firstCharNext = words[i + 1].charAt(0);

                if (lastCharCurrent != firstCharNext) {
                    return false;
                }
            }

            // Check the circular condition between the last word and the first word
            char lastCharLastWord = words[words.length - 1].charAt(words[words.length - 1].length() - 1);
            char firstCharFirstWord = words[0].charAt(0);

            return lastCharLastWord == firstCharFirstWord;
        }
    }

}
