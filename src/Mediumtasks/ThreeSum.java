package Mediumtasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates for the first element

                int left = i + 1; // Initialize left pointer
                int right = nums.length - 1; // Initialize right pointer

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if (sum < 0) {
                        left++; // Move left pointer to the right
                    } else if (sum > 0) {
                        right--; // Move right pointer to the left
                    } else {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // Skip duplicates for the second element
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // Skip duplicates for the third element
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        // Move both pointers after processing duplicates
                        left++;
                        right--;
                    }
                }
            }
            return res; // Return the result list
        }
    }
}
