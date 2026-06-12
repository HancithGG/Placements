public class ArrayPalindrome {
    public static boolean isPalindrome(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                return false; // mismatch found
            }
            left++;
            right--;
        }
        return true; // all matched
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 1};
        int[] arr2 = {1, 2, 3, 4, 5};

        System.out.println(isPalindrome(arr1)); // true
        System.out.println(isPalindrome(arr2)); // false
    }
}
