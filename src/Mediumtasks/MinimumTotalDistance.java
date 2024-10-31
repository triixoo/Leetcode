package Mediumtasks;
import java.util.*;
public class MinimumTotalDistance {
    class Solution {
        public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
            Collections.sort(robot);
            Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

            int n = robot.size();
            int m = factory.length;

            long[][] dp = new long[m + 1][n + 1];

            // Initialize dp array with large values
            for (int i = 0; i <= m; i++) {
                Arrays.fill(dp[i], Long.MAX_VALUE);
            }
            dp[0][0] = 0;

            // DP to calculate minimum distance
            for (int j = 1; j <= m; j++) {
                dp[j][0] = 0; // No robots assigned to this factory
                for (int i = 1; i <= n; i++) {
                    dp[j][i] = dp[j - 1][i]; // Case where no robots are assigned to this factory
                    long totalDistance = 0;

                    for (int k = 1; k <= factory[j - 1][1] && i - k >= 0; k++) {
                        totalDistance += Math.abs(robot.get(i - k) - factory[j - 1][0]);
                        if (dp[j - 1][i - k] != Long.MAX_VALUE) {
                            dp[j][i] = Math.min(dp[j][i], dp[j - 1][i - k] + totalDistance);
                        }
                    }
                }
            }

            return dp[m][n];
        }
    }

}
