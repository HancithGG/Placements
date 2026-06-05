int slow = 0;

for(int fast = 0; fast < arr.length; fast++){

    if(valid){

        arr[slow] = arr[fast];
        slow++;
    }
}
