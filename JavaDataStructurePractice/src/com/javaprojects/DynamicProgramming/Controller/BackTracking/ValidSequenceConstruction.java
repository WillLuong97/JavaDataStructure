package com.javaprojects.DynamicProgramming.Controller.BackTracking;
/*
Given an integer n, find a sequence that satisfies all of the following:

The integer 1 occurs once in the sequence.
Each integer between 2 and n occurs twice in the sequence.
For every integer i between 2 and n, the distance between the two occurrences of i is exactly i.
The distance between two numbers on the sequence, a[i] and a[j], is the absolute difference of their indices, |j - i|.

Return the lexicographically largest sequence. It is guaranteed that under the given constraints, there is always a solution.

A sequence a is lexicographically larger than a sequence b (of the same length) if in the first position where a and b differ, sequence a has a number greater than the corresponding number in b. For example, [0,1,9,0] is lexicographically larger than [0,1,5,6] because the first position they differ is at the third number, and 9 is greater than 5.



Example 1:

Input: n = 3
Output: [3,1,2,3,2]
Explanation: [2,3,2,1,3] is also a valid sequence, but [3,1,2,3,2] is the lexicographically largest valid sequence.
Example 2:

Input: n = 5
Output: [5,3,1,4,3,5,2,4,2]


Constraints:

1 <= n <= 20

we will use backtracking to solve this problem by going backward from n

*  */
public class ValidSequenceConstruction {
    public int[] constructDistancedSequence(int n) {
        //create a solution to the
        int[] result = new int[(2*n) - 1];
        //boolean array to check if a number has been visited or not
        boolean[] visited = new boolean[n+1];
        backtracking(0, result, visited, n);
        return result;
    }

    private boolean backtracking(int i, int[] result, boolean[] visited, int n){
        if(i == result.length){
            return true;
        }
        if(result[i] != 0 ){
            //backtracking to see if the number needs to continue to be repeated or not
            backtracking(i+1, result, visited, n);
        }

        //traversing through n backward
        for(int j = n; j > 0; j--){
            if(!visited[j] && (j == 1 || i+j < result.length && result[i+j] == 0)){
                result[i] = j;
                if(j != 1){
                    result[i+j] = j;
                    visited[j] = true;
                    if(backtracking(i+1, result, visited, n)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
