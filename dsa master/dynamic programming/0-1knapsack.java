        Capacity
        0 1 2 3 4 5 6 7
      +-------------------
0     | 0 0 0 0 0 0 0 0
1     | 0 1 1 1 1 1 1 1     
2     | 0 1 1 4 5 5 5 5       items 
3     | 0 1 1 4 5 6 6 9
4     | 0 1 1 4 5 7 8 9

public class Knapsack {

    static int knapsack(
            int[] weights,
            int[] values,
            int capacity) {

        int n = weights.length;

        int[][] dp = new int[n + 1][capacity + 1];

        // i = number of items considered
        for (int i = 1; i <= n; i++) {

            // w = current capacity
            for (int w = 1; w <= capacity; w++) {

                // Current item doesn't fit
                if (weights[i - 1] > w) {

                    dp[i][w] = dp[i - 1][w];

                } else {

                    // Don't take the item
                    int notTake = dp[i - 1][w];

                    // Take the item
                    int take =
                        values[i - 1]
                        + dp[i - 1][w - weights[i - 1]];

                    // Choose the better option
                    dp[i][w] = Math.max(take, notTake);
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {

        int[] weights = {1, 3, 4, 5};

        int[] values = {1, 4, 5, 7};

        int capacity = 7;

        int answer =
                knapsack(weights, values, capacity);

        System.out.println("Maximum value = " + answer);
    }
}
