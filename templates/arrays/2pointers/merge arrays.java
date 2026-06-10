int i = 0;
int j = 0;

while(i < arr1.length && j < arr2.length){

    // Compare current elements

    if(arr1[i] <= arr2[j]){

        // Element from arr1 enters answer

        i++;
    }
    else{

        // Element from arr2 enters answer

        j++;
    }
}

// Add leftover from arr1

while(i < arr1.length){
    i++;
}

// Add leftover from arr2

while(j < arr2.length){
    j++;
}
