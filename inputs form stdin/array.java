// goal is to take inputs in this format [1, 2, 3, 4, 5] and store them in array
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the entire line as a string (example: [1, 2, 3, 4, 5])
        String str = sc.nextLine().trim();

        // Remove the square brackets -> "1, 2, 3, 4, 5"
        str = str.replace("[", "").replace("]", "");

        // Split by comma -> {"1", " 2", " 3", " 4", " 5"}
        String[] str1 = str.split(",");

        // Create an integer array of the same length
        int[] arr = new int[str1.length];

        // Convert each string element to integer
        // Use trim() to remove spaces around numbers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str1[i].trim());
        }

        // Print the array elements one by one
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
