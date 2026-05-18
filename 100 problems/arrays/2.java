import java.util.Scanner;

public class MissingNumber {

    public static int findMissingNumber(int[] arr, int n) {

        // Sum of first N natural numbers
        int totalSum = n * (n + 1) / 2;

        // Sum of array elements
        int arrSum = 0;

        for (int num : arr) {
            arrSum += num;
        }

        // Missing number
        return totalSum - arrSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input example: [1, 2, 4, 5, 6]
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

        // Input N
        int n = sc.nextInt();

        int result = findMissingNumber(arr, n);

        System.out.println(result);

        sc.close();
    }
}
