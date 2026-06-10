//Find the duplicate number using the fast & slow pointer technique cycle method 
public static int hasdup(int[] arr){

    int slow = arr[0];
    int fast = arr[arr[0]];

    while(slow != fast){
      slow = arr[slow];
      fast = arr[arr[fast]];
    }

    fast = 0;

    while(slow != fast){
      slow = arr[slow];
      fast = arr[fast];
    }
    return fast;
  }
