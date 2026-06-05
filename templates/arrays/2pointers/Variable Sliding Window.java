int left = 0;
int windowValue = 0;

int answer = 0;

for(int right = 0; right < arr.length; right++){

    // Element entering window
    windowValue += arr[right];

    // Window invalid?
    while(condition breaks){

        // Element leaving window
        windowValue -= arr[left];
        left++;
    }

    // Current valid window
    answer = Math.max(answer,
                      right - left + 1);
}

System.out.println(answer);
