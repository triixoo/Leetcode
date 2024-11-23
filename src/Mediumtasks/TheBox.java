package Mediumtasks;

public class TheBox {
    class Solution {
        public char[][] rotateTheBox(char[][] box) {
            int m = box.length;    // Number of rows
            int n = box[0].length; // Number of columns

            // Simulate gravity for each row
            for (int i = 0; i < m; i++) {
                int write = n - 1; // Start from the rightmost position
                for (int j = n - 1; j >= 0; j--) {
                    if (box[i][j] == '*') {
                        write = j - 1; // Reset write pointer to just before the obstacle
                    } else if (box[i][j] == '#') {
                        box[i][j] = '.';    // Mark current position as empty
                        box[i][write] = '#'; // Move the stone to the write pointer
                        write--;             // Update write pointer
                    }
                }
            }

            // Rotate the box 90 degrees clockwise
            char[][] rotated = new char[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    rotated[j][m - 1 - i] = box[i][j];
                }
            }

            return rotated;
        }
    }

}
