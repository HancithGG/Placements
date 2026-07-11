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



public class MergeSort {

    // Merge two sorted halves
    static void merge(int[] arr, int left, int mid, int right) {                                                      

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy left half
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];

        // Copy right half
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];

        int i = 0;
        int j = 0;
        int k = left;

        // Merge both arrays
        while (i < n1 && j < n2) {

            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }

            k++;
        }

        // Copy remaining left elements
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy remaining right elements
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {

            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);

            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }

    }

    public static void main(String[] args) {

        int[] arr = {7, 2, 9, 1, 5};

        mergeSort(arr, 0, arr.length - 1);

        System.out.print("Sorted Array: ");

        for (int num : arr)
            System.out.print(num + " ");
    }
}
