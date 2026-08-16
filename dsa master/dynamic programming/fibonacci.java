static int fibo(int num){
        int dp[] = new int[num + 1];

        if(num <= 1){
            return num;
        }

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=num; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[num];
    }

    static int fibonaci(int num){
        if(num <= 1){
            return num;
        }

        int prev1 = 1;
        int prev2 = 0;

        for(int i=2; i<= num; i++){
            int current = prev1 + prev2;

            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
