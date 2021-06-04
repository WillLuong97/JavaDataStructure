package com.javaprojects.DynamicProgramming.Controller.DynamicProgrammingProblems;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2
Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

*  */


    /*
    Dynamic programming can help reduce the time complexity down by not sorting the array.
    bottom-up or tabuluation: dp = [] and populate the dp with the solution of the lowest subproblem and
    then move on to the sub problem until the final problem is solved.

    what is the subproblem here?
    - the subproblem that we are trying to solve here is the sub amount from 0 to amount, and
    we are trying to see how many coin we can collect to build the sub amount in the most minimum way.
    */

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        //base case:
        if(coins.length == 0){
            return -1;
        }

        //create a 2d array dp approach with the row to store the value of the coin
        //and the column to store the amount
        int[][] dp = new int[coins.length][amount+1];
        //populate the dp with the some place holder value
        for(int i = 0; i < coins.length; i++){
            for(int j = 0; j <= amount; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        //we will exclude the 0 amount since no value of coin can make up a total = 0 ;
        for(int i = 0; i < coins.length; i++){
            dp[i][0] = 0;
        }

        //traverse through the 2-d array to keep track of the value and how many coin can it make up the sub amount
        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(i > 0){
                    //when we get to this point of the 2-d array, the current target amount can be made up from
                    //another set of coin value, so before, we want to check how many coin can the current value make up
                    //we will use the previous number of coin as the placeholder here
                    dp[i][j] = dp[i-1][j];
                }

                if(j >= coins[i]){ //if the current amount is greater then the current given coin value, we will try to see if the coin value can make up any more minimum amount
                    if(dp[i][j-coins[i]] != Integer.MAX_VALUE){
                        dp[i][j] = Math.min(dp[i][j], dp[i][j-coins[i]] + 1);
                    }
                }
            }
        }

        return dp[coins.length-1][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length-1][amount];
    }
}
