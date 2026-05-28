✅ Problem: Maximum Average Subarray I

Given an integer array nums and an integer k,
find the contiguous subarray of size k that has the maximum average.

Return the maximum average.

Sample Input
nums = [1,12,-5,-6,50,3]
k = 4
Expected Output
12.75

Because:

[12,-5,-6,50]

Sum:

51

Average:

51 / 4 = 12.75

import java.util.Scanner;

public class MaximumAverageSubarray {

    public static double findMaxAverage(int[] nums, int k) {

        int windowSum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // Sliding window
        for (int i = k; i < nums.length; i++) {

            windowSum = windowSum - nums[i - k] + nums[i];  //💡💡💡💡

            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input example: [1,12,-5,-6,50,3]
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

        int k = sc.nextInt();

        double result = findMaxAverage(nums, k);

        System.out.println(result);

        sc.close();
    }
}
