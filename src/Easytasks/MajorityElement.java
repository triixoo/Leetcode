package Easytasks;

public class MajorityElement {
    class Solution {
        public int majorityElement(int[] nums) {
            int candidate = nums[0];  // Assume the first element is the candidate
            int count = 0;

            // Boyer-Moore Voting Algorithm
            for (int num : nums) {
                if (count == 0) {
                    candidate = num;  // Set the current number as the new candidate
                }
                count += (num == candidate) ? 1 : -1;  // Increment or decrement count
            }

            return candidate;
        }
    }

}
