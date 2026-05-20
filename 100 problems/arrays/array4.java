//Rotate the array to the right by K positions. Use the three-reversal technique for O(1) space. 
Expected Output: [5, 6, 7, 1, 2, 3, 4], K = 3 Sample Input: arr = [1,2,3,4,5,6,7]


import java.util.Scanner;

public class RotateArray {

    // Reverse function
    public static void reverse(int[] arr, int start, int end) {

        while (start < end) {

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    // Rotate array to right by k positions
    public static void rotateArray(int[] arr, int k) {

        int n = arr.length;

        // Handle cases where k > n
        k = k % n;

        // Three reversal technique
        reverse(arr, 0, n - 1);

        reverse(arr, 0, k - 1);

        reverse(arr, k, n - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input example: [1,2,3,4,5,6,7]
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

        // Input k
        int k = sc.nextInt();

        // Rotate array
        rotateArray(arr, k);

        // Print rotated array
        System.out.print("[");

        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i]);

            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

        sc.close();
    }
}
