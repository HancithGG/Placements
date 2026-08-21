def binary_search(arr, target):
    low = 0
    high = len(arr) - 1

    while low <= high:
        mid = low + (high - low) // 2

        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            low = mid + 1
        else:
            high = mid - 1

    return -1


if __name__ == "__main__":
    arr = [2, 5, 8, 10, 15, 18, 20]
    target = 15

    index = binary_search(arr, target)

    if index != -1:
        print(f"Element found at index {index}")
    else:
        print("Element not found")

