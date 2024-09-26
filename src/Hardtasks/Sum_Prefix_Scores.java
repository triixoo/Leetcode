package Hardtasks;
public class Sum_Prefix_Scores {
    class TrieNode {
        TrieNode[] children;
        int count;

        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
                node.count++;
            }
        }

        int getPrefixScore(String word) {
            TrieNode node = root;
            int score = 0;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                node = node.children[index];
                score += node.count;
            }
            return score;
        }
    }

    class Solution {
        public int[] sumPrefixScores(String[] words) {
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }

            int[] result = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                result[i] = trie.getPrefixScore(words[i]);
            }

            return result;
        }
    }
}