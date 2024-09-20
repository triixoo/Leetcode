package Mediumtasks;

import java.util.Arrays;

public class Largest_Number {
    class Solution{
        public String largestNumber(int[] nums){
            String[] array = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                array[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(array, (a, b) -> (b+a).compareTo(a + b));
            if (array[0].equals("0")){
                return "0";
            }
            StringBuilder largestNumber = new StringBuilder();
            for (String s : array) {
                largestNumber.append(s);
            }
            return largestNumber.toString();
        }

    }
}
