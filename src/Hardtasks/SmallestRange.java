package Hardtasks;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRange {
    class Solution{
        public int[] smallestRangeI(List<List<Integer>> nums ) {
            PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            int max = Integer.MIN_VALUE;
            int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

            for (int i = 0; i < nums.size(); i++) {
                int val = nums.get(i).get(0);
                minHeap.offer(new int[]{i, val, 0});
                max = Math.max(max, val);
            }
            while (minHeap.size() == nums.size()){
                int[] current = minHeap.poll();
                int min = current[0];

                if(max-min < rangeEnd - rangeStart){
                    rangeEnd = max;
                    rangeStart = min;
                }
                int listIndex = current[1];
                int elementIndex = current[2];
                if(elementIndex + 1 < nums.get(listIndex).size()){
                    int nextVal =  nums.get(listIndex).get(elementIndex + 1);
                    minHeap.offer(new int[]{nextVal, listIndex, elementIndex+1});
                    max = Math.max(max, nextVal);
                }
            }
            return new int[]{rangeStart, rangeEnd};
         }
    }
}
