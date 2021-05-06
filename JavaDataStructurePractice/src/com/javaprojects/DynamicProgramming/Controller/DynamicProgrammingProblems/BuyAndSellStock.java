package com.javaprojects.DynamicProgramming.Controller.DynamicProgrammingProblems;

/* You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104

 One pass approach:
 we have an abitraility low price
 we will loop through the list of days one time and at each looping, we will minus the current price with the lowprice and see if that would increase our profit to
 the maximum and repeat this process until the end where you will have the most value

 time complexity: O(n), the algorithm will run through the list one time
 space complexity: O(1), we are not storing any values in the list
* */
public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        //base case:
        if (prices.length == 0){
            return 0;
        }
        //creating an abitraility low price to compare it with others in the list
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        //loop through the list of days
        for(int i = 0; i < prices.length; i++){
            //if the price to buy stock is low, then buy it
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            //look at other days and check to see if they can
            else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}
