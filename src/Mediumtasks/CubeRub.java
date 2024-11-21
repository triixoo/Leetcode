package Mediumtasks;

public class CubeRub {
    class Solution {
        private static final int GUARD = 1;
        private static final int WALL = 2;
        private static final int GUARDED = 3;

        public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
            int[][] grid = new int[m][n];

            // Mark guards and walls on the grid
            for (int[] guard : guards) {
                grid[guard[0]][guard[1]] = GUARD;
            }
            for (int[] wall : walls) {
                grid[wall[0]][wall[1]] = WALL;
            }

            // Simulate guard vision
            for (int[] guard : guards) {
                int row = guard[0], col = guard[1];

                // Check all four directions
                markGuarded(grid, row, col, -1, 0); // Up
                markGuarded(grid, row, col, 1, 0);  // Down
                markGuarded(grid, row, col, 0, -1); // Left
                markGuarded(grid, row, col, 0, 1);  // Right
            }

            // Count unguarded cells
            int unguardedCount = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        unguardedCount++;
                    }
                }
            }

            return unguardedCount;
        }

        private void markGuarded(int[][] grid, int row, int col, int dRow, int dCol) {
            int m = grid.length, n = grid[0].length;
            row += dRow;
            col += dCol;

            while (row >= 0 && row < m && col >= 0 && col < n) {
                if (grid[row][col] == WALL || grid[row][col] == GUARD) {
                    break;
                }
                if (grid[row][col] == 0) {
                    grid[row][col] = GUARDED;
                }
                row += dRow;
                col += dCol;
            }
        }
    }

}
