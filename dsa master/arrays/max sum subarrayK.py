#fixed sliding window

def max_sum_subarray_k(nums, k):
    n = len(nums)
    if n < k:
        return 0  # not enough elements

    # initial window sum
    window_sum = sum(nums[:k])
    max_sum = window_sum

    # slide the window
    for i in range(k, n):
        window_sum += nums[i] - nums[i - k]
        max_sum = max(max_sum, window_sum)

    return max_sum


# Example usage
print(max_sum_subarray_k([2, 1, 5, 1, 3, 2], 3))  # → 9 (subarray [5,1,3])
print(max_sum_subarray_k([1, 2, 3, 4, 5], 2))     # → 9 (subarray [4,5])
print(max_sum_subarray_k([4, 2, 1, 7, 8, 1, 2, 8, 1, 0], 3))  # → 16 (subarray [7,8,1])

