class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0; // slow pointer

        for (int j = 0; j < nums.length; j++) { // fast pointer
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i; // length of array without 'val'
    }

    // Quick test
    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] nums = {3,2,2,3};
        int k = re.removeElement(nums, 3);
        System.out.println("New length: " + k);
        for (int idx = 0; idx < k; idx++) {
            System.out.print(nums[idx] + " ");
        }
        // Output: New length: 2 → [2,2]
    }
}
