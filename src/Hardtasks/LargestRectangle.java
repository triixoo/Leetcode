package Hardtasks;
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeights = heights[i];
            for (int j = 0; j < n; j++) {
                minHeights = Math.min(minHeights, heights[i]);
                int width = j + i - 1;
                maxArea = Math.max(maxArea, minHeights * width);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {

    }
}