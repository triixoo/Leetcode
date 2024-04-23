package Easytasks;

import java.util.Scanner;

public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;


        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.insert(0, sum % 2);
            carry = sum / 2;
        }


        if (carry > 0) {
            sb.insert(0, carry);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter binary string a: ");
        String a = scanner.nextLine();

        System.out.print("Enter binary string b: ");
        String b = scanner.nextLine();

        System.out.println("Sum of " + a + " and " + b + " is: " + addBinary(a, b));

        scanner.close();
    }
}
