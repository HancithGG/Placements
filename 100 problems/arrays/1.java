import java.util.Scanner;

public class SecondLargestDistinct {

    public static int findSecondLargest(int[] arr) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {

            if (num > largest) {
                secondLargest = largest;
                largest = num;
            }

            else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            return -1;
        }

        return secondLargest;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input example: [12, 35, 1, 10, 34, 1]
        String str = sc.nextLine().trim();

        // Remove brackets
        str = str.replace("[", "").replace("]", "");

        // Split values using comma
        String[] str1 = str.split(",");

        // Create integer array
        int[] arr = new int[str1.length];

        // Convert string values to integers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str1[i].trim());
        }

        // Find second largest distinct element
        int result = findSecondLargest(arr);

        System.out.println(result);

        sc.close();
    }
}
