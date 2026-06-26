import java.util.*;

public static void partitionPivot(int[] arr, int pivot) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        while (left <= right && arr[left] < pivot) {
            left++;
        }
        while (left <= right && arr[right] >= pivot) {
            right--;
        }

        if (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;   // move inward
            right--;  // move inward
        }
    }
}


    public static void main(String[] args) {
        int[] nums = {9,12,5,10,14,3,10};

        int[] result = pivotArray(nums,10);

        for(int num : result)
            System.out.print(num + " ");
    }
}
