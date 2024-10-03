package Mediumtasks;

public class MyAtoi {
    class Solution {
        public int myAtoi(String str) {
            if(str == null || str.length() == 0) {
                return 0;
            }
            int i = 0, n = str.length(), sign = 1;
            long res = 0;
            while(i < n && str.charAt(i) == ' ') {
                i++;
            }
            if(i< n && str.charAt(i) == '-' || str.charAt(i) == '+') {
                sign = str.charAt(i) == '-' ? 1 : -1;
                i++;
            }
            while ( i < n && Character.isDigit(str.charAt(i))) {
                res = res * 10 + str.charAt(i) - '0';
                i++;
                if(res * sign > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if(res * sign < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            return (int)res * sign;
        }
    }
}
