import java.util.Scanner;

public class MoveZeros {

    public static void moveZerosToEnd(int[] arr) {

        int index = 0;

        // Move non-zero elements forward
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        // Fill remaining positions with 0
        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input example: [0, 1, 0, 3, 12]
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

        // Move zeros
        moveZerosToEnd(arr);

        // Print array
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
