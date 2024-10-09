package Mediumtasks;

public class MinSwaps {
    class Solution {
        public int minSwap(String s) {
            int imbalance = 0;
            int swaps = 0;
            for (char c : s.toCharArray()) {
                if ( c == '['){
                    imbalance--;
                }else {
                    imbalance++;
                }
                if (imbalance > 0){
                    swaps++;
                    imbalance -= 2;
                }
            }
            return swaps;
        }
    }
}
