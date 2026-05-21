Given stock prices for each day, find the maximum profit you can achieve from one buy and one sell (buy before sell). 
 
Sample Input: prices = [7,1,5,3,6,4] Expected Output: 5

  import java.util.Scanner;

public class BestTimeToBuySellStock {

    public static int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            // Calculate profit
            int profit = prices[i] - minPrice;

            // Update maximum profit
            maxProfit = Math.max(maxProfit, profit);

            // Update minimum price
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input example: [7,1,5,3,6,4]
        String str = sc.nextLine().trim();

        // Remove brackets
        str = str.replace("[", "").replace("]", "");

        // Split values
        String[] str1 = str.split(",");

        // Create array
        int[] prices = new int[str1.length];

        // Convert string to integer
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Integer.parseInt(str1[i].trim());
        }

        int result = maxProfit(prices);

        System.out.println(result);

        sc.close();
    }
}
