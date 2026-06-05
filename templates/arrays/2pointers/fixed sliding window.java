int left = 0;
int windowValue = 0;

// Build first window
for(int right = 0; right < k; right++){
    windowValue += arr[right];
}

// First answer
int answer = windowValue;

// Slide remaining windows
for(int right = k; right < arr.length; right++){

    // Element leaving window
    windowValue -= arr[left];

    // Element entering window
    windowValue += arr[right];

    left++;

    // Update result
    answer = Math.max(answer, windowValue);
}

System.out.println(answer);
