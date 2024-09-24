package Mediumtasks;

import java.util.Arrays;

public class Longest_Common_Prefix {
    class Solution {
        public int longestCommonPrefix(int[] arr1, int[] arr2) {
            String[] sArr1 = Arrays.stream(arr1).mapToObj(String::valueOf).toArray(String[]::new);
            String[] sArr2 = Arrays.stream(arr2).mapToObj(String::valueOf).toArray(String[]::new);
            Arrays.sort(sArr1);
            Arrays.sort(sArr2);
            int maxLength = 0;
            int i = 0, j = 0;
            while (i < sArr1.length && j < sArr2.length) {
                String s1 = sArr1[i];
                String s2 = sArr2[j];
                int commonLength = findCommonPrefixLength(s1, s2);
                maxLength = Math.max(maxLength, commonLength);
                if (s1.compareTo(s2) < 0) {
                    i++;
                } else {
                    j++;
                }
            }
            return maxLength;
        }

            private int findCommonPrefixLength (String s1, String s2){
                int minLength = Math.min(s1.length(), s2.length());
                int i = 0;
                while (i < minLength && s1.charAt(i) == s2.charAt(i)) {
                    i++;
                }
                return i;
            }
        }
    }

