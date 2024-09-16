package Mediumtasks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class MIn_Time_Difference {
    class Solution{
        public int findMinDifference(List<String> timePoints){
            List<Integer> minList = new ArrayList<>();
            for (String time : timePoints){
                String[] parts = time.split(":");
                int hours = Integer.parseInt(parts[0]);
                int minutes = Integer.parseInt(parts[1]);
                minList.add(hours * 60 + minutes);
            }
            Collections.sort(minList);
            int minDifference = Integer.MAX_VALUE;
            for (int i = 1; i < minList.size(); i++) {
                minDifference = Math.min(minDifference, minList.get(i) - minList.get(i-1));
            }
            int lastDifference = 1440 - minList.get(minList.size() - 1) + minList.get(0);
            minDifference = Math.min(minDifference, lastDifference);
            return minDifference;
        }
    }
}
