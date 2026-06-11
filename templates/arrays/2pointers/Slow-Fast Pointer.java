Need in-place modification
+
One pointer explores
+
One pointer maintains result
=
Fast & Slow Pointers

int slow = 0;

for(int fast = 0; fast < arr.length; fast++){

    if(valid){

        arr[slow] = arr[fast];
        slow++;
    }
}
