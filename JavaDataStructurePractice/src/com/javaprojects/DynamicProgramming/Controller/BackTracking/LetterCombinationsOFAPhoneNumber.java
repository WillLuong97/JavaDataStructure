package com.javaprojects.DynamicProgramming.Controller.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]

Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].


Approach: Backtracking + Hashmap

The idea is to find all possible combinations of the digits string by referring to the hashmap.
If the current solution does not turn out to have the solution then the algorithm will backtrack and look for the next
possible candidate

O(3^N * 4^M), where N is the number of digits in the string S that maps to 3 letters and M is the number of digits in the string S that maps to 4 letters.




*  */
public class LetterCombinationsOFAPhoneNumber {
    //create a result array
    List<String> ans;
    //create a hashmap to store the digit and character relationship
    Map<Character, String> digitToCharMap;
    StringBuilder curr_combination;


    public List<String> letterCombinations(String digits) {
        //base case:
        ans = new ArrayList<>();
        digitToCharMap = new HashMap<>();
        curr_combination = new StringBuilder();

        if(digits.length() == 0 || digits == null){
            return ans;
        }

        //init the map
        createMap();
        //pass the digit from the input string into the recursion function
        generateCombination(digits);
        return ans;
    }


    //helper method to generate the combination using recursion
    private void generateCombination(String digits){
        //base case: check if the digit is valid or not
        if(digits.length() == 0 || digits == null){
            return;
        }

        //the string of character that belongs to the current digit
        String characterOfDigit = digitToCharMap.get(digits.charAt(0));
        //find the digit on the map and get its char
        for(int i = 0; i < characterOfDigit.length(); i++){
            //current character in the current string
            char curr_char = characterOfDigit.charAt(i);
            curr_combination.append(curr_char);
            //run recursion on the new substring
            generateCombination(digits.substring(1));

            if(digits.length() == 1){
                ans.add(curr_combination.toString());
            }
            //backtrack and
            //remove the element at the end of the current combination and replace it with a new candiate
            curr_combination.deleteCharAt(curr_combination.length() - 1);
        }
    }


    //helper method to contruct a map of digits and characters
    private void createMap(){
        digitToCharMap.put('2', "abc");
        digitToCharMap.put('3', "def");
        digitToCharMap.put('4', "ghi");
        digitToCharMap.put('5', "jkl");
        digitToCharMap.put('6', "mno");
        digitToCharMap.put('7', "pqrs");
        digitToCharMap.put('8', "tuv");
        digitToCharMap.put('9', "wxyz");
    }
}





























