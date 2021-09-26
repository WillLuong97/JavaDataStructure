package com.javaprojects.DynamicProgramming.Controller.DynamicProgrammingProblems;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given a string s, a split is called good if you can split s into 2 non-empty strings p and q where its concatenation is equal to s and the number of distinct letters in p and q are the same.
 *
 * Return the number of good splits you can make in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aacaba"
 * Output: 2
 * Explanation: There are 5 ways to split "aacaba" and 2 of them are good.
 * ("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
 * ("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
 * ("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
 * ("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
 * ("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
 * Example 2:
 *
 * Input: s = "abcd"
 * Output: 1
 * Explanation: Split the string as follows ("ab", "cd").
 * Example 3:
 *
 * Input: s = "aaaaa"
 * Output: 4
 * Explanation: All possible splits are good.
 * Example 4:
 *
 * Input: s = "acbadbaada"
 * Output: 2
 *
 *
 * Constraints:
 *
 * s contains only lowercase English letters.
 *
 * s = "abcd"
 *
 * how to determine a good split?
 * both sub-string contains the same number of unique character
 *  => how to keep track of unique character in each string?
 *      - We can create two set to keep track of each element in the split
 *      - We will create 2 array to keep track of the size of each set at each split
 *    increment the counter everytime the size of each unique set is equal to each other from each split
 *
 *
 * Time complexity: O(n), n is the size of the string
 * Space complexity: O(n)
 *
 * 1 <= s.length <= 10^5**/
public class NumberOfGoodSplitStringWay {
    public int numSplits(String s) {
        int length = s.length();
        //base case:
        if(length < 0){
            return -1;
        }
        //create the two sets to store the number of unique character in the left or right splits
        Set<Character> leftUniqueCharacterSet = new HashSet<>();
        Set<Character> rightUniqueCharacterSet = new HashSet<>();
        //arrays to keep track of the size of each set at each splits
        int[] leftSplitArray = new int[length];
        int[] rightSplitArray = new int[length];

        for(int i = 0; i < length; i++){
            leftUniqueCharacterSet.add(s.charAt(i));
            rightUniqueCharacterSet.add(s.charAt(length - 1 - i));
            leftSplitArray[i] = leftUniqueCharacterSet.size();
            rightSplitArray[length - 1 - i] = rightUniqueCharacterSet.size();

        }

        int counter = 0;
        for(int i = 0; i < length; i++){
            if(leftSplitArray[i-1] == rightSplitArray[i]){
                counter++;
            }
        }

        return counter;
    }
}
