package com.javaprojects.DynamicProgramming.Controller;

/* 151. Reverse Words in a String
Given an input string s, reverse the order of the words. A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
Example 4:

Input: s = "  Bob    Loves  Alice   "
Output: "Alice Loves Bob"
Example 5:

Input: s = "Alice does not even like bob"
Output: "bob like even not does Alice"


Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.

Example:
"the sky is blue"

stack data structure: loop through the string and only push a word from a string onto a stack, then pop them out and add it the result string.

Optimize: loop through the string backwards and create a substring of word which are contigous character without the a whitespace.

This way we can reduce the space complexity to just O(1) because we didnt need to use a stack.

Follow up: Could you solve it in-place with O(1) extra space?
* */
public class ReverseWordInAString {
    public String reverseWords(String s) {
        //base case:
        if(s.length() == 0){
            return "Empty String";
        }

        var sb = new StringBuilder();

        int i = s.length() - 1;
        // loop through the string
        while(i >=0 && s.charAt(i) == ' '){
            //strip trailling white spaces:
            i--;
        }

        //loop through the string backward
        while(i >= 0){
            //getting the two boundary for a substring to make a word
            int start = i;
            int end = i;
            //keep traversing down the string and keep building a word from the substring
            while(i >0 && s.charAt(i) != ' '){
                i--;
                start = i;
            }
            //if we hit a white space while making a substring, that mean the word is done
            sb.append(s.substring(start, end+1));
            sb.append(" ");
            i--;

            //strip the whitespace before the next work
            while(i >=0 && s.charAt(i) == ' '){
                i--;
            }

        }

        //remove the last space:
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

}
