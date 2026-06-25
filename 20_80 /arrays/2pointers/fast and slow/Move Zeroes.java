class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int slow = 0; // position to place next non-zero

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                // Swap non-zero forward
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
        }
    }

    // Quick test
    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] nums = {0,1,0,3,12};
        mz.moveZeroes(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
        // Output: [1,3,12,0,0]
    }
}
