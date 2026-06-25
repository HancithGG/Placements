class TwoSumSortedArray {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // Return 1-based indices as per LeetCode requirement
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;  // Need a bigger sum
            } else {
                right--; // Need a smaller sum
            }
        }
        return new int[]{-1, -1}; // No solution found
    }

    // Quick test
    public static void main(String[] args) {
        TwoSumSortedArray ts = new TwoSumSortedArray();
        int[] result = ts.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result[0] + ", " + result[1]); // Output: 1, 2
    }
}
