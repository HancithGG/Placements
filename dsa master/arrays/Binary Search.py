def binary_search(arr, target):
    """Return index of target in sorted arr, or -1 if not found."""
    left, right = 0, len(arr) - 1
    
    while left <= right:
        mid = (left + right) // 2
        guess = arr[mid]
        
        if guess == target:
            return mid
        if guess < target:
            left = mid + 1
        else:
            right = mid - 1
    
    return -1


# Example usage
nums = [2, 5, 8, 10, 15, 18, 20]
print(binary_search(nums, 15))  # → 4
print(binary_search(nums, 7))   # → -1

