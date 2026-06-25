class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // slow pointer

        for (int j = 1; j < nums.length; j++) { // fast pointer
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j]; // overwrite duplicate
            }
        }
        return i + 1; // length of unique part
    }

    // Quick test
    public static void main(String[] args) {
        RemoveDuplicatesSortedArray rd = new RemoveDuplicatesSortedArray();
        int[] nums = {1,1,2,2,3,3,4};
        int k = rd.removeDuplicates(nums);
        System.out.println("Unique count: " + k);
        for (int idx = 0; idx < k; idx++) {
            System.out.print(nums[idx] + " ");
        }
        // Output: Unique count: 4 → [1,2,3,4]
    }
}
