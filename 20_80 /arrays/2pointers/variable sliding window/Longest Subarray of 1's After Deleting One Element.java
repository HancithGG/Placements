class LongestSubarrayAfterDeletingOne {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int zeros = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }

            while (zeros > 1) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            // subtract 1 because we must delete one element
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubarrayAfterDeletingOne la = new LongestSubarrayAfterDeletingOne();
        int[] nums = {1,1,0,1};
        System.out.println(la.longestSubarray(nums)); // Output: 3
    }
}
