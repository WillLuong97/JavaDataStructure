package com.javaprojects.DynamicProgramming.Controller.DynamicProgrammingProblems;

/*
*  The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.


Constraints:

0 <= n <= 30

*/
public class FibonacciSequence {
    //Basic recursion implemntation:
    public int fib_RECURSION(int n){
        //base case:
        if(n <= 1){
            return n;
        }
        return fib_RECURSION(n-1) + fib_RECURSION(n - 2);
    }


    //Bottom-up implementation: we will try to cache each sub problem solution into a data structure
    public int fib_BOTTOM_UP(int n){
        if(n <= 1){
            return n;
        }
        return memoize(n);
    }

    //helper method to calcuate all fib sequence and cache them into an array
    private int memoize(int n){
        //create an array to store all the sub solution to the sub problem that was found
        int[] cache = new int[n+1];
        //base case:
        cache[0] = 0;
        cache[1] = 1;

        //compute the solution for the rest of the problem
        for(int i = 2; i <= n; i++){
            cache[i] = cache[i-1] + cache[i-2];
        }

        return cache[n];

    }

}
