def remove_duplicates(arr):
    if len(arr) == 0:
        return 0

    left = 0

    for right in range(1, len(arr)):
        if arr[right] != arr[left]:
            left += 1
            arr[left] = arr[right]

    return left + 1


def main():
    arr = [1, 1, 2, 2, 3]

    length = remove_duplicates(arr)

    print(arr[:length])


main()
