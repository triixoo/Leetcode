package Mediumtasks;

import java.util.HashMap;

public class MinSubarray {
    public int minSubarray(int[] nums, int p) {
        // Step 1: Calculate total sum of the array
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: Calculate the target remainder
        int target = (int)(totalSum % p);
        if (target == 0) return 0;  // If the sum is already divisible by p

        // Step 3: Use a hashmap to store the prefix sums' mod values
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1);  // Initial condition to handle full prefix
        int minLength = nums.length;
        long prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int modValue = (int)(prefixSum % p);

            // Find the modValue we need to remove
            int requiredMod = (modValue - target + p) % p;

            if (prefixMap.containsKey(requiredMod)) {
                minLength = Math.min(minLength, i - prefixMap.get(requiredMod));
            }

            // Store the current prefix sum mod with its index
            prefixMap.put(modValue, i);
        }

        // If we found a valid subarray to remove
        return (minLength == nums.length) ? -1 : minLength;
    }
}
