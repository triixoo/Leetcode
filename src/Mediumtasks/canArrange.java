package Mediumtasks;
public class canArrange {
    class Solution {
        public boolean canArrange(int[] arr, int k) {
            int[] remainderFreq = new int[k];

            // Calculate frequency of remainders
            for (int num : arr) {
                int remainder = ((num % k) + k) % k;  // To handle negative numbers
                remainderFreq[remainder]++;
            }

            // Check remainder 0: it should have an even count (because they must pair with each other)
            if (remainderFreq[0] % 2 != 0) {
                return false;
            }

            // Check the pairs of remainders from 1 to k/2
            for (int i = 1; i <= k / 2; i++) {
                if (remainderFreq[i] != remainderFreq[k - i]) {
                    return false;
                }
            }

            return true;
        }
    }
}
