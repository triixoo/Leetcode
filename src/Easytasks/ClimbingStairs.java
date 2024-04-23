package Easytasks;
import java.util.Scanner;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClimbingStairs climbingStairs = new ClimbingStairs();

        System.out.print("Enter the number of steps: ");
        int n = scanner.nextInt();

        System.out.println("Number of distinct ways to climb to the top: " + climbingStairs.climbStairs(n));

        scanner.close();
    }
}
