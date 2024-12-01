package Mediumtasks;
import java.util.HashSet;
public class СheckIfExist {
    class Solution {
        public boolean checkIfExist(int[] arr) {
            HashSet<Integer> seen = new HashSet<>();

            for (int num : arr) {
                // Check if the current number satisfies either condition
                if (seen.contains(2 * num) || (num % 2 == 0 && seen.contains(num / 2))) {
                    return true;
                }
                // Add the current number to the set
                seen.add(num);
            }

            return false; // No such pair found
        }
    }

}
