Sort an array containing only 0s, 1s and 2s in a single traversal without any built-in sort. 
 
Sample Input: arr = [2,0,2,1,1,0] Expected Output: [0, 0, 1, 1, 2, 2]

import java.util.Scanner;

public class Sort012 {

    public static void sortColors(int[] arr) {

        // Dutch National Flag Algorithm
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            // If element is 0
            if (arr[mid] == 0) {

                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low++;
                mid++;
            }

            // If element is 1
            else if (arr[mid] == 1) {
                mid++;
            }

            // If element is 2
            else {

                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input example: [2,0,2,1,1,0]
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

        // Sort array
        sortColors(arr);

        // Print sorted array
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
