package Easytasks;

import java.util.HashMap;
import java.util.Scanner;

public class RomantoInteger {
    Scanner scanner =  new Scanner(System.in);
    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;


        for (int i = 0; i < s.length(); i++) {
            int current = romanMap.get(s.charAt(i));

            if (i + 1<s.length()){
                int next = romanMap.get(s.charAt(i+1));
                if (current<next){
                    result -= current;
                }else{
                    result += current;
                }
            }else{
                result +=current;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter number = ");
        String roman = scanner1.nextLine();
        int result = romanToInt(roman);
        System.out.println("Roman number " + roman + " = " + result);
    }
    }