package com.javaprojects.DynamicProgramming.Controller.DynamicProgrammingProblems;
/*
The Tribonacci sequence Tn is defined as follows:

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
Given n, return the value of Tn.

Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4

Example 2:

Input: n = 25
Output: 1389537

Constraints:
0 <= n <= 37
The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
N = 4
T0 = 0
T1 = 1
T2 = 1
     t0  t1  t2
T3 = 0 + 1 + 1 = 2
T4 = 1 + 1 + 2 = 4
t(2+3=5) => 1 + 2 + 4 = 7
cache[0
n = 5 => recursion(5-3) + recursion(5-2) + recursion(5-1)
                    2               3                 4

approach: bottom-up we will cache all computed solutions of the subproblems into an array and
retrieve them to help us with calculating the next set of subproblems

time complelity: o(n)
space complexity: O(n), the size of the cache can go up to n
*  */
public class NthTribonacciNumber {
    public int tribonacci(int n) {
        //create a cache array to keep track of the number of each sub problems solutions
        int[] cache = new int[n+3];
        //setting up base case:
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 1;
        //calculate for the rest of the subproblem until n
        for(int i = 3; i <= n; i++){
            cache[i] = cache[i-1] + cache[i-2] + cache[i-3];
        }

        return cache[n];
    }

}
