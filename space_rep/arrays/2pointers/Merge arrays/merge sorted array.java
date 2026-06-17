1️⃣ Merge Sorted Array (LeetCode 88) ⭐⭐⭐ Easy (Anchor)
Problem

You are given two sorted arrays nums1 and nums2. nums1 has enough extra space at the end to hold all elements of nums2. Merge nums2 into nums1 so that nums1 remains sorted.

Input

nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6], n = 3

Output

[1,2,2,3,5,6]

public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int write = m + n - 1;

    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[write--] = nums1[i--];
        } else {
            nums1[write--] = nums2[j--];
        }
    }

    while (j >= 0) {
        nums1[write--] = nums2[j--];
    }
}
