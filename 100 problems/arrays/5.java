Find the contiguous subarray which has the largest sum and return that sum. 
  Sample Input: arr = [-2,1,-3,4,-1,2,1,-5,4] Expected Output: 6

  import java.util.Scanner;

public class MaximumSubarraySum {

    public static int maxSubarraySum(int[] arr) {

        // Kadane's Algorithm
        int currentSum = arr[0];
        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {

            currentSum = Math.max(arr[i], currentSum + arr[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input example: [-2,1,-3,4,-1,2,1,-5,4]
        String str = sc.nextLine().trim();

        // Remove brackets
        str = str.replace("[", "").replace("]", "");

        // Split values
        String[] str1 = str.split(",");

        // Create array
        int[] arr = new int[str1.length];

        // Convert string to integer
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str1[i].trim());
        }

        int result = maxSubarraySum(arr);

        System.out.println(result);

        sc.close();
    }
}
