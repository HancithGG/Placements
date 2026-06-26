public class Main {

    public static int sumRange(int[] nums, int left, int right) {

        int[] prefix = new int[nums.length];

        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        if (left == 0)
            return prefix[right];

        return prefix[right] - prefix[left - 1];
    }

    public static void main(String[] args) {

        int[] nums = {-2,0,3,-5,2,-1};

        System.out.println(sumRange(nums, 0, 2));
    }
}
