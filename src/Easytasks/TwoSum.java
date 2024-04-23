package Easytasks;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter array length: ");
            int length = scanner.nextInt();
            int[] nums = new int[length];
            System.out.println("Enter Array Elements:");
            for (int i = 0; i < length; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.print("Enter target value: ");
            int target = scanner.nextInt();
            int[] result = TwoSum.twoSum(nums, target);
            System.out.println("Result: [" + result[0] + ", " + result[1] + "]");

            scanner.close();
        }
    }
}