        Capacity
        0 1 2 3 4 5 6 7
      +-------------------
0     | 0 0 0 0 0 0 0 0
1     | 0 1 1 1 1 1 1 1     
2     | 0 1 1 4 5 5 5 5       items 
3     | 0 1 1 4 5 6 6 9
4     | 0 1 1 4 5 7 8 9

def knapsack(W, wt, val, n):
    # dp[i][w] = max value using first i items with capacity w
    dp = [[0] * (W + 1) for _ in range(n + 1)]

    for i in range(1, n + 1):
        for w in range(1, W + 1):
            if wt[i - 1] <= w:
                dp[i][w] = max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w])
            else:
                dp[i][w] = dp[i - 1][w]

    return dp[n][W]


# Example usage
values = [1, 3, 4, 5]
weights = [1, 4, 5, 7]
capacity = 7
n = len(values)

print(knapsack(capacity, weights, values, n)) 

