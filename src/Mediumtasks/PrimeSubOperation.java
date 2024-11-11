package Mediumtasks;

import java.util.ArrayList;
import java.util.List;

public class PrimeSubOperation {
    class Solution {
        public boolean primeSubOperation(int[] nums) {
            List<Integer> primes = new ArrayList<>();
            for (int i = nums.length - 1; i > 0; i++) {
                if(nums[i] < nums[i-1]) {
                    boolean found = false;
                    for (int p : primes) {
                        if (p< nums[i-1] && nums[i-1] -p > nums[i]-2) {
                            nums[i-1] -= p;
                            found = true;
                            break;
                        }
                    }
                    if(!found) return false;
                }
            }
            return true;
        }
        private List<Integer> sieveOfEratosthenes(int limit) {
            boolean[] isPrime = new boolean[limit + 1];
            List<Integer> primes = new ArrayList<>();
            for (int i = 2; i <= limit; i++) isPrime[i] = true;
            for (int i = 2; i * i < limit ; i++) {
                if(isPrime[i]){
                    for (int j = i*i; j <=limit  ; j+=i) {
                        isPrime[j] = false;
                    }
                }
            }
            for (int i = 2; i <= limit; i++) {
                if(isPrime[i]) primes.add(i);
            }
            return primes;
        }


    }
}
