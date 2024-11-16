package Mediumtasks;

import java.util.Arrays;

public class CountFairPairs {
    class Solution{
        public int countFairPairs(int[] nums, int lower, int upper){
            Arrays.sort(nums);
            long count = 0;

            for (int i = 0; i < nums.length; i++) {
                int start = lowerBound(nums, i+ 1, nums.length-1, lower - nums[i]);
                int end = upperBound(nums, i + 1, nums.length - 1, upper - nums[i]);
                count += end - start + 1;
            }
            return (int)count;
        }
        private int lowerBound(int[] nums, int left, int right, int target){
            while (left < right){
                int mid = left + (right - left) / 2;
                if (nums[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            return left;
        }
        private int upperBound(int[] nums, int left, int right, int target){
            while (left <= right){
                int mid = left + (right - left) / 2;
                if (nums[mid] <= target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            return right;
        }
    }
}
