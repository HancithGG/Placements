import java.util.Arrays;

public class Main {

    public static void threeSum(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    System.out.println(nums[i] + " " + nums[left] + " " + nums[right]);
                    return;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println("No triplet found");
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        threeSum(nums);
    }
}
