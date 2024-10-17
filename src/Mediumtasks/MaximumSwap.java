package Mediumtasks;

public class MaximumSwap {
    class Solution{
        public int maximumSwap(int num) {
            char[] digits = Integer.toString(num).toCharArray();
            int[] lastIndex = new int[10];

            for (int i = 0; i < digits.length; i++) {
                lastIndex[digits[i] - '0']++;
            }
            for (int i = 0; i < digits.length; i++) {
                for (int j = 9; j> digits[i] - '0' ; j--) {
                    if(lastIndex[j] > 0){
                        char temp = digits[i];
                        digits[i] = digits[lastIndex[j]];
                        digits[lastIndex[j]] = temp;

                        return Integer.parseInt(new String(digits));
                    }
                }
            }
            return num;
        }
    }
}
