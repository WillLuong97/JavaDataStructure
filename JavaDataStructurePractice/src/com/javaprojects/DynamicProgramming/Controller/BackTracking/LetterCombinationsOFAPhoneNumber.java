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

*  */
public class LetterCombinationsOFAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        //create a result array
        List<String> result = new ArrayList<>();
        String curr_combination = "";
        //base case:
        if(digits.length() == 0){
            return result;
        }

        //create a hashmap to store the digit and character relationship
        Map<Character, String> digitToCharMap = new HashMap<>();
        digitToCharMap.put('2', "abc");
        digitToCharMap.put('3', "def");
        digitToCharMap.put('4', "ghi");
        digitToCharMap.put('5', "jkl");
        digitToCharMap.put('6', "mno");
        digitToCharMap.put('7', "pqrs");
        digitToCharMap.put('8', "tuv");
        digitToCharMap.put('9', "wxyz");

        //pass the digit from the input string into the recursion function
        generateCombination(digits.charAt(0), 0, digitToCharMap, result, digits, curr_combination);
        return result;
    }


    //helper method to generate the combination using recursion
    private void generateCombination(char digit, int index, Map<Character, String> digitToCharMap, List<String> result, String digits, String curr_combination){
        //base case: check if the digit is valid or not
        if(Character.getNumericValue(digit) == digits.length()) {
            result.add(curr_combination);
            return;
        }
        //the string of character that belongs to the current digit
        String characterOfDigit = digitToCharMap.get(digit);
        //find the digit on the map and get its char
        for(int i = 0; i < characterOfDigit.length(); i++){
            //current character in the current string
            char curr_char = characterOfDigit.charAt(i);
            curr_combination += curr_char;
            generateCombination(digits.charAt(index+1), index+1, digitToCharMap, result, digits, curr_combination);
        }
    }
}





























