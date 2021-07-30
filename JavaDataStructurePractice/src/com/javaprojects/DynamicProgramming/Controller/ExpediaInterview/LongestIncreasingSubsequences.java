package com.javaprojects.DynamicProgramming.Controller.ExpediaInterview;

/*
* We have already discussed Overlapping Subproblems and Optimal Substructure properties.
Now, let us discuss the Longest Increasing Subsequence (LIS) problem as an example problem that can be solved using Dynamic Programming.
The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements
* of the subsequence are sorted in increasing order.
* For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
* Input: arr[] = {3, 10, 2, 1, 20}
Output: Length of LIS = 3
The longest increasing subsequence is 3, 10, 20

Input: arr[] = {3, 2}
Output: Length of LIS = 1
The longest increasing subsequences are {3} and {2}

Input: arr[] = {50, 3, 10, 7, 40, 80}
Output: Length of LIS = 4
The longest increasing subsequence is {3, 7, 40, 80}
*
Formally, the length of the longest increasing subsequence ending at index i, will be 1 greater than the maximum of lengths of all longest
increasing subsequences ending at indices before i, where arr[j] < arr[i] (j < i).

* Thus, we see the LIS problem satisfies the optimal substructure property as the main problem can be solved using solutions to subproblems.

* */

public class LongestIncreasingSubsequences {
    public int longestIncreasingSub(int arr[]){
        throw new RuntimeException("NOT YET IMPLEMENTED!");
    }
}
