package Mediumtasks;

import java.util.ArrayList;
import java.util.List;

public class MinGroups {
    class Solution{
        public int minGroups(int[][] intervals) {
            List<int[]> events = new ArrayList<>();
            for(int[] interval : intervals){
                events.add(new int[]{interval[0], 1});  // Starting an interval
                events.add(new int[]{interval[1] + 1, -1});
            }
            events.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
            int maxGroups = 0;
            int activeInterval = 0;
            for(int[] event : events){
                activeInterval += event[1];
                maxGroups = Math.max(maxGroups, activeInterval);
            }
            return maxGroups;
        }
    }
}
