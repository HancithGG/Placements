import java.util.Scanner;

public class MajorityElement {

    public static int findMajorityElement(int[] arr) {

        // Boyer-Moore Voting Algorithm
        int candidate = 0;
        int count = 0;

        for (int num : arr) {

            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input example: [3, 2, 3]
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

        int result = findMajorityElement(arr);

        System.out.println(result);

        sc.close();
    }
}
