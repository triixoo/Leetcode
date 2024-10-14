package Mediumtasks;

import java.util.PriorityQueue;

public class MaxKelements {
    class Solution{
        public long maxKelements(int[] nums, int k) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
            for (int num : nums) {
                maxHeap.offer(num);
            }
            long score = 0;

            for (int i = 0; i < k; i++) {
                int maxVal = maxHeap.poll();

                score += maxVal;

                int newVal = (int) Math.ceil(maxVal / 3.0);
                maxHeap.offer(newVal);
            }
            return score;
        }
    }
}
