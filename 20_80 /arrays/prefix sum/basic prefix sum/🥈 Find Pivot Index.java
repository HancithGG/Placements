 public static int findpivot(int[] arr) {
       
        int total = 0;

        for(int a: arr){
            total += a;
        }

        int left_sum = 0;

        for(int i=0; i<arr.length; i++){
            int right_sum = total - arr[i] - left_sum;

            if(right_sum == left_sum){
                return i;
            }
            left_sum += arr[i];
        }
        return -1;
    }
