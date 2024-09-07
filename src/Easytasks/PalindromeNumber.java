package Easytasks;

import java.util.HashMap;
import java.util.Scanner;

public class PalindromeNumber {
    class Solution{
        public boolean isPalindrome(int x){
            if (x< 0 || x%10 == 0 && x !=0 ){
                return false;
            }
            int reversed = 0;
            int original = x;

            while (x > reversed){
                int LastDigit = x %10;
                reversed = reversed * 10 + LastDigit;
                x /=10;
            }
            return x == reversed || x == reversed / 10;
        }
    }
}
