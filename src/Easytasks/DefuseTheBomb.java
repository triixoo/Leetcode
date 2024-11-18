package Easytasks;

public class DefuseTheBomb {
    class Solution {
        public int[] decrypt(int[] code, int k) {
            int n = code.length;
            int[] result = new int[n];

            if (k == 0) {
                return result; // All elements are replaced with 0
            }

            int start, end, step;
            if (k > 0) {
                start = 1;
                end = k;
                step = 1;
            } else {
                start = -1;
                end = k;
                step = -1;
            }

            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = start; j != end + step; j += step) {
                    int index = (i + j + n) % n; // Circular indexing
                    sum += code[index];
                }
                result[i] = sum;
            }

            return result;
        }
    }

}
