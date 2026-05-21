Given an array and a target, return the indices of the two numbers that add up to the target. Assume exactly one 
solution exists. 
Sample Input: nums = [2,7,11,15], target = 9 
Expected Output: [0, 1]

import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            // If complement already exists
            if (map.containsKey(complement)) {

                return new int[]{map.get(complement), i};
            }

            // Store number and index
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input example: [2,7,11,15]
        String str = sc.nextLine().trim();

        // Remove brackets
        str = str.replace("[", "").replace("]", "");

        // Split values
        String[] str1 = str.split(",");

        // Create array
        int[] nums = new int[str1.length];

        // Convert string to integer
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(str1[i].trim());
        }

        // Input target
        int target = sc.nextInt();

        int[] result = twoSum(nums, target);

        // Print result
        System.out.println("[" + result[0] + ", " + result[1] + "]");

        sc.close();
    }
}
