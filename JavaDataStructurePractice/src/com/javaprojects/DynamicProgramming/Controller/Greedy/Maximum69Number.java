package com.javaprojects.DynamicProgramming.Controller.Greedy;

/*
Given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

Example 1:

Input: num = 9669
Output: 9969
Explanation:
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666.
The maximum number is 9969.

Example 2:

Input: num = 9996
Output: 9999
Explanation: Changing the last digit 6 to 9 results in the maximum number.

Example 3:
Input: num = 9999
Output: 9999
Explanation: It is better not to apply any change.

Constraints:

1 <= num <= 10^4
num's digits are 6 or 9.


Greedy approach: convert the num into a string and then traverse through each digit in the string
from left to right and at any point, if the digit is not a 9, convert it into a 9, exit the loop and return the updated
number

Time complexity: O(n), worst cast and average case would be n is the length of str_nums that we converted our num into.
Space complexity: O(n), n is the length of the string version of the num that we created.
*  */
public class Maximum69Number {
    public int maximum69Number (int num) {
        //convert the num into a string
        String strNum = Integer.toString(num);
        char[] num_char_arr = strNum.toCharArray();
        //loop through the string and convert the digit
        for(int i = 0; i < strNum.length(); i++){
            if(strNum.charAt(i) == '6'){
                num_char_arr[i] = '9';
                break;
            }
        }
        String resutl = new String(num_char_arr);

        return Integer.parseInt(resutl);
    }

}
