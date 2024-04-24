package Hardtasks;

import java.util.Scanner;
public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            // Update the heights array for each row
            for (int j = 0; j < cols; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            // Calculate the maximal area for each row
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        int[] stack = new int[n + 1];
        int top = -1;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (top != -1 && h < heights[stack[top]]) {
                int height = heights[stack[top--]];
                int width = (top == -1) ? i : i - stack[top] - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack[++top] = i;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        char[][] matrix = new char[rows][cols];
        System.out.println("Enter the elements of the matrix (0 or 1):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.next().charAt(0);
            }
        }

        System.out.println("Largest rectangle area containing only 1's: " + maximalRectangle(matrix));

        scanner.close();
    }
}