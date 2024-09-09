package Mediumtasks;

import java.util.Arrays;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class SpiralTasks {
    class Solution{
        public int[][] spiralMatrix(int m, int n, ListNode head){
        int[][] spiralMatrix = new int[m][n];
           for(int[] row : spiralMatrix){
               Arrays.fill(row, -1);
           }
           int top = 0, bottom = m -1;
           int left = 0, right = n - 1;

           ListNode current = head;

           while (current != null&& top <= bottom && left<= right){
               for (int i = left; i <= right && current!=null; i++) {
                   spiralMatrix[top][i] = current.val;
                   current = current.next;
               }
               top++;
               for (int i = top; i <= bottom && current!=null; i++) {
                   spiralMatrix[i][right] = current.val;
                   current = current.next;
               }
               right--;
               for (int i = right; i >= left && current !=null; i++) {
                   spiralMatrix[bottom][i] = current.val;
                   current = current.next;
               }
               bottom--;
               for (int i = bottom; i >= top && current!= null ; i++) {
                   spiralMatrix[i][left] = current.val;
                   current = current.next;
               }
               left++;
           }
           return spiralMatrix;
        }
    }
}
