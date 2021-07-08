package com.javaprojects.DynamicProgramming.Controller;

/*
x is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from x. Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other (on this case they are rotated in a different direction, in other words 2 or 5 gets mirrored); 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.

Now given a positive number n, how many numbers x from 1 to n are good?

Example:
Input: 10
Output: 4
Explanation:
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
Note:

n will be in range [1, 10000].

Approach: loop through the n range from 1 and check to see if each number if each number contains the
strongly good number such as: 2,5,6,9 or automatic fails if they can contain invalid number such as 3,4,7.

* */
public class RotatedDigits {
    public int rotatedDigits(int n) {
        //BASE CASE: n is out of constraint boundary
        if(n < 1 || n > 10000){
            throw new RuntimeException("Invalid Input: input n is out of valid range");
        }

        int result = 0;
        //traverse through the array to check for the good number
        for(int i = 0; i <= n; i++){
            String curr_nums = String.valueOf(i);
            if(curr_nums.contains("3") || curr_nums.contains("4") || curr_nums.contains("7")){
                continue;
            }

            if(curr_nums.contains("2") || curr_nums.contains("5") || curr_nums.contains("6") || curr_nums.contains("9")){
                result++;
            }
        }
        return result;
    }
}
