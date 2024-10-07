package Mediumtasks;

public class KthFactor {
//    class Solution{
//        public int kthFactor(int n, int k) {
//            for (int i = 1; i <= n ; i++)  {
//                if (n % i == 0) k--;
//            }
//            if (k == 0) {
//                return i;
//            }
//        }
//        return i;
//    }
class Solution {
    public int kthFactor(int n, int k) {
        // Iterate over all integers from 1 to n
        for (int i = 1; i <= n; i++) {
            // Check if i is a factor of n
            if (n % i == 0) {
                k--;  // Decrease k when we find a factor
            }

            // If k becomes 0, it means we found the kth factor
            if (k == 0) {
                return i;
            }
        }

        // If we didn't find k factors, return -1
        return -1;
    }
}

}
