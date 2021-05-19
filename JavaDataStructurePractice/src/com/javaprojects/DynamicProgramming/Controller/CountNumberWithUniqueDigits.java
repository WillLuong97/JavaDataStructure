package com.javaprojects.DynamicProgramming.Controller;

import static java.lang.Math.*;

/* Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.
Example 1:

Input: n = 2
Output: 91
Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99
Example 2:

Input: n = 0
Output: 1


Constraints:

0 <= n <= 8

Approach: append each digit into a number from the range of 0 to 10^n using recursion.
The main function is used to construct the left most digit, to avoid leading 0 and the recursion is used to build the rest of digits
require for the current number. We do this from 0 to 10^n and if the number is unique and still within the boundary, we will increment by 1
and keep repeating the process.

- Backtracking approach: after a each number built, we backtrack and check for another number.

Time complexity: O(10!) worst case, or O(n!) if n < 10.
Space complexity: O(n)
*  */
public class CountNumberWithUniqueDigits {
    //this is used to build out the leftmost digit without leading 0
    public int countNumbersWithUniqueDigits(int n) {
        //base case:
        if(n > 10){
            return countNumbersWithUniqueDigits(10);
        }
        int count = 1; //if x == 0; counting the leading 0
        //getting the max number:
        long max = (long) Math.pow(10, n);
        //Create a basic visited array to keep track of which digit that have been processed to avoid non-unique number
        boolean[] used = new boolean[10];
        //constructing the leftmost digit of the number
        for(int i = 1; i < 10; i++){
            //mark the number as visited
            used[i] = true;
            //recursively building the rest of digit for the current number
            count += digitBuilder(i, max, used);
            //after we are done with the current digit, backtrack and check the next digit
            used[i] = false;
        }
        return count;
    }

    //recursive function to build the rest of the digit set (left to rightmost digit)
    private static int digitBuilder(long curr, long max, boolean[] used){
        int count = 0;
        //continue counting if the number is still lesser the max bounday
        if(curr < max){
            count+=1;
        } else{
            return count;
        }

        //start building the rest of the digit
        for(int i = 0; i < 10; i++){
            //if the current digit has not been built so we will use it.
            if(!used[i]){
                used[i] = true;
                long cur = 10 * curr + i;
                count += digitBuilder(cur, max, used);
                used[i] = false;
            }
        }
        return count;
    }
}
