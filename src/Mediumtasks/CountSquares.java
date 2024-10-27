package Mediumtasks;

public class CountSquares {
    class Solution {
        public int countSquares(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            int[][] dp = new int[rows][cols];
            int totalSquares = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // Only calculate if the current cell is 1
                    if (matrix[i][j] == 1) {
                        if (i == 0 || j == 0) {
                            dp[i][j] = 1;  // Edges can only form squares of size 1
                        } else {
                            dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                        }
                        totalSquares += dp[i][j];
                    }
                }
            }

            return totalSquares;
        }
    }

}
