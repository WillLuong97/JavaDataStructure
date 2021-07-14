package com.javaprojects.DynamicProgramming.Controller.Greedy;

/*
A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:

s[i] == 'I' if perm[i] < perm[i + 1], and
s[i] == 'D' if perm[i] > perm[i + 1].
Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return any of them.

Example 1:

Input: s = "IDID"
Output: [0,4,1,3,2]

Example 2:

Input: s = "III"
Output: [0,1,2,3]

Example 3:

Input: s = "DDI"
Output: [3,2,0,1]

Constraints:

1 <= s.length <= 105
s[i] is either 'I' or 'D'.


Approach: Keep track of largest and smallest element as we go through the list. If we see an I, then place the small element, otherwise, place the large element,
*  */
public class DIStringMatch {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int low = 0;
        int high = n;
        int[] result = new int[n+1];
        //loop through the list
        for(int i =0; i < n; ++i){
            if(s.charAt(i) == 'I'){
                result[i] = low++;
            } else{
                result[i] = high++;
            }
        }

        result[n] = low;
        return result;

    }

}
