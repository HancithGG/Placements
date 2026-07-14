class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
          return 0;
        int write = 0; // next position to write unique element
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[read - 1]) {
                nums[write] = nums[read];
                write++;
            }
        }
        return write; // length of unique array
    }
}

