package Mediumtasks;

import java.util.Arrays;

public class ThreeSumClosest {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int closestSum = nums[0] + nums[1] + nums[2];

            for (int i = 1; i < nums.length - 2; i++) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int currSum = nums[i] + nums[left] + nums[right];
                    if (Math.abs(currSum - target) < Math.abs(closestSum - target))  {
                        closestSum = currSum;
                    }
                    if(currSum < target) {
                        left++;
                    } else if (currSum > target) {
                        right--;
                    }else {
                        return currSum;
                    }
                }
            }
            return closestSum;
        }
    }
}
