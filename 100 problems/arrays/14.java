import java.util.Scanner;

public class CountOccurrences {

    // Find first occurrence
    public static int firstOccurrence(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;
                high = mid - 1; // move left
            }

            else if (arr[mid] < target) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return result;
    }

    // Find last occurrence
    public static int lastOccurrence(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;
                low = mid + 1; // move right
            }

            else if (arr[mid] < target) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static int countOccurrences(int[] arr, int target) {

        int first = firstOccurrence(arr, target);

        // Target not found
        if (first == -1) {
            return 0;
        }

        int last = lastOccurrence(arr, target);

        return last - first + 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input example: [1,2,2,2,3,4]
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

        // Input target
        int target = sc.nextInt();

        int result = countOccurrences(arr, target);

        System.out.println(result);

        sc.close();
    }
}
