package com.javaprojects.DynamicProgramming.Controller.DynamicProgrammingProblems;

/**
 * Given two strings s and t, find the number of ways you can choose a non-empty substring of s and replace a single character by a different character such that the resulting substring is a substring of t. In other words, find the number of substrings in s that differ from some substring in t by exactly one character.
 *
 * For example, the underlined substrings in "computer" and "computation" only differ by the 'e'/'a', so this is a valid way.
 *
 * Return the number of substrings that satisfy the condition above.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aba", t = "baba"
 * Output: 6
 * Explanation: The following are the pairs of substrings from s and t that differ by exactly 1 character:
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * The underlined portions are the substrings that are chosen from s and t.
 * ​​Example 2:
 * Input: s = "ab", t = "bb"
 * Output: 3
 * Explanation: The following are the pairs of substrings from s and t that differ by 1 character:
 * ("ab", "bb")
 * ("ab", "bb")
 * ("ab", "bb")

 The underlined portions are the substrings that are chosen from s and t.
 * Example 3:
 * Input: s = "a", t = "a"
 * Output: 0
 * Example 4:
 *
 * Input: s = "abe", t = "bbc"
 * Output: 10
 * Constraints:
 * 1 <= s.length, t.length <= 100
 * s and t consist of lowercase English letters only. **/
public class CountSubstringThatDifferBy1Char {
    public int countSubstrings(String s, String t) {
        int m = s.length();
        int n = t.length();
        //Create a 3-d array, mxnx2 dimension to keep track of the number differences in each substring
        //on the 3rd dimension, we will keep track of the changes, 0 - for no changes and 1 for changes occured
        int[][][] dp = new int[m+1][n+1][2];
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //update hte
                dp[i+1][j+1][0] = (s.charAt(i) == t.charAt(j)) ? dp[i][j][0] + 1 : 0;
                dp[i+1][j+1][1] = (s.charAt(i) == t.charAt(j)) ? dp[i][j][1] : dp[i][j][0] + 1;
                res += dp[i+1][j+1][1];
            }
        }

        return res;

    }
}
