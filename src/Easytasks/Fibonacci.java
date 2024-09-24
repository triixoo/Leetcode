package Easytasks;
public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n; // Base cases: fibonacci(0) = 0, fibonacci(1) = 1
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // Recursive calls
    }

    public static void main(String[] args) {
        int n = 15; // Example input
        System.out.println("Fibonacci iz " + n + " eto: " + fibonacci(n));
    }
}

