package Mediumtasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestChair {
    class Solution{
        public int smallestChair(int[][] times, int targetFriend) {
            int n = times.length;
            int[][] sortedTimes = new int[n][3];
            for (int i = 0; i < n; i++) {
                sortedTimes[i][0] = times[i][0];
                sortedTimes[i][1] = times[i][1];
                sortedTimes[i][2] = i;
            }
            Arrays.sort(sortedTimes, Comparator.comparingInt(a -> a[0]));

            PriorityQueue<Integer> availableTimes = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                availableTimes.offer(i);
            }
            PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            for(int[] time : sortedTimes) {
                int arrival = time[0];
                int leaving = time[1];
                int friend = time[2];
                while(!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] < arrival) {
                    int[] leavingInfo = occupiedChairs.poll();
                    availableTimes.offer(leavingInfo[1]);
                }
                int chair = availableTimes.poll();
                if(friend == targetFriend) {
                    return chair;
                }
                occupiedChairs.offer(new int[]{leaving, friend});
            }
            return -1;
        }
    }
}
