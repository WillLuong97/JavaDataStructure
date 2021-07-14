package com.javaprojects.DynamicProgramming.Controller.BackTracking;
import java.util.ArrayList;
import java.util.List;
/*
In LeetCode Store, there are n items to sell. Each item has a price. However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.

You are given an integer array price where price[i] is the price of the ith item, and an integer array needs where needs[i] is the number of pieces of the ith item you want to buy.

You are also given an array special where special[i] is of size n + 1 where special[i][j] is the number of pieces of the jth item in the ith offer and special[i][n] (i.e., the last integer in the array) is the price of the ith offer.

Return the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers. You are not allowed to buy more items than you want, even if that would lower the overall price. You could use any of the special offers as many times as you want.

Example 1:

Input: price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
Output: 14
Explanation: There are two kinds of items, A and B. Their prices are $2 and $5 respectively.
In special offer 1, you can pay $5 for 3A and 0B
In special offer 2, you can pay $10 for 1A and 2B.
You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.

Example 2:

Input: price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]
Output: 11
Explanation: The price of A is $2, and $3 for B, $4 for C.
You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C.
You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C.
You cannot add more items, though only $9 for 2A ,2B and 1C.

Constraints:

n == price.length
n == needs.length
1 <= n <= 6
0 <= price[i] <= 10
0 <= needs[i] <= 10
1 <= special.length <= 100
special[i].length == n + 1
0 <= special[i][j] <= 50

Approach 1: recursion + backtracking

We will first calculate the overall price of how much we would pay to sastify our need without the offer. Then we make a copy of the current needs
array so that we can update it while keeping track of the original needs as we apply the offer and calculate the newer price with the offer

Time complexity: O(2^M*L*N) where L is len(prices), M is len(specials), N is len(needs)
Space complexity:


*  */

public class ShoppingOffer {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shopping(price, special, needs);
    }

    //helper method to recursively check for the price and offers
    private int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        int i = 0;
        //we first calculate the money paid to sastify our need and then update it based on the next
        //best offer we can find
        int result = totalPrices(price, needs);
        for(List<Integer> offer : special){
            //create a clone of the needs so that we can update it with the offer while
            //keeping track of the original needs
            List<Integer> needs_copy = new ArrayList<>(needs);

            for(i = 0; i < needs.size(); i++){
                int diff = needs.get(i) - offer.get(i);
                //the special offer does not give us the number of items that we wish for that's why we break out
                //and look for the next ones
                if(diff < 0){
                    break;
                }
                //otherwise, update the clone with the updated number of items appropriate
                needs_copy.set(i, diff);
            }
            //once we have found the right offer, then check to see if it can produce a smaller price than
            //the one we have just found and make appropriate updates.
            if(i == needs.size()){
                result = Math.min(result, offer.get(i) + shopping(price, special, needs_copy));
            }


        }


        return result;



    }

    //helper method to calculate the price based on the items and needs
    private int totalPrices(List<Integer> price, List<Integer> needs){
        int result = 0;
        for(int i =0; i < needs.size(); i++){
            result += price.get(i) * needs.get(i);
        }

        return result;
    }

}
