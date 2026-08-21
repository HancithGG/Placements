# variable sliding window
def min_subarray_len(target, nums):
    n = len(nums)
    left = 0
    total = 0
    min_len = float("inf")

    for right in range(n):
        total += nums[right]

        while total >= target:
            min_len = min(min_len, right - left + 1)
            total -= nums[left]
            left += 1

    return 0 if min_len == float("inf") else min_len


# Example usage
print(min_subarray_len(7, [2,3,1,2,4,3]))   # → 2  (subarray [4,3])
print(min_subarray_len(11, [1,1,1,1,1,1,1])) # → 0  (no valid subarray)
print(min_subarray_len(15, [1,2,3,4,5]))     # → 5  (whole array)

