✅ Problem: Remove Duplicates from Sorted Array

Given a sorted array, remove duplicates in-place such that each unique element appears only once.

Return the number of unique elements.

Sample Input
[1,1,2,2,3,4,4]
Expected Output
Unique Elements:
[1,2,3,4]

Count:
4

  import java.util.Scanner;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] arr) {

        // If array is empty
        if (arr.length == 0) {
            return 0;
        }

        int index = 1;

        for (int i = 1; i < arr.length; i++) {

            // New unique element found
            if (arr[i] != arr[i - 1]) {

                arr[index] = arr[i];

                index++;
            }
        }

        return index;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input example: [1,1,2,2,3,4,4]
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

        int count = removeDuplicates(arr);

        // Print unique elements
        System.out.print("[");

        for (int i = 0; i < count; i++) {

            System.out.print(arr[i]);

            if (i != count - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

        System.out.println("Count = " + count);

        sc.close();
    }
}
