def partition(arr, low, high):
    pivot = arr[high]

    i = low - 1

    for j in range(low, high):

        if arr[j] <= pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]

    i += 1
    arr[i], arr[high] = arr[high], arr[i]

    return i


def quicksort(arr, low, high):
    if low < high:

        pivot_index = partition(arr, low, high)

        quicksort(arr, low, pivot_index - 1)
        quicksort(arr, pivot_index + 1, high)


def main():
    arr = [7, 2, 1, 6, 8, 5, 3, 4]

    print("Before sorting:", arr)

    quicksort(arr, 0, len(arr) - 1)

    print("After sorting:", arr)


main()
