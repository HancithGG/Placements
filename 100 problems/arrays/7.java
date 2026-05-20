//Given an array where 1 <= a[i] <= n, find all elements that appear more than once. Return them in any order. 
Sample Input: arr = [4,3,2,7,8,2,3,1] Expected Output: [2, 3]


import java.util.ArrayList;
import java.util.Scanner;

public class FindDuplicates {

    public static ArrayList<Integer> findDuplicates(int[] arr) {

        ArrayList<Integer> result = new ArrayList<>();

        // Mark visited indices
        for (int i = 0; i < arr.length; i++) {

            int index = Math.abs(arr[i]) - 1;

            // Already negative => duplicate found
            if (arr[index] < 0) {
                result.add(index + 1);
            }

            // Mark as visited
            else {
                arr[index] = -arr[index];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input example: [4,3,2,7,8,2,3,1]
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

        ArrayList<Integer> duplicates = findDuplicates(arr);

        System.out.println(duplicates);

        sc.close();
    }
}
