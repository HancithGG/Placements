int slow = 0;

for(int fast = 0; fast < arr.length; fast++){

    if(condition){

        int temp = arr[fast];
        arr[fast] = arr[slow];
        arr[slow] = temp;

        slow++;
    }
}
