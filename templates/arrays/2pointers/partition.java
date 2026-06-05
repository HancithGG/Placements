//basic one 

int left = 0;

for(int right = 0; right < arr.length; right++) {

    if(arr[right] % 2 == 0) {

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        left++;
    }
}


// advanced one

int pivot = arr[high];

int i = low;

for(int j = low; j < high; j++) {

    if(arr[j] <= pivot) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        i++;
    }
}

int temp = arr[i];
arr[i] = arr[high];
arr[high] = temp;

return i;
