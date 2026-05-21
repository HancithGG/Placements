Find the contiguous subarray which has the largest product and return that product. Array may contain negatives and 
zeros. 
 
Sample Input: arr = [2,3,-2,4] Expected Output: 6

  import java.util.Scanner;

public class MaximumProductSubarray {

    public static int maxProduct(int[] arr) {

        int maxProduct = arr[0];
        int currentMax = arr[0];
        int currentMin = arr[0];

        for (int i = 1; i < arr.length; i++) {

            // If number is negative, swap max and min
            if (arr[i] < 0) {

                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            // Find current maximum product
            currentMax = Math.max(arr[i], currentMax * arr[i]);

            // Find current minimum product
            currentMin = Math.min(arr[i], currentMin * arr[i]);

            // Update answer
            maxProduct = Math.max(maxProduct, currentMax);
        }

        return maxProduct;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input example: [2,3,-2,4]
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

        int result = maxProduct(arr);

        System.out.println(result);

        sc.close();
    }
}
