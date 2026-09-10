        [7,2,9,1,5]
          /      \
      [7,2]    [9,1,5]
      /   \     /    \
    [7] [2]   [9]  [1,5]
                   /   \
                 [1]   [5]

mergeSort(0,4)
│
├── mergeSort(0,2)
│   │
│   ├── mergeSort(0,1)
│   │   │
│   │   ├── mergeSort(0,0) ✅ return
│   │   ├── mergeSort(1,1) ✅ return
│   │   └── merge(0,0,1)
│   │
│   ├── mergeSort(2,2) ✅ return
│   └── merge(0,1,2)
│
├── mergeSort(3,4)
│   ├── mergeSort(3,3) ✅ return
│   ├── mergeSort(4,4) ✅ return
│   └── merge(3,3,4)
│
└── merge(0,2,4)



def merge(arr, left, mid, right):
    temp = []

    i = left
    j = mid + 1

    while i <= mid and j <= right:
        if arr[i] <= arr[j]:
            temp.append(arr[i])
            i += 1
        else:
            temp.append(arr[j])
            j += 1

    while i <= mid:
        temp.append(arr[i])
        i += 1

    while j <= right:
        temp.append(arr[j])
        j += 1

    for k in range(len(temp)):
        arr[left + k] = temp[k]


def merge_sort(arr, left, right):
    if left >= right:
        return

    mid = (left + right) // 2

    merge_sort(arr, left, mid)
    merge_sort(arr, mid + 1, right)

    merge(arr, left, mid, right)


def main():
    arr = [8, 3, 5, 4, 7, 6, 1, 2]

    merge_sort(arr, 0, len(arr) - 1)

    print(arr)


main()
